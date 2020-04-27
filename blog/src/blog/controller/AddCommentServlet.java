package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.dao.CommentDao;
import blog.service.CommentService;
import blog.vo.Comment;
import blog.vo.Member;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private Comment comment;
    private CommentService commentService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//인코딩작업
	request.setCharacterEncoding("UTF-8");
	//세션작업/로그인 된 사람만 들어올 수 있다.
	HttpSession session = request.getSession();
	//loginMember 변수에 로그인되어있는 회원의 정보를 담는다.
	Member loginMember = (Member)session.getAttribute("loginMember");
	//System.out.println(loginMember.getMemberId()+ "/loginMember");
	//로그인이 되어있지 않은 상태에서 코맨트를 작성하려고 하면 홈으로 돌아간다.
	if(loginMember == null) {
		response.sendRedirect(request.getContextPath() + "/HomeServlet");
		return;
	}
	
	//selectPostOne jsp에서 hidden으로 보낸  postNo를  숫자값으로 변환해서 변수에 기입한다.
	int postNo = Integer.parseInt(request.getParameter("postNo"));
	System.out.println(postNo + "/postNo/addComment/");
	
	//로그인 되어있는 id 값을 가져와서 memeberId에 변수 기입한다.
	String memberId = loginMember.getMemberId();
	System.out.println(memberId+ "/memberId/addComment/");
	
	//selectPostOne에서 입력한 commentContent값을 가져와서 변수로 지정한다. 
	String commentContent = request.getParameter("commentContent");
	System.out.println(commentContent + "/commentContent/addComment/");
	
	//객체선언을 하고 변수 지정한 값들을 comment에 기입한다.
	comment = new Comment();
	comment.setCommentContent(commentContent);
	comment.setPostNo(postNo);
	comment.setMemberId(memberId);
	//System.out.println(comment +"/comment/addComment");
	
	//commentService 객체를 선언하고 comment변수값을 서비스로 보낸다. 
	commentService = new CommentService();
	commentService.addComment(comment);
	//결과가 완료되면 지정된 주소로 돌아간다.
	response.sendRedirect(request.getContextPath() + "/SelectPostOneServlet?postNo="+postNo);
	}

}
