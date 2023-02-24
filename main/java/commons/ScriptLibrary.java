package commons;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 *  공통 메세지(스크립트 관련)
 * @author 김현수
 *
 */
public class ScriptLibrary {

	// 에러전용 - alert 메세지 발생
	public static void alertError(HttpServletResponse response, Exception e) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String message = e.getMessage();
			
			out.printf("<script>alert('warning : %s');</script>", message);
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}// alertError() E
	

	// 에러전용 - alert 메세지 발생 후 발생할 이벤트.
	public static void alertError(HttpServletResponse response, Exception e, String after ) {
		alertError(response, e);
		
		if(after.equals("back")) {
			
		}
	}// alertError() E
	
	
	//에러 발생 후 후속작업을 위한 페이지 이동 기능
	// target - 이동 시 기준이 되는 페이지 의미. self - 자신 페이지, parent - 부모 페이지
	public static void go(HttpServletResponse response, String url, String target) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			target = target == null? "self" : target;
			
			out.printf("<script> %s.location.replace('%s'); </script>", target,url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}// go() E
	
	public static void go(HttpServletResponse response,String url) {
		go(response,url,"self");
	}//go() E
	
	
	//매개변수 step의 수만큼 뒤로 또는 앞으로 페이지 이동
	public static void go(HttpServletResponse response, int step, String target) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			target = target == null? "self" : target;
			
			out.printf("<script> %s.history.go() </script>", target, step);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//go() E
	
	public static void go(HttpServletResponse response, int step) {
		go(response, step,"self");
	}// go() E
	
}// class E
