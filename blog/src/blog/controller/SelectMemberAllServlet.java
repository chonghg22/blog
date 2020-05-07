package blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.*;
import blog.vo.*;

@WebServlet("/SelectMemberAllServlet")
public class SelectMemberAllServlet extends HttpServlet {
	private SubjectService subjectService;
	private MemberService memberService;
	private final int ROW_PER_PAGE = 5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null || loginMember.getMemberLevel() >= 10) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		
		memberService = new MemberService();
		Map<String, Object> map = memberService.getMemberList(currentPage,ROW_PER_PAGE);
		request.setAttribute("memberList", map.get("list"));
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/WEB-INF/views/selectMemberAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
