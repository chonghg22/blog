package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import blog.dao.*;
import blog.vo.*;
import blog.service.*;

@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	private MemberService memberService;
	private SubjectService subjectService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트 호출
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("/WEB-INF/views/deleteMember.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//현재 로그인 되어있는값을 변수로 기입한다.
		Member member = (Member)(request.getSession().getAttribute("loginMember"));
		member.setMemberPw(request.getParameter("memberPw"));
		//System.out.println(member.getMemberId() + "<-- memberId");
		
		//객체선언
		memberService = new MemberService();
		//member의 변수값을 memberService로 보낸다.
		memberService.remove(member);
		
		
		response.sendRedirect(request.getContextPath()+"/LogoutServlet");
	}

}
