package com.company.jeongmin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.jeongmin.Dao_Dto.FoodDao;
import com.company.jeongmin.Dao_Dto.FoodDto;

public class FoodDetail implements FoodService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 넘겨받기
		int id=Integer.parseInt(request.getParameter("id"));
		//드커프리
		FoodDao dao = new FoodDao();
		
		FoodDto select = dao.select(id);
		
		
		//Dao를 잘못 적은건가... 
		
		//데이터 넘겨주기
	
	}

}
