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

import tools.GetFromHashtable;
import tools.KeyCheck;

public class GetLabelList extends HttpServlet {
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
			int kind = Integer.parseInt(req.getParameter("kind"));
			double locationX=Double.parseDouble(req.getParameter("locationX"));
			double locationY=Double.parseDouble(req.getParameter("locationY"));
			double distance=Double.parseDouble(req.getParameter("distance"));
			long start_time=Long.parseLong(req.getParameter("start_time"));
			long end_time=Long.parseLong(req.getParameter("end_time"));
			
			
			jsonObject.put("errcode", 0);
			jsonObject.put("labelList", Sql.getLabelList(kind, locationX, locationY, distance,start_time,end_time));
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
