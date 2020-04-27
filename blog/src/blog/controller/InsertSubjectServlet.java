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

import blog.service.PostService;
import blog.service.SubjectService;
import blog.vo.Member;
import blog.vo.Post;
import blog.vo.Subject;

/**
 * Servlet implementation class InsertSubjectServlet
 */
@WebServlet("/InsertSubjectServlet")
public class InsertSubjectServlet extends HttpServlet {
	private PostService postService;
	private SubjectService subjectService;
	private final int ROW_PER_PAGE = 5;
	private Post post;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//로그인 되어있는 회원의 값을 가져온다
		Member loginMember = (Member)session.getAttribute("loginMember");
		//로그인이 되어있지 않거나 로그인한 멤버의 레벨이 10보다 크거나 같으면 홈으로 돌아간다.
		if(loginMember == null || loginMember.getMemberLevel() >= 10) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;
		}
		
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String subjectName = request.getParameter("subjectName");
		postService = new PostService();
		List<Post> postList = postService.getBySubject(subjectName);
		request.setAttribute("postList", postList);
		Map<String, Object> map = postService.getPostAll(currentPage, ROW_PER_PAGE);
		request.setAttribute("list", map.get("list"));
		request.setAttribute("lastPage", map.get("lastPage"));
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("/WEB-INF/views/insertSubjectContent.jsp").forward(request, response);
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		//System.out.println(memberId + "/memberId/insertSubject/");
		String subjectName = request.getParameter("subjectName");
		//System.out.println(subjectName + "/subjectName/insertSubject/");
		String postTitle = request.getParameter("postTitle");
		//System.out.println(postTitle + "/postTitle/insertsubject");
		String postContent = request.getParameter("postContent");
		//System.out.println(postContent + "/postContent/insertsubject");
		
		post = new Post();
		post.setMemberId(memberId);
		post.setSubjectName(subjectName);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		
		postService = new PostService();
		postService.insertBySubject(post);
		response.sendRedirect(request.getContextPath() + "/HomeServlet");
		
	}

}
