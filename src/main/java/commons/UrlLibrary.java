package commons;

import javax.servlet.http.HttpServletRequest;

public class UrlLibrary {
/**
 *  url 자동완성(contextPath 자동으로 추가)
 */
	
	public static String getUrl(HttpServletRequest request, String url) {
		url = url == null? "" : url;
		return request.getContextPath() + url;
	}
	
	public static String getUrl(HttpServletRequest request) {
		return getUrl(request,"");
	}
}
