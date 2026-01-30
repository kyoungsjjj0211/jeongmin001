package com.thejoa703.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.request.MaterialRequestDto;
import com.thejoa703.dto.request.MaterialUpdateRequestDto;
import com.thejoa703.dto.response.MaterialResponseDto;
import com.thejoa703.service.MaterialService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    /**
     * 1. 식재료 목록 조회 (페이징 및 검색)
     * GET /api/materials?keyword=배추&page=1&size=10
     */
    @GetMapping
    public ResponseEntity<List<MaterialResponseDto>> getMaterialList(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        
        List<MaterialResponseDto> list = materialService.getMaterialListPaged(keyword, page, size);
        return ResponseEntity.ok(list);
    }

    /**
     * 2. 식재료 상세 조회
     * GET /api/materials/{materialid}
     */
    @GetMapping("/{materialid}")
    public ResponseEntity<MaterialResponseDto> getMaterialDetail(@PathVariable("materialid") Long materialid) {
        MaterialResponseDto detail = materialService.getMaterialDetail(materialid);
        return ResponseEntity.ok(detail);
    }

    /**
     * 3. 식재료 등록
     * POST /api/materials
     * @ModelAttribute를 사용하여 폼 데이터(title, season 등)를 DTO로 직접 바인딩합니다.
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MaterialResponseDto> createMaterial(
            @ModelAttribute MaterialRequestDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        
        log.info("식재료 등록 시작: {}", dto.getTitle());
        MaterialResponseDto result = materialService.createMaterial(dto, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * 4. 식재료 수정
     * PUT /api/materials/{materialid}
     * URL의 ID를 서비스에 명시적으로 전달합니다.
     */
    @PutMapping(value = "/{materialid}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MaterialResponseDto> updateMaterial(
            @PathVariable("materialid") Long materialid,
            @ModelAttribute MaterialUpdateRequestDto dto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        
        log.info("식재료 수정 시작 - ID: {}, Title: {}", materialid, dto.getTitle());
        MaterialResponseDto result = materialService.updateMaterial(materialid, dto, file);
        return ResponseEntity.ok(result);
    }

    /**
     * 5. 식재료 삭제
     * DELETE /api/materials/{materialid}
     */
    @DeleteMapping("/{materialid}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable("materialid") Long materialid) {
        log.info("식재료 삭제 시작 - ID: {}", materialid);
        materialService.deleteMaterial(materialid);
        return ResponseEntity.noContent().build();
    }
}