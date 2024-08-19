//$Id$

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.*;
import com.zc.component.users.PlatformType;
import com.zc.component.users.ZCSignUpData;
import com.zc.component.users.ZCUser;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.util.logging.Level;
import java.io.StringWriter;
import javax.servlet.ServletInputStream;

public class AuthenticationCases implements CatalystAdvancedIOHandler {

	String rowid="";
	private static final Logger LOGGER = Logger.getLogger(AuthenticationCases.class.getName());
	static String GET = "GET";
	static String POST = "POST";

	@Override
	public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		// TODO Auto-generated method stub
		String param="";
		String name="";
		String[] params= {};
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
		LOGGER.log(Level.INFO,param);
		LOGGER.log(Level.INFO,name);
		switch(param)
		{
			case "testCase11":
			testCase11(request,response);
			break;
			case "testCase12":
			testCase12(request,response);
			break;
			case "testCase13":
			testCase13(request,response);
			break;
			case "testCase14":
			testCase14(request,response);
			break;
			default:
			testCase11(request,response);
		}
	}
	public void testCase11(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		String lname="";
		String fname="";
		String mail="";
		long role=0;
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try{
		if(method.equals(POST))
		{
			//resetMethod();
		ZCSignUpData signUpdetails = ZCSignUpData.getInstance();
		signUpdetails.setPlatformType(PlatformType.WEB);
		signUpdetails.userDetail.setEmailId("surendhar.v+automation7@zohotest.com");
		signUpdetails.userDetail.setLastName("LN");
		signUpdetails.userDetail.setFirstName("FN");
		signUpdetails.userDetail.setRoleId(1926000004334040L);
		signUpdetails = ZCUser.getInstance().registerUser(signUpdetails);
		responseData.put("message", "User has been added !");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		else{
			List<ZCUserDetail> details = ZCUser.getInstance().getAllUser();
				if((String)details.get(0).getLastName()!=null) {lname=(String)details.get(0).getLastName();}else {responseData.put("alert","getLastName method is returning null");}
				if((String)details.get(0).getFirstName()!=null) {fname=(String)details.get(0).getFirstName();}else {responseData.put("alert","getFirstName method is returning null");}
				if((String)details.get(0).getEmailId()!=null) {mail=(String)details.get(0).getEmailId();}else {responseData.put("alert","getEmailId method is returning null");}
				if((Long)details.get(0).getRoleId()!=null) {role=(Long)details.get(0).getRoleId();}else {responseData.put("alert","getRoleId method is returning null");}
				if(details.get(0).getCreatedTime()==null) {flag=true;responseData.put("alert","getCreatedTime method is returning null");}
				if(details.get(0).getInvitedTime()==null) {flag=true;responseData.put("alert","getInvitedTime method is returning null");}
				if(details.get(0).getUserId()==null) {flag=true;responseData.put("alert","getUserId method is returning null");}
				if((lname.equals("LN"))&&(fname.equals("FN"))&&(mail.equals("surendhar.v+automation7@zohotest.com")&&role==1926000004334040L))
				{
					responseData.put("message", "User added successfully and these details are verified. Case passed ");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					flag=true;
					responseData.put("message", "Mismatch in one of the input while fetching user details. Case failed."+fname+" "+lname+" "+mail);
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
					responseData.clear();
				}
			}
		}
		catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase12(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		String lname="";
		String fname="";
		String mail="";
		long role=0;
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try{
		ZCSignUpData signUpdetails = ZCSignUpData.getInstance();
		signUpdetails.setPlatformType(PlatformType.WEB);
		signUpdetails.userDetail.setEmailId("surendhar.v+automation7@zohotest.com");
		signUpdetails.userDetail.setLastName("LN");
		ZCUser.getInstance().resetPassword(signUpdetails);
		responseData.put("message", "Reset password method was called and no exceptions were thrown. Case passed ");
		responseData.put("flag", flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase13(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		String lname="";
		String fname="";
		String mail="";
		long zaaid=0;
		Boolean flag=false;
		long role=0;
		JSONObject responseData = new JSONObject();
		try{
		if(method.equals(POST))
		{

		ZCSignUpData signUpdetails1 = ZCSignUpData.getInstance();
		signUpdetails1.setPlatformType(PlatformType.WEB);
		signUpdetails1.userDetail.setEmailId("surendhar.v+automation8@zohotest.com");
		signUpdetails1.userDetail.setLastName("LName");
		signUpdetails1.userDetail.setFirstName("FName");
		signUpdetails1.userDetail.setOrgId(1010342414L);
		//signUpdetails1.userDetail.setZaaid(1005141790L);
		signUpdetails1 = ZCUser.getInstance().addUser(signUpdetails1);
		responseData.put("message", "User has been added !");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		else{

			List<ZCUserDetail> details = ZCUser.getInstance().getAllUser();
				if((String)details.get(0).getLastName()!=null) {lname=(String)details.get(0).getLastName();}else {responseData.put("alert","getLastName method is returning null");}
				if((String)details.get(0).getFirstName()!=null) {fname=(String)details.get(0).getFirstName();}else {responseData.put("alert","getFirstName method is returning null");}
				if((String)details.get(0).getEmailId()!=null) {mail=(String)details.get(0).getEmailId();}else {responseData.put("alert","getEmailId method is returning null");}
				if((Long)details.get(0).getZaaid()!=null) {zaaid=(Long)details.get(0).getZaaid();}else {responseData.put("alert","getZaaid method is returning null");}
				if((Long)details.get(0).getRoleId()!=null) {role=(Long)details.get(0).getRoleId();}else {responseData.put("alert","getRoleId method is returning null");}
				if(details.get(0).getCreatedTime()==null) {flag=true;responseData.put("alert","getCreatedTime method is returning null");}
				if(details.get(0).getInvitedTime()==null) {flag=true;responseData.put("alert","getInvitedTime method is returning null");}
				if(details.get(0).getUserId()==null) {flag=true;responseData.put("alert","getUserId method is returning null");}
				LOGGER.log(Level.INFO,"last name - "+lname);
				LOGGER.log(Level.INFO,"first name - "+fname);
				if((lname.equals("LName"))&&(fname.equals("FName"))&&(mail.equals("surendhar.v+automation8@zohotest.com")))
				{
					responseData.put("message", "User added successfully and these details are verified. Case passed ");
					responseData.put("flag", flag);
					responseData.put("val", lname+fname+mail+zaaid);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					flag=true;
					responseData.put("message", "Mismatch in one of the input while fetching user details. Case failed. First name - "+fname+" , Last name - "+lname+" ,email - "+mail);
					responseData.put("flag", flag);
					responseData.put("val", lname+fname+mail+zaaid);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
					responseData.clear();
				}
			}
		}
		catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase14(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try{
		List<ZCUserDetail> details = ZCUser.getInstance().getAllUser();
		ArrayList<Long> userIdList = new ArrayList<>();
		for(int itr=0;itr<details.size();itr++) {
			if(details.get(itr).getUserId()!=1926000004343937L&&details.get(itr).getUserId()!=1926000004343933L) {
				ZCUser.getInstance().deleteUser(details.get(itr).getUserId());
			}
		}
		details=ZCUser.getInstance().getAllUser();
		if(details.size()==2)
		{
			responseData.put("message", "Two users were deleted as expected. Case passed ");
			responseData.put("flag", flag);
		}
		else {
			flag=true;
		responseData.put("message", "Issue with user deletion. Case Failed ");
		responseData.put("flag", flag);
		responseData.put("message1","Expected number of users to be present - 2. But users present - "+details.size());
		}
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void resetMethod() {
		try {
			List<ZCUserDetail> details = ZCUser.getInstance().getAllUser();
			for(int itr=0;itr<details.size();itr++) {
				if(details.get(itr).getUserId()!=1926000004343937L&&details.get(itr).getUserId()!=1926000004343933L) {
					ZCUser.getInstance().deleteUser(details.get(itr).getUserId());
				}
			}
		}
		catch(Exception e) {

		}
	}
}
