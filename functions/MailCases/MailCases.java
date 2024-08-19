import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.mail.ZCMail;
import com.zc.component.mail.ZCMailContent;

public class MailCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(MailCases.class.getName());
	@Override
    public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String param="";
		String name="";
		String[] params= {};
		JSONObject jsonObject = new JSONObject();
		if(request.getQueryString()!=null) {
			LOGGER.log(Level.INFO,request.getQueryString());
			jsonObject = (JSONObject) JSONValue.parse(request.getQueryString());
			params=request.getQueryString().split("&");
			if(params[0].startsWith("n")) {
			name=params[0].substring(5);
			if(params[1]!=null){
				param=params[1].substring(5);
			}
		}
			else {
				param=params[0].substring(5);
				if(params[1]!=null){
					name=params[1].substring(5);
				}
			}
			}
		else {
			jsonObject=(JSONObject) JSONValue.parse(request.getReader().readLine());
		param=(String) jsonObject.get("case");
		name=(String) jsonObject.get("name");
		}
		switch(param)
		{
			case "testCase36":
			testCase36(request,response);
			break;
			case "testCase37":
			testCase37(request,response);
			break;
			case "testCase38":
			testCase38(request,response);
			break;
//			case "testCase4":
//			testCase4(request,response);
//			break;
//			case "testCase5":
//			testCase5(request,response);
//			break;
//			case "testCase6":
//			testCase6(request,response);
//			break;
//			case "testCase7":
//			testCase7(request,response);
//			break;
			default:
			testCase36(request,response);
	}
	}
	public void testCase36(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCMailContent mailContent = ZCMailContent.getInstance();
			mailContent.setContent("<p>Hello, Welcome to Zoho Catalyst</p>");
			mailContent.setFromEmail("surendhar.v+catalystmail@zohotest.com");
			mailContent.setToEmail("surendhar.v+mailtest@zohotest.com");
			mailContent.setHtmlMode(true);
			mailContent.setSubject("Testing");
			ZCMail.getInstance().sendMail(mailContent);
			responseData.put("message","No exceptions were thrown while sending mail. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	public void testCase37(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCMailContent mailContent = ZCMailContent.getInstance();
			mailContent.setContent("<p>Hello, Welcome to Zoho Catalyst</p>");
			mailContent.setFromEmail("surendhar.v+unverified@zohotest.com");
			mailContent.setToEmail("surendhar.v+mailtest@zohotest.com");
			mailContent.setHtmlMode(true);
			mailContent.setSubject("Testing");
			ZCMail.getInstance().sendMail(mailContent);
			responseData.put("message","No exceptions were thrown for unverified sender id while sending mail. Case Failed");
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : No such from_email with the given id exists INVALID_ID")) {
			responseData.put("message","Proper exception is obtained as expected. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
			}
	}
	public void testCase38(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCMailContent mailContent = ZCMailContent.getInstance();
			mailContent.setContent("<p>Hello, Welcome to Zoho Catalyst</p>");
			mailContent.setFromEmail("surendhar.v+catalystmail@zohotest.com");
			mailContent.setToEmail("surendhar.v+mailtest@zohotest.com");
			mailContent.setHtmlMode(true);
			ZCMail.getInstance().sendMail(mailContent);
			responseData.put("message","No exceptions were thrown for empty subject while sending mail. Case Failed");
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : subject cannot be null INVALID_INPUT")||exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : subject cannot be blank INVALID_INPUT")) {
			responseData.put("message","Proper exception is obtained as expected. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString()+". Expected exception - com.zc.exception.ZCServerException. Caused by : subject cannot be null INVALID_INPUT");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
			}
	}
}
