package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Sql {

	private static Connection conn = null;

	private static String string1;
	private static String string2;

	public static Hashtable userList;
	public static Hashtable labelList;
	public static Hashtable myLabelList;

	static {
		userList = new Hashtable();
		labelList = new Hashtable();
		myLabelList = new Hashtable();

		string1 = "com.mysql.jdbc.Driver";
		string2 = "jdbc:mysql://202.194.14.197:3306/training?user=cd&password=cd@chendian&characterEncoding=UTF-8";
		try {
			Class.forName(string1);
			conn = DriverManager.getConnection(string2);

			init();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		try {
			String sqlString = "SELECT id from label";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
				ids.add(rs.getInt(1));
			}
			for (Integer idInteger : ids) {
				Label label = getLabel(idInteger);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User getUser(int id) {
		User user = (User) userList.get(id);
		if (user != null) {
			return user;
		} else {
			user = getUserFromDatabase(id);
			if (user != null)
				userList.put(id, user);
			return user;
		}
	}

	public static boolean register(User user) {
		String sqlString = "SELECT * from user where username='"
				+ user.username + "'";
		ResultSet rs;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlString);
			if (rs.next()) {
				return false;// ÒÑ±»×¢²á
			} else {
				sqlString = "INSERT INTO user(username,password,real_name,email,phone_number,intro,info,joined_label) ";
				sqlString += "VALUES('" + user.username + "','" + user.password
						+ "','" + user.real_name + "','" + user.email + "','"
						+ user.phone_number + "','" + user.intro + "','"
						+ user.info + "','" + user.joined_label + "')";
				stmt.executeUpdate(sqlString);

				rs.close();
				stmt.close();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean editeUser(User user) {
		String sql = "UPDATE user SET " + "username = '" + user.username + "',"
				+ "password = '" + user.password + "'," + "real_name = '"
				+ user.real_name + "'," + "email = '" + user.email + "',"
				+ "phone_number = '" + user.phone_number + "'," + "intro = '"
				+ user.intro + "'," + "info = '" + user.info + "',"
				+ "joined_label = '" + user.joined_label + "'" + "WHERE id = "
				+ user.id;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			userList.remove(user.id);

			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static User getUserFromDatabase(int id) {
		User user = new User();
		try {
			String sqlString = "SELECT * from user where id=" + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);

			rs.next();
			user.id = id;
			user.username = rs.getString(2);
			user.password = rs.getString(3);
			user.real_name = rs.getString(4);
			user.email = rs.getString(5);
			user.phone_number = rs.getString(6);
			user.intro = rs.getString(7);
			user.info = rs.getString(8);
			user.joined_label = rs.getString(9);

			rs.close();
			stmt.close();

			return user;
		} catch (SQLException e) {
			return null;
		}

	}

	public static Label getLabel(int id) {
		Label label = (Label) labelList.get(id);
		if (label != null) {
			return label;
		} else {
			label = getLabelFromDatabase(id);
			if (label != null)
				labelList.put(id, label);
			return label;
		}
	}

	private static Label getLabelFromDatabase(int id) {
		Label label = new Label();
		try {

			String sqlString = "SELECT * from label where id=" + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			rs.next();
			label.id = id;
			label.kind = rs.getInt(2);
			label.joining_limit = rs.getInt(3);
			label.sponsor_id = rs.getInt(4);
			label.statu = rs.getInt(5);
			label.place = rs.getString(6);
			label.joined_user = rs.getString(7);
			label.start_time = rs.getLong(8);
			label.title = rs.getString(9);
			label.intro = rs.getString(10);
			rs.close();
			stmt.close();
			return label;
		} catch (SQLException e) {
			return null;
		}

	}

	public static boolean addLabel(Label label) {
		try {

			String sqlString = "INSERT INTO label(kind,joining_limit,sponsor_id,statu,place,joined_user,start_time,end_time,locationX,locationY,title,intro) ";
			sqlString += "VALUES(" + label.kind + "," + label.joining_limit
					+ "," + label.sponsor_id + "," + label.statu + ",'"
					+ label.place + "','" + label.joined_user + "',"
					+ label.start_time + "," + label.end_time + ","
					+ label.locationX + "," + label.locationY +",'"+ label.title+ "','"+label.intro+"')";

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlString);

			stmt.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteLabel(int id) {
		String sql = "DELETE FROM label WHERE id = '" + id + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			labelList.remove(id);

			stmt.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static boolean editeLabel(Label label) {
		String sql = "UPDATE label SET " + "kind = " + label.kind + ","
				+ "joining_limit = " + label.joining_limit + ","
				+ "sponsor_id = " + label.sponsor_id + "," + "statu = "
				+ label.statu + "," + "place = '" + label.place + "',"
				+ "joined_user = '" + label.joined_user + "',"
				+ "start_time = " + label.start_time  + ",end_time = " + label.end_time+","
				+ "locationX = " + label.locationX +","
				+ "locationY = " + label.locationY
				+ " WHERE id = "
				+ label.id;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			labelList.remove(label.id);

			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String getLabelList(int kind,double locationX,double locationY,double distance,long start_time,long end_time) throws Exception{
		try {
			String sqlString ="SELECT id,locationX,locationY from label";
			if(kind!=0){
				sqlString+=" where kind="+kind;
			}
			if(start_time!=0){
				sqlString+=(kind==0?" where ":" AND ");
				sqlString+="start_time>"+start_time+" AND end_time<"+end_time;
			}
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);

			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				double x=rs.getDouble(2);
				double y=rs.getDouble(3);
				
				if((Math.pow(x-locationX, 2)+Math.pow(y-locationY, 2))<Math.pow(distance, 2)){
					jsonArray.add(rs.getInt(1));
				}
				
			}

			rs.close();
			stmt.close();

			return jsonArray.toString();
		} catch (SQLException e) {
			throw e;
		}
	}
	public static String getMyLabel(int id) {
		String labelList = (String) myLabelList.get(id);
		if (labelList != null) {
			return labelList;
		} else {
			labelList = getMyLabelFromDatabase(id);
			if (labelList != null)
				myLabelList.put(id, labelList);
			return labelList;
		}
	}

	public static String getMyLabelFromDatabase(int id) {
		try {
			String sqlString = "SELECT id from label where sponsor_id=" + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);

			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				jsonArray.add(rs.getInt(1));
			}

			rs.close();
			stmt.close();

			return jsonArray.toString();
		} catch (SQLException e) {
			return "";
		}
	}

	public static String getPassword(String admin) {
		try {
			String sqlString = "SELECT password from user where username='"
					+ admin + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			rs.next();

			String returnsString = rs.getString(1);
			rs.close();
			stmt.close();

			return returnsString;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static int getIdByUsername(String username) {
		try {
			String sqlString = "SELECT id from user where username='"
					+ username + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			rs.next();

			int returnsInt = Integer.parseInt(rs.getString(1));
			rs.close();
			stmt.close();

			return returnsInt;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void main(String[] args) {
		try {
			Label aLabel =new Label();
			aLabel.id=10;
			editeLabel(aLabel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
