package tools;

import java.util.Hashtable;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import pac.Label;
import pac.Sql;

public class GetFromHashtable {  
	
	 public static JSONArray getLabelList(Hashtable map){
		
		 try {
			 Iterator iter = map.keySet().iterator();
			 JSONArray jsonArray=new JSONArray();
			 while (iter.hasNext()) {
				 int key = (Integer) iter.next();
				 Label label = (Label) map.get(key);
				 JSONObject labeljJsonObject=new JSONObject();
				 labeljJsonObject.put("id", label.id);
				 labeljJsonObject.put("kind", label.kind);
				 labeljJsonObject.put("joining_limit", label.joining_limit);
				 labeljJsonObject.put("sponsor_id", label.sponsor_id);
				 labeljJsonObject.put("statu", label.statu);
				 labeljJsonObject.put("place", label.place);
				 labeljJsonObject.put("joined_user", label.joined_user);
				 labeljJsonObject.put("start_time", label.start_time);
				 jsonArray.add(labeljJsonObject);
			 }
			 return jsonArray;
			 
		} catch (Exception e) {
			return null;
		}
		
	 }
	
    public static void main(String a[]){  
           
        Hashtable hm = new Hashtable();
        Label label1=Sql.getLabel(1);
        Label label2=Sql.getLabel(2);
        Label label3=Sql.getLabel(3);
        hm.put(label1.id, label1);
        hm.put(label2.id, label2);
        hm.put(label3.id, label3);
    
        System.out.println(getLabelList(hm).toString());
    }  
}  