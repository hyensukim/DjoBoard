package controllers.members;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commons.UrlLibrary;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		session.invalidate();

	// 로그아웃 후 -> 로그인 페이지 이동
	resp.sendRedirect(UrlLibrary.getUrl(req, "/member/login"));
	
	}

}
