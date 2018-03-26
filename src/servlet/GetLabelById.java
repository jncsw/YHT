package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pac.Label;
import pac.Sql;
import pac.User;

import tools.GetFromHashtable;
import tools.KeyCheck;

public class GetLabelById extends HttpServlet {
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
			
			Label label=Sql.getLabel(Integer.parseInt(req.getParameter("id")));
			jsonObject.put("errcode", 0);
			jsonObject.put("kind", label.kind);
			jsonObject.put("joining_limit", label.joining_limit);
			jsonObject.put("sponsor_id", label.sponsor_id);
			jsonObject.put("statu", label.statu);
			jsonObject.put("place", label.place);
			jsonObject.put("joined_user", label.joined_user);
			jsonObject.put("start_time", label.start_time);
			jsonObject.put("end_time", label.end_time);
			jsonObject.put("locationX", label.locationX);
			jsonObject.put("locationY", label.locationY);
			jsonObject.put("title", label.title);
			jsonObject.put("intro", label.intro);
			
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
