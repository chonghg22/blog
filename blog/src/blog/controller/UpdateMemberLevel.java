package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.*;
import blog.vo.*;

@WebServlet("/UpdateMemberLevel")
public class UpdateMemberLevel extends HttpServlet {
	private MemberService memberService;
	private SubjectService subjectService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null || loginMember.getMemberLevel()>=10) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		
		String memberId = request.getParameter("memberId");
		
		Member member = new Member();
		member.setMemberId(memberId);
		
		memberService = new MemberService();
		member = memberService.selectListAll(member);
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/WEB-INF/views/updateLevel.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		int memberLevel = Integer.parseInt(request.getParameter("memberLevel"));
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberLevel(memberLevel);
		
		memberService = new MemberService();
		memberService.updateLevle(member);
		
		response.sendRedirect(request.getContextPath()+"/SelectMemberAllServlet");
	}

}
