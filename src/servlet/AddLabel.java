package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import pac.Label;
import pac.Sql;

import tools.KeyCheck;

public class AddLabel extends HttpServlet {
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
			if (!KeyCheck.isLegal(req, resp)) {
				throw new Exception();
			}
			Label label=new Label();
			
			label.kind = Integer.parseInt(req.getParameter("kind"));
			label.joining_limit =  Integer.parseInt(req.getParameter("joining_limit"));
			label.sponsor_id = Sql.getIdByUsername(KeyCheck.getId(req));
			label.statu =0;
			label.place = req.getParameter("place");
			label.joined_user = "";
			label.start_time = Long.parseLong(req.getParameter("start_time"));
			label.end_time=Long.parseLong(req.getParameter("end_time"));
			
			label.locationX=Double.parseDouble(req.getParameter("locationX"));
			label.locationY=Double.parseDouble(req.getParameter("locationY"));
			label.title=req.getParameter("title");
			label.intro=req.getParameter("intro");
			
			
			if(!Sql.addLabel(label)){
				throw new Exception();
			}
			
			jsonObject.put("errcode", 0);
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
