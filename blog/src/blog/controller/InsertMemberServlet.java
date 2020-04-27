package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.MemberService;
import blog.service.SubjectService;
import blog.vo.Subject;
import blog.vo.*;
@WebServlet("/InsertMemberServlet")
public class InsertMemberServlet extends HttpServlet {
	private SubjectService subjectService;
    private MemberService memberService;   
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리스트 호출한다.
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		//로그인 한 사람만 접속 가능
		HttpSession session = request.getSession();
		//로그인 하지 않은사람은 홈으로 돌아가기
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		//jsp폼을 가져와서 보여준다.
		request.getRequestDispatcher("/WEB-INF/views/insertMember.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 한 사람만 접속가능
		HttpSession session = request.getSession();
		//로그인이 아니면 홈으로 돌아가기
		if(session.getAttribute("loginMember") != null) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		//login.jsp에서 입력한 memberId값을 가져와 memberId 변수에 기입한다.
		String memberId = request.getParameter("memberId");
		System.out.println(memberId+"<<<<<<<<<<<<<<<<memberId");
		//login.jsp에서 입력한 memberPw값을 가져와 memberPw 변수에 기입한다.
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw+"<<<<<<<<<<<<<<<memberPw");
		String memberPhone = request.getParameter("memberPhone");
		System.out.println(memberPhone + "/memberPhone/insertMember");
		String memberAddress = request.getParameter("memberAddress");
		System.out.println(memberAddress + "/memberAddress/insertMember");
		String memberBirth = request.getParameter("memberBirth");
		System.out.println(memberBirth + "/memberBirth/insertMember");
		
		//객체 선언 후 request로 가져온 값을을 member변수에 기입한다.
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberBirth(memberBirth);
		
		memberService = new MemberService();
		//기존에 가입되어있던 회원이면 홈으로 돌아간다.
		if(memberService.addMember(member)) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
		//가입한 회원이 아닐경우 회원가입창으로 넘어간다.
		}else {
			response.sendRedirect(request.getContextPath()+"/InsertMemberServlet");
			System.out.println("로그인 성공");
		}
	}
}
