package synchronization.FluentWait;

import java.util.Properties;

public class PiratesTalk {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	 Properties p=System.getProperties();
	 p.setProperty("pirate", "scuvy");
	String s= p.getProperty("argProp")+" ";
	s +=p.getProperty("pirate");
	System.out.println(s);
	
		}

}
