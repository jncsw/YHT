package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import pac.Sql;

import tools.MD5;
import tools.RandomString;

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObject=new JSONObject();
		try {
			String admin = req.getParameter("username");
			String password = req.getParameter("password2");
			System.out.println(password);
			String password_r = MD5.MD5(Sql.getPassword(admin));
			System.out.println(Sql.getPassword(admin));
			System.out.println(password_r);
			if (!password.equals(password_r)) {
				throw new Exception();
			}

			String key = RandomString.randomString(30);

			Cookie cookie1 = new Cookie("yht", admin);
			Cookie cookie2 = new Cookie(admin, key);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);

			HttpSession session = req.getSession();
			session.setAttribute(admin, key);
			
			jsonObject.put("errcode", 0);
			out.println(jsonObject);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			jsonObject.put("errcode", 1);
			e.printStackTrace();
			out.println(jsonObject);
			out.flush();
			out.close();
		}
		
		System.out.println(jsonObject.get("errcode"));
		
	}
	
}
