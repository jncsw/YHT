package tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KeyCheck {

	public static boolean isLegal(HttpServletRequest req, HttpServletResponse resp) {
		if(check(req)){
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean check(HttpServletRequest req) {
		try{
			final String cookieName="yht";
			Cookie[] cookies = req.getCookies();
			
			String adminId=getValue(cookies,cookieName);
			String key=getValue(cookies,adminId);
			
			HttpSession session=req.getSession();
			String key_r=(String) session.getAttribute(adminId);
			
			if(key_r.equals(key)){
				return true;
			}
			
		}catch (Exception e) {
			return false;
		}
		return false;
	}
	public static String getId(HttpServletRequest req){
		try {
			final String cookieName="yht";
			Cookie[] cookies = req.getCookies();
			String adminId=getValue(cookies,cookieName);
			return adminId;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getValue(Cookie[] cookies, String name) {
		String value = "";
		try {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName()) && cookie.getValue() != null) {
					value = cookie.getValue();
					break;
				}
			}
		} catch (Exception e) {

		}
		return value;
	}
	
}
