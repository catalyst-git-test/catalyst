import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.cache.ZCCache;
import com.zc.component.cache.ZCCacheObject;
import com.zc.component.cache.ZCSegment;

public class CacheCases implements CatalystAdvancedIOHandler {
	String rowid="";
	private static final Logger LOGGER = Logger.getLogger(CacheCases.class.getName());
	static String GET = "GET";
	static String POST = "POST";
	static long segmentId=1926000004343628L;
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
		switch(param)
		{
			case "testCase15":
			testCase15(request,response);
			break;
			case "testCase16":
			testCase16(request,response);
			break;
			case "testCase17":
			testCase17(request,response);
			break;
			case "testCase18":
			testCase18(request,response);
			break;
			case "testCase19":
			testCase19(request,response);
			break;
			case "testCase20":
			testCase20(request,response);
			break;
			case "testCase21":
			testCase21(request,response);
			break;
			default:
			testCase15(request,response);
		}
}
		public void testCase15(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			String url = request.getRequestURI();
			String method = request.getMethod();
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			try {
				resetMethod();
				ZCCache cacheobj=ZCCache.getInstance();
				ZCSegment segment = cacheobj.getSegment(segmentId);
				segment.putCacheValue("abc", "Test Value");
				segment.putCacheValue("Expiry", "0123", 24L);
				ZCCacheObject cacheDetails = ZCCacheObject.getInstance();
				cacheDetails.setKeyName("ObjectKey");
				cacheDetails.setValue("ObjectValue");
				cacheDetails.setExpiryInHours(1L);
				//Create the cache using the CacheObject
				ZCCacheObject cache = segment.putCacheObject(cacheDetails);
				Thread.sleep(5000);
				LOGGER.log(Level.INFO,segment.getCacheValue("Expiry"));
				Thread.sleep(5000);
				LOGGER.log(Level.INFO,segment.getCacheValue("abc"));
				String cacheValue= segment.getCacheValue("abc");
				if(!cacheValue.equals("Test Value")) {
					flag=true;
					responseData.put("mismatch", "Expected value not found. Value obtained is "+cacheValue);}
				cacheValue= segment.getCacheValue("ObjectKey");
				if(!cacheValue.equals("ObjectValue")) {
					flag=true;
					responseData.put("mismatch", "Expected value not found. Value obtained is "+cacheValue);}
				ZCCacheObject object= segment.getCacheObject("Expiry");
				long expiryValue=object.getExpiryInHours();
				cacheValue=object.getValue();
				if(!(cacheValue.equals("0123")&&expiryValue==24L)) {
					flag=true;
					responseData.put("mismatch", "Expected value not found. Value obtained is "+cacheValue+" and "+expiryValue);
				}
				if(flag==true)
				{
					responseData.put("message", "Cache values inserted but there is a mismatch in one of the values. Case failed");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					responseData.put("message", "Cache values inserted and values were fetched and verified successfully. Case Passed");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
			}
			catch(Exception e) {
				LOGGER.log(Level.SEVERE, "Exception occured", e);
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				responseData.put("message",e);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
				
			}
	}
		public void testCase16(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			String url = request.getRequestURI();
			String method = request.getMethod();
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			try {
				ZCCache cacheobj=ZCCache.getInstance();
				ZCSegment segment = cacheobj.getSegment(segmentId);
				segment.updateCacheValue("Expiry", "NewValue", 3L);
				Thread.sleep(5000);
				ZCCacheObject object= segment.getCacheObject("Expiry");
				long expiryValue=object.getExpiryInHours();
				String cacheValue=object.getValue();
				if(!(cacheValue.equals("NewValue")&&expiryValue==3L)) {
					flag=true;
					responseData.put("mismatch", "Expected value not found. Expected key value is NewValue and expiry is 2. But, Value obtained is "+cacheValue+" and Expiry value is "+expiryValue);
				}
				if(flag==true)
				{
					responseData.put("message", "Cache value updated but there is a mismatch in one of the values. Case failed");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					responseData.put("message", "Cache values updated and values were fetched and verified successfully. Case Passed");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
			}
			catch(Exception e) {
				LOGGER.log(Level.SEVERE, "Exception occured", e);
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				String exceptionAsString = sw.toString();
				responseData.put("message",e);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
}
		public void testCase17(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			String url = request.getRequestURI();
			String method = request.getMethod();
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			try {
				ZCCache cacheobj=ZCCache.getInstance();
				ZCSegment segment = cacheobj.getSegment(segmentId);
				segment.deleteCacheValue("Expiry");
				ZCCacheObject cacheDetails = ZCCacheObject.getInstance();
				cacheDetails.setKeyName("äbcABC123");
				segment.deleteCacheObject(cacheDetails);
				ZCCacheObject object= segment.getCacheObject("ObjectKey");
				segment.deleteCacheValue("ObjectKey");
				responseData.put("message", "Deleted the cache values and they are deleted properly. Case Passed");
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
				responseData.put("message",e);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
}
		public void testCase18(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			try {
				ZCCache cacheobj=ZCCache.getInstance();
				ZCSegment segment = cacheobj.getSegment(segmentId);
				segment.putCacheValue("", "");
				responseData.put("message","No exception was thrown while trying to insert an empty key and cache value got inserted. Case Failed");
				flag=true;
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
				if(exceptionAsString.contains("cache_name cannot be blank INVALID_INPUT")) {
					responseData.put("message","Expected alert is thrown. Case passed");
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					responseData.put("message",e);
					responseData.put("value","exception");
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(500);
				}
					
			}
		}
		public void testCase19(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
				try {
					ZCCache cacheobj=ZCCache.getInstance();
					ZCSegment segment = cacheobj.getSegment(segmentId);
					segment.putCacheValue("~", "test");
					responseData.put("message","No exception was thrown while trying to use special characters and cache value got inserted. Case Failed");
					flag=true;
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);	
				}
				catch(Exception e) {
					StringWriter sw = new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					String exceptionAsString = sw.toString();
					if(exceptionAsString.contains("Please check whether the input values are correct PATTERN_NOT_MATCHED")) {
						responseData.put("message","Expected alert is thrown. Case passed");
						responseData.put("flag",flag);
						response.setContentType("application/json");
						response.getWriter().write(responseData.toString());
						response.setStatus(200);
					}
					else {
						responseData.put("message",e);
						responseData.put("value","exception");
						responseData.put("flag",flag);
						response.setContentType("application/json");
						response.getWriter().write(responseData.toString());
						response.setStatus(500);
					}
				}
							
}
		public void testCase20(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
				try {
					ZCCache cacheobj=ZCCache.getInstance();
					ZCSegment segment = cacheobj.getSegment(segmentId);
					String email=segment.getCreatedBy().getEmailId();
					String createdTime= segment.getCreatedTime().toString(); 
					long id = segment.getSegmentId();
					String segmentName=segment.getSegmentName();
					if(!(email.equals("surendhar.v+apinew1@zohotest.com")&&createdTime.equals("Mon Feb 13 09:49:00 GMT 2023")&&id==1926000004343628L&&segmentName.equals("SegmentTest"))){
						flag=true;
						LOGGER.log(Level.INFO, "date", segment.getCreatedTime());
						responseData.put("message","Mismatch in obtained segment details. Expected values : email - surendhar.v+apinew1@zohotest.com , created time - Mon Feb 13 09:49:00 GMT 2023 , segment id - 1926000004343628 , segment name - SegmentTest . Found - "+email+" "+createdTime+" "+id+" "+segmentName);
					}
					else {
						responseData.put("message","Details of segment were fetched and verified successfully");
					}
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				catch(Exception e) {
					StringWriter sw = new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					String exceptionAsString = sw.toString();
					responseData.put("message",e);
					responseData.put("flag",flag);
					responseData.put("value","exception");
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
							
}
	public void testCase21(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCCache cacheobj=ZCCache.getInstance();
			ZCSegment segment = cacheobj.getSegment(segmentId);
			segment.putCacheValue("null", "");
			String cacheValue= segment.getCacheValue("null");
			if(!cacheValue.equals("")) {
				flag=true;
				responseData.put("message","Empty value is not fetched as expected. Case Failed.");
			}
			else {
				responseData.put("message","Empty value is fetched as expected. Case Passed.");
			}
			segment.deleteCacheValue("null");
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
			responseData.put("value","exception");
			responseData.put("message",e.toString());
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
	}
	public void resetMethod() {
		try {
			ZCCache cacheobj=ZCCache.getInstance();
			ZCSegment segment = cacheobj.getSegment(segmentId);
			if(segment.getCacheValue("äbcABC123")!=null)
			segment.deleteCacheValue("äbcABC123");
			if(segment.getCacheValue("Expiry")!=null)
			segment.deleteCacheValue("Expiry");
			if(segment.getCacheValue("ObjectKey")!=null)
			segment.deleteCacheValue("ObjectKey");
			if(segment.getCacheValue("null")!=null)
			segment.deleteCacheValue("null");
		}
		catch(Exception e) {
			
		}
	}
}