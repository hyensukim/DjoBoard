package controllers.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//merge 후에 사용될 패키지
/*
 * import models.member.MemberServiceManager;
 */
import static commons.ScriptLibrary.*;

@WebServlet("/mypage/config")
public class ConfigController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/mypage/config.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			/*
			 * models.member 패키지 사용 - merge 후 사용
			 */
			
			//MemberServiceManager serviceManager = MemberServiceManager.getInstance();
			//models.member에 ConfigService 추가 예정
			
			//로그인 성공 -> 내 프로필로 이동
			
		} catch(RuntimeException e) {
			e.printStackTrace();
			alertError(resp, e);
		}
	}
	
}
