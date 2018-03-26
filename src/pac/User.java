package pac;

public class User {

	public int id;
	public String username;//用户昵称
	public String password;
	
	public String real_name;//真名
	public String email;
	public String phone_number;
	
	public String intro;
	
	public String info;//推送信息json
	public String joined_label;//参加的标签json
	
	public String toString() {
		String returnString="";
		returnString+=id;returnString+="-";
		returnString+=username;returnString+="-";
		returnString+=real_name;returnString+="-";
		returnString+=email;returnString+="-";
		returnString+=phone_number;returnString+="-";
		returnString+=intro;returnString+="-";
		returnString+=info;returnString+="-";
		returnString+=joined_label;
		
		return returnString;
	}
}
