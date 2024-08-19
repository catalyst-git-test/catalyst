import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import com.zc.component.object.ZCObject;
import com.zc.component.object.ZCRowObject;
import com.zc.component.object.ZCTable;
import com.zc.component.zcql.ZCQL;

public class ZCQLCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(ZCQLCases.class.getName());
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
			case "testCase44":
			testCase44(request,response,name);
			break;
			case "testCase45":
			testCase45(request,response,name);
			break;
			case "testCase46":
			testCase46(request,response,name);
			break;
			case "testCase47":
			testCase47(request,response,name);
			break;
			case "testCase48":
			testCase48(request,response,name);
			break;
			case "testCase49":
			testCase49(request,response,name);
			break;
			case "testCase50":
			testCase50(request,response,name);
			break;
			case "testCase51":
			testCase51(request,response,name);
			break;
			case "testCase52":
			testCase52(request,response,name);
			break;
			case "testCase53":
			testCase53(request,response,name);
			break;
			case "testCase54":
			testCase54(request,response,name);
			break;
			case "testCase63":
			testCase63(request,response,name);
			break;
			case "testCase64":
			testCase64(request,response,name);
			break;
			case "testCase65":
			testCase65(request,response,name);
			break;
			case "testCase66":
			testCase66(request,response,name);
			break;
			case "testCase67":
			testCase67(request,response,name);
			break;
			case "testCase68":
			testCase68(request,response,name);
			break;
			case "testCase69":
			testCase69(request,response,name);
			break;
			case "testCase70":
			testCase70(request,response,name);
			break;
			case "testCase71":
			testCase71(request,response,name);
			break;
			case "testCase72":
			testCase72(request,response,name);
			break;
			case "testCase73":
			testCase73(request,response,name);
			break;
			case "testCase74":
			testCase74(request,response,name);
			break;
			case "testCase75":
			testCase75(request,response,name);
			break;
			case "testCase76":
			testCase76(request,response,name);
			break;
			case "testCase77":
			testCase77(request,response,name);
			break;
			case "testCase78":
			testCase78(request,response,name);	
			break;
			case "testCase79":
				testCase79(request,response,name);	
				break;
			case "testCase80":
				testCase80(request,response,name);	
				break;
			case "testCase81":
				testCase81(request,response,name);	
				break;
			case "testCase82":
				testCase82(request,response,name);	
				break;
			case "testCase83":
				testCase83(request,response,name);	
				break;
			case "testCase84":
				testCase84(request,response,name);	
				break;
			case "testCase85":
				testCase85(request,response,name);	
				break;
			case "testCase86":
				testCase86(request,response,name);	
				break;
			case "testCase87":
				testCase87(request,response,name);	
				break;
			case "testCase91":
				testCase91(request,response,name);	
				break;
			case "testCase92":
				testCase92(request,response,name);	
				break;
			case "testCase93":
				testCase93(request,response);	
				break;
			case "testCase94":
				testCase94(request,response);	
				break;
			case "testCase95":
				testCase95(request,response,name);	
				break;
			default:
			testCase44(request,response,name);
}
	}
	public void testCase44(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String rowid="";
		try {
			deleteRows();
			String query ="insert into "+TABLENAME+" values('qq','~!@#$%^&*()_+{}|<>?:;,./[]\\`','2021-05-01','2021-03-01 23:59:59',999999999,1.23,false,-11,1234,12,'varch')";
			LOGGER.log(Level.INFO, query);
			ZCQL.getInstance().executeQuery(query);
			query = "select * from "+TABLENAME+" limit 10";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.size()!=1) {
				responseData.put("message","Expected number of rows -1. Found -"+rowList.size()+". values of unique int - "+rowList.get(0).get("integerunique")+". "+rowList.get(1).get("integerunique"));
				flag=true;
			}
			else {
				responseData.put("message","Expected number of rows are correctly fetched using select query");
			}
//			ArrayList<Long> rowIdList = new ArrayList<>();
//			ZCObject obj = ZCObject.getInstance();
//			ZCTable tab = obj.getTable(1926000000239009L);
//			List<ZCRowObject> rows = tab.getAllRows();
//			for(int i=0;i<rows.size();i++)
//			{
//				rowid=rows.get(i).get(TABLENAME,"ROWID").toString();
//				rowIdList.add(Long.parseLong(rowid));
//			}
//			List<ZCRowObject> deletedRowList = tab.deleteRows(rowIdList);
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
		}
	public void testCase45(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			String query = "select * from "+TABLENAME+" where var = 'qq' AND mandtext LIKE '~!@#$%*' AND integerUnique>999999998";
			LOGGER.log(Level.INFO,query);
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			Thread.sleep(5000);
//			if(name.contains("app")) {
//				if(rowList.size()!=0) {
//					responseData.put("message","Expected number of rows -0. Found -"+rowList.size()+" . Query - select * from \"+TABLENAME+\" where var = 'qq' AND mandtext LIKE '~!@#$%' AND integerUnique>999999998");
//					flag=true;
//				}
//				else {
//					responseData.put("message","Expected number of rows are correctly fetched using select query with where clause");
//				}
//			}
//			else {
			if(rowList.size()!=1) {
				responseData.put("message","Expected number of rows -1. Found -"+rowList.size()+" . Query - select * from \"+TABLENAME+\" where var = 'qq' AND mandtext LIKE '~!@#$%' AND integerUnique>999999998");
				flag=true;
			}
			else {
				responseData.put("message","Expected number of rows are correctly fetched using select query with where clause");
			}
			//}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase46(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String rowid="";
		String table2="FKTable";
		try {
			String query="insert into TestTable(mandtext,integerUnique) values('dummy',100)";
			ZCQL.getInstance().executeQuery(query);
			query = "select * from "+TABLENAME+" limit 10";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			rowid=rowList.get(1).get(TABLENAME, "ROWID").toString();
			query="insert into "+table2+" (FK) values("+rowid+")";
			ZCQL.getInstance().executeQuery(query);
//			ZCRowObject row1 = ZCRowObject.getInstance();
//			row1.set("FK", rowid);
//			ZCObject.getInstance().getTableInstance(table2).insertRow(row1);
			query = "select TestTable.integerUnique, TestTable.mandtext FROM TESTTABLE INNER JOIN FKTable ON TestTable.ROWID=FKTable.FK ORDER BY FKTable.FK";
			rowList = ZCQL.getInstance().executeQuery(query);
			String mandtext = (String)rowList.get(0).get("mandtext");
			String integerUnique=(String)rowList.get(0).get("integerUnique");
			if(!(mandtext.equals("dummy")&&integerUnique.equals("100")&&rowList.size()==1)) {
				responseData.put("message", "Expected - mandtext - dummy , integerUnique - 100 , rowList size - 1 . Found - mandtext - "+mandtext+" , integerUnique - "+integerUnique+" , rowList size - "+rowList.size()+" . Query - select TestTable.integerUnique, TestTable.mandtext FROM TESTTABLE INNER JOIN FKTable ON TestTable.ROWID=FKTable.FK");
				flag=true;
			}
			else {
				responseData.put("message", "Expected result found for the INNER JOIN query");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase47(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			String query = "select TestTable.integerUnique, TestTable.mandtext FROM TESTTABLE LEFT JOIN FKTable ON TestTable.ROWID=FKTable.FK";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			
			if(rowList.size()!=2) {
				responseData.put("message","For the LEFT JOIN query 2 rows should have been returned. Found - "+rowList.size()+" rows");
				flag=true;
			}
			else {
				responseData.put("message", "Expected number of rows returned for the LEFT JOIN query");
			}
			
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
}
	public void testCase48(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			String query = "select TestTable.integerUnique, TestTable.mandtext FROM TESTTABLE LEFT JOIN FKTable ON TestTable.ROWID=FKTable.FK ORDER BY TestTable.integerUnique";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			
			if(!rowList.get(0).get("integerUnique").toString().equals("100")) {
				responseData.put("message","Expected value at the top upon ordering - 100. Found - "+rowList.get(0).get("integerUnique"));
				flag=true;
			}
			else {
				responseData.put("message", "Expected value at the top upon ordering is obtained successfully");
			}
			
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
}
	public void testCase49(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			if(name.contains("app")) {
				responseData.put("flag",flag);
				responseData.put("message","case not suitable for app user");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			ZCRowObject row = ZCRowObject.getInstance();
			for(int itr=0;itr<10;itr++) {
			row.set("mandtext","itr "+itr);
			row.set("integerUnique",itr);
			LOGGER.log(Level.INFO,"itr "+itr);
			ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
			}
			String query="select * from TestTable LIMIT 3,10";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(!(rowList.size()==10&&rowList.get(0).get("integerUnique").toString().equals("0"))){
				responseData.put("message","Expected size of result - 10 and integerUnique value at top - 0 . But found - rowList size - "+rowList.size()+" and integerUnique value at top - "+rowList.get(0).get("integerUnique")+" . Query - "+query);
				flag=true;
			}
			else {
				responseData.put("message", "Expected result size and integerUnique value at the top is obtained successfully following the usage of LIMIT clause");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase50(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String value="";
		try {
			if(name.contains("app")) {
				responseData.put("message","Case not suitable for app user.");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			String query="select MIN(integerUnique) from TestTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.get(0).get("integerUnique").toString().equals("0")) {
				value+="Expected result of MIN function is found. Query - select MIN(integerUnique) from TestTable<br>";
				//responseData.put("message","Expected result of MIN function is found. Case passed");
			}
			else {
				value+="Expected value of minimum not found. Expected - 0. Found - "+rowList.get(0).get("integerUnique")+". Query - select MIN(integerUnique) from TestTable<br>";
				//responseData.put("message","Expected value of minimum not found. Expected - 0. Found - "+rowList.get(0).get("integerUnique"));
				flag=true;
			}
			rowList.clear();
			query = "select MAX(integerUnique) from TestTable";
			rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.get(0).get("integerUnique").toString().equals("999999999")) {
				value+="Expected result of MAX function is found. Query - select MAX(integerUnique) from TestTable<br>";
			}
			else {
				value+="Expected value of maximum not found. Expected - 999999999. Found - "+rowList.get(0).get("integerUnique")+". Query - select MAX(integerUnique) from TestTable<br>";
				flag=true;
			}
			rowList.clear();
			query="select COUNT(integerUnique) from TestTable where integerUnique > 5";
			rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.get(0).get("integerUnique").toString().equals("6")) {
				value+="Expected result of COUNT function is found. Query - select COUNT(integerUnique) from TestTable where integerUnique > 5<br>";
			}
			else {
				value+="Expected value of COUNT not found. Expected - 6. Found - "+rowList.get(0).get("integerUnique")+". Query - select COUNT(integerUnique) from TestTable where integerUnique > 5<br>";
				flag=true;
			}
			rowList.clear();
			query="select SUM(integerUnique) from TestTable where integerUnique < 100";
			rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.get(0).get("integerUnique").toString().equals("45")) {
				value+="Expected result of SUM function is found. Query - select SUM(integerUnique) from TestTable where integerUnique < 100<br>";
			}
			else {
				value+="Expected value of SUM not found. Expected - 45. Found - "+rowList.get(0).get("integerUnique")+". Query - select SUM(integerUnique) from TestTable where integerUnique < 100<br>";
				flag=true;
			}
			rowList.clear();
			query="select AVG(integerUnique) from TestTable";
			rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.get(0).get("integerUnique").toString().equals("83333345.3333")) {
				value+="Expected result of AVG function is found. Query - select AVG(integerUnique) from TestTable<br>";
			}
			else {
				value+="Expected value of AVG not found. Expected - 83333345.3333. Found - "+rowList.get(0).get("integerUnique")+". Query - select AVG(integerUnique) from TestTable<br>";
				flag=true;
			}
			ZCRowObject row = ZCRowObject.getInstance();
			row.set("mandtext","dummy");
			row.set("integerUnique",111);
			ZCObject.getInstance().getTableInstance(TABLENAME).insertRow(row);
			rowList.clear();
			query="select DISTINCT(mandtext) from TestTable";
			rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.size()!=12) {
				value+="Expected value of DISTINCT not found. Expected - 12 rows. Found - "+rowList.size()+" rows. Query - select DISTINCT(mandtext) from TestTable<br>";
				flag=true;
			}
			else {
				value+="Expected result of DISTINCT function is found. Query - select DISTINCT(mandtext) from TestTable<br>";
			}
			deleteRows();
			responseData.put("message", value);
			responseData.put("flag",flag);
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
	public void testCase51(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			deleteRows();
			String query="insert into TestTable(mandtext,integerUnique) values('zcql',34)";
			ZCQL.getInstance().executeQuery(query);
			query="select * from TestTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(!(rowList.size()==1&&rowList.get(0).get("mandtext").toString().equals("zcql")&&rowList.get(0).get("integerUnique").toString().equals("34"))){
				LOGGER.log(Level.INFO,rowList.size()+" size");
				responseData.put("message","Expected size of result - 1, mandtext value - zcql and integerUnique value at top - 34 . But found - rowList size - "+rowList.size()+" , mandText - "+rowList.get(0).get("mandText").toString()+" and integerUnique value at top - "+rowList.get(0).get("integerUnique")+" . Query - insert into TestTable(mandtext,integerUnique) values('zcql',34)");
				flag=true;
			}
			else {
				responseData.put("message", "Expected result size, mandtext and integerUnique value at the top is obtained successfully following the usage of INSERT statement");
			}
			deleteRows();
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase52(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			if(name.contains("app")) {
				responseData.put("flag",flag);
				responseData.put("message","case not suitable for app user");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			String query="insert into TestTable('var1','~!@#','2021-01-06','2021-11-10 20:50:03',012,9898,'false',1234567890,'*&',90,'varch')";
			ZCQL.getInstance().executeQuery(query);
			query="select * from TestTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(!(rowList.size()==1&&rowList.get(0).get("mandtext").toString().equals("~!@#")&&rowList.get(0).get("integerUnique").toString().equals("12")&&rowList.get(0).get("var").toString().equals("var1")&&rowList.get(0).get("doubleVal").toString().equals("9898.0")&&rowList.get(0).get("boolVal").toString().equals("false")&&rowList.get(0).get("bigintVal").toString().equals("1234567890")&&rowList.get(0).get("encVal").toString().equals("*&")&&rowList.get(0).get("search").toString().equals("90")&&rowList.get(0).get("defaultDateVal").toString().equals("2021-01-06")&&rowList.get(0).get("dateTime").toString().equals("2021-11-10 20:50:03"))){
				responseData.put("message","Expected values are not obtained for the insert query ");
				flag=true;
			}
			else {
				responseData.put("message", "Expected values are obtained for the INSERT statement");
			}
			//deleteRows();
			responseData.put("flag",flag);
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase53(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			if(name.contains("app")) {
				responseData.put("flag",flag);
				responseData.put("message","case not suitable for app user");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			String query="update TestTable set var='var2' where dateTime='2021-11-10 20:50:03'";
			ZCQL.getInstance().executeQuery(query);
			query="select * from TestTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(!(rowList.size()==1&&rowList.get(0).get("var").toString().equals("var2"))) {
				responseData.put("message","Expected values are not obtained after the update query ");
				flag=true;
			}
			else {
				responseData.put("message", "Expected values are obtained for the update query");
			}
			//deleteRows();
			responseData.put("flag",flag);
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase54(HttpServletRequest request, HttpServletResponse response,String name) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			if(name.contains("app")) {
				responseData.put("flag",flag);
				responseData.put("message","case not suitable for app user");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			String query="delete from TestTable where bigintVal = 1234567890";
			ZCQL.getInstance().executeQuery(query);
			query="select * from TestTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.size()!=0) {
				responseData.put("message","Row is not deleted after executing delete query. query - delete from TestTable where bigintVal = 1234567890");
				flag=true;
			}
			else {
				responseData.put("message", "Delete query execution is successful");
			}
			deleteRows();
			responseData.put("flag",flag);
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
			responseData.put("message",e.toString());
			responseData.put("value", "exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void deleteRows() {
		String query="";
		try {
		query="delete from TestTable";
		ZCQL.getInstance().executeQuery(query);
		query="delete from FKTable";
		ZCQL.getInstance().executeQuery(query);
	}
		catch(Exception e) {

		}
}
	public void testCase63(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			query="Select * from SelectTable";
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.size()!=1) {
				message+="Expected count of rows - 1. Found - "+rowList.size();
				flag=true;
			}
			else {
				message+="pass";
			}
			message+=queryExecute("txt","text with space","Select txt from SelectTable");
			message+=queryExecute("var","varchar","Select var from SelectTable");
			message+=queryExecute("bg","9876543210","Select bg from SelectTable");
			message+=queryExecute("inn","12","Select inn from SelectTable");			
			message+=queryExecute("dob","123456.9876","Select dob from SelectTable");
			message+=queryExecute("dat","2022-06-19","Select dat from SelectTable");
			message+=queryExecute("dattm","2022-06-01 23:00:59","Select dattm from SelectTable");
			message+=queryExecute("et","encrypted check","Select et from SelectTable");
			message+=queryExecute("boo","true","Select boo from SelectTable");
			message+=queryExecute("fkey","1926000004346689","Select fkey from SelectTable");
			if(message.length()!=44) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected values were obtained for all individual select queries");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase64(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			message+=returnCount("Select count(txt) from SelectTable","1","txt");
			message+=returnCount("Select count(var) from SelectTable","1","var");
			message+=returnCount("Select count(bg) from SelectTable","1","bg");
			message+=returnCount("Select count(inn) from SelectTable","1","inn");
			message+=returnCount("Select count(dob) from SelectTable","1","dob");
			message+=returnCount("Select count(dat) from SelectTable","1","dat");
			message+=returnCount("Select count(dattm) from SelectTable","1","dattm");
			message+=returnCount("Select count(et) from SelectTable","1","et");
			message+=returnCount("Select count(boo) from SelectTable","1","boo");
			message+=returnCount("Select count(fkey) from SelectTable","1","fkey");
			if(message.length()!=40) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected count were obtained for all individual select queries with count");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase65(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			query="Insert into SelectTable('011','09999','9999999999','876','098754.1234','2022-06-16','2022-07-11 10:59:31','0123','false','1926000004346689')";
			ZCQL.getInstance().executeQuery(query);
			
			message+=queryExecute("txt","11.0","Select sum(txt) from SelectTable");
			message+=queryExecute("var","9999.0","Select sum(var) from SelectTable");
			message+=queryExecute("bg","19876543209","Select sum(bg) from SelectTable");
			message+=queryExecute("inn","888","Select sum(inn) from SelectTable");			
			message+=queryExecute("dob","222211.111","Select sum(dob) from SelectTable");
			message+=queryExecute("dat","2074-12-01","Select sum(dat) from SelectTable");
			message+=queryExecute("dattm","2074-12-10 04:30:30","Select sum(dattm) from SelectTable");
			message+=queryExecute("et","0.0","Select sum(et) from SelectTable");
			message+=queryExecute("boo","true","Select sum(boo) from SelectTable");
			message+=queryExecute("fkey","3852000008693378","Select sum(fkey) from SelectTable");
			if(message.length()!=40) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected values were obtained for all individual select queries with sum function");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase66(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			query="Insert into SelectTable('011','09999','9999999999','876','098754.1234','2022-06-16','2022-07-11 10:59:31','0123','false','1926000004346689')";
			ZCQL.getInstance().executeQuery(query);
			
			message+=queryExecute("txt","text with space","Select max(txt) from SelectTable");
			message+=queryExecute("var","varchar","Select max(var) from SelectTable");
			message+=queryExecute("bg","9999999999","Select max(bg) from SelectTable");
			message+=queryExecute("inn","876","Select max(inn) from SelectTable");			
			message+=queryExecute("dob","123456.9876","Select max(dob) from SelectTable");
			message+=queryExecute("dat","2022-06-19","Select max(dat) from SelectTable");
			message+=queryExecute("dattm","2022-07-11 10:59:31","Select max(dattm) from SelectTable");
			message+=queryExecute("et","encrypted check","Select max(et) from SelectTable");
			message+=queryExecute("boo","true","Select max(boo) from SelectTable");
			message+=queryExecute("fkey","1926000004346689","Select max(fkey) from SelectTable");
			if(message.length()!=40) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected values were obtained for all individual select queries with max function");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase67(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			query="Insert into SelectTable('011','09999','9999999999','876','098754.1234','2022-06-16','2022-07-11 10:59:31','0123','false','1926000004346689')";
			ZCQL.getInstance().executeQuery(query);
			
			message+=queryExecute("txt","011","Select min(txt) from SelectTable");
			message+=queryExecute("var","09999","Select min(var) from SelectTable");
			message+=queryExecute("bg","9876543210","Select min(bg) from SelectTable");
			message+=queryExecute("inn","12","Select min(inn) from SelectTable");			
			message+=queryExecute("dob","98754.1234","Select min(dob) from SelectTable");
			message+=queryExecute("dat","2022-06-16","Select min(dat) from SelectTable");
			message+=queryExecute("dattm","2022-06-01 23:00:59","Select min(dattm) from SelectTable");
			message+=queryExecute("et","0123","Select min(et) from SelectTable");
			message+=queryExecute("boo","false","Select min(boo) from SelectTable");
			message+=queryExecute("fkey","1926000004346689","Select min(fkey) from SelectTable");
			if(message.length()!=40) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected values were obtained for all individual select queries with min function");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
	public void testCase68(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String message="";
		try {
			String query = "Delete from SelectTable where txt != 'text with space'";
			ZCQL.getInstance().executeQuery(query);
			query="Delete from SelectTable where txt is null";
			ZCQL.getInstance().executeQuery(query);
			query="Insert into SelectTable('check','Varchar','9999999999','12','0123456.9876','2022-06-19','2022-06-01 10:59:31','enc','true','1926000004346689')";
			ZCQL.getInstance().executeQuery(query);
			
			message+=returnRowListSize("Select distinct(txt) from SelectTable","2","txt");
			message+=returnRowListSize("Select distinct(var) from SelectTable","1","var");
			message+=returnRowListSize("Select distinct(bg) from SelectTable","2","bg");
			message+=returnRowListSize("Select distinct(inn) from SelectTable","1","inn");			
			message+=returnRowListSize("Select distinct(dob) from SelectTable","1","dob");
			message+=returnRowListSize("Select distinct(dat) from SelectTable","1","dat");
			message+=returnRowListSize("Select distinct(dattm) from SelectTable","2","dattm");
			message+=returnRowListSize("Select distinct(et) from SelectTable","2","et");
			message+=returnRowListSize("Select distinct(boo) from SelectTable","1","boo");
			message+=returnRowListSize("Select distinct(fkey) from SelectTable","1","fkey");
			if(message.length()!=40) {
				responseData.put("message", message);
				flag=true;
			}
			else {
				responseData.put("message", "Expected values were obtained for all individual select queries with distinct(colname) function");
			}
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase69(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable('check','Varchar','9999999999','12','0123456.9876','2022-06-19','2022-06-01 10:59:31','enc','true','1926000004346689')";
				ZCQL.getInstance().executeQuery(query);				
				message+=returnRowListSize("Select distinct txt from SelectTable","2","txt");
				message+=returnRowListSize("Select distinct var from SelectTable","1","var");
				message+=returnRowListSize("Select distinct bg from SelectTable","2","bg");
				message+=returnRowListSize("Select distinct inn from SelectTable","1","inn");			
				message+=returnRowListSize("Select distinct dob from SelectTable","1","dob");
				message+=returnRowListSize("Select distinct dat from SelectTable","1","dat");
				message+=returnRowListSize("Select distinct dattm from SelectTable","2","dattm");
				message+=returnRowListSize("Select distinct et from SelectTable","2","et");
				message+=returnRowListSize("Select distinct boo from SelectTable","1","boo");
				message+=returnRowListSize("Select distinct fkey from SelectTable","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with distinct colname function");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase70(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt='text with space'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var='varchar'","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg=9876543210","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn=12","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob=123456.9876","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat='2022-06-19'","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm='2022-06-01 23:00:59'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et='encrypted check'","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo=true","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey=1926000004346689","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and equals operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase71(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable(null,null,null,null,null,null,null,null,null,null)";
				ZCQL.getInstance().executeQuery(query);				
				message+=returnRowListSize("Select * from SelectTable where txt is null","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var is null","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg is null","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn is null","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob is null","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat is null","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm is null","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et is null","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo is null","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey is null","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'is null' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase72(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable(null,null,null,null,null,null,null,null,null,null)";
				ZCQL.getInstance().executeQuery(query);				
				message+=returnRowListSize("Select * from SelectTable where txt is not null","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var is not null","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg is not null","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn is not null","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob is not null","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat is not null","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm is not null","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et is not null","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo is not null","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey is not null","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'is not null' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase73(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt != 'Text with space'","0","txt");
				message+=returnRowListSize("Select * from SelectTable where var != 'Varchar'","0","var");
				message+=returnRowListSize("Select * from SelectTable where bg != 987654321","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn != 12","0","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob != 123456.9876","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat != '2022-06-19'","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm != '2022-06-01 23:00:58'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et != 'encrypted'","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo != false","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey != 1926000000533387","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '!=' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase74(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt <> 'Text'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var <> 'varchar'","0","var");
				message+=returnRowListSize("Select * from SelectTable where bg <> 987","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn <> 1","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob <> 123456.9876","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat <> '2022-06-19'","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm <> '2022-06-01 23:00:59'","0","dattm");
				message+=returnRowListSize("Select * from SelectTable where et <> 'encrypted'","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo <> false","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey <> 1926000000533387","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '<>' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase75(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt like 'text with space'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var like 'varchar'","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg like 9876543210","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn like 12","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob like 123456.9876","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat like '2022-06-19'","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm like '2022-06-01 23:00:59'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et like 'encrypted check'","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo like true","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey like 1926000004346689","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'like' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase76(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);		
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt not like 'text with space'","0","txt");
				message+=returnRowListSize("Select * from SelectTable where var not like 'varchar'","0","var");
				message+=returnRowListSize("Select * from SelectTable where bg not like 9876543210","0","bg");
				message+=returnRowListSize("Select * from SelectTable where inn not like 12","0","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob not like 123456.9876","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat not like '2022-06-19'","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm not like '2022-06-01 23:00:59'","0","dattm");
				message+=returnRowListSize("Select * from SelectTable where et not like 'encrypted check'","0","et");
				message+=returnRowListSize("Select * from SelectTable where boo not like true","0","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey not like 1926000004346689","0","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'not like' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase77(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt in ('text with space','zzzqq')","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var in ('var','wq')","0","var");
				message+=returnRowListSize("Select * from SelectTable where bg in ('12345','987654321')","0","bg");
				message+=returnRowListSize("Select * from SelectTable where inn in (12,10,0)","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob in (123456.987)","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat in ('2022-06-19','2022-06-19')","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm in ('2022-06-01 23:00:59','2022-06-01 23:00:50')","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et in ('encrypted','qwqw')","0","et");
				message+=returnRowListSize("Select * from SelectTable where boo in ('false','false')","0","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey in 1926000004346689","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'in' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase78(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt not in ('text with space','zzzqq')","0","txt");
				message+=returnRowListSize("Select * from SelectTable where var not in ('var','wq')","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg not in ('12345','987654321')","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn not in (12,10,0)","0","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob not in (123456.987)","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat not in ('2022-06-19','2022-06-19')","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm not in ('2022-06-01 23:00:59','2022-06-01 23:00:50')","0","dattm");
				message+=returnRowListSize("Select * from SelectTable where et not in ('encrypted','qwqw')","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo not in ('false','false')","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey not in 1926000004346689","0","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and 'not in' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase79(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);		
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt > 'text'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var > 'varcha'","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg > 9876543209","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn > 11","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob > 123456.9877","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat > '2022-06-19'","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm > '2022-06-01 23:00:58'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where boo > false","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey > 1926000000533387","1","fkey");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '>' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase80(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt >= 'text with space'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var >= 'varchar'","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg >= 9876543211","0","bg");
				message+=returnRowListSize("Select * from SelectTable where inn >= 12","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob >= 123456.9870","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat >= '2022-06-19'","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm >= '2022-06-01 23:01:00'","0","dattm");
				message+=returnRowListSize("Select * from SelectTable where boo >= true","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey >= 1926000000533387","1","fkey");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '>=' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase81(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt < 'text with space '","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var < 'varchas'","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg < 9876543210","0","bg");
				message+=returnRowListSize("Select * from SelectTable where inn < 12","0","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob < 123456.9877","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat < '2022-06-19'","0","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm < '2022-06-01 23:01:00'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where boo < true","0","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey < 1926000004346690","1","fkey");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '<' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase82(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);		
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt <= 'text with space'","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var <= 'varchaq'","0","var");
				message+=returnRowListSize("Select * from SelectTable where bg <= 9876543210","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn <= 11","0","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob <= 123456.9875","0","dob");
				message+=returnRowListSize("Select * from SelectTable where dat <= '2022-06-19'","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm <= '2022-06-01 23:01:00'","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where boo <= true","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey <= 1926000004346689","1","fkey");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and '<=' operator");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase83(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);		
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				message+=returnRowListSize("Select * from SelectTable where txt='text with space' limit 1,1","1","txt");
				message+=returnRowListSize("Select * from SelectTable where var='varchar' limit 1,1","1","var");
				message+=returnRowListSize("Select * from SelectTable where bg=9876543210 limit 1,1","1","bg");
				message+=returnRowListSize("Select * from SelectTable where inn=12 limit 1,1","1","inn");			
				message+=returnRowListSize("Select * from SelectTable where dob=123456.9876 limit 1,1","1","dob");
				message+=returnRowListSize("Select * from SelectTable where dat='2022-06-19 limit 1,1'","1","dat");
				message+=returnRowListSize("Select * from SelectTable where dattm='2022-06-01 23:00:59' limit 1,1","1","dattm");
				message+=returnRowListSize("Select * from SelectTable where et='encrypted check' limit 1,1","1","et");
				message+=returnRowListSize("Select * from SelectTable where boo=true limit 1,1","1","boo");
				message+=returnRowListSize("Select * from SelectTable where fkey=1926000004346689 limit 1,1","1","fkey");
				if(message.length()!=40) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with where clause and equals operator and limit 1");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase84(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable('check','Varchar','9999999999','13','9999.9999','2022-07-18','2022-06-01 10:59:31','enc','false','1926000004346689')";
				ZCQL.getInstance().executeQuery(query);
				Thread.sleep(3000);
				message+=queryExecute("txt","check","Select * from SelectTable where txt!='qwqw' ORDER BY txt limit 1,1");
				message+=queryExecute("var","varchar","Select * from SelectTable where txt!='qwqw' ORDER BY var limit 1,1");
				message+=queryExecute("bg","9876543210","Select * from SelectTable where txt!='qwqw' ORDER BY bg limit 1,1");
				message+=queryExecute("inn","12","Select * from SelectTable where txt!='qwqw' ORDER BY inn limit 1,1");
				message+=queryExecute("dob","9999.9999","Select * from SelectTable where txt!='qwqw' ORDER BY dob limit 1,1");
				message+=queryExecute("dat","2022-06-19","Select * from SelectTable where txt!='qwqw' ORDER BY dat limit 1,1");
				message+=queryExecute("dattm","2022-06-01 10:59:31","Select * from SelectTable where txt!='qwqw' ORDER BY dattm limit 1,1");
				message+=queryExecute("boo","false","Select * from SelectTable where txt!='qwqw' ORDER BY boo limit 1,1");
				message+=queryExecute("fkey","1926000004346689","Select * from SelectTable where txt!='qwqw' ORDER BY fkey limit 1,1");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with ORDER BY ");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase85(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable('check','Varchar','9999999999','13','9999.9999','2022-07-18','2022-06-01 10:59:31','enc','false','1926000004346689')";
				ZCQL.getInstance().executeQuery(query);
				Thread.sleep(3000);
				message+=queryExecute("txt","check","Select * from SelectTable where txt!='qwqw' ORDER BY txt ASC limit 1,1");
				message+=queryExecute("var","varchar","Select * from SelectTable where txt!='qwqw' ORDER BY var ASC limit 1,1");
				message+=queryExecute("bg","9876543210","Select * from SelectTable where txt!='qwqw' ORDER BY bg ASC limit 1,1");
				message+=queryExecute("inn","12","Select * from SelectTable where txt!='qwqw' ORDER BY inn ASC limit 1,1");
				message+=queryExecute("dob","9999.9999","Select * from SelectTable where txt!='qwqw' ORDER BY dob ASC limit 1,1");
				message+=queryExecute("dat","2022-06-19","Select * from SelectTable where txt!='qwqw' ORDER BY dat ASC limit 1,1");
				message+=queryExecute("dattm","2022-06-01 10:59:31","Select * from SelectTable where txt!='qwqw' ORDER BY dattm ASC limit 1,1");
				message+=queryExecute("boo","false","Select * from SelectTable where txt!='qwqw' ORDER BY boo ASC limit 1,1");
				message+=queryExecute("fkey","1926000004346689","Select * from SelectTable where txt!='qwqw' ORDER BY fkey ASC limit 1,1");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with ORDER BY ASC");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase86(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);	
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable('check','Varchar','9999999999','13','9999.9999','2022-07-18','2022-06-01 10:59:31','enc','true','1926000004346689')";
				ZCQL.getInstance().executeQuery(query);
				Thread.sleep(3000);
				message+=queryExecute("txt","text with space","Select * from SelectTable where txt!='qwqw' ORDER BY txt DESC limit 1,1");
				message+=queryExecute("var","varchar","Select * from SelectTable where txt!='qwqw' ORDER BY var DESC limit 1,1");
				message+=queryExecute("bg","9999999999","Select * from SelectTable where txt!='qwqw' ORDER BY bg DESC limit 1,1");
				message+=queryExecute("inn","13","Select * from SelectTable where txt!='qwqw' ORDER BY inn DESC limit 1,1");
				message+=queryExecute("dob","123456.9876","Select * from SelectTable where txt!='qwqw' ORDER BY dob DESC limit 1,1");
				message+=queryExecute("dat","2022-07-18","Select * from SelectTable where txt!='qwqw' ORDER BY dat DESC limit 1,1");
				message+=queryExecute("dattm","2022-06-01 23:00:59","Select * from SelectTable where txt!='qwqw' ORDER BY dattm DESC limit 1,1");
				message+=queryExecute("boo","true","Select * from SelectTable where txt!='qwqw' ORDER BY boo DESC limit 1,1");
				message+=queryExecute("fkey","1926000004346689","Select * from SelectTable where txt!='qwqw' ORDER BY fkey DESC limit 1,1");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with ORDER BY DESC");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase87(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query = "Delete from SelectTable where txt != 'text with space'";
				ZCQL.getInstance().executeQuery(query);
				query="Delete from SelectTable where txt is null";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into SelectTable('check','varchar','9876543210','12','123456.9876','2022-06-19','2022-06-01 23:00:59','encrypted check','true','1926000004346689')";
				ZCQL.getInstance().executeQuery(query);
				Thread.sleep(3000);
				message+=returnRowListSize("select * from selectTable where var!='qw' group by txt order by txt","2","txt");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by var order by var","1","var");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by bg order by bg","1","bg");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by inn order by inn","1","inn");			
				message+=returnRowListSize("select * from selectTable where var!='qw' group by dob order by dob","1","dob");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by dat order by dat","1","dat");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by dattm order by dattm","1","dattm");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by boo order by boo","1","boo");
				message+=returnRowListSize("select * from selectTable where var!='qw' group by fkey order by fkey","1","fkey");
				if(message.length()!=36) {
					responseData.put("message", message);
					flag=true;
				}
				else {
					responseData.put("message", "Expected values were obtained for all individual select queries with GROUP BY");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		
		public void testCase91(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query="Delete from MoreRows";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into morerows(intt) values(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(99)";
				ZCQL.getInstance().executeQuery(query);
				responseData.put("message", "No exception was thrown when we try to insert more than 300 rows");
				flag=true;
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
				responseData.put("message","Expected exception is thrown for app user");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else if(e.toString().equalsIgnoreCase("com.zc.exception.ZCServerException. Caused by : ZCQL CANNOT HAVE MORE THAN 300 ROWS IN LIMIT ZCQL QUERY ERROR")) {
				responseData.put("message", "expected exception was thrown for more than 300 rows");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			else {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			responseData.put("message",e.toString());
			flag=true;
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(400);
		}
		}
	}	
		public void testCase92(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query="Delete from MoreRows";
				ZCQL.getInstance().executeQuery(query);
				query="Insert into morerows(intt) values(1),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(10),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(1),(99)";
				ZCQL.getInstance().executeQuery(query);
				query="select count(intt) from morerows";
				ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
				if(!rowList.get(0).get("intt").toString().equals("300")) {
					flag=true;
					responseData.put("message", "Expected no. of rows - 300. Found - "+rowList.get(0).get("intt"));
				}
				else {
					responseData.put("message", "Expected number of rows - 300 present.");
				}
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
		catch(Exception e) {
			if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
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
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	}
		public void testCase93(HttpServletRequest request, HttpServletResponse response) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query="select enc1,enc2,enc3,enc4,enc5,enc6,enc7,enc8,enc9,enc10,enc11,enc12,enc13,enc14,enc15,enc16,dt1,dt2,dt3,dt4,dt5,dt6,dt7,dt8,selecttable.et,boo,fkey,text1,var1,search.intVal from maxlimit INNER JOIN SELECTTABLE ON selecttable.rowid=maxlimit.fkey LEFT JOIN SEARCH ON search.rowid=selecttable.fkey INNER JOIN SEARCH2 ON search2.rowid=search.fkval LEFT JOIN Complex ON complex.rowid = search.fkcomplex where enc1='wqwwq' and var1='qwwqqw' and enc2='qwqwqw' and enc3!='wwq' or enc4='qqw' and enc5='wqqwqw' and enc14!='qwwq' and var1 like 'qww*' and enc12 is not null and enc11 !='wwqqw' group by search.rowid order by maxlimit.dt1 limit 1,2";
				ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
				if(!rowList.get(0).get("et").toString().equals("encrypted check")) {
					flag=true;
					responseData.put("message", "Expected list size - 1. Found - "+rowList.size()+". Expected encrypted text - encrypted check. Found - "+rowList.get(0).get("selecttable.et"));
				}
				else {
					responseData.put("message", "Expected result obtained");
				}
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
			flag=true;
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(400);
		}
	}
		public void testCase94(HttpServletRequest request, HttpServletResponse response) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query="select * from jointest LEFT JOIN search ON search.rowid=jointest.fk group by jointest.fk order by jointest.fk limit 1,10";
				ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
				if(rowList.size()!=2) {
					flag=true;
					message+="Expected list size - 2. Found - "+rowList.size()+"<br>";
				}
				else {
					message+="Expected result obtained<br>";
				}
				rowList.clear();
				query="select * from jointest INNER JOIN search ON search.rowid=jointest.fk group by jointest.fk order by jointest.fk limit 1,10";
				rowList = ZCQL.getInstance().executeQuery(query);
				if(rowList.size()!=1) {
					flag=true;
					message+="Expected list size - 1. Found - "+rowList.size();
				}
				else {
					message+="Expected result obtained";
				}
				responseData.put("flag",flag);
				responseData.put("message",message);
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
			flag=true;
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(400);
		}
	}
		
		public void testCase95(HttpServletRequest request, HttpServletResponse response,String name) throws Exception{
			Boolean flag=false;
			JSONObject responseData = new JSONObject();
			String message="";
			try {
				String query="Select * from SelectTable where txt!='qwqw' ORDER BY et limit 1,1";
				ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
				flag=true;
				responseData.put("flag",flag);
				responseData.put("message","No exception was thrown when we try to order by encrypted column");
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}
			catch(Exception e) {
				if(name.contains("app")&&e.toString().contains("com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
					responseData.put("message","Expected exception is thrown for app user");
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : Order By/Group By is not supported for ENCRYPTED Column ZCQL QUERY ERROR")) {
					responseData.put("message","Expected exception is thrown for order by encrypted column");
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
				responseData.put("message",e.toString());
				flag=true;
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
			}
		}
	public String queryExecute(String fieldName, String expectedValue,String query) {
		String message="";
		try {
		ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
		if(!rowList.get(0).get(fieldName).toString().equals(expectedValue)) {
			message+="\nExpected "+fieldName+" - "+expectedValue+". Found - "+rowList.get(0).get(fieldName);
		}
		else {
			message+="pass";
		}
		return message;
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return e.toString();
		}
	}
	public String returnCount(String query,String expectedCount,String fieldName) {
		String message="";
		try {
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(!rowList.get(0).get(fieldName).toString().equals(expectedCount)) {
				message+="Expected return count for query - "+query+" is "+expectedCount+". But found - "+rowList.get(0).get(fieldName);
			}
			else {
				message+="pass";
			}
			return message;
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return e.toString();
		}
	}
	public String returnRowListSize(String query,String expectedCount,String fieldName) {
		String message="";
		try {
			ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
			if(rowList.size()!=Integer.parseInt(expectedCount)) {
				message+="Expected row list size for query - "+query+" is "+expectedCount+". But found - "+rowList.size();
			}
			else {
				message+="pass";
			}
			return message;
		}
		catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occured", e);
			return e.toString();
		}
	}
	
}
