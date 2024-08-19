import java.util.logging.Logger;
import java.io.IOException;
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

public class SendMail implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(SendMail.class.getName());
	
	@Override
    public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String mailid="";
		String content="";
		jsonObject=(JSONObject) JSONValue.parse(request.getReader().readLine());	
		mailid=(String) jsonObject.get("id");
		content=(String) jsonObject.get("content");
		LOGGER.log(Level.INFO,mailid);
		LOGGER.log(Level.INFO,content);
		sendMail(request,response,mailid,content);
	}
	public void sendMail(HttpServletRequest request, HttpServletResponse response,String mailid,String content) throws IOException {
		JSONObject responseData = new JSONObject();
		try {
		ZCMailContent mailContent = ZCMailContent.getInstance();
		mailContent.setContent(content);
		mailContent.setFromEmail("surendhar.v+catalystmail@zohotest.com");
		mailContent.setToEmail(mailid);
		mailContent.setHtmlMode(true);
		mailContent.setSubject("catalyst automation report - failed cases");
		ZCMail.getInstance().sendMail(mailContent);
		responseData.put("message","mail sent");
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
}