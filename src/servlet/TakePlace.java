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

import tools.KeyCheck;

public class TakePlace extends HttpServlet {
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
			Label label = Sql
					.getLabel(Integer.parseInt(req.getParameter("id")));
			User user = Sql.getUser(Sql.getIdByUsername(KeyCheck.getId(req)));
			
			JSONObject users =null;
			JSONArray userlist = null;
			try {
				users=JSONObject.fromObject(label.joined_user);
				userlist = JSONArray.fromObject(users.get("userList").toString());
				
			} catch (Exception e) {
				users =new JSONObject();
				userlist = new JSONArray();
			}
			
			userlist.add(user.id);
			users = new JSONObject();
			users.put("userList", userlist);
			label.joined_user=users.toString();
			Sql.editeLabel(label);
			
			
			JSONObject labels =null;
			JSONArray labelList = null;
			try {
				labels=JSONObject.fromObject(user.joined_label);
				labelList = JSONArray.fromObject(labels.get("labelList").toString());
				
			} catch (Exception e) {
				labels =new JSONObject();
				labelList = new JSONArray();
			}
			
			labelList.add(label.id);
			labels = new JSONObject();
			labels.put("labelList", labelList);
			user.joined_label=labels.toString();
			Sql.editeUser(user);

			
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
	public static void main(String[] args) {
		
		System.out.println(JSONArray.fromObject(new JSONArray().toString()).toString());
	}
}
