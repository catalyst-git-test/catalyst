import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.auth.connectors.ZCConnection;
import com.zc.auth.connectors.ZCConnector;

public class Connectors implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(Connectors.class.getName());
	static String GET = "GET";
	static String POST = "POST";

	@Override
	public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String param = "";
		String name = "";
		String[] params = {};
		String queryString = request.getQueryString();

		if (queryString != null) {
			LOGGER.log(Level.INFO, queryString);
			jsonObject = (JSONObject) JSONValue.parse(queryString);
			params = queryString.split("&");
			if (params[0].startsWith("n")) {
				name = params[0].substring(5);
				if (params[1] != null)
					param = params[1].substring(5);
			} else {
				param = params[0].substring(5);
				if (params[1] != null) {
					name = params[1].substring(5);
				}
			}
		} else {
			jsonObject = (JSONObject) JSONValue.parse(request.getReader().readLine());
			param = (String) jsonObject.get("case");
			name = (String) jsonObject.get("name");
		}

		switch (param) {
		case "testCase111":
			testCase111(request, response, name);
			break;
		case "testCase112":
			testCase112(request, response, name);
			break;
		default:
			testCase111(request, response, name);
		}
	}
	public String generateToken() throws Exception {
		boolean flag = false;
		JSONObject responseData = new JSONObject();
		JSONObject authJson = new JSONObject();
		try {
			authJson.put("client_id","1000.W42QRDTB97M8PN14E2ZWTN8HD79ARH"); 
			authJson.put("client_secret","1826a905fc699abfed40409f52b02715d1720ceb59");
			authJson.put("auth_url","https://accounts.localzoho.com/oauth/v2/token"); 
			authJson.put("refresh_url","https://accounts.localzoho.com/oauth/v2/token"); 
			authJson.put("refresh_token","1000.a6f9cbaed0711709103d01179c83f4c2.6cb58be7759b55c9105757114a9d1bad");
			JSONObject connectorJson = new JSONObject(); 
			connectorJson.put("CRMConnector",authJson); 
			ZCConnection conn = ZCConnection.getInstance(connectorJson); 
			ZCConnector crmConnector = conn.getConnector("CRMConnector");
			String accessToken;
			if((accessToken = crmConnector.getAccessToken()) == null)
				return "null";
			else
				return accessToken;
		} 
		catch (Exception e) {
			return e.toString();
		}
	}
	public void testCase111(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		boolean flag = false;
		boolean status = false;
		JSONObject responseData = new JSONObject();
		try {
			String accessToken = generateToken();
			if((!Pattern.matches("^[a-z0-9.]+$", accessToken)) || !accessToken.startsWith("1000.")) {
				flag = true;
				responseData.put("message", "No proper access token is generated.\n" + accessToken);
				responseData.put("Details",accessToken);
				responseData.put("flag", flag);
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
	    	String apiUrl = "https://crm.localzoho.com/crm/v7/Leads";
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Authorization", "Zoho-oauthtoken " + accessToken);
	        connection.setDoOutput(true);

	    	String requestBody = "{\"data\":[{\"Company\": \"Api Call for Connectors\",\"Last_Name\": \"Connectors Test\"}]}";
	        try(OutputStream os = connection.getOutputStream()) {
				byte[] input = requestBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
	        int responseCode = connection.getResponseCode();
	        BufferedReader reader;
	        if(responseCode == 201) {
		        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        	status = true;
	        }
	        else 
	        	reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	        
	        StringBuilder apiResponse = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	apiResponse.append(line);
	        }
	        reader.close();
	        connection.disconnect();
	        JSONParser parser = new JSONParser();
	        try {
	        	JSONObject jsonObject = (JSONObject) parser.parse(apiResponse.toString());
	        	if(status && ((String) ((JSONObject) ((JSONArray) jsonObject.get("data")).get(0)).get("code")).equals("SUCCESS")) {
	    			responseData.put("message","Expected Status - 200 and Response code - SUCCESS is matched");
	        	}
	        	else if(((String)jsonObject.get("code")).equals("OAUTH_SCOPE_MISMATCH")){
	    			flag = true;
	        		responseData.put("message","Expected Status - 200 and Response code - SUCCESS. But Received Status - 401 and Response code - OAUTH_SCOPE_MISMATCH");
	        	}
	        	else if(((String)jsonObject.get("status")).equals("OAUTH_SCOPE_MISMATCH")) {
	        		flag = true;
	        		responseData.put("message","Expected Status - 200. But Received status is " + responseCode);
	        		responseData.put("Response",jsonObject.toString());
	        	}
			} 
	        catch (Exception e) {
	        	flag = true;
	        	responseData.put("message","Unexpected Error in code: \nException : " + e.toString());
			}
	        responseData.put("flag",flag);
	        response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		} 
		catch (Exception e) {
			if (name.contains("app") && e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} 
			else {
				responseData.put("message",e.toString());
				flag = true;
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
		}
	}
	public void testCase112(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		boolean flag = false;
		boolean status = false;
		JSONObject responseData = new JSONObject();
		try {
			String accessToken = generateToken();
			if((!Pattern.matches("^[a-z0-9.]+$", accessToken)) || !accessToken.startsWith("1000.")) {
				flag = true;
				responseData.put("message", "No proper access token is generated.\n" + accessToken);
				responseData.put("Details",accessToken);
				responseData.put("flag", flag);
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
	    	String apiUrl = "https://crm.localzoho.com/crm/v7/Leads";
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Authorization", "Zoho-oauthtoken " + accessToken);
	        
	        int responseCode = connection.getResponseCode();
	        BufferedReader reader;
	        if(responseCode >= 200 && responseCode < 300) {
		        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        	status = true;
	        }
	        else
	        	reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
	        
	        StringBuilder apiResponse = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	apiResponse.append(line);
	        }
	        reader.close();
	        connection.disconnect();
	        JSONParser parser = new JSONParser();
	        try {
	        	JSONObject jsonObject = (JSONObject) parser.parse(apiResponse.toString());
	        	if(status && ((String) ((JSONObject) ((JSONArray) jsonObject.get("data")).get(0)).get("code")).equals("SUCCESS")) {
	        		flag = true;
	        		responseData.put("message","Expected Status - 401 and Response code - OAUTH_SCOPE_MISMATCH. But Received Status - 200 and Response code - SUCCESS. Access token is generated with CREATE scope only but able to READ");
	        	}
	        	else if(((String)jsonObject.get("code")).equals("OAUTH_SCOPE_MISMATCH")){
	        		responseData.put("message","Expected Status - 401 and response code - OAUTH_SCOPE_MISMATCH is matched.");
	        	}
	        	else if(((String)jsonObject.get("status")).equals("OAUTH_SCOPE_MISMATCH")) {
	        		flag = true;
	        		responseData.put("message","Expected Status - 200. But Received status - " + responseCode);
	        		responseData.put("Response",jsonObject.toString());
	        	}
			} 
	        catch (Exception e) {
	        	flag = true;
	        	responseData.put("message","Unexpected Error in code: \nException : " + e.toString());
			}
	        responseData.put("flag",flag);
	        response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		} 
		catch (Exception e) {
			if (name.contains("app") && e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} 
			else {
				responseData.put("message",e.toString());
				flag = true;
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
		}
	}
}