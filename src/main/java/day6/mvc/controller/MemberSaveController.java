package day6.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//MemberSaveController는 post
public class MemberSaveController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String test = request.getParameter("test");
		//post 요청 처리 후에는 튻정 url로 리다이텍트합니다
		response.sendRedirect("modify?test=" + test);
	}
}
	
	