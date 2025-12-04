package project2.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import project2.dao.AppUserMapper;
import project2.dao.RecipeDao;
import project2.dto.RecipeDto;
import project2.dto.RecipeImage;
import project2.dto.RecipeIngre;
import project2.dto.RecipeIngreMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired PasswordEncoder pwencoder;
    @Autowired RecipeDao dao;

    // 파일 저장 경로 (Windows 기준)
    private static final String UPLOAD_PATH = "C:/file/";
    
    @Override
    @Transactional
    public int insert(RecipeDto dto, List<MultipartFile> files) {
        int result = 0;

        // 1. UPLOAD_PATH 폴더가 없을 경우 생성 (안전 장치)
        File dir = new File(UPLOAD_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        if (dto.getImage() == null) {
            dto.setImage(null); // 또는 빈문자열 "" — Oracle에서는 "" = NULL
        }

        // 2. 레시피 기본 정보 저장 (mapper의 selectKey로 recipeId 채워짐)
        result += dao.insert(dto);
        int recipeId = dto.getRecipeId();

        // 3. instruction 텍스트 처리
        List<String> instructionTexts = dto.getInstructionTexts();

        // 4. 이미지 처리 — files 의 구조: [0] = 대표 이미지(선택), [1..] = 단계 이미지들
        if (files != null && !files.isEmpty()) {
            // 4-1) 대표 이미지 처리 (files[0])
            MultipartFile mainFile = files.get(0);
            if (mainFile != null && !mainFile.isEmpty()) {
                String original = mainFile.getOriginalFilename();
                String saveName = UUID.randomUUID().toString() + "_" + original;
                File dest = new File(UPLOAD_PATH + saveName);
                try {
                    mainFile.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("대표 이미지 저장 중 오류 발생", e);
                }

                // DB에는 파일명(또는 URL 규칙에 따른 값)만 저장
                String dbUrl = saveName;
                dto.setImage(dbUrl);

                // recipes 테이블의 image 컬럼을 업데이트.
                // (간단히 dao.update(dto)를 호출해서 image 컬럼을 포함한 레코드를 갱신)
                // 만약 DAO에 전용 메서드(updateRecipeImage)가 있으면 그걸 호출해도 됩니다.
                result += dao.update(dto);
            } else {
                // 대표 이미지가 비어있으면 기본 이미지 사용 (원하면 기본값 세팅)
                if (dto.getImage() == null || dto.getImage().isEmpty()) {
                    dto.setImage("default-recipe.png");
                    result += dao.update(dto);
                }
            }

            // 4-2) 단계 이미지 처리: instructionTexts size에 맞춰 files[1..]을 매핑
            int stepCount = (instructionTexts != null) ? instructionTexts.size() : 0;

            if (stepCount > 0) {
                for (int i = 0; i < stepCount; i++) {
                    // 단계 i 에 매칭되는 파일은 files.get(i + 1)
                    MultipartFile stepFile = (files.size() > i + 1) ? files.get(i + 1) : null;
                    if (stepFile != null && !stepFile.isEmpty()) {
                        String original = stepFile.getOriginalFilename();
                        String saveName = UUID.randomUUID().toString() + "_" + original;
                        File dest = new File(UPLOAD_PATH + saveName);
                        try {
                            stepFile.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("단계 이미지 저장 중 오류 발생", e);
                        }

                        String dbUrl = saveName;

                        RecipeImage imageDto = new RecipeImage();
                        imageDto.setRecipeId(recipeId);
                        imageDto.setRurl(dbUrl);
                        // 만약 이미지 순서가 필요하면 imageDto에 순서 필드를 추가하고 세팅하세요.
                        result += dao.insertRecipeImage(imageDto);
                    }
                }
            } else {
                // instructionTexts 가 없고 여전히 files가 존재하는 경우 (files[1..] 모두 단계 이미지로 저장)
                for (int j = 1; j < files.size(); j++) {
                    MultipartFile f = files.get(j);
                    if (f != null && !f.isEmpty()) {
                        String original = f.getOriginalFilename();
                        String saveName = UUID.randomUUID().toString() + "_" + original;
                        File dest = new File(UPLOAD_PATH + saveName);
                        try {
                            f.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("단계 이미지 저장 중 오류 발생", e);
                        }

                        String dbUrl = saveName;

                        RecipeImage imageDto = new RecipeImage();
                        imageDto.setRecipeId(recipeId);
                        imageDto.setRurl(dbUrl);

                        result += dao.insertRecipeImage(imageDto);
                    }
                }
            }
        } else {
            // files null 또는 empty 인 경우: 대표 이미지가 비어있으면 기본 이미지 지정
            if (dto.getImage() == null || dto.getImage().isEmpty()) {
                dto.setImage("default-recipe.png");
                result += dao.update(dto);
            }
        }

        // 5. 재료 삽입
        List<RecipeIngre> ingredients = dto.getIngredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            RecipeIngreMap mapDto = new RecipeIngreMap();
            mapDto.setRecipeId(recipeId);
            dao.insertIngredientMap(mapDto);
            int ingreMapId = mapDto.getIngreMapId();

            for (RecipeIngre ingre : ingredients) {
                ingre.setIngreMapId(ingreMapId);
                result += dao.insertIngredientDetail(ingre);
            }
        }

        return result;
    }

    // --- R E A D (조회) ---
    @Override
    public List<RecipeDto> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<RecipeDto> selectMyRecipes(int appUserId) {
        return dao.selectMyRecipes(appUserId);
    }

    @Autowired
    AppUserSecurityService userService;  // 사용자 서비스

    @Override
    @Transactional
    public RecipeDto selectRecipeDetail(int recipeId) {
        // 1. 조회수 증가
        dao.incrementRecipeViews(recipeId);

        // 2. 레시피 기본 정보 조회
        RecipeDto dto = dao.select(recipeId);

        if (dto != null) {
            // 카테고리 이름 조회
            String categoryName = dao.selectCategoryNameById(dto.getCategory());
            dto.setCategoryName(categoryName);  // 카테고리 이름 설정

            // 이미지 목록 조회 (단계 이미지)
            List<RecipeImage> images = dao.selectRecipeImages(recipeId);
            dto.setImages(images);

            // 재료 목록 조회
            List<RecipeIngre> ingredients = dao.selectRecipeIngredients(recipeId);
            dto.setIngredients(ingredients);
        }

        return dto;
    }

    // --- U P D A T E (수정) ---
    @Override
    @Transactional
    public int update(RecipeDto dto, List<MultipartFile> files) {
        int result = 0;
        int recipeId = dto.getRecipeId();

        // 1. UPLOAD_PATH 폴더가 없을 경우 생성 (안전 장치)
        File dir = new File(UPLOAD_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 2. 기본 정보 업데이트 (title, description 등)
        result += dao.update(dto);

        // 3. 이미지: 기존 단계 이미지는 삭제 후 새로 등록
        dao.deleteRecipeImages(recipeId);
        

        List<String> instructionTexts = dto.getInstructionTexts();

        
        if (files != null && !files.isEmpty()) {
            // 3-1) 새 대표 이미지가 업로드 되었다면 처리 (files[0])
            MultipartFile newMain = files.get(0);
            if (newMain != null && !newMain.isEmpty()) {
                String original = newMain.getOriginalFilename();
                String saveName = UUID.randomUUID().toString() + "_" + original;
                File dest = new File(UPLOAD_PATH + saveName);
                try {
                    newMain.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("대표 이미지 저장 중 오류 발생", e);
                }

                String dbUrl = saveName;
                dto.setImage(dbUrl);
                // 대표 이미지 컬럼 갱신
                result += dao.update(dto);
            } // else: 새 대표 이미지가 없으면 기존 dto.image 유지

            // 3-2) 단계 이미지 등록 (files[1..] -> instructionTexts[0..])
            int stepCount = (instructionTexts != null) ? instructionTexts.size() : 0;

            if (stepCount > 0) {
                for (int i = 0; i < stepCount; i++) {
                    MultipartFile stepFile = (files.size() > i + 1) ? files.get(i + 1) : null;
                    if (stepFile != null && !stepFile.isEmpty()) {
                        String original = stepFile.getOriginalFilename();
                        String saveName = UUID.randomUUID().toString() + "_" + original;
                        File dest = new File(UPLOAD_PATH + saveName);
                        try {
                            stepFile.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("단계 이미지 저장 중 오류 발생", e);
                        }

                        String dbUrl = saveName;

                        RecipeImage imageDto = new RecipeImage();
                        imageDto.setRecipeId(recipeId);
                        imageDto.setRurl(dbUrl);
                        result += dao.insertRecipeImage(imageDto);
                    }
                }
            } else {
                // instructionTexts가 없을 때 files[1..] 전부 저장
                for (int j = 1; j < files.size(); j++) {
                    MultipartFile f = files.get(j);
                    if (f != null && !f.isEmpty()) {
                        String original = f.getOriginalFilename();
                        String saveName = UUID.randomUUID().toString() + "_" + original;
                        File dest = new File(UPLOAD_PATH + saveName);
                        try {
                            f.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("단계 이미지 저장 중 오류 발생", e);
                        }

                        String dbUrl = saveName;

                        RecipeImage imageDto = new RecipeImage();
                        imageDto.setRecipeId(recipeId);
                        imageDto.setRurl(dbUrl);
                        result += dao.insertRecipeImage(imageDto);
                    }
                }
            }
        }

        // 4. 재료는 기존 map 삭제 후 재생성
        dao.deleteIngredientMaps(recipeId);

        List<RecipeIngre> ingredients = dto.getIngredients();
        if (ingredients != null && !ingredients.isEmpty()) {
            RecipeIngreMap mapDto = new RecipeIngreMap();
            mapDto.setRecipeId(recipeId);
            dao.insertIngredientMap(mapDto);
            int ingreMapId = mapDto.getIngreMapId();

            for (RecipeIngre ingre : ingredients) {
                ingre.setIngreMapId(ingreMapId);
                result += dao.insertIngredientDetail(ingre);
            }
        }

        return result;
    }

    // --- D E L E T E (삭제) ---
    @Override
    public int delete(int recipeId, int appUserId) {
        return dao.delete(recipeId);
    }

    @Override
    public int incrementRecipeViews(int recipeId) {
        return dao.incrementRecipeViews(recipeId);
    }

    @Override
    public int getTotalRecipeCount() {
        return dao.selectRecipeTotalCount();
    }

    @Override
    public List<RecipeDto> selectRecipeListPaging(int currentPage) {
        java.util.HashMap<String, Object> para = new java.util.HashMap<>();
        int onepagelist = 10;
        int start = (currentPage - 1) * onepagelist + 1;
        int end = start + onepagelist - 1;
        para.put("start", start);
        para.put("end", end);
        return dao.selectRecipeListPaging(para);
    }

    @Override
    public String selectCategoryNameById(int categoryId) {
        return null;
    }
    
    @Override
    public List<RecipeDto> selectSearchTitle(String keyword) {

        HashMap<String, Object> para = new HashMap<>();
        para.put("search", "%" + keyword + "%");

        return dao.selectSearchTitle(para);
    }

    @Override
    public List<RecipeDto> selectSearchCategory(String keyword) {

        HashMap<String, Object> para = new HashMap<>();
        para.put("search", "%" + keyword + "%");

        return dao.selectSearchCategory(para);
    }
    
	/*
	 * @Override public List<RecipeDto> selectSearchTitle(String search) { search =
	 * "%" + search + "%"; return dao.selectSearchTitle(search); }
	 * 
	 * @Override public List<RecipeDto> selectSearchCategory(String search) { search
	 * = "%" + search + "%"; return dao.selectSearchCategory(search); }
	 */

}
