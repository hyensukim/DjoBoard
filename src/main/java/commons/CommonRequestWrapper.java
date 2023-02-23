package commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper{

	// 요청 시 공통 기능 S
	public CommonRequestWrapper(HttpServletRequest request) {
		super(request);
		
		String method = request.getMethod().toUpperCase();
		if(method.equals("POST")) {
			try {
				request.setCharacterEncoding("UTF-8");
			}catch(Exception e) {e.printStackTrace();}
		}
		
		//로그인 상태 확인
		
	}// 요청시 공통 기능 E

}
