package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.Board;
import board.BoardDAO;
import user.User;
import user.UserDAO;

@WebServlet("/add")
public class AddBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("memberID");
		
		System.out.println(userId);

		String b_Title = request.getParameter("b_Title");
		String b_Content = request.getParameter("b_Content");

		Board board = new Board(b_Title, userId, b_Content, 1);
		BoardDAO myBoard = new BoardDAO();

		int result = myBoard.create(board);

		if (result == 1) {
			out.print("ok");

		} else {
			out.print("회원가입 실패");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
