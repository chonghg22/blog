package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.SubjectService;
import blog.vo.Member;
import blog.vo.Subject;

/**
 * Servlet implementation class SelectSubjectAllServlet
 */
@WebServlet("/SelectSubjectAllServlet")
public class SelectSubjectAllServlet extends HttpServlet {
	private SubjectService subjectService;
	private Subject subject;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null || loginMember.getMemberLevel()>=10) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}		
		
		subjectService = new SubjectService();
		
		
		List<Subject> subjectList = subjectService.getSubjectListAll();
		System.out.println(subjectList.size() + "/test");
		request.setAttribute("subjectList", subjectList);	
	
	request.getRequestDispatcher("/WEB-INF/views/selectSubjectList.jsp").forward(request, response);
	}



}
