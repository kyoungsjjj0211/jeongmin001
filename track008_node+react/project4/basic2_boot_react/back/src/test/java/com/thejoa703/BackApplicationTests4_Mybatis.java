package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dao.MaterialDao;
import com.thejoa703.dto.response.MaterialResponseDto;

@SpringBootTest
@Transactional // 테스트 완료 후 자동으로 롤백하여 DB 청결 유지
class BackApplicationTests4_Mybatis {

    @Autowired
    private MaterialDao materialDao;

    @Test
    @DisplayName("Material XML Mapper 통합 기능 테스트")
    void materialMapperTest() {
        
        // 1. insertMaterial 테스트
        // 인터페이스 정의에 따라 MaterialResponseDto를 파라미터로 사용합니다.
        MaterialResponseDto testDto = new MaterialResponseDto();
        testDto.setTitle("매퍼테스트_배추");
        testDto.setCategory("채소");
        testDto.setSeason("겨울");
        testDto.setAllergy("없음");
        testDto.setImageurl("test_url.jpg");
        testDto.setTemperature("5도");
        testDto.setCalories100g("20kcal");
        testDto.setEfficacy("비타민 C 풍부");
        testDto.setBuyguide("잎이 싱싱한 것");
        testDto.setTrimguide("겉잎을 떼어내고 세척");
        testDto.setStoreguide("냉장 보관");

        long insertResult = materialDao.insertMaterial(testDto);
        assertThat(insertResult).isGreaterThan(0); // MyBatis는 영향을 받은 행의 수를 반환함

        // 2. selectTitle 테스트 (방금 넣은 데이터 조회)
        MaterialResponseDto foundByTitle = materialDao.selectTitle("매퍼테스트_배추");
        assertThat(foundByTitle).isNotNull();
        assertThat(foundByTitle.getTitle()).isEqualTo("매퍼테스트_배추");
        
        Long generatedId = foundByTitle.getMaterialid(); // 시퀀스로 생성된 ID 확보

        // 3. selectMaterial 테스트 (ID로 조회)
        MaterialResponseDto foundById = materialDao.selectMaterial(generatedId);
        assertThat(foundById).isNotNull();
        assertThat(foundById.getMaterialid()).isEqualTo(generatedId);

        // 4. updateMaterial 테스트
        foundById.setTitle("수정된_매퍼배추");
        foundById.setCategory("가공채소");
        
        long updateResult = materialDao.updateMaterial(foundById);
        assertThat(updateResult).isGreaterThan(0);

        // 수정 확인
        MaterialResponseDto updatedDto = materialDao.selectMaterial(generatedId);
        assertThat(updatedDto.getTitle()).isEqualTo("수정된_매퍼배추");

        // 5. select10 (페이징/검색) 테스트
        HashMap<String, Object> params = new HashMap<>();
        params.put("keyword", "수정된");
        params.put("start", 1);
        params.put("end", 10);

        List<MaterialResponseDto> list = materialDao.select10(params);
        assertThat(list).isNotEmpty();
        assertThat(list.get(0).getTitle()).contains("수정된");

        // 6. selectTotalCnt 테스트
        long totalCnt = materialDao.selectTotalCnt("수정된");
        assertThat(totalCnt).isGreaterThanOrEqualTo(1);

        // 7. deleteMaterial 테스트
        long deleteResult = materialDao.deleteMaterial(generatedId);
        assertThat(deleteResult).isGreaterThan(0);

        // 삭제 확인
        MaterialResponseDto afterDelete = materialDao.selectMaterial(generatedId);
        assertThat(afterDelete).isNull();
    }
}