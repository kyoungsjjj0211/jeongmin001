package com.thejoa703.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialRequestDto {
	    private String title;
	    private String season;
	    private String temperature;
	    private String calories100g;
	    private String efficacy;
	    private String buyguide;
	    private String trimguide;
	    private String storeguide;
	    private String category; 
	    private String allergy;
}
