package controllers.admin;

import static commons.ScriptLibrary.alertError;
import static commons.ScriptLibrary.go;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.UrlLibrary;
import models.admin.BoardConfig;
import models.admin.services.BoardConfigSaveService;
import models.admin.services.ConfigServiceManager;

@WebServlet("/admin/board/config/*")
public class BoardConfigController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String _pattern = "board/config/([^\\?]*)";
		Pattern pattern = Pattern.compile(_pattern);
		String uri = req.getRequestURI();
		Matcher matcher = pattern.matcher(uri);
		if(matcher.find()) {
			String boardId = matcher.group(1);
			if(boardId != null && !boardId.isBlank()) {
				try {
					BoardConfig boardConfig = ConfigServiceManager.getInstance()
																										.getBoardConfigInfoService()
																										.get(boardId);
					req.setAttribute("boardConfig", boardConfig);
				}catch(RuntimeException e) {
					e.printStackTrace();
					alertError(resp,e,"back");
					return;
				}
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/admin/board/config.jsp");
		rd.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ConfigServiceManager manager = ConfigServiceManager.getInstance();
			BoardConfigSaveService service = manager.getBoardConfigSaveService();
			service.save(req);
			
			/**
			 * 게시판 저장 후 후속처리
			 * 게시판 목록 페이지로 이동
			 */
			String url = UrlLibrary.getUrl(req,"/admin/board");
			go(resp,url,"parent");
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			alertError(resp, e);
		}
		
	}
}
