package controllers.members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.UrlLibrary;
import models.member.MemberLoginService;
import models.member.MemberServiceManager;
import static commons.ScriptLibrary.*;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		MemberServiceManager manager = MemberServiceManager.getInstance();
		MemberLoginService service = manager.getMemberLoginService();
				service.doLogin(req, resp);
		//로그인 성공 -> 메인페이지
				go(resp, UrlLibrary.getUrl(req), "parent");
				
		}catch(Exception e) {
			e.printStackTrace();
			//로그인 실패 -> alert로 예외 알림
			alertError(resp, e);
		}

	}
	
	

}
