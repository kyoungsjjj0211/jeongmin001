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
		
		//드커프리
		FoodDao dao = new FoodDao();
		FoodDto dto = new FoodDto();
		//뭘 받아서 뭘 삭제해야할지... 정보를 뭘 가져와야 하나요..
		
		request.setAttribute("result", String.valueOf(dao.delete(dto)));
	}

}
