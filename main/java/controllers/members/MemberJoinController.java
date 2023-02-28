package controllers.members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.UrlLibrary;
import models.member.MemberJoinService;
import models.member.MemberServiceManager;
import static commons.ScriptLibrary.*;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberServiceManager serviceManager = MemberServiceManager.getInstance();
			MemberJoinService service = serviceManager.getMemberJoinService();
			service.doJoin(req);

			// 성공 -> 로그인 이동
			go(resp, UrlLibrary.getUrl(req, "/member/login"), "parent");

		} catch (RuntimeException e) {

			// 회원가입 실패, 오류 -> 자바스크립트 alert 메세지로 출력
			e.printStackTrace();
			alertError(resp, e);
		}

	}

}
