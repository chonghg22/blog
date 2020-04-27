package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.service.SubjectService;
import blog.vo.Subject;

/**
 * Servlet implementation class InsertSubjectListServlet
 */
@WebServlet("/InsertSubjectListServlet")
public class InsertSubjectListServlet extends HttpServlet {
	private Subject subject;
	private SubjectService subjectService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//jsp 폼을 가져오기
	request.getRequestDispatcher("/WEB-INF/views/insertSubject.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩작업
		request.setCharacterEncoding("UTF-8");
		//insertSubject.jsp에서 입력한 subjectName값을 가져온다.
		String subjectName = request.getParameter("subjectName");
		//객체 선언
		subject = new Subject();
		subject.setSubjectName(subjectName);
		//객체 선언
		subjectService = new SubjectService();
		//subject 변수값을 서비스로 보낸다.
		subjectService.insertSubjectList(subject);
		//최종 실행 된 후 지정된 페이지로 돌아간다.
		response.sendRedirect(request.getContextPath() + "/SelectSubjectAllServlet");
				
	}

}
