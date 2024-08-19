import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.cron.CRONTYPE;
import com.zc.component.cron.RequestMethod;
import com.zc.component.cron.TIMEZONE;
import com.zc.component.cron.ZCCron;
import com.zc.component.cron.ZCCronDetail;
import com.zc.component.cron.ZCJobConfig;
import com.zc.component.cron.ZCRequestConfig;

public class CronCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(CronCases.class.getName());
	static String GET = "GET";
	static String POST = "POST";	
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
			case "testCase22":
			testCase22(request,response);
			break;
			case "testCase23":
			testCase23(request,response);
			break;
			case "testCase24":
			testCase24(request,response);
			break;
			case "testCase25":
			testCase25(request,response);
			break;
			case "testCase26":
			testCase26(request,response);
			break;
			case "testCase27":
			testCase27(request,response);
			break;
			case "testCase62":
			testCase62(request,response);
			break;
			default:
			testCase22(request,response);
	
}
	}
	public void testCase22(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			resetMethod();
			ZCCronDetail onetimeCron = ZCCronDetail.getInstance();
			onetimeCron.setCronName("TestCron");
			onetimeCron.setCronType(CRONTYPE.ONETIME);
			onetimeCron.setStatus(true);
			onetimeCron.Request.setUrl("https://www.google.co.in").setRequestMethod(RequestMethod.GET).setRequestBody("").setHeaders(new JSONObject()).setParams(new JSONObject());
			onetimeCron.Config.setTimeOfExecution(System.currentTimeMillis()).setTimezone(TIMEZONE.ASIA_CALCUTTA);
			ZCCron.getInstance().createCron(onetimeCron);
			ZCCron myCron = ZCCron.getInstance();
			List<ZCCronDetail> mycronInfo = myCron.getCron();
			CronData expectedDetails= new CronData();
			expectedDetails.expectedCronType="OneTime";
			expectedDetails.expectedCronName="TestCron";
			responseData=verifyCronDetails(mycronInfo,expectedDetails);
			if(responseData.get(flag)=="false") {
				responseData.put("message", "Cron was created and Details of cron were fetched and verified successfully");
			}
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
	public void testCase23(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData= new JSONObject();
		Boolean flag=false;
		try {
			ZCCronDetail periodicCron = ZCCronDetail.getInstance();
			periodicCron.setCronName("PeriodicCron");
			periodicCron.setCronType(CRONTYPE.PERIODIC);
			periodicCron.setStatus(true);
			periodicCron.Request.setUrl("https://www.google.co.in").setRequestMethod(RequestMethod.GET).setRequestBody("").setHeaders(new JSONObject()).setParams(new JSONObject());
			periodicCron.Config.setHour(1).setMinute(0).setSeconds(0).setTimezone(TIMEZONE.ASIA_CALCUTTA);
			ZCCron.getInstance().createCron(periodicCron);
			ZCCron myCron = ZCCron.getInstance();
			List<ZCCronDetail> mycronInfo = myCron.getCron();
			CronData expectedDetails = new CronData();
			expectedDetails.expectedCronType="Periodic";
			expectedDetails.expectedCronName="PeriodicCron";
			expectedDetails.expectedHour=1;
			responseData=verifyCronDetails(mycronInfo,expectedDetails);
			if(responseData.get(flag)=="false") {
				responseData.put("message", "Cron was created and Details of cron were fetched and verified successfully");
			}
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e.toString());
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
	public void testCase24(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int arr[]= {1,3,5,7,9};
		JSONObject responseData=new JSONObject();
		Boolean flag=false;
		try {
			ZCCronDetail calendarCron2 = ZCCronDetail.getInstance();
			calendarCron2.setCronName("CalendarCron2");
			calendarCron2.setCronType(CRONTYPE.CALENDAR);
			calendarCron2.setStatus(true);
			calendarCron2.setCronFunctionId(1926000004343699L);
			JSONObject params2 = new JSONObject();
			params2.put("Name", "Test");
			calendarCron2.Request.setUrl("").setParams(params2);
			calendarCron2.Config.setRepetitionType("Monthly").setDaysArr(arr).setHour(17).setMinute(59).setSeconds(59).setTimezone(TIMEZONE.ASIA_CALCUTTA);
			ZCCron.getInstance().createCron(calendarCron2);
			ZCCron myCron = ZCCron.getInstance();
			List<ZCCronDetail> mycronInfo = myCron.getCron();
			CronData expectedDetails = new CronData();
			expectedDetails.expectedCronType="Calendar";
			expectedDetails.expectedCronName="CalendarCron2";
			expectedDetails.expectedHour=17;
			expectedDetails.expectedMinute=59;
			expectedDetails.expectedSeconds=59;
			expectedDetails.expectedRepetitionType="Monthly";
			expectedDetails.expectedURL="";
			expectedDetails.expectedMethod="";
			responseData=verifyCronDetails(mycronInfo,expectedDetails);
			if(responseData.get(flag)=="false") {
				responseData.put("message", "Cron was created and Details of cron were fetched and verified successfully");
			}
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e.toString());
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
	public void testCase25(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData=new JSONObject();
		Boolean flag=false;
		int arr[]= {11,13,15,17,19};
		
		try {
			ZCCron myCron = ZCCron.getInstance();
			List<ZCCronDetail> myCronInfo=myCron.getCron();
			long jobId1=myCronInfo.get(0).getCronJobId();
			ZCCronDetail cron =myCron.getCron(jobId1);
			cron.setStatus(false);
			cron.setCronName("EditedCronName");
			cron.getJobConfig().setRepetitionType("Monthly").setDaysArr(arr).setHour(1).setMinute(5).setSeconds(0);
			JSONObject params2 = new JSONObject();
			params2.put("Edited", "Value");
			cron.getRequestConfig().setParams(params2);
			ZCCron.getInstance().updateCron(cron);
			cron =myCron.getCron(jobId1);
			if(!(cron.getStatus()==false&&cron.getCronName().equals("EditedCronName")&&cron.getJobConfig().getHour()==1&&cron.getJobConfig().getMinute()==5&&cron.getJobConfig().getSeconds()==0&&cron.getJobConfig().getTimezone().equals("Asia/Calcutta")&&cron.getRequestConfig().getParams().get("Edited").equals("Value"))) {
				flag=true;
				responseData.put("message","Mismatch found in updated cronDetails. Expected - False, EditedCronName, 1, 5, 0, Asia/Calcutta. Found - "+cron.getJobConfig().getHour()+", "+cron.getJobConfig().getMinute()+", "+cron.getJobConfig().getSeconds()+", "+cron.getJobConfig().getTimezone());
			}
			else {
				responseData.put("message","Cron details updated successfully and details were fetched and verified");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e.toString());
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
	public void testCase26(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData=new JSONObject();
		Boolean flag=false;
		try {
			ZCCronDetail cron=ZCCronDetail.getInstance();
			cron.setCronName("AlertCheck");
			cron.setCronType(CRONTYPE.ONETIME);
			cron.setStatus(true);
			cron.setCronFunctionId(1926000004343685L);
			cron.Config.setTimeOfExecution(System.currentTimeMillis()).setTimezone(TIMEZONE.PACIFIC_TIME);
			ZCCron myCron = ZCCron.getInstance();
			myCron.createCron(cron);
			responseData.put("message","No exception was thrown while trying to create a cron with advanced I/O function. Case Failed");
			flag=true;
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
			if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : The given function is not a cron function. INVALID_INPUT")) {
				responseData.put("message", "Expected alert is thrown while trying to create cron with advanced I/O function");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
				flag=true;
				responseData.put("error", e.toString());
				responseData.put("flag",flag);
				responseData.put("value", "exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
			
		}
	}
	public void testCase27(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData=new JSONObject();
		Boolean flag=false;
		try {
			ZCCron myCron = ZCCron.getInstance();
			List<ZCCronDetail> myCronInfo=myCron.getCron();
			long jobId1=myCronInfo.get(0).getCronJobId();
			long jobId2=myCronInfo.get(1).getCronJobId();
			long jobId3=myCronInfo.get(2).getCronJobId();
			myCron.deleteCron(jobId1);
			myCron.deleteCron(jobId2);
			myCron.deleteCron(jobId3);
			myCronInfo=myCron.getCron();
			if(myCronInfo.size()>0) {
				flag=true;
				responseData.put("message", "Even after deletion, one or more cron jobs were found. Case Failed");
			}
			else {
				responseData.put("message","All three cronJobs were deleted successfully. Case passed");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e.toString());
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
	
	public void testCase62(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData=new JSONObject();
		Boolean flag=false;
		try {
			ZCCron myCron = ZCCron.getInstance();
			ZCCronDetail cron = ZCCronDetail.getInstance();
			cron.setCronType(CRONTYPE.ONETIME);
			cron.setStatus(true);
			myCron.createCron(cron);
			responseData.put("message","No exception was thrown. Case Failed");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e.toString());
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : cron_name cannot be null INVALID_INPUT"))
			{
				responseData.put("message", "Expected exception was thrown. Case passed.");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);			
			}
			else {
				flag=false;
				responseData.put("flag",flag);
				responseData.put("message",e.toString());
				responseData.put("value", "exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
		}
	}
	
public JSONObject verifyCronDetails(List<ZCCronDetail> mycronInfo,CronData expectedDetails) {
	Boolean flag=false;
	String method="";
	JSONObject responseData = new JSONObject();
	String email=mycronInfo.get(0).getCreatedBy().getEmailId();
//	long funcId=mycronInfo.get(0).getCronFunctionId();
	long jobId=mycronInfo.get(0).getCronJobId();
	String cronName=mycronInfo.get(0).getCronName();
	String cronType=mycronInfo.get(0).getCronType();
	if(mycronInfo.get(0).getExecutionTimesPerDay()!=null) {int times=mycronInfo.get(0).getExecutionTimesPerDay();}
	ZCJobConfig jobConfig=mycronInfo.get(0).getJobConfig();
	ZCRequestConfig requestConfig=mycronInfo.get(0).getRequestConfig();
	Boolean status=mycronInfo.get(0).getStatus();
	String date=jobConfig.getTimezone();
	String url=requestConfig.getUrl();
	if(requestConfig.getRequestMethod()!=null) {method=requestConfig.getRequestMethod();}
	int periodicity=0;
	String repType="";
	long timeOfExecution=0L;
	String repetitionType="";
	int hours=0;
	int minutes=0;
	int seconds=0;
	int daysArr[]= {};
	if(jobConfig.getPeriodicity()!=null) {periodicity=jobConfig.getPeriodicity();}
	if(jobConfig.getRepetitionType()!=null) {repType=jobConfig.getRepetitionType();}
	if(jobConfig.getTimeOfExecution()!=null) {timeOfExecution=jobConfig.getTimeOfExecution();}
	if(jobConfig.getRepetitionType()!=null) {repetitionType=jobConfig.getRepetitionType();}
	if((Integer)jobConfig.getHour()!=null) {hours=jobConfig.getHour();}
	if((Integer)jobConfig.getMinute()!=null) {minutes=jobConfig.getMinute();}
	if((Integer)jobConfig.getSeconds()!=null) {seconds=jobConfig.getSeconds();}
	if(repetitionType=="Monthly") {
		for(int itr=0;jobConfig.getDaysArr()[itr]!='\0';itr++) {
			daysArr[itr]=jobConfig.getDaysArr()[itr];
		}
	for(int itr=0;jobConfig.getDaysArr()[itr]!='\0';itr++) {
		if(daysArr[itr]!=expectedDetails.expectedDays[itr]) {
			flag=true;
			responseData.put("message1","Mismatch in getDaysArr ");
		}
	}
	}
	if(!(email.equals(expectedDetails.expectedMail)&&cronName.equals(expectedDetails.expectedCronName)&&cronType.equals(expectedDetails.expectedCronType)&&status.equals(expectedDetails.expectedStatus)&&date.equals(expectedDetails.expectedTimeZone)&&url.equals(expectedDetails.expectedURL)&&method.equals(expectedDetails.expectedMethod)&&repetitionType.equals(expectedDetails.expectedRepetitionType)&&hours==expectedDetails.expectedHour&&minutes==expectedDetails.expectedMinute&&seconds==expectedDetails.expectedSeconds)){
		flag=true;
		responseData.put("message", "Mismatch in obtained values. Expected - "+expectedDetails.expectedMail+ ", "+expectedDetails.expectedCronName+ ", "+expectedDetails.expectedCronType+", " +expectedDetails.expectedStatus+ ", "+expectedDetails.expectedTimeZone+ ", "+expectedDetails.expectedURL+ ", "+expectedDetails.expectedMethod+", "+expectedDetails.expectedRepetitionType+", "+expectedDetails.expectedHour+", "+expectedDetails.expectedMinute+", "+expectedDetails.expectedSeconds+" .Found - "+email+", "+cronName+ ", "+cronType+ ", "+status+", "+ date+ ", "+url+", "+ method+", "+repetitionType+", "+hours+", "+minutes+", "+seconds );
	}
	else {
		responseData.put("message", "Cron was created and Details of cron were fetched and verified successfully");
	}
	responseData.put("flag", flag);
	return responseData;
}
public void resetMethod() {
	try {
		ZCCron myCron = ZCCron.getInstance();
		List<ZCCronDetail> myCronInfo=myCron.getCron();
		for(int itr=0;itr<myCronInfo.size();itr++) {
			myCron.deleteCron(myCronInfo.get(itr).getCronJobId());
		}
	}
	catch(Exception e) {
		
	}
}
}