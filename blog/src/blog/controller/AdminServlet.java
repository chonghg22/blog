package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import blog.vo.*;
import blog.service.SubjectService;
import blog.vo.Subject;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	//클래스명이랑 변수명을 미리 선언하여 밑에서 클래스명을 생략 할 수 있다.
	private SubjectService subjectService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//리스트 호출
		subjectService = new SubjectService();
		//subjectService 내 getSubjectList 메소드의 값을 subject 리스트에 기입한다.
		List<Subject> subjectList = subjectService.getSubjectList();
		//subjectList의 값을 가져오고 "subjectList"라는 변수로 지정한다.
		request.setAttribute("subjectList", subjectList);
		
		//로그인 된 사람만 들어올 수 있다.
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		//로그인이 되어있지 않으면 홈으로 돌아가기
		if(loginMember == null || loginMember.getMemberLevel() >= 10) {
		response.sendRedirect(request.getContextPath()+"/HomeServlet");
		}
		//jsp파일의 폼을 가져와서 보여준다.
		request.getRequestDispatcher("/WEB-INF/views/admin.jsp").forward(request, response);
	}


}
