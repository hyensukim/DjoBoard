package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import models.admin.services.BoardConfigSaveService;
import models.admin.services.ConfigServiceManager;
import static commons.ScriptLibrary.*;

@WebServlet("/admin/board/config/*")
public class BoardConfigController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/admin/board/config.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ConfigServiceManager manager = ConfigServiceManager.getInstance();
			BoardConfigSaveService service = manager.getboardConfigSaveService();
			service.save(req);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			alertError(resp, e);
		}
		
	}
}
