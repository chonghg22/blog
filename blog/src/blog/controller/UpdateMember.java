package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.service.MemberService;
import blog.vo.Member;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UpdateMember")
public class UpdateMember extends HttpServlet {
	MemberService memberService;
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		System.out.println(memberId + "/memberId/updateMember");
		Member member = new Member();
		member.setMemberId(memberId);
		
		memberService = new MemberService();
		member = memberService.selectListAll(member);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/updateMember.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		System.out.println(memberId + "/memberId/post/updateMember");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw + "/memberPw/updateMember");
		String memberPhone = request.getParameter("memberPhone");
		System.out.println(memberPhone + "/memberPhone/updateMember");
		String memberAddress = request.getParameter("memberAddress");
		System.out.println(memberAddress + "/memberAddress/updatemember");
		String memberBirth = request.getParameter("memberBirth");
		System.out.println(memberBirth + "/memberBirth/updatemember");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberAddress(memberAddress);
		member.setMemberPw(memberPw);
		member.setMemberPhone(memberPhone);
		member.setMemberBirth(memberBirth);
		
		memberService = new MemberService();
		memberService.updateMember(member);
		
		response.sendRedirect(request.getContextPath() + "/HomeServlet");
	}

}
