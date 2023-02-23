package commons;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CommonResponseWrapper extends HttpServletResponseWrapper{

	// 응답 시 공통 기능
	public CommonResponseWrapper(HttpServletResponse response) {
		super(response);
		
		
	}

}
