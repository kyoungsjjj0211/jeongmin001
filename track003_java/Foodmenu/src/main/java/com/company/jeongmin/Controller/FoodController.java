package com.company.jeongmin.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.jeongmin.service.FoodDelete;
import com.company.jeongmin.service.FoodDetail;
import com.company.jeongmin.service.FoodInsert;
import com.company.jeongmin.service.FoodList;
import com.company.jeongmin.service.FoodService;
import com.company.jeongmin.service.FoodUpdate;
import com.company.jeongmin.service.FoodUpdateView;

/**
 * Servlet implementation class FoodController
 */
@WebServlet("*.food")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath(); // /a.do
		System.out.println(path);
		
		FoodService service = null; //##
		
		if(path.equals("/list.do")) {
			service = new FoodList(); service.exec(request, response);
			request.getRequestDispatcher("View/list.jsp").forward(request, response);
			
		}else if (path.equals("/writeview.do")) {
			request.getRequestDispatcher("View/write.jsp").forward(request, response);
			
		}else if (path.equals("/write.do")) {
			service = new FoodInsert(); service.exec(request, response);
			
			String result = (String)request.getAttribute("result");
			if(result.equals("1")) {
				out.println("<script>alert('글쓰기에 성공했습니다.');location.href='list.do';</script>");
			}else {
				out.println("<script>alert('다시 시도해주시기 바랍니다.');location.href='list.do';</script>");
			}
		}else if (path.equals("/detail.do")) { //작성한 글의 상세보기
			service = new FoodDetail(); service.exec(request, response);
			request.getRequestDispatcher("View/detail.jsp").forward(request, response);
		}else if (path.equals("/editView.do")) { //수정내용 확인
			service = new FoodUpdateView(); service.exec(request, response);
			request.getRequestDispatcher("View/edit.jsp").forward(request, response);
		}else if (path.equals("edit.do")) { //수정
			service = new FoodUpdate(); service.exec(request, response);
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			String result = (String) request.getAttribute("result");
			if(result.equals("1")) {
				out.println("<seript>alert('내용수정에 성공했습니다.');location.href='detail.do?id=" + request.getParameter("id") + "'l</script>");
			}else {
				out.println("<script>alert('비밀번호를 확인해주세요.'); history.go(-1); </script>");
			}
			
		}else if (path.equals("/deleteView.do")) {
			
			request.getRequestDispatcher("View/delete.jsp").forward(request, response);
		}else if (path.equals("/delete.do")) {
			service = new FoodDelete(); service.exec(request,response);
			String result = (String) request.getAttribute("result");
			if(result.equals("1")) {
				out.println("<script>alert('글삭제에 성공했습니다.');location.href='list.do;</script>");
			}else {
				out.println("<script>alert('비밀번호를 확인해주세요.');history.go(-1);</script>");
				}
			}		
		}
	}
