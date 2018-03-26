package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pac.Sql;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import tools.KeyCheck;

public class GetMyLabel extends HttpServlet {
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
			int user_id = Integer.parseInt(KeyCheck.getId(req));
			
			JSONArray myLabelList=JSONArray.fromObject(Sql.getMyLabel(user_id));
			
			
			jsonObject.put("errcode", 0);
			jsonObject.put("myLabelList",myLabelList);
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
