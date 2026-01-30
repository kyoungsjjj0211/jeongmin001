package com.thejoa703.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.thejoa703.dao.MaterialDao;
import com.thejoa703.dto.request.MaterialRequestDto;
import com.thejoa703.dto.request.MaterialUpdateRequestDto;
import com.thejoa703.dto.response.MaterialResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.util.FileStorageService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MaterialService {
    private final MaterialDao materialDao;
    // private final FileUploadService fileUploadService; // 파일 업로드 유틸리티가 있다면 주입
    private final FileStorageService  fileStorageService; //##

    public List<MaterialResponseDto> getMaterialListPaged(String keyword, int page, int size) {
        int start = (page - 1) * size + 1;
        int end = page * size;
        HashMap<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("start", start);
        params.put("end", end);
        return materialDao.select10(params);
    }
    public MaterialResponseDto getMaterialDetail(Long materialId) {
        return materialDao.selectMaterial(materialId);
    }
    @Transactional
    public MaterialResponseDto createMaterial(MaterialRequestDto dto, MultipartFile file) {
    MaterialResponseDto responseDto = new MaterialResponseDto();
    responseDto.setTitle(dto.getTitle());
    responseDto.setSeason(dto.getSeason());
    responseDto.setTemperature(dto.getTemperature());
    responseDto.setCalories100g(dto.getCalories100g());
    responseDto.setEfficacy(dto.getEfficacy());
    responseDto.setBuyguide(dto.getBuyguide());
    responseDto.setTrimguide(dto.getTrimguide());
    responseDto.setStoreguide(dto.getStoreguide());
    responseDto.setCategory(dto.getCategory());
    responseDto.setAllergy(dto.getAllergy());
        
        if (file != null && !file.isEmpty()) {
             String imageUrl = fileStorageService.upload(file);
             responseDto.setImageurl(imageUrl);             
        }
        materialDao.insertMaterial(responseDto);
        return materialDao.selectTitle(dto.getTitle());
    }
    
    @Transactional
    public MaterialResponseDto updateMaterial(Long materialid, MaterialUpdateRequestDto dto, MultipartFile file) {
    MaterialResponseDto responseDto = new MaterialResponseDto();
    responseDto.setMaterialid(materialid);
    responseDto.setTitle(dto.getTitle());
    responseDto.setSeason(dto.getSeason());
    responseDto.setTemperature(dto.getTemperature());
    responseDto.setCalories100g(dto.getCalories100g());
    responseDto.setEfficacy(dto.getEfficacy());
    responseDto.setBuyguide(dto.getBuyguide());
    responseDto.setTrimguide(dto.getTrimguide());
    responseDto.setStoreguide(dto.getStoreguide());
    responseDto.setCategory(dto.getCategory());
    responseDto.setAllergy(dto.getAllergy());
   

    if (file != null && !file.isEmpty()) {
        String imageUrl = fileStorageService.upload(file);
        responseDto.setImageurl(imageUrl);
        }
        materialDao.updateMaterial(responseDto);
        return materialDao.selectMaterial(materialid);
    }
    @Transactional
    public void deleteMaterial(Long materialId) {

        materialDao.deleteMaterial(materialId);

    }

}