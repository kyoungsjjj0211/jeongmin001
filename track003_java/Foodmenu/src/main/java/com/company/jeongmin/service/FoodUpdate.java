package com.company.jeongmin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.jeongmin.Dao_Dto.FoodDao;
import com.company.jeongmin.Dao_Dto.FoodDto;

public class FoodUpdate implements FoodService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		FoodDao updateDao = new FoodDao();
        FoodDto updateDto = new FoodDto();
        updateDto.setName("김치찌개 - 수정");
        updateDto.setCategoryId(1); 
        updateDto.setKcal(480);
        updateDto.setProtein(22.0);
        updateDto.setCarb(16.0);
        updateDto.setFat(19.0);
      	updateDto.setRecipe("김치와 돼지고기를 넣고 더 진하게 끓입니다.");
        updateDto.setImageUrl("images/kimchi_stew_updated.jpg");
        updateDto.setFoodId(5);
        
		request.setAttribute("dto", updateDao);
		request.setAttribute("dto", updateDto);
		
	}

	
}
