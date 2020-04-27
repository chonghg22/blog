package blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.service.LikeyService;
import blog.vo.Likey;
import blog.vo.Member;

/**
 * Servlet implementation class AddLikeyServlet
 */
@WebServlet("/AddLikeyServlet")
public class AddLikeyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 되어있는 유저만 접속 가능하다.
		HttpSession session = request.getSession();
		//현재 로그인 되어있는 사람의 정보를 loginMember 변수에 기입한다.
		Member loginMember = (Member)session.getAttribute("loginMember");
		//로그인이 아닌 상태일경우 홈으로 돌아가기
		if(loginMember == null) {
		response.sendRedirect(request.getContextPath() + "/HomeServlet");
		return;
			}
		//selectPostOne.jsp에서 넘긴 postNo값을 받아 다시 postNo 변수로 기입한다.
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		//System.out.println(postNo + "/postNo/11111");
		//selectPostOne.jsp에서 넘긴  likeyCk값을 받아 다시 likeyCk 변수로 기입한다.
		int likeyCk = Integer.parseInt(request.getParameter("likeyCk"));
		//System.out.println(likeyCk +"/likeyCk");
		
		//현재 로그인 되어있는 아이디를 변수로 기입한다.
		String memberId = loginMember.getMemberId();
		
		//객체선언
		Likey likey = new Likey();
		likey.setPostNo(postNo);
		likey.setMemberId(memberId);
		likey.setLikeyCk(likeyCk);
		
		//객체선언
		LikeyService likeyService = new LikeyService();
		//likeyService로 likey변수값을 보낸다.
		likeyService.addLikey(likey);
		//실행이 된 후 다른페이지로 돌아간다.
		response.sendRedirect(request.getContextPath() + "/SelectPostOneServlet?postNo="+postNo);
	}	

}
