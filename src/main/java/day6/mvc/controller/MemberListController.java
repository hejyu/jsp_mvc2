package day6.mvc.controller;

import day6.mvc.dao.MybatisMemberDao;
import day6.mvc.dto.CustomerDto;
import day6.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(MemberListController.class);


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MybatisMemberDao dao = new MybatisMemberDao();

		List<CustomerDto> list = dao.selectAll();

		request.setAttribute("list",list);

		RequestDispatcher dispacher = request.getRequestDispatcher("list.jsp");
		dispacher.forward(request,response);

		logger.info("[회원 목록] : {}  ", list);
	
	}

}