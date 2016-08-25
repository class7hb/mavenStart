package antStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpParsing {
	StringBuffer msg= new StringBuffer();
	private final String USER_AGENT = "Mozilla/5.0";
	 
	public String sendHttp(String url) throws Exception {
	         
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", USER_AGENT);
	    BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	        response.append(inputLine);
	        msg.append(inputLine);
	    }
	    in.close();
	    System.out.println(msg);
	    return response.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new HttpParsing().sendHttp("http://naver.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
