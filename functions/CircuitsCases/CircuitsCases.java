import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import org.json.simple.JSONObject; 
import java.util.Date;
import com.zc.component.circuits.ZCCircuit; 
import com.zc.component.circuits.ZCCircuitDetails; 
import com.zc.component.circuits.ZCCircuitExecutionDetails; 
import com.zc.component.circuits.ZCCircuitExecutionStatus;

public class CircuitsCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(CircuitsCases.class.getName());
	
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
			case "testCase99":
				testCase99(request,response);
				break;
			case "testCase100":
				testCase100(request,response);
				break;
			case "testCase101":
				testCase101(request,response);
				break;
			
	}
	}
	public void testCase99(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String status="";
		Date currentDate = new Date();
		try {
			ZCCircuitDetails userBackupCircuit = ZCCircuit.getInstance().getCircuitInstance(1926000006804079L); 
			JSONObject execInputJson = new JSONObject();
			ZCCircuitExecutionDetails circuitExecution = userBackupCircuit.execute("Case"+currentDate.getTime(),execInputJson); 
			String executionId=circuitExecution.getExecutionId();
			ZCCircuitExecutionDetails execDetails = userBackupCircuit.getExecutionDetails(executionId);
			for(int itr=0;itr<20;itr++) {
				execDetails = userBackupCircuit.getExecutionDetails(executionId);
				if(execDetails.getStatus().toString().equals("RUNNING")) {
					Thread.sleep(500);
				}
				else {
					break;
				}
			}
			status=userBackupCircuit.getExecutionDetails(executionId).getStatus().toString();
			if(!status.equals("SUCCESS")) 
			{ 
				flag=true;
				responseData.put("message", "Success status is not obtained for circuit execution. Obtained status - "+status);
			} 
			else {
				responseData.put("message","Success response is obtained for circuit execution");
			}
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase100(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String status="";
		Date currentDate = new Date();
		try {
			ZCCircuitDetails userBackupCircuit = ZCCircuit.getInstance().getCircuitInstance(1926000006804079L); 
			JSONObject execInputJson = new JSONObject();
			ZCCircuitExecutionDetails circuitExecution = userBackupCircuit.execute("Case"+currentDate.getTime(),execInputJson); 
			String executionId=circuitExecution.getExecutionId();
			ZCCircuitExecutionDetails execDetails = userBackupCircuit.getExecutionDetails(executionId);
			
			userBackupCircuit.abortExecution(executionId);
			for(int itr=0;itr<20;itr++) {
				execDetails = userBackupCircuit.getExecutionDetails(executionId);
				if(execDetails.getStatus().getExecutionStatus(executionId)!=null&&execDetails.getStatus().toString().equals("RUNNING")) {
					Thread.sleep(500);
				}
				else {
					break;
				}
			}
			ZCCircuitExecutionDetails newExecDetails = userBackupCircuit.getExecutionDetails("328d9cbb-5f0a-4a41-97b0-a07f079ae684");
			status=newExecDetails.getStatus().toString();
			if(!status.equals("ABORTED")) 
			{ 
				flag=true;
				responseData.put("message", "Aborted status not found after aborting execution. Obtained status - "+status);
			} 
			else {
				responseData.put("message","Aborted response is obtained after aborting");
			}
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	
	public void testCase101(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String status="";
		String circuitName="";
		String execId="";
		Date currentDate = new Date();
		JSONObject inputVal=new JSONObject();
		try {
			ZCCircuitDetails userBackupCircuit = ZCCircuit.getInstance().getCircuitInstance(1926000006804079L); 
			JSONObject execInputJson = new JSONObject();
			execInputJson.put("testKey", "testVal");
			ZCCircuitExecutionDetails circuitExecution = userBackupCircuit.execute("Case"+currentDate.getTime(),execInputJson); 
			circuitName=circuitExecution.getCircuitName();
			LOGGER.log(Level.INFO,circuitName);
			execId=circuitExecution.getExecutionId();
			inputVal=circuitExecution.getInput();
			String name=circuitExecution.getName();
			Date start=circuitExecution.getStartTime();
			ZCCircuitExecutionDetails execDetails = userBackupCircuit.getExecutionDetails(execId);
			for(int itr=0;itr<40;itr++) {
				execDetails = userBackupCircuit.getExecutionDetails(execId);
				if(execDetails.getStatus().toString().equals("RUNNING")) {
					Thread.sleep(500);
				}
				else {
					break;
				}
			}
			status=userBackupCircuit.getExecutionDetails(execId).getStatus().toString();
			if(circuitName==null||!circuitName.equals("test")||execId==null||!inputVal.get("testKey").equals("testVal")||name==null||start==null||!status.equals("SUCCESS")) {
				flag=true;
			responseData.put("message","Mismatch in one or more of the values. Values found - Circuit name - "+circuitName+" , execution id - "+execId+" , input json - "+inputVal.toString()+" , name - "+name+" , start date - "+start+" , status - "+status);
			}else {
				responseData.put("message","Expected values obtained for circuit execution. ");
			}
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
}