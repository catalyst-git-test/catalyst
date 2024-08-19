import java.util.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.object.ZCObject;
import com.zc.component.object.ZCRowObject;
import com.zc.component.object.ZCTable;
import com.zc.component.search.ZCSearch;
import com.zc.component.search.ZCSearchDetails;

public class SearchCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(SearchCases.class.getName());
	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
	List<String> searchList1 = new ArrayList<String>();
	List<String> searchList2 = new ArrayList<String>();
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
			case "testCase39":
			testCase39(request,response);
			break;
			case "testCase40":
			testCase40(request,response);
			break;
			case "testCase41":
			testCase41(request,response);
			break;
			case "testCase42":
			testCase42(request,response);
			break;
			case "testCase43":
			testCase43(request,response);
			break;
			case "testCase88":
			testCase88(request,response);
			break;
			case "testCase89":
				testCase89(request,response);
				break;
			case "testCase90":
				testCase90(request,response);
				break;
//			case "testCase6":
//			testCase6(request,response);
//			break;
//			case "testCase7":
//			testCase7(request,response);
//			break;
			default:
			testCase39(request,response);
	}
	}
	public void testCase39(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("999999999999999");
			searchList1.add("bigintVal");
			searchList2.add("var");
			map.put("SearchNew", searchList1);
			map.put("Search2New", searchList2);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=2) {
				flag=true;
				responseData.put("message", "Expected - 2 search result. Found - "+rowList.size()+" . Expected search result not obtained for bigint and varchar search using two different Tables");
			}
			else {
				responseData.put("message", "Expected search result obtained for bigint and varchar search using two different Tables");
			}
			responseData.put("flag",flag);
			searchList1.clear();
			searchList2.clear();
			map.clear();
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
	public void testCase40(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("2021-07-30 2021-07-17 02:02:13");
			searchList1.add("dateTimeVal");
			searchList2.add("dateVal2");
			map.put("SearchNew", searchList1);
			map.put("Search2New", searchList2);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=2) {
				flag=true;
				responseData.put("message", "Expected - 2 search result. Found - "+rowList.size()+" . Expected search result not obtained for date and datetime search using two different Tables");
			}
			else {
				responseData.put("message", "Expected search result obtained for date and datetime search using two different Tables");
			}
			responseData.put("flag",flag);
			searchList1.clear();
			searchList2.clear();
			map.clear();
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
	public void testCase41(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("false");
			searchList1.add("boolVal");
			searchList2.add("bool");
			map.put("SearchNew", searchList1);
			map.put("Search2New", searchList2);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=2) {
				flag=true;
				responseData.put("message", "Expected - 2 search result. Found - "+rowList.size()+" . Expected search result not obtained for boolean and varchar search using two different Tables");
			}
			else {
				responseData.put("message", "Expected search result obtained for boolean and varchar search using two different Tables");
			}
			responseData.put("flag",flag);
			searchList1.clear();
			searchList2.clear();
			map.clear();
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
	public void testCase42(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("999999999");
			searchList1.add("doubleVal");
			map.put("SearchNew", searchList1);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()==1) {
				flag=true;
				responseData.put("message", "Expected - 0 search result. Found - "+rowList.size()+" . Search is happening for column which is not indexed");
			}
			else {
				responseData.put("message", "Case Passed. No rows returned for non-search indexed column");
			}
			responseData.put("flag",flag);
			searchList1.clear();
			searchList2.clear();
			map.clear();
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
	public void testCase43(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("abcd");
			searchList1.add("wqwq");
			map.put("SearchNew", searchList1);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			responseData.put("message","No exception is thrown for invalid column. Case Failed");
			searchList1.clear();
			searchList2.clear();
			map.clear();
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			if(exceptionAsString.contains("com.zc.exception.ZCServerException. Caused by : Invalid column name wqwq INVALID_INPUT")) {
				responseData.put("message","Invalid column name exception is thrown correctly. Case Passed");
				responseData.put("flag",flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			}else {
			responseData.put("message",e.toString()+" Expected exception is not thrown.");
			responseData.put("value","exception");
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);}
		}
	}
	public void testCase88(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String value="";
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("abc*");
			searchList1.add("varNew");
			map.put("SearchNew", searchList1);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=1) {
				value+="Expected rowlist size not obtained for *. searched word - abc* , searched column -  varNew<br>";
				flag=true;
			}
			else {
				value+="Expected rowlist size obtained for *. searched word - abc* , searched column -  varNew<br>";
			}
			searchList1.clear();
			searchList2.clear();
			map.clear();
			responseData.put("flag",flag);
			responseData.put("message",value);
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
	public void testCase89(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String value="";
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("100");
			searchList1.add("intVal");
			map.put("SearchNew", searchList1);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=1) {
				value+="Expected rowlist size not obtained for int search. searched word - 100 , searched column -  intVal";
				flag=true;
			}
			else {
				value+="Expected rowlist size obtained for int search. searched word - 100 , searched column -  intVal";
			}
			searchList1.clear();
			searchList2.clear();
			map.clear();
			responseData.put("flag",flag);
			responseData.put("message",value);
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
	public void testCase90(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Boolean flag=false;
		JSONObject responseData = new JSONObject();
		String value="";
		try {
			ZCSearchDetails search = ZCSearchDetails.getInstance();
			search.setSearch("1926000007668635");
			searchList1.add("FKval");
			map.put("SearchNew", searchList1);
			search.setSearchTableColumns(map);
			ArrayList<ZCRowObject> rowList = ZCSearch.getInstance().executeSearchQuery(search);
			if(rowList.size()!=1) {
				value+="Expected rowlist size not obtained for ForeignKey search. searched word - 1926000007668635 , searched column -  FKval";
				flag=true;
			}
			else {
				value+="Expected rowlist size obtained for ForeignKey search. searched word - 1926000007668635 , searched column -  FKval";
			}
			searchList1.clear();
			searchList2.clear();
			map.clear();
			responseData.put("flag",flag);
			responseData.put("message",value);
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
}
		