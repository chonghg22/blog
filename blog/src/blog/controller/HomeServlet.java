
package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.dao.SubjectDao;
import blog.service.SubjectService;
import blog.vo.*;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private SubjectService subjectService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트 호출
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);		
		//jsp폼을 가져와서 보여준다.
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}


}

