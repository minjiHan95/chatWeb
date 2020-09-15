package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userId = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");

		UserDAO myUser = new UserDAO();
		int result = myUser.login(userId, userPassword);
		
		if(result==1) {
			//로그인 성공 -> main 페이지로 돌아간다.
			HttpSession session = request.getSession();
			session.setAttribute("memberID", userId);
			response.sendRedirect("index.jsp");
			
		} else if(result==0) {
			//비밀번호 불일치
			out.print("비밀번호가 다릅니다..");
		} else {
			out.print("일치하는 회원정보가 존재하지 않음");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
