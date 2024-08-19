import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.zc.component.object.ZCColumn;
import com.zc.component.object.ZCObject;
import com.zc.component.object.ZCRowObject;
import com.zc.component.object.ZCRowPagedResponse;
import com.zc.component.object.ZCTable;
import com.zc.component.zcql.ZCQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;

public class CatalystAutomationProject implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(CatalystAutomationProject.class.getName());
	String rowid="";
	private static String TABLENAME = "TestTable";
	static String GET = "GET";
	static String POST = "POST";
	private static String TABLENAME2="FKTable";
	String name="";
	@Override
    public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String param="";
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
			case "testCase1":
			testCase1(request,response);
			break;
			case "testCase2":
			testCase2(request,response);
			break;
			case "testCase3":
			testCase3(request,response);
			break;
			case "testCase4":
			testCase4(request,response);
			break;
			case "testCase5":
			testCase5(request,response);
			break;
			case "testCase6":
			testCase6(request,response);
			break;
			case "testCase7":
			testCase7(request,response);
			break;
			case "testCase8":
			testCase8(request,response);
			break;
			case "testCase9":
			testCase9(request,response);
			break;
			case "testCase10":
			testCase10(request,response);
			break;
			case "testCase96":
			testCase96(request,response);
			break;
			case "testCase97":
			testCase97(request,response);
			break;
			case "testCase98":
			testCase98(request,response);
			break;
			default:
			testCase1(request,response);
		}


}
	public void testCase1(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String method = request.getMethod();
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try{
		if(method.equals(POST))
		{
			resetMethod();
		ZCRowObject row = ZCRowObject.getInstance();
		row.set("var", "qq");
		row.set("mandtext","~!@#$%^&*()_+{}|<>?:';,./[]\\`");
		row.set("integerUnique",999999999);
		row.set("doubleVal",1.23);
		row.set("bigintVal",-11);
		row.set("encVal","1234");
		row.set("boolVal", false);
		row.set("dateTime", "2021-03-01 23:59:59");
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		responseData.put("message", "Value has been inserted!");
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
	}
	else{
		String query="select * from "+TABLENAME;
		ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
		JSONObject data = new JSONObject();
		JSONArray content = new JSONArray();
		for(int i=0;i<rowList.size();i++)
		{
			JSONObject rowData = new JSONObject();
			JSONObject tableData = new JSONObject();
			String value="";
			String var = (String) rowList.get(i).get(TABLENAME, "var");
			String mandtext = (String)rowList.get(i).get(TABLENAME, "mandtext");
			String integerUnique=(String)rowList.get(i).get(TABLENAME,"integerUnique");
			String defaultDateVal=(String)rowList.get(i).get(TABLENAME,"defaultDateVal");
			Double doubleVal=(Double) (rowList.get(i).get(TABLENAME,"doubleVal"));
			String bigintVal=(String) (rowList.get(i).get(TABLENAME,"bigintVal"));
			String encVal=(String)rowList.get(i).get(TABLENAME,"encVal");
			String dateTime=(String)rowList.get(i).get(TABLENAME,"dateTime");
			String boolVal=rowList.get(i).get(TABLENAME,"boolVal").toString();
			rowid=rowList.get(i).get(TABLENAME,"ROWID").toString();

			if(var.equals("qq")){value+="Expected value of var is qq and the value is fetched correctly.<br>";}else{value+="Expected value of var is qq but the value obtained is "+var+". Values mismatch !<br> ";flag=true;}
			if(mandtext.equals("~!@#$%^&*()_+{}|<>?:';,./[]\\`")){value+="Expected value of mandtext is ~!@#$%^&*()_+{}|<>?:';,./[]\\` and the value is fetched correctly.<br>";}else{value+="Expected value of mandtext is ~!@#$%^&*()_+{}|<>?:';,./[]\\` but the value obtained is "+mandtext+". Values mismatch !<br>";flag=true;}
			if(integerUnique.equals("999999999")){value+="Expected value of interunique is 999999999 and the value is fetched correctly.<br>";}else{value+="Expected value of integerunique is 999999999 but the value obtained is "+integerUnique+". Values mismatch !<br>";flag=true;}
			if(defaultDateVal.equals("2021-05-01")){value+="Expected value of defaultDateVal is 2021-05-01 and the value is fetched correctly.<br>";}else{value+="Expected value of defaultDateVal is 2021-05-01 but the value obtained is "+defaultDateVal+". Values mismatch !<br>";flag=true;}
			if(doubleVal.equals(1.23)){value+="Expected value of doubleVal is 1.23 and the value is fetched correctly.<br>";}else{value+="Expected value of doubleVal is 1.23 but the value obtained is "+doubleVal+". Values mismatch !<br>";flag=true;}
			if(bigintVal.equals("-11")){value+="Expected value of bigintVal is -11 and the value is fetched correctly.<br>";}else{value+="Expected value of bigintVal is -11 but the value obtained is "+bigintVal+". Values mismatch !<br>";flag=true;}
			if(encVal.equals("1234")){value+="Expected value of encVal is 1234 and the value is fetched correctly.<br>";}else{value+="Expected value of encVal is 1234 but the value obtained is "+encVal+". Values mismatch !<br>";flag=true;}
			if(dateTime.equals("2021-03-01 23:59:59")){value+="Expected value of dateTime is 2021-03-01 23:59:59 and the value is fetched correctly.<br>";}else{value+="Expected value of dateTime is 2021-03-01 23:59:59 but the value obtained is "+dateTime+". Values mismatch !<br>";flag=true;}
			if(boolVal.equals("false")){value+="Expected value of boolVal is false and the value is fetched correctly.<br>";}else{value+="Expected value of boolVal is false but the value obtained is "+boolVal+". Values mismatch !<br>";flag=true;}

			resetMethod();
			responseData.put("var", var);
			//rowData.put("varchar1size", varchar1size);
			responseData.put("message",value);
			responseData.put("flag", flag);
			}
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
//		responseData.put("message",resp);
	}


	}
	catch(Exception e)
	{
		LOGGER.log(Level.SEVERE, "Exception occured", e);
		if(name.contains("app"))
			{
			if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
			responseData.put("message","Expected exception is thrown for app user");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
			else {
				responseData.put("message",e.toString());
				flag=true;
				responseData.put("value","exception");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
			}
		else {
	responseData.put("message",e.toString());
	flag=true;
	responseData.put("value","exception");
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(500);
	}
	}
}

	public void testCase2(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String method = request.getMethod();
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
		if(method.equals(POST))
		{
		resetMethod();
		ZCRowObject row = ZCRowObject.getInstance();
		row.set("var", "qq");
		row.set("mandtext","~!@#$%^&*()_+{}|<>?:';,./[]\\`");
		row.set("integerUnique",999999999);
		row.set("doubleVal",1.23);
		row.set("bigintVal",-11);
		row.set("encVal","1234");
		row.set("boolVal", false);
		row.set("dateTime", "2021-03-01 23:59:59");
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		ZCRowObject row1 = ZCRowObject.getInstance();
		row1.set("integerUnique",999999999);
		row1.set("mandtext","zz");
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row1);
		flag=true;
		responseData.put("message","Duplicate check exception was not thrown and duplicate value has been inserted. Case Failed");
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(400);
	}
	}

	catch(Exception e)
	{
	resetMethod();
	LOGGER.log(Level.SEVERE, "Exception occured", e);
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	String exceptionAsString = sw.toString();
	if(name.contains("app"))
	{
	if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
	responseData.put("message","Expected exception is thrown for app user");
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(200);
}
	else {
		responseData.put("message",e.toString());
		flag=true;
		responseData.put("flag",flag);
		responseData.put("value","exception");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(500);
	}
	}
	else {
	if(exceptionAsString.contains("Duplicate value")){
	responseData.put("message","Duplicate value found for one of the entries alert is correctly thrown. Case Passed");
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(200);
	}
	else{
	flag=true;
	responseData.put("value","exception");
	responseData.put("message",sw.toString());
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(400);
	}
	}
	}
	}

	public void testCase3(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
		if(method.equals(POST))
		{
		ZCRowObject row = ZCRowObject.getInstance();
		row.set("integerUnique",33);
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		responseData.put("message", "Mandatory column missing alert is not thrown. Case Failed");
		flag=true;
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
	}
	}

	catch(Exception e)
	{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	String exceptionAsString = sw.toString();

	if(name.contains("app"))
	{
	if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
	responseData.put("message","Expected exception is thrown for app user");
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(200);
}
	else {
		responseData.put("message",e.toString());
		flag=true;
		responseData.put("flag",flag);
		responseData.put("value","exception");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(500);
	}
	}
	else {
	if(exceptionAsString.contains("Column mandtext is mandatory and cannot be empty")){
	responseData.put("message","Mandatory column missing alert is thrown correctly. Case Passed. ");
	responseData.put("flag",flag);
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(200);
	}
	else{
	flag=true;
	responseData.put("message",sw.toString());
	responseData.put("flag",flag);
	responseData.put("value","exception");
	response.setContentType("application/json");
	response.getWriter().write(responseData.toString());
	response.setStatus(500);
	}
	}
	}
	}
	public void testCase4(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
		if(method.equals(POST))
		{
		ZCRowObject row = ZCRowObject.getInstance();
		row.set("integerUnique","qwwq");
		row.set("mandtext", "wqqw");
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		responseData.put("message", "Invalid value alert alert is not thrown. Case Failed");
		flag=true;
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
	}
	}

	catch(Exception e)
	{
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();

		if(name.contains("app"))
		{
		if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
		responseData.put("message","Expected exception is thrown for app user");
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
	}
		else {
			responseData.put("message",e.toString());
			flag=true;
			responseData.put("flag",flag);
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
		else {
		if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : Invalid input value for integerUnique. int value expected INVALID_INPUT")){
		responseData.put("message","Invalid input alert is thrown correctly. Case Passed.");
		responseData.put("flag",flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		else{
		flag=true;
		responseData.put("message",sw.toString());
		responseData.put("flag",flag);
		responseData.put("value","exception");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(500);
		}
		}
		}
	}
	public void testCase5(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		String intVal="";
		Boolean flag=false;
		try{
			resetMethod();
			ZCRowObject row = ZCRowObject.getInstance();
			row.set("var", "qq");
			row.set("mandtext","~!@#$%^&*()_+{}|<>?:';,./[]\\`");
			row.set("integerUnique",999999999);
			row.set("doubleVal",1.23);
			row.set("bigintVal",-11);
			row.set("encVal","1234");
			row.set("boolVal", false);
			row.set("dateTime", "2021-03-01 23:59:59");
			ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
			ZCObject object = ZCObject.getInstance();
			ZCTable table = object.getTable("TestTable");
			List<ZCRowObject> rowsGet = table.getAllRows();
			List<ZCRowObject> rows = new ArrayList<ZCRowObject>();
			ZCRowObject row1 = ZCRowObject.getInstance();
			long rownum=0L;
			if(rowsGet.size()>0) {
				rowid=rowsGet.get(0).get(TABLENAME,"ROWID").toString();
				rownum=Long.parseLong(rowid);
			row1.set("integerUnique",0);
			row1.set("mandtext", "updatedval");
			row1.set("ROWID", rownum);
			rows.add(row1);
			}
			table.updateRows(rows);
			rowsGet = table.getAllRows();
			intVal=rowsGet.get(0).get(TABLENAME,"integerUnique").toString();
			if(intVal.equals("0"))
			{
				responseData.put("message","Row has been updated correctly. Case Passed");
				responseData.put("flag",flag);
			}
			else {
				flag=true;
				responseData.put("message","Row has not been updated correctly. Case Failed");
				responseData.put("flag","false");
			}
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString());
			flag=true;
			responseData.put("flag", flag);
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase6(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
			resetMethod();
			ZCRowObject row = ZCRowObject.getInstance();
			row.set("var", "qq");
			row.set("mandtext","~!@#$%^&*()_+{}|<>?:';,./[]\\`");
			row.set("integerUnique",999999999);
			row.set("doubleVal",1.23);
			row.set("bigintVal",-11);
			row.set("encVal","1234");
			row.set("boolVal", false);
			row.set("dateTime", "2021-03-01 23:59:59");
			ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
			ZCObject obj = ZCObject.getInstance();
			ZCTable tab = obj.getTable("TestTable");
			List<ZCRowObject> rows = tab.getAllRows();
			long rownum=0L;
			if(rows.size()>0) {
				rowid=rows.get(0).get(TABLENAME,"ROWID").toString();
				rownum=Long.parseLong(rowid);}
				tab.deleteRow(rownum);
			responseData.put("message","Row deleted successfully. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			resetMethod();
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString());
			flag=true;
			responseData.put("flag",flag);
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase7(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
			resetMethod();
			List<ZCRowObject> rows = new ArrayList<ZCRowObject>();
			ZCObject object = ZCObject.getInstance();
			ZCTable tab = object.getTable("TestTable");
			ZCRowObject row1 = ZCRowObject.getInstance();
			ZCRowObject row2 = ZCRowObject.getInstance();
			String mandVal="";
			String varText="";
			String doubleVal="";
			String mandVal2="";
			String intUnique="";
			row1.set("mandtext","Value1");
			row1.set("var", "multiple");
			row2.set("mandtext","Value2");
			row2.set("doubleVal", 3.45);
			row2.set("integerUnique", 100);
			rows.add(row1);
			rows.add(row2);
			tab.insertRows(rows);
			List<ZCRowObject> rowsGet = tab.getAllRows();
			mandVal=rowsGet.get(0).get(TABLENAME,"mandtext").toString();
			varText=rowsGet.get(0).get(TABLENAME,"var").toString();
			mandVal2=rowsGet.get(1).get(TABLENAME,"mandtext").toString();
			doubleVal=rowsGet.get(1).get(TABLENAME,"doubleVal").toString();
			intUnique=rowsGet.get(1).get(TABLENAME,"integerUnique").toString();
			if(mandVal.equals("Value1")&&varText.equals("multiple")&&doubleVal.equals("3.45")&&mandVal2.equals("Value2")&&intUnique.equals("100"))
			{
				responseData.put("message","Multiple rows have been inserted correctly. Case Passed");
				responseData.put("flag",flag);
			}
			else {
				flag=true;
				responseData.put("message","Multiple rows have not been inserted correctly. Case Failed");
				responseData.put("flag",flag);
			}
			resetMethod();
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
			}
		catch(Exception e) {
			resetMethod();
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	}
	public void testCase8(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
 		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try{
			resetMethod();
			List<ZCRowObject> rows = new ArrayList<ZCRowObject>();
			ZCObject object = ZCObject.getInstance();
			ZCTable tab = object.getTable("TestTable");
			ZCRowObject row1 = ZCRowObject.getInstance();
			ZCRowObject row2 = ZCRowObject.getInstance();
			String mandVal="";
			String varText="";
			String doubleVal="";
			String mandVal2="";
			String intUnique="";
			row1.set("mandtext","Value1");
			row1.set("var", "multiple");
			row2.set("mandtext","Value2");
			row2.set("doubleVal", 3.45);
			row2.set("integerUnique", 100);
			rows.add(row1);
			rows.add(row2);
			tab.insertRows(rows);
			ArrayList<Long> rowIdList = new ArrayList<>();
			ZCObject obj = ZCObject.getInstance();
			List<ZCRowObject> rows1 = tab.getAllRows();
			for(int i=0;i<rows1.size();i++)
			{
				rowid=rows1.get(i).get(TABLENAME,"ROWID").toString();
				rowIdList.add(Long.parseLong(rowid));
			}
			List<ZCRowObject> deletedRowList = tab.deleteRows(rowIdList);
			resetMethod();
			responseData.put("message","Multiple rows deleted successfully. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			resetMethod();
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase9(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject resp= new JSONObject();
		JSONObject responseData = new JSONObject();
		try {
		ZCObject object = ZCObject.getInstance();
		ZCTable tableMeta = object.getTable("TestTable");
		ZCColumn col=tableMeta.getColumn("ROWID");
		ColumnData expValues= new ColumnData();
		expValues.expectedId=1926000004342813L;
		expValues.expectedName="ROWID";
		expValues.expectedType="bigint";
		expValues.expectedMand=false;
		resp=columnDetailsCheck(col,expValues);
		response.setContentType("application/json");
		response.getWriter().write(resp.toString());
		response.setStatus(200);
		}
		catch(Exception e)
		{
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase10(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject resp= new JSONObject();
		JSONObject responseData = new JSONObject();
		String parentColumn="";
		String parentTable="";
		String val="";
		Boolean flag=false;
		try {
		ZCObject object = ZCObject.getInstance();
		ZCTable tableMeta = object.getTable("FKTable");
		ZCColumn col=tableMeta.getColumn("FK");
		ColumnData expValues= new ColumnData();
		expValues.expectedId=1926000004343532L;
		expValues.expectedName="FK";
		expValues.expectedType="foreign key";
		expValues.expectedMand=false;
		resp=columnDetailsCheck(col,expValues);
		if(col.getParentColumn()!=null)
		{
			parentColumn=col.getParentColumn();
			if(!parentColumn.equals("1926000004342813")) {
				flag=true;
				resp.put("flag",flag);
				val=resp.get("message").toString();
				resp.put("message", val+". Parent Column value mismatch for foreign key column. Expected - 1926000004342813, Found - "+parentColumn);
			}
			else {
					val=resp.get("message").toString();
					resp.put("message", val+". Expected Parent Column value found for foreign key column");
				}
		}
		if(col.getParentTable()!=null) {
			parentTable=col.getParentTable();
			if(!parentTable.equals("1926000004342810")) {
				flag=true;
				resp.put("flag",flag);
				val=resp.get("message").toString();
				resp.put("message", val+". Parent Table value mismatch for foreign key column. Expected - 1926000004342810, Found - "+parentTable);
			}
			else {
					val=resp.get("message").toString();
					resp.put("message", val+". Expected Parent Table value found for foreign key column");
				}
			}
		response.setContentType("application/json");
		response.getWriter().write(resp.toString());
		response.setStatus(200);
		}
		catch(Exception e)
		{
			responseData.put("message",e.toString());
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase96(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject resp= new JSONObject();
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			resetMethod();
		ZCObject object = ZCObject.getInstance();
		ZCRowObject row = ZCRowObject.getInstance();
		row.set("mandtext", "wqqw");
		row.set("uniqueVar","null");
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
		flag=true;
		responseData.put("message", "Duplicate value alert is not thrown. Case failed.");
		responseData.put("flag", flag);
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		resetMethod();
		}
		catch(Exception e)
		{
			resetMethod();
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			if(name.contains("app"))
			{
			if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
			responseData.put("message","Expected exception is thrown for app user");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
			else {
				responseData.put("message",e.toString());
				flag=true;
				responseData.put("flag",flag);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
			}
			else {
			if(exceptionAsString.contains("Duplicate value")){
			responseData.put("message","Duplicate value found for one of the entries alert is correctly thrown. Case Passed");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
			}
			else{
			flag=true;
			responseData.put("value","exception");
			responseData.put("message",sw.toString());
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
			}
		}
	}
	public void testCase97(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
		ZCObject object = ZCObject.getInstance();
		String nextToken = null;
		ZCRowPagedResponse pagedResp;
		int count=0;
		int maxRows = 100;
			do{
				pagedResp = ZCObject.getInstance().getTable("rows300").getPagedRows(nextToken, maxRows);
				for(ZCRowObject row : pagedResp.getRows()){
				count+=1;
				}
				if(pagedResp.moreRecordsAvailable()){
				nextToken = pagedResp.getNextToken();
					}
			}while(pagedResp.moreRecordsAvailable());
			if(count!=300) {
				flag=true;
				responseData.put("message","300 records were not fetched as expected. Found - "+count+" records");
			}
			else {
				responseData.put("message","300 records were fetched as expected.");
			}
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
			if(name.contains("app"))
			{
			if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
			responseData.put("message","Expected exception is thrown for app user");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
			else {
				responseData.put("message",e.toString());
				flag=true;
				responseData.put("flag",flag);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
			}
			else {
			flag=true;
			responseData.put("value","exception");
			responseData.put("message",sw.toString());
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
			}
		}
	public void testCase98(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		List<ZCRowObject> rows = new ArrayList<ZCRowObject>();
		String query="";
		ArrayList<ZCRowObject> rowList = new ArrayList<ZCRowObject>();
		try {
		if(!name.contains("app"))
		{
		query="delete from Datastore_table";
		rowList=ZCQL.getInstance().executeQuery(query);
		}
		ZCObject object = ZCObject.getInstance();
		ZCTable tab = object.getTable("Datastore_Table");
		ZCRowObject row1 = ZCRowObject.getInstance();
		for(int itr=0;itr<200;itr++) {
			row1.set("intt", 0);
			rows.add(row1);
		}
		tab.insertRows(rows);
		query="select * from Datastore_Table";
		rowList.clear();
		rowList=ZCQL.getInstance().executeQuery(query);
		if(rowList.size()!=200) {
			flag=true;
			responseData.put("messsage", "Expected row count - 200. Found - "+rowList.size());
		}
		else {
			responseData.put("message", "Expected row count found after insertion");
		}
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
			if(name.contains("app"))
			{
			if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
			responseData.put("message","Expected exception is thrown for app user");
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
			else {
				responseData.put("message",e.toString());
				flag=true;
				responseData.put("flag",flag);
				responseData.put("value","exception");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
			}
			else {
			flag=true;
			responseData.put("value","exception");
			responseData.put("message",sw.toString());
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
			}
		}
	public JSONObject columnDetailsCheck(ZCColumn col,ColumnData expValues)
	{
		JSONObject responseData = new JSONObject();
		Long id=0L;
		String name="";
		String type="";
		Boolean mand=false;
		Boolean flag=false;
		try {
			id=col.getColumnId();
			name=col.getColumnName();
			type=col.getDataType();
			mand=col.getIsMandatory();
			if(id.equals(expValues.expectedId)&&name.equals(expValues.expectedName)&&type.equals(expValues.expectedType)&&Boolean.compare(mand,expValues.expectedMand)==0)
			{
				responseData.put("message","Expected values for the column properties are obtained");
			}
			else {
				flag=true;
				responseData.put("message","Mismatch in one of the properties. Expected values - <br>column id - "+expValues.expectedId+" <br>column name -  "+expValues.expectedName+" <br>column type - "+expValues.expectedType+" <br>is mandatory value - "+expValues.expectedMand+"<br> Found : column id - "+id+" <br>column name - "+name+" <br>column type - "+type+" <br>is mandatory value - "+mand+"<br>");
			}
			responseData.put("flag",flag);
		//	responseData.put("details",col.getColumnId()+" "+col.getColumnName()+" "+col.getDataType()+" "+col.getIsMandatory());
			return responseData;
		}
		catch(Exception e)
		{
			responseData.put("message", e.toString());
			responseData.put("value","exception");
			return responseData;
		}
	}
	public void resetMethod() {
		try {
			ArrayList<Long> rowIdList = new ArrayList<>();
			ZCObject obj = ZCObject.getInstance();
			ZCTable tab = obj.getTable("TestTable");
			List<ZCRowObject> rows = tab.getAllRows();
			for(int i=0;i<rows.size();i++)
			{
				rowid=rows.get(i).get(TABLENAME,"ROWID").toString();
				rowIdList.add(Long.parseLong(rowid));
			}
			tab.deleteRows(rowIdList);
			rowIdList.clear();
			rows.clear();
			tab = obj.getTable("FKTable");
			rows = tab.getAllRows();
			for(int i=0;i<rows.size();i++)
			{
				rowid=rows.get(i).get(TABLENAME2,"ROWID").toString();
				rowIdList.add(Long.parseLong(rowid));
			}
			tab.deleteRows(rowIdList);
			rowIdList.clear();
			rows.clear();
			tab = obj.getTable("Datastore_Table");
			rows = tab.getAllRows();
			for(int i=0;i<rows.size();i++)
			{
				rowid=rows.get(i).get("Datastore_Table","ROWID").toString();
				rowIdList.add(Long.parseLong(rowid));
			}
		}
		catch(Exception e) {

		}
	}
}
