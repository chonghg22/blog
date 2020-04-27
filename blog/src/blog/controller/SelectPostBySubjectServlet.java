package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.*;
import blog.vo.*;
import java.util.*;
import java.sql.*;

@WebServlet("/SelectPostBySubjectServlet")
public class SelectPostBySubjectServlet extends HttpServlet {
	private SubjectService subjectService;
	private PostService postService;
	private CommentService commentService;
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
		
		//selectPostList.jsp에서 기입한 subjectName값을 가져와 다시 subjectName 변수에 값을 기입한다.
		String subjectName = request.getParameter("subjectName");
		System.out.println(subjectName +"/subjectName/");
		
		
		postService = new PostService();
		//리스트 나열
		List<Post> list = postService.getBySubject(subjectName);
		System.out.println(list + "/list/");
		request.setAttribute("list", list);
		commentService = new CommentService();
		
		request.getRequestDispatcher("/WEB-INF/views/selectPostList.jsp").forward(request, response);
		
		
	}


}