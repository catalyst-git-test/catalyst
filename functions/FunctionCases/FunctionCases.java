import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.cache.ZCCache;
import com.zc.component.cache.ZCSegment;
import com.zc.functions.ZCatalystFunction;

public class FunctionCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(FunctionCases.class.getName());
	static String GET = "GET";
	static String POST = "POST";	
	private static String TABLENAME = "TestTable";
	@Override
    public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
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
		switch(param)
		{
			case "testCase34":
			testCase34(request,response);
			break;
			case "testCase35":
			testCase35(request,response);
			break;
			default:
			testCase34(request,response);
	
}
}
	public void testCase34(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("name", "Function Name");
			Object result = ZCatalystFunction.getInstance().getFunctionInstance(1926000004343685L).executeFunction(jsonobj);
			Thread.sleep(3000);
			ZCCache cacheobj=ZCCache.getInstance();
			ZCSegment segment = cacheobj.getSegment(1926000004334061L);
			String cacheValue= segment.getCacheValue("Name");
			if(!cacheValue.equals("Function Name")) {
				responseData.put("message","Function execution failure. Expected cache value not found in cache segment. Case Failed");
				flag=true;
			}
			else {
				responseData.put("message","Function execution successful and its execution was verified. Case Passed");
			}
			segment.deleteCacheValue("name");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase35(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCatalystFunction function=ZCatalystFunction.getInstance();
			String mail=function.getFunctionInstance(1926000004343685L).getCreatedBy().getEmailId();
			String featuretype=function.getFunctionInstance(1926000004343685L).getFeatureType();
			String name=function.getFunctionInstance(1926000004343685L).getFunction_name();
			String funtype=function.getFunctionInstance(1926000004343685L).getFunctionType();
			Boolean deploy=function.getFunctionInstance(1926000004343685L).getIsDeployed();
			//responseData.put("message",mail+" "+featuretype+" "+name+" "+funtype+" "+deploy);
			responseData.put("message",name+" "+deploy+" "+funtype+" "+featuretype);
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
			responseData.put("message",e.toString()+". Exception occured while getting details of function");
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
}	


