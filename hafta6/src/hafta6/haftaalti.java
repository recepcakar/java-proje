package hafta6;
import java.util.HashMap;
public class haftaalti {

	public static void main(String[] args) {
		HashMap <String,Integer> m=new HashMap<String,Integer>();
		m.put("Bolu",14);
		m.put("kastamonu",37);
		m.put("istambul",34);
		
     
      
      
		for(String n:m.keySet())
			
		{
		  System.out.println("key "+n+" value "+m.get(n));	
		}
	}

}
