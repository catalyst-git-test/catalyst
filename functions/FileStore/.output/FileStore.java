import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.*;
import com.zc.component.files.ZCFile;
import com.zc.component.files.ZCFileDetail;
import com.zc.component.files.ZCFolder;
import com.zc.component.users.PlatformType;
import com.zc.component.users.ZCSignUpData;
import com.zc.component.users.ZCUser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
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


public class FileStore implements CatalystAdvancedIOHandler {

	String rowid="";
	private static final Logger LOGGER = Logger.getLogger(FileStore.class.getName());
	static String GET = "GET";
	static String POST = "POST";
	long  globalFolderId=0;
	String name="";
	@Override
	public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		// TODO Auto-generated method stub
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
			case "testCase28":
			testCase28(request,response);
			break;
			case "testCase29":
			testCase29(request,response);
			break;
			case "testCase30":
			testCase30(request,response);
			break;
			case "testCase31":
			testCase31(request,response);
			break;
			case "testCase32":
			testCase32(request,response);
			break;
			case "testCase33":
			testCase33(request,response);
			break;
			default:
			testCase28(request,response);
		}
	}
	public void testCase28(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		Boolean flag=false;
		String folderName="";
		String createdBy="";
		JSONObject responseData = new JSONObject();
		try{
		if(method.equals(POST))
		{
		resetMethod();
		ZCFile fileStore = ZCFile.getInstance();
		fileStore.createFolder("Folder_Test");
		responseData.put("message", "Folder has been created !");
		response.setContentType("application/json");
		response.getWriter().write(responseData.toString());
		response.setStatus(200);
		}
		else{

			ZCFile fileStore = ZCFile.getInstance();
			List<ZCFolder> folderDetails = fileStore.getFolder();
			folderName=folderDetails.get(0).getFolderName();
			createdBy=folderDetails.get(0).getCreatedBy().getEmailId();
			if(folderName.equals("Folder_Test")&&createdBy.equals("surendhar.v+apinew1@zohotest.com"))
				{
					responseData.put("message", "Folder created successfully and the details are verified. Case passed ");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					flag=true;
					responseData.put("message", "Folder created but there is a mismatch in folder details. Case failed");
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
	public void testCase29(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		Boolean flag=false;
		String folderName="";
		String modifiedBy="";
		long folderId=0;
		JSONObject responseData = new JSONObject();
		try{
			ZCFile fileStore = ZCFile.getInstance();
			List<ZCFolder> folderDetails = fileStore.getFolder();
			folderName=folderDetails.get(0).getFolderName();
			folderId=folderDetails.get(0).getFolderId();
			ZCFolder folderUpdate = fileStore.getFolder(folderId);
			folderUpdate.setFolderName("Updated_FolderName");
			fileStore.updateFolder(folderUpdate);
			folderDetails = fileStore.getFolder();
			folderName=folderDetails.get(0).getFolderName();
			modifiedBy=folderDetails.get(0).getModifiedBy().getEmailId();
			if(folderName.equals("Updated_FolderName")&&modifiedBy.equals("surendhar.v+apinew1@zohotest.com"))
				{
					responseData.put("message", "Folder edited successfully and the details are verified. Case passed ");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
				else {
					flag=true;
					responseData.put("message", "Folder edited but there is a mismatch in folder details. Case failed");
					responseData.put("flag", flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
					responseData.clear();
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
	public void testCase30(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = request.getRequestURI();
		String method = request.getMethod();
		Boolean flag=false;
		String folderName="";
		String createdBy="";
		String fileName="";
		long folderId=0;
		long fileId=0;
		JSONObject responseData = new JSONObject();
		try{
			LOGGER.log(Level.INFO,name);
			File f = new File("catalyst-config.json");
			ZCFile fileStore = ZCFile.getInstance();
			List<ZCFolder> folderDetails = fileStore.getFolder();
			folderId=folderDetails.get(0).getFolderId();
			folderName=folderDetails.get(0).getFolderName();
			ZCFolder folder = fileStore.getFolderInstance(folderId);
			folder.uploadFile(f);
			responseData.put("message","No exception was thrown while file upload. Case passed");
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
			responseData.clear();
				}
		catch(Exception e)
		{
				if(name.contains("app"))
					{
					LOGGER.log(Level.INFO,"app user");
					if(e.toString().contains("com.zc.exception.ZCServerException. Caused by : UnAuthorized")) {
					responseData.put("message","Expected exception is thrown for app user");
					responseData.put("flag",flag);
					response.setContentType("application/json");
					response.getWriter().write(responseData.toString());
					response.setStatus(200);
				}
					else {
						LOGGER.log(Level.INFO,e.toString()+" - "+name);
						responseData.put("message",e.toString());
						flag=true;
						responseData.put("flag",flag);
						response.setContentType("application/json");
						response.getWriter().write(responseData.toString());
						response.setStatus(500);
					}
					}
				else {
					LOGGER.log(Level.INFO,e.toString()+" - "+name);
			responseData.put("message",e.toString());
			flag=true;
			responseData.put("flag",flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
			}
		}
	}
	public void testCase31(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			ZCFile fileStore = ZCFile.getInstance();
			ZCFolder folderDetails = fileStore.getFolderInstance(1926000004343741L);
			ZCFileDetail fileDetail=folderDetails.getFile(1926000004343941L);
			String fileName=fileDetail.getFileName();
			String createdBy=fileDetail.getCreatedBy().getEmailId();
			long fileSize=fileDetail.getFileSize();
			LOGGER.log(Level.INFO, Long.toString(fileSize));
			if(!(fileName.equals("Test.docx")&&createdBy.equals("surendhar.v+apinew1@zohotest.com")&&fileSize==3531L)){
			responseData.put("message","While verifying file details, expected file name - Test.docx , created by email - surendhar.v+apinew1@zohotest.com , File size - 3531 bytes . Found - "+fileName+" , "+createdBy+" and "+fileSize+" bytes");
			flag=true;
			}
			else {
				responseData.put("message","File name, created by email and file size values were fetched and verified correctly");
			}
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e)
		{
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
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(500);
			}
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
	public void testCase32(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			ZCFile fileStore = ZCFile.getInstance();
			ZCFolder folder = fileStore.getFolderInstance(1926000004343741L);
			InputStream is = folder.downloadFile(1926000004343941L);
			responseData.put("message","No exception was thrown during downloadFile . Case passed.");
			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		}
		catch(Exception e)
		{
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
						response.setContentType("application/json");
						response.getWriter().write(responseData.toString());
						response.setStatus(500);
					}
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
	public void testCase33(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		long folderId=0L;
		try {
			ZCFile fileStore = ZCFile.getInstance();
			List<ZCFolder> folderDetails = fileStore.getFolder();
			for(int itr=0;itr<folderDetails.size();itr++) {
				if(!folderDetails.get(itr).getFolderId().equals(1926000004343741L)) {
				folderId=folderDetails.get(itr).getFolderId();
				fileStore.deleteFolder(folderId);
				}
			}
			try {
			ZCFolder folderCheck = fileStore.getFolder(folderId);
			responseData.put("message", "Issue in folder deletion. No exception was thrown while trying to access a deleted folder id");
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
				if(exceptionAsString.contains("Folder not found INVALID_RESOURCE")) {
					responseData.put("message", "Folder has been deleted successfully and its deletion is verified. Case Passed ");
				}
				else {
					responseData.put("message", "Expected exception is not thrown. Expected - No such Folder with the given id exists INVALID_ID. Found - "+exceptionAsString);	
					flag=true;
				}
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
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
	public void resetMethod() {
		try {
			ZCFile fileStore = ZCFile.getInstance();
			List<ZCFolder> folderDetails = fileStore.getFolder();
			for(int itr=0;itr<folderDetails.size();itr++) {
				if(folderDetails.get(itr).getFolderId()!=1926000004343741L) {
				fileStore.deleteFolder(folderDetails.get(itr).getFolderId());
				LOGGER.log(Level.INFO,folderDetails.get(itr).getFolderId().toString());
				}
			}
		}
		catch(Exception e) {
			
		}
	}
}