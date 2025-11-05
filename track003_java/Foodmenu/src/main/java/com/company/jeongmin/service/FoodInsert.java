package com.company.jeongmin.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.jeongmin.Dao_Dto.FoodDao;
import com.company.jeongmin.Dao_Dto.FoodDto;

public class FoodInsert implements FoodService{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int foodid = (Integer)session.getAttribute("foodid");
		String name = request.getParameter("name");
		int categoryid = (Integer)session.getAttribute("categoryid");
		double kcal = Double.parseDouble(request.getParameter("kcal"));
		double protein = Double.parseDouble(request.getParameter("protein"));
		double carb = Double.parseDouble(request.getParameter("carb"));
		double fat = Double.parseDouble(request.getParameter("fat"));
		String recipe = request.getParameter("recipe");
		String imageurl = request.getParameter("imageurl");
		String regdateStr = request.getParameter("regdate");
		Date regdate = null;
		try { 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			regdate = sdf.parse(regdateStr);
		} catch(Exception e) {e.printStackTrace();
		}
		
		FoodDao dao = new FoodDao();
		FoodDto dto = new FoodDto();
		dto.setFoodId(foodid);
		dto.setName(name); dto.setCategoryId(categoryid); dto.setKcal(kcal); dto.setProtein(protein);
		dto.setCarb(carb); dto.setFat(fat); dto.setRecipe(recipe); dto.setImageUrl(imageurl); dto.setRegDate(regdate);
		String result = String.valueOf(dao.insert(dto));
		
		request.setAttribute("result", result);
		
		
		
		
	}

}
