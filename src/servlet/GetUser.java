package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pac.Sql;
import pac.User;

import tools.GetFromHashtable;
import tools.KeyCheck;

public class GetUser extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8"); 
		
		PrintWriter out = resp.getWriter();
		JSONObject jsonObject = new JSONObject();
		try {
			if (!KeyCheck.isLegal(req, resp)) {
				throw new Exception();
			}
			
			User user=Sql.getUser(Integer.parseInt(req.getParameter("id")));
			jsonObject.put("errcode", 0);
			jsonObject.put("real_name", user.real_name);
			jsonObject.put("email", user.email);
			jsonObject.put("phone_number", user.phone_number);
			jsonObject.put("intro", user.intro);
			jsonObject.put("joined_label", user.joined_label);
			
			out.println(jsonObject);
			out.flush();
			out.close();

		} catch (Exception e) {
			jsonObject.put("errcode", 1);
			out.println(jsonObject);
			out.flush();
			out.close();
		}

	}
}
