
package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import blog.dao.*;
import blog.vo.*;
import java.sql.*;
import java.util.List;
import blog.service.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private SubjectService subjectService;
	private MemberService memberService;
	//login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//객체선언
		subjectService = new SubjectService();
		//Subject 테이블의 리스트를 가져온다.
		List<Subject> subjectList = subjectService.getSubjectList();
		//sjujectList 변수값을 가져오고 그걸 다시 subjectList 변수로 선언한다.
		request.setAttribute("subjectList", subjectList);
		//로그인 페이지 폼을 가져온다.
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	//login action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		//System.out.println(memberId + "/memberId/LoginId");
		String memberPw = request.getParameter("memberPw");
		//System.out.println(memberPw + "/memberPw/LoginPw");
		
		//객체선언
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		//System.out.println(member + "/member/Loginmember/");
		//객체선언
		memberService = new MemberService();
		//member 변수값을 selectall 메소드로 보내 실행시킨뒤 그 값을 다시 가져와 retrunmember 변수에 기입한다.
		Member returnMember = memberService.selectAll(member);
		//System.out.println(returnMember + "returnMember/Login/");
		if(returnMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", returnMember);
			System.out.println("로그인성공");
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
		}
	}
}


