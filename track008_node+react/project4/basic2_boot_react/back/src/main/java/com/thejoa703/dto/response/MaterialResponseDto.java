package com.thejoa703.dto.response;

import java.time.LocalDateTime;

import com.thejoa703.entity.Material;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialResponseDto {
  	private long materialid;
    private String title;
    private String imageurl;
    private String season;
    private String temperature;
    private String calories100g;
    private String efficacy;
    private String buyguide;
    private String trimguide;
    private String storeguide;
    private String category;
    private LocalDateTime createdat;
    private LocalDateTime updatedat; 
    private String allergy;
    
    // 이 생성자가 엔티티를 정확히 받아야 서비스의 빨간줄이 사라집니다.
    public MaterialResponseDto(Material entity) {
        this.materialid = entity.getMaterialid().intValue();      
        this.title = entity.getTitle();
        this.imageurl = entity.getImageurl();
        this.season = entity.getSeason();
        this.temperature = entity.getTemperature();
        this.calories100g = entity.getCalories100g();
        this.efficacy = entity.getEfficacy();
        this.buyguide = entity.getBuyguide();
        this.trimguide = entity.getTrimguide();
        this.storeguide = entity.getStoreguide();
        this.category = entity.getCategory();
        this.createdat = entity.getCreatedat();
        this.updatedat = entity.getUpdatedat();
        this.allergy = entity.getAllergy();
    }
}