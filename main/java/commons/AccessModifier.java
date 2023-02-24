package commons;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.exception.AdminAccessException;

public class AccessModifier {
/**
 *  관리자인 경우에만 접근 가능함.
 */
	public void isAdmin(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("memberType");
		
		if(type.toLowerCase().indexOf("admin") != -1 ) {
			//해당 페이지로 이동
			try {
				response.sendRedirect("/admin/main.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			throw new AdminAccessException();
		}
	}
	
	
	
}
