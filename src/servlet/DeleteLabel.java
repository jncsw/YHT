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

public class DeleteLabel extends HttpServlet {
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
			int id=Integer.parseInt(req.getParameter("id"));
			Label label=Sql.getLabel(id);
			
			if(label.sponsor_id!=Sql.getIdByUsername(KeyCheck.getId(req))){
				throw new Exception();
			}
			if(!Sql.deleteLabel(id)){
				throw new Exception();
			}
			jsonObject.put("errcode", 0);
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
