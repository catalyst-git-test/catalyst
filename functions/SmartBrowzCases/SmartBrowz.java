import java.util.logging.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zc.component.files.ZCFile;
import com.zc.component.files.ZCFolder;
import com.zc.component.smartbrowz.ZCSmartBrowz;
import com.zc.component.smartbrowz.ZCSmartBrowzConvertDetails;

public class SmartBrowz implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(SmartBrowz.class.getName());
	static String GET = "GET";
	static String POST = "POST";
	static ZCFolder folderDetails;

	@Override
	public void runner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String param = "";
		String name = "";
		String[] params = {};
		String queryString = request.getQueryString();

		if (queryString != null) {
			LOGGER.log(Level.INFO, queryString);
			jsonObject = (JSONObject) JSONValue.parse(queryString);
			params = queryString.split("&");
			if (params[0].startsWith("n")) {
				name = params[0].substring(5);
				if (params[1] != null)
					param = params[1].substring(5);
			} else {
				param = params[0].substring(5);
				if (params[1] != null) {
					name = params[1].substring(5);
				}
			}
		} else {
			jsonObject = (JSONObject) JSONValue.parse(request.getReader().readLine());
			param = (String) jsonObject.get("case");
			name = (String) jsonObject.get("name");
		}

		ZCFile fileStore = ZCFile.getInstance();
		if (fileStore.getFolder().size() == 0)
			fileStore.createFolder("SmartBrowz");
		long folderID = fileStore.getFolder().get(0).getFolderId();
		folderDetails = fileStore.getFolderInstance(folderID);

		switch (param) {
			case "testCase108":
				testCase108(request, response, name);
				break;
			case "testCase109":
				testCase109(request, response, name);
				break;
			case "testCase110":
				testCase110(request, response, name);
				break;
			default:
				testCase108(request, response, name);
		}
	}

	// Generate Visual Document From a Predefined Template
	public void testCase108(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		boolean flag = false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSmartBrowz smartBrowz = ZCSmartBrowz.getInstance();
			ZCSmartBrowzConvertDetails convertDetailsForTemplateConversion = ZCSmartBrowzConvertDetails.getInstance();
			convertDetailsForTemplateConversion.setTemplateId(392000000010001L);
			convertDetailsForTemplateConversion.setTemplateInput(new ObjectMapper().createObjectNode());
			InputStream inputStream = smartBrowz.generateFromTemplate(convertDetailsForTemplateConversion);

			// Create new file
			String fileName = "convertDetailsForTemplateConversion.pdf";
			File file = new File(fileName);
			if (file.createNewFile())
				System.out.println("File created: " + file.getName());
			else
				System.out.println("File already exists.");

			// Write the stream in the file
			try (OutputStream outputStream = new FileOutputStream(file)) {
				byte[] bytes = new byte[4096];
				int bytesRead;
				responseData.put("File Processing", "Processing");
				while ((bytesRead = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, bytesRead);
				}
				responseData.put("File Processing", "Processed");
				inputStream.close();
				outputStream.flush();
			} catch (Exception e) {
				responseData.put("File Processing", "failed");
			}

			// Upload processed file in FileStore
			Long fileID = folderDetails.uploadFile(file).getFileId();

			// Check file existence
			if (folderDetails.getFile(fileID) == null) {
				flag = true;
				responseData.put("message",
						"File Processed. Issue in upload as a file in File Store or File not found in File Store");
			} else {
				responseData.put("message",
						"PDF is generated from the template and upload as a PDF file in File Store and verified");
				folderDetails.deleteFile(fileID);
			}

			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		} catch (Exception e) {
			if (name.contains("app") && e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for app user");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else if (e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : Order By/Group By is not supported for ENCRYPTED Column ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for order by encrypted column");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else {
				responseData.put("message", e.toString());
				flag = true;
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
		}
	}

	// Convert to PDF from HTML
	public void testCase109(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		boolean flag = false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSmartBrowz smartBrowz = ZCSmartBrowz.getInstance();
			ZCSmartBrowzConvertDetails convertFromHTMLtoPDF = ZCSmartBrowzConvertDetails.getInstance();
			convertFromHTMLtoPDF.setHtml(
					"<!DOCTYPE html><html><head><title>Page Title</title></head><body><h1>This is a Heading</h1><p>This is a paragraph.</p></body></html>");
			InputStream inputStream = smartBrowz.convertToPdf(convertFromHTMLtoPDF);

			// Create new file
			String fileName = "convertFromHTMLtoPDF.pdf";
			File file = new File(fileName);
			if (file.createNewFile())
				System.out.println("File created: " + file.getName());
			else
				System.out.println("File already exists.");

			// Write the stream in the file
			try (OutputStream outputStream = new FileOutputStream(file)) {
				byte[] bytes = new byte[4096];
				int bytesRead;
				responseData.put("File Processing", "Processing");
				while ((bytesRead = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, bytesRead);
				}
				responseData.put("File Processing", "Processed");
				inputStream.close();
				outputStream.flush();
			} catch (Exception e) {
				responseData.put("File Processing", "failed");
			}

			// Upload processed file in FileStore
			Long fileID = folderDetails.uploadFile(file).getFileId();

			// Check file existence
			if (folderDetails.getFile(fileID) == null) {
				flag = true;
				responseData.put("message",
						"File Processed. Issue in upload as a file in File Store or File not found in File Store");
			} else {
				responseData.put("message",
						"Convertion of PDF from HTML is successful and upload as a PDF file in File Store and verified");
				folderDetails.deleteFile(fileID);
			}

			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		} catch (Exception e) {
			if (name.contains("app") && e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for app user");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else if (e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : Order By/Group By is not supported for ENCRYPTED Column ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for order by encrypted column");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else {
				responseData.put("message", e.toString());
				flag = true;
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
		}
	}

	// Take a screenshot from URL
	public void testCase110(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		boolean flag = false;
		JSONObject responseData = new JSONObject();
		try {
			ZCSmartBrowz smartBrowz = ZCSmartBrowz.getInstance();
			ZCSmartBrowzConvertDetails screenshotFromURL = ZCSmartBrowzConvertDetails.getInstance();
			screenshotFromURL.setUrl("https://example.com/");
			InputStream inputStream = smartBrowz.takeScreenshot(screenshotFromURL);

			// Create new file
			String fileName = "screenshotFromURL.jpeg";
			File file = new File(fileName);
			if (file.createNewFile())
				System.out.println("File created: " + file.getName());
			else
				System.out.println("File already exists.");

			// Write the stream in the file
			try (OutputStream outputStream = new FileOutputStream(file)) {
				byte[] bytes = new byte[4096];
				int bytesRead;
				responseData.put("File Processing", "Processing");
				while ((bytesRead = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, bytesRead);
				}
				responseData.put("File Processing", "Processed");
				inputStream.close();
				outputStream.flush();
			} catch (Exception e) {
				responseData.put("File Processing", "failed");
			}

			// Upload processed file in FileStore
			Long fileID = folderDetails.uploadFile(file).getFileId();

			// Check file existence
			if (folderDetails.getFile(fileID) == null) {
				flag = true;
				responseData.put("message",
						"File Processed. Issue in upload as a file in File Store or File not found in File Store");
			} else {
				responseData.put("message",
						"Screenshot taken from URL and upload as a JPEG file in FileStore and verified");
				folderDetails.deleteFile(fileID);
			}

			responseData.put("flag", flag);
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(200);
		} catch (Exception e) {
			if (name.contains("app") && e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : No privileges to perform this action. ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for app user");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else if (e.toString().contains(
					"com.zc.exception.ZCServerException. Caused by : Order By/Group By is not supported for ENCRYPTED Column ZCQL QUERY ERROR")) {
				responseData.put("message", "Expected exception is thrown for order by encrypted column");
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(200);
			} else {
				responseData.put("message", e.toString());
				flag = true;
				responseData.put("flag", flag);
				response.setContentType("application/json");
				response.getWriter().write(responseData.toString());
				response.setStatus(400);
			}
		}
	}
}