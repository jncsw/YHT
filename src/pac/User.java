package pac;

public class User {

	public int id;
	public String username;//�û��ǳ�
	public String password;
	
	public String real_name;//����
	public String email;
	public String phone_number;
	
	public String intro;
	
	public String info;//������Ϣjson
	public String joined_label;//�μӵı�ǩjson
	
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
