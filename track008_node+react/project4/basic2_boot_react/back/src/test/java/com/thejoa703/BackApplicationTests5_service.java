package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import com.thejoa703.dao.MaterialDao;
import com.thejoa703.dto.request.MaterialRequestDto;
import com.thejoa703.dto.request.MaterialUpdateRequestDto;
import com.thejoa703.dto.response.MaterialResponseDto;
import com.thejoa703.service.MaterialService;
import com.thejoa703.util.FileStorageService;

@ExtendWith(MockitoExtension.class)
class BackApplicationTests5_service {

    @Mock
    private MaterialDao materialDao;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private MaterialService materialService;

    @Test
    @DisplayName("페이징 목록 조회: 시작 인덱스와 끝 인덱스가 올바르게 계산되어야 함")
    void getMaterialListPaged_Success() {
        // given
        String keyword = "감자";
        int page = 2; 
        int size = 10;
        given(materialDao.select10(any())).willReturn(Collections.singletonList(new MaterialResponseDto()));

        // when
        List<MaterialResponseDto> result = materialService.getMaterialListPaged(keyword, page, size);

        // then
        assertThat(result).isNotEmpty();
        verify(materialDao).select10(argThat(map -> 
            map.get("start").equals(11) && 
            map.get("end").equals(20) && 
            map.get("keyword").equals(keyword)
        ));
    }

    @Test
    @DisplayName("식재료 등록: 파일이 있을 때 업로드 URL이 정상적으로 포함되어 저장되어야 함")
    void createMaterial_WithFile_Success() {
        // given
        MaterialRequestDto requestDto = new MaterialRequestDto();
        requestDto.setTitle("신선한 배추");
        
        MockMultipartFile file = new MockMultipartFile("file", "test.jpg", "image/jpeg", "data".getBytes());
        String uploadedUrl = "/images/test.jpg";
        
        given(fileStorageService.upload(file)).willReturn(uploadedUrl);
        given(materialDao.selectTitle("신선한 배추")).willReturn(new MaterialResponseDto());

        // when
        materialService.createMaterial(requestDto, file);

        // then
        verify(fileStorageService, times(1)).upload(file);
        // 내부에서 생성된 ResponseDto가 올바른 값을 가졌는지 확인
        verify(materialDao).insertMaterial(argThat(dto -> 
            dto.getTitle().equals("신선한 배추") && 
            dto.getImageurl().equals(uploadedUrl)
        ));
    }

    @Test
    @DisplayName("식재료 수정: 파라미터로 받은 materialid가 DTO에 정상 매핑되어 DAO로 전달되어야 함")
    void updateMaterial_Success() {
        // given
        Long materialid = 100L;
        MaterialUpdateRequestDto updateDto = new MaterialUpdateRequestDto();
        updateDto.setTitle("수정된 제목");
        updateDto.setCategory("채소류");

        given(materialDao.selectMaterial(materialid)).willReturn(new MaterialResponseDto());

        // when
        materialService.updateMaterial(materialid, updateDto, null);

        // then
        verify(fileStorageService, never()).upload(any());
        // 핵심: 서비스 메서드 인자인 materialid가 ResponseDto의 ID로 세팅되었는지 검증
        verify(materialDao).updateMaterial(argThat(dto -> 
            dto.getMaterialid() == materialid && 
            dto.getTitle().equals("수정된 제목")
        ));
        verify(materialDao).selectMaterial(materialid);
    }

    @Test
    @DisplayName("식재료 상세 조회: ID를 통해 DAO 조회가 이루어져야 함")
    void getMaterialDetail_Success() {
        // given
        Long id = 50L;
        given(materialDao.selectMaterial(id)).willReturn(new MaterialResponseDto());

        // when
        materialService.getMaterialDetail(id);

        // then
        verify(materialDao).selectMaterial(id);
    }

    @Test
    @DisplayName("식재료 삭제: ID를 통해 DAO 삭제 호출이 이루어져야 함")
    void deleteMaterial_Success() {
        // given
        Long id = 77L;

        // when
        materialService.deleteMaterial(id);

        // then
        verify(materialDao).deleteMaterial(id);
    }
}