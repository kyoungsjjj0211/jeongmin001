package com.company.jeongmin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.jeongmin.Dao_Dto.FoodDao;
import com.company.jeongmin.Dao_Dto.FoodDto;

public class FoodDelete implements FoodService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //유니코드로 한글,문자 충돌 안나게 하는거..
		
		int id = Integer.parseInt(request.getParameter("id"));
		String Name = request.get.Parameter("Name");
		int CategoryId = Integer.parseInt(request.getParameter("CategoryId")); 
		  	Double.getKcal();  //Double은 뭐로 정의해야하나요..?
	        Double.getProtein();
	        Double.getCarb();
	        Double.getFat();
	        String Recipe = request.get.Recipe("Recipe");
	        String ImageUrl = request.get.ImageUrl("ImageUrl");
	     	int FoodId = Integer.parseInt(request.getParameter("FoodId"));
			
			//드커프리
		FoodDao dao = new FoodDao();
		FoodDto dto = new FoodDto();
		   dto.settName();
           dto.setCategoryId(); 
           dto.setKcal();
           dto.setProtein();
           dto.setCarb();
           dto.setFat();
           dto.setRecipe();
           dto.setImageUrl();
           dto.setFoodId();
		//뭘 받아서 뭘 삭제해야할지... 정보를 뭘 가져와야 하나요..
		
		request.setAttribute("result", String.valueOf(dao.delete(dto)));
	}

}
