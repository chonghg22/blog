package blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.service.CommentService;
import blog.service.LikeyService;
import blog.service.PostService;
import blog.service.SubjectService;
import blog.vo.Comment;
import blog.vo.Post;
import blog.vo.Subject;

/**
 * Servlet implementation class SelectPostOneServlet
 */
@WebServlet("/SelectPostOneServlet")
public class SelectPostOneServlet extends HttpServlet {
	private SubjectService subjectService;
	private PostService postService;
	private CommentService commentService;
	private LikeyService likeyService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		request.setAttribute("subjectList", subjectList);
		postService = new PostService();
		Post post = postService.selectOne(postNo);
		request.setAttribute("post", post);
	
		
		//commentList
		commentService = new CommentService();
		List<Comment> commentList = commentService.getCommentListByPostNo(postNo);
	    request.setAttribute("commentList", commentList);
		//likeyCount
		likeyService = new LikeyService();
		Map<String, Integer> map= likeyService.getCountLikey(postNo);
		request.setAttribute("map", map);		
	    
		request.getRequestDispatcher("/WEB-INF/views/selectPostOne.jsp").forward(request, response);
	}

	
	

}
