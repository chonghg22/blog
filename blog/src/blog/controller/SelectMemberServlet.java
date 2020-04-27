package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.dao.*;
import blog.service.MemberService;
import blog.service.SubjectService;
import blog.vo.*;
@WebServlet("/SelectMemberServlet")
public class SelectMemberServlet extends HttpServlet {
	private SubjectService subjectService;
	private MemberService memberService;
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		//현재 로그인 되어있는 회원의 Id값을 가져와 memberId 변수에 기입한다.
		String memberId = ((Member)(session.getAttribute("loginMember"))).getMemberId();
		
		Member member = new Member();
		member.setMemberId(memberId);
		
		memberService = new MemberService();
		memberService.selectListAll(member);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/selectMember.jsp").forward(request, response);
	}
}
