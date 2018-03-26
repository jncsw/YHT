package pac;

public class Label {

	public int id;
	
	public int kind;
	public int joining_limit;
	public int sponsor_id;//·¢ÆðÈËid
	public int statu;//×´Ì¬
	
	public String place;
	public String joined_user;//json
	
	public long start_time;
	public long end_time;
	
	public double locationX;
	public double locationY;
	
	public String title;
	public String intro;
	
	public String toString() {
		String returnString="";
		returnString+=id;returnString+="-";
		returnString+=kind;returnString+="-";
		returnString+=joining_limit;returnString+="-";
		returnString+=sponsor_id;returnString+="-";
		returnString+=statu;returnString+="-";
		returnString+=place;returnString+="-";
		returnString+=joined_user;returnString+="-";
		returnString+=start_time;
		
		return returnString;
	}
	
}


