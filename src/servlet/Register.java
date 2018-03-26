package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import pac.Sql;
import pac.User;
public class Register extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8"); 
		System.out.println(1);
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObject = new JSONObject();
		try {
			
			User user = new User();
			user.username = req.getParameter("username");
			user.password = req.getParameter("password");
			user.real_name = req.getParameter("real_name");
			user.email = req.getParameter("email");
			user.phone_number = req.getParameter("phone_number");
			user.intro = req.getParameter("intro");
			user.info = "";
			user.joined_label = "";
			
			System.out.println(user.username);
			
			if(!Sql.register(user)){
				throw new Exception();
			}
			
			jsonObject.put("errcode", 0);
			jsonObject.put("username", user.username);
			jsonObject.put("id", Sql.getIdByUsername(user.username));
			out.println(jsonObject);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("errcode", 1);
			out.println(jsonObject);
			out.flush();
			out.close();
		}

	}
}
