import java.util.logging.Logger;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.component.ml.ZCAge;
import com.zc.component.ml.ZCAnalyseMode;
import com.zc.component.ml.ZCBarcodeData;
import com.zc.component.ml.ZCBarcodeFormat;
import com.zc.component.ml.ZCBarcodeOptions;
import com.zc.component.ml.ZCChequeData;
import com.zc.component.ml.ZCContent;
import com.zc.component.ml.ZCFaceAnalysisData;
import com.zc.component.ml.ZCFaceAnalyticsOptions;
import com.zc.component.ml.ZCFaceComparisonData;
import com.zc.component.ml.ZCFaceEmotion;
import com.zc.component.ml.ZCFaceLandmark;
import com.zc.component.ml.ZCFacePoints;
import com.zc.component.ml.ZCFaces;
import com.zc.component.ml.ZCFineEntitiesDetails;
import com.zc.component.ml.ZCGender;
import com.zc.component.ml.ZCImageModerateData;
import com.zc.component.ml.ZCImageModerationConfidence;
import com.zc.component.ml.ZCImageModerationOptions;
import com.zc.component.ml.ZCImageModerationPrediction;
import com.zc.component.ml.ZCKeywordExtractionData;
import com.zc.component.ml.ZCLine;
import com.zc.component.ml.ZCML;
import com.zc.component.ml.ZCOCRModelType;
import com.zc.component.ml.ZCOCROptions;
import com.zc.component.ml.ZCObjectDetectionData;
import com.zc.component.ml.ZCObjectPoints;
import com.zc.component.ml.ZCPanData;
import com.zc.component.ml.ZCParagraph;
import com.zc.component.ml.ZCSentenceAnalytics;
import com.zc.component.ml.ZCSentimentAnalysisData;
import com.zc.component.ml.ZCSentimentAnalysisDetails;
import com.zc.component.ml.ZCSentimentConfidenceScore;
import com.zc.component.ml.ZCTextAnalyticsData;
import com.zc.component.ml.ZCNERData; 
import com.zc.component.ml.ZCNERDetails;

public class ZiaCases implements CatalystAdvancedIOHandler {
	private static final Logger LOGGER = Logger.getLogger(ZiaCases.class.getName());
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
			case "testCase55":
			testCase55(request,response);
			break;
			case "testCase56":
			testCase56(request,response);
			break;
			case "testCase57":
			testCase57(request,response);
			break;
			case "testCase58":
			testCase58(request,response);
			break;
			case "testCase59":
			testCase59(request,response);
			break;
			case "testCase60":
			testCase60(request,response);
			break;
			case "testCase61":
			testCase61(request,response);
			break;
			case "testCase101":
			testCase101(request,response);
			break;
			case "testCase102":
			testCase102(request,response);
			break;
			case "testCase103":
			testCase103(request,response);
			break;
			case "testCase104":
			testCase104(request,response);
			break;
			case "testCase105":
			testCase105(request,response);
			break;
			case "testCase106":
			testCase106(request,response);
			break;
			case "testCase107":
			testCase107(request,response);
			break;
			default:
			testCase55(request,response);
	}
	}
	public void testCase55(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File file = new File("pan.jpg");
			ZCOCROptions options = ZCOCROptions.getInstance().setModelType(ZCOCRModelType.PAN);
			ZCContent ocrContent = ZCML.getInstance().getContent(file, options);
			ZCPanData  panData = ocrContent.getPanData(); 
			String  firstName = panData.getFirstName();
			String  lastName = panData.getLastName();
			String  pan = panData.getPan();
			Date  dob = panData.getDob();
			if(firstName==null||lastName==null||pan==null||dob==null){
				flag=true;
			}
			if(flag==true) {
				responseData.put("message","One of the values is returned as null for a proper pan card. Case Failed");
			}
			else {
				responseData.put("message","Values are returned for all individual elements of panData. Case passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
	public void testCase56(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File file = new File("facetest.jpeg");
			ZCFaceAnalyticsOptions options = ZCFaceAnalyticsOptions.getInstance().setAgeNeeded(true).setEmotionNeeded(true).setGenderNeeded(true).setAnalyseMode(ZCAnalyseMode.ADVANCED); 
			ZCFaceAnalysisData faceData = ZCML.getInstance().analyzeFace(file, options);
			Long facesCount = faceData.getFacesCount(); 
			List <ZCFaces> faces = faceData.getFacesList(); 
			for(ZCFaces face : faces){        
				Double faceConfidence = face.getConfidence(); 
				ZCAge age = face.getAge(); 
				ZCGender gender = face.getGender(); 
				ZCFaceEmotion emotion = face.getEmotion(); 
				ZCFacePoints facePoints = face.getCoordinates(); 
				List<ZCFaceLandmark> faceLandmarks = face.getFaceLandmarks(); 
				if(faceConfidence==null||age==null||gender==null||emotion==null||facePoints.getBelowRightCoordinates()==null||facePoints.getTopLeftCoordinates()==null) {
					flag=true;
				}
				if(flag==true) {
					responseData.put("message","One of the values in ZCFaces is returning null. Case Failed");
				}
				else {
					responseData.put("message","Face Analytics is working fine and values are returned for all individual elements. Case Passed");
				}
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
	public void testCase57(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File file = new File("mod.jpeg"); 
			ZCImageModerationOptions options = ZCImageModerationOptions.getInstance().setAnalyseMode(ZCAnalyseMode.ADVANCED); 
			ZCImageModerateData imData = ZCML.getInstance().moderateImage(file, options); 
			ZCImageModerationPrediction prediction = imData.getPrediction();
			Double predictionConfidence = imData.getConfidence();
			List<ZCImageModerationConfidence> confidences = imData.getImageModerationConfidenceList();
			if(prediction==null||predictionConfidence==null) {
				flag=true;
			}
			for(int i=0;i<confidences.size();i++) {
				if(confidences.get(i).getConfidence()==null||confidences.get(i).getType()==null) {
					flag=true;
				}
			}
			if(flag==true) {
				responseData.put("message","One of the values returned for ZCImageModerateData is null. Case Failed");
			}
			else {
				responseData.put("message","Values are returned for all elements in ZCImageModerateData. Case Passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
	public void testCase58(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File file = new File("image.jpeg"); 
			List<ZCObjectDetectionData> objects = ZCML.getInstance().detectObjects(file); 
			for(ZCObjectDetectionData object : objects){    
				String objectType = object.getObjectType(); 
				Double objConfidence = object.getConfidence(); 
				ZCObjectPoints objCoordinates = object.getObjectPoints(); 
				if(objectType==null||objConfidence==null||objCoordinates.getTopLeftCoordinates()==null||objCoordinates.getBelowRightCoordinates()==null) {
					flag=true;
				}
			}
			if(flag==true) {
				responseData.put("message","One of the attributes in detectObjects method is returning null. Case Failed");
			}
			else {
				responseData.put("message","Values are returned for all attributes in detectObjects method. Case Passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	public void testCase59(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File file = new File("barcode.png"); 
			ZCBarcodeOptions options = ZCBarcodeOptions.getInstance().setFormat(ZCBarcodeFormat.ALL); 
			ZCBarcodeData barcodeResult = ZCML.getInstance().scanBarcode(file, options);
			String content = barcodeResult.getContent(); 
			if(content==null) {
				flag=true;
				responseData.put("message","Content of barcode is returned as null. Case Failed");
			}
			else {
				responseData.put("message","Value is obtained for content of barcode. Case Passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}
	public void testCase60(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		try {
			File  sourceImage= new File("mou.jpeg");
			File  queryImage= new File("mou2.jpeg");
			ZCFaceComparisonData data = ZCML.getInstance().compareFace(sourceImage,queryImage ); 
			Double  confidence = data.getConfidence (); 
			boolean  matched= data.getMatched ();
			if(confidence==null) {
				flag=true;
				responseData.put("message","Confidence value is returned as null. Case Failed");
			}
			else {
				responseData.put("message","Value is obtained for confidence in compareFace method. Case Passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
}

	public void testCase61(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		try {
			
			File file = new File("ocr_sample.png"); 
			ZCOCROptions options = ZCOCROptions.getInstance().setModelType(ZCOCRModelType.OCR).setLanguageCode("eng,tam"); 
			ZCContent ocrContent = ZCML.getInstance().getContent(file, options); 
			List<ZCParagraph> paragraphs = ocrContent.getParagraphs();
			if(paragraphs.isEmpty()) {
				flag=true;
				message+="paragraphs is empty";
			}
			for(ZCParagraph paragraph : paragraphs){
				List<ZCLine> paraLines = paragraph.lines;    
				if(paraLines.isEmpty()) {
					flag=true;
					message+="para lines is empty";
				}
				for(ZCLine line : paraLines){      
					String[] words = line.words;        
					String text = line.text;  	
					if(words.length<=0) {
						flag=true;
						message+="words is empty. "+Arrays.toString(words);
					}
					if(text==null) {
						flag=true;
						message+="text is empty";
					}
					}    
				String text = paragraph.text; 
				if(text==null) {
					flag=true;
					message+="para text is empty";
				}
			}
			String text = ocrContent.text; 
			if(text==null) {
				flag=true;
				message+="ocr content text is empty";
			}
		if(flag==true) {
			responseData.put("message",message+". Null value is returned for one or more of the attributes of OCR. Case Failed");
		}
		else {
			responseData.put("message","Values are returned for all attributes of OCR. Case Passed");
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
		}
	public void testCase101(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		JSONObject resp=new JSONObject();
		JSONParser parser = new JSONParser();
		String expText="{\"pincode\":{\"prob\":1,\"value\":400607},\"address\":{\"prob\":1,\"value\":\"14 3rd cross road DD Nagar Mumbai Maharashtra 400607\"},\"gender\":{\"prob\":1,\"value\":\"MALE\"},\"dob\":{\"prob\":1,\"value\":\"12/11/1994\"},\"name\":{\"prob\":1,\"value\":\"Willaim Stone\"},\"aadhaar\":{\"prob\":1,\"value\":\"123465789100\"}}";
		try {
			File file = new File("AadhaarFront.png"); 
			File file2 = new File("AadhaarBack.png"); 
			String languageCode = "eng,tam"; 
			ZCContent ocrContent = ZCML.getInstance().getContentForAadhaar(file,file2,languageCode); 
			//Call getContent() with the file object to get the detected text in ZCContent object 
			//To get individual paragraphs 
			List<ZCParagraph>  paragraphs = ocrContent.getParagraphs(); 
			if(paragraphs.isEmpty()) {
				flag=true;
				message+="paragraphs is empty\n";
			}
			for(ZCParagraph paragraph : paragraphs)
			{ 
			//To get individual lines in the paragraph 
			List<ZCLine> paraLines = paragraph.lines; 
			if(paraLines.isEmpty()) {
				flag=true;
				message+="paraLines is empty\n";
			}
			for(ZCLine line : paraLines)
			{ 
			//To get individual words in the line 
			String[] words = line.words; 
			if(words.length==0) {
				flag=true;
				message+="words is empty\n";
			}
			String text = line.text; 
			if(text==null) {
				flag=true;
				message+="line.text is empty\n";
			}
			else {
				if(!text.equals(expText)) {
					flag=true;
					message+="Expected response is not obtained. Obtained response - "+text+" . Expected response - "+expText;
				}
				}
			
			//Raw line text 
			} 
			String text = paragraph.text; 
			if(text==null) {
				flag=true;
				message+="paragraph.text is empty\n";
			}
			//Returns the raw paragraph text 
			} 
			String text = ocrContent.text;
			if(text==null) {
				flag=true;
				message+="ocrContent.text is empty\n";
			}
			if(flag==false) {
				message+="Aadhaar case passed";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase102(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		String expText="{\"address\":\"GROUND FLOOR, JAYABHADRA VILLAS.V.P ROADBORIVALI (W)MUMBAIMAHARASHTRA400092\",\"city\":\"MUMBAI\",\"centre\":\"GREATER MUMBAI\",\"bankName\":\"HDFC Bank\",\"accountNumber\":\"605502010070106\",\"branch\":\"MUMBAI - BORIVALI (WEST)\",\"dateOfOpening\":\"04/03/2020\",\"imps\":\"true\",\"neft\":\"true\",\"contact\":\"+919890603333\",\"district\":\"GREATER MUMBAI\",\"micr\":\"400240027\",\"name\":\"QUINN RIVERS\",\"state\":\"MAHARASHTRA\",\"rtgs\":\"true\",\"ifsc\":\"HDFC0000145\"}";
		try {
			File file = new File("Passbook1.png"); 
			ZCOCROptions options = ZCOCROptions.getInstance().setModelType(ZCOCRModelType.PASSBOOK).setLanguageCode("eng"); 
			ZCContent ocrContent = ZCML.getInstance().getContent(file, options); 
			//Call getContent() with the file object to get the detected text in ZCContent object 
			//To get individual paragraphs 
			List<ZCParagraph>  paragraphs = ocrContent.getParagraphs(); 
			if(paragraphs.isEmpty()) {
				flag=true;
				message+="paragraphs is empty\n";
			}
			for(ZCParagraph paragraph : paragraphs)
			{ 
			//To get individual lines in the paragraph 
			List<ZCLine> paraLines = paragraph.lines; 
			if(paraLines.isEmpty()) {
				flag=true;
				message+="paraLines is empty\n";
			}
			for(ZCLine line : paraLines)
			{ 
			//To get individual words in the line 
			String[] words = line.words; 
			if(words.length==0) {
				flag=true;
				message+="words is empty\n";
			}
			String text = line.text; 
			if(text==null) {
				flag=true;
				message+="line.text is empty\n";
			}
			else {
				if(!text.equals(expText)) {
					flag=true;
					message+="Expected response is not obtained. Obtained response - "+text+" . Expected response - "+expText;
				}
			}
			//Raw line text 
			} 
			String text = paragraph.text; 
			if(text==null) {
				flag=true;
				message+="paragraph.text is empty\n";
			}
			//Returns the raw paragraph text 
			} 
			String text = ocrContent.text;
			if(text==null) {
				flag=true;
				message+="ocrContent.text is empty\n";
			}
			if(flag==false) {
				message+="Passbook Case passed";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase103(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		try {
			File file = new File("Cheque1.png"); 
			//Specify the file path 
			ZCOCROptions options = ZCOCROptions.getInstance().setModelType(ZCOCRModelType.CHEQUE); 
			//Set the model type 
			ZCContent ocrContent = ZCML.getInstance().getContent(file, options); 
			//Call getContent() with the file object to get the detected text in ZCContent object 
			ZCChequeData chequeData = ocrContent.getChequeData(); 
			//This method obtains the cheque data 
			//To fetch individual elements like the account number, IFSC code, bank name, branch, amount, and date of transaction from the processed image 
			Long accountNumber = chequeData.getAccountNumber(); 
			String ifsc = chequeData.getIfsc(); 
			String bankName = chequeData.getBankName(); 
			String branchName = chequeData.getBranchName(); 
			String amount = chequeData.getAmount(); 
			Date date = chequeData.getDate();
			if(!accountNumber.equals(605502010070106l)) {
				flag=true;
				message+="expected account number is not found. expected - 605502010070106 , found - "+accountNumber;
			}
			if(!ifsc.equals("HDFC0000145")) {
				flag=true;
				message+="expected ifsc is not found. expected - HDFC0000145, found - "+ifsc;
			}
			if(!bankName.equals("HDFC Bank")) {
				flag=true;
				message+="expected bank name is not found. expected - HDFC Bank, found - "+bankName;
			}
			if(!branchName.equals("MUMBAI - BORIVALI (WEST)")) {
				flag=true;
				message+="branch name is not found";
			}
			if(!amount.equals("10000")) {
				flag=true;
				message+="amount is not found";
			}
			if(!date.toString().equals("Sat Feb 12 00:00:00 UTC 2022")) {
				flag=true;
				message+="date is not found";
			}
			if(flag==false) {
				message+="Cheque case passed";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase104(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		try {
			JSONArray textArray = new JSONArray(); 
			textArray.add("This is a sad day today as we feel sorry to announce that we are closing our operations by the end of this month."); 
			//Input text to be processed 
			JSONArray keywords = new JSONArray(); 
			keywords.add("operations"); 
			//Optional keywords, if you wish to process the sentences containing only these keywords 
			List<ZCSentimentAnalysisData> listOfSentimentAnalysisData = ZCML.getInstance().getSentimentAnalysis(textArray,keywords); 
			//Input text is passed 
			ZCSentimentAnalysisData sentimentAnalysisData = listOfSentimentAnalysisData.get(0); 
			List<ZCSentimentAnalysisDetails> SentimentAnalysisDetails = sentimentAnalysisData .getSentimentAnalysisDetails(); 
			for (ZCSentimentAnalysisDetails sentimentAnalysis : SentimentAnalysisDetails) 
			{ 
			String sentiment = sentimentAnalysis.getDocumentSentiment(); 
			if(!sentiment.equals("Negative")) {
				flag=true;
				message+="Expected sentiment value is not present. Expected - Negative. Found - "+sentiment;
			}
			//To obtain the overall sentiment of the text 
			double overallScore = sentimentAnalysis.getOverallScore(); 
			if(overallScore!=1.0) {
				flag=true;
			message+="Expected overallScore is not found. Expected - 1.0. Found - "+overallScore;
			}
			//To obtain the confidence score of the overall analysis 
			List<ZCSentenceAnalytics> listOfSentenceAnalytics = sentimentAnalysis.getSentenceAnalytics(); 
			//To obtain the sentiment of each sentence 
			for(ZCSentenceAnalytics values : listOfSentenceAnalytics) {
			String sentenceSentiment = values.getSentiment();
			if(!sentenceSentiment.equals("Negative")) {
				flag=true;
				message+="Expected sentenceSentiment is not found. Found - "+sentenceSentiment;
			}
			String sentence = values.getSentence();
			if(!sentence.equals("This is a sad day today as we feel sorry to announce that we are closing our operations by the end of this month.")) {
				flag=true;
				message+="Expected sentence is not found. Found - "+sentence;
			}
			ZCSentimentConfidenceScore sentenceLevelConfidenceScore = values.getConfidenceScore(); 
			if(sentenceLevelConfidenceScore.getNegativeScore()!=1.0||sentenceLevelConfidenceScore.getNeutralScore()!=0.0||sentenceLevelConfidenceScore.getPositiveScore()!=0.0) {
				flag=true;
				message+="Expected confidence scores not found. Expected 1.0, 0.0, 0.0. Found - "+sentenceLevelConfidenceScore.getNegativeScore()+", "+sentenceLevelConfidenceScore.getNeutralScore()+", "+sentenceLevelConfidenceScore.getPositiveScore();
			}

			//To obtain the confidence score of each sentence analysis 
			}
			}
			if(flag==false) {
				message+="Sentiment Analysis case passed";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase105(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		try {
			JSONArray textArray = new JSONArray();
			textArray.add("Zoho Corporation, is an Indian multinational technology company that makes web-based business tools.It is best known for Zoho Office Suite. The company was founded by Sridhar Vembu and Tony Thomas and has a presence in seven locations with its global headquarters in Chennai, India, and corporate headquarters in Pleasanton, California.");
			List<ZCNERData> listOfNERData = ZCML.getInstance().getNERPrediction(textArray); 
			List <ZCNERDetails>nerDetails = listOfNERData.get(0).getNERList(); 
			String token = nerDetails.get(0).getToken(); 
			if(!token.equals("Zoho Corporation")) {
				flag=true;
				message+="Expected token not found. Expected - Zoho Corporation. Found - "+token;
			}
			String tag = nerDetails.get(0).getNERTag(); 
			if(!tag.equals("Organization")) {
				flag=true;
				message+="Expected tag not found. Expected - Organization. Found - "+tag;
			}
			double confidenceScore = nerDetails.get(0).getConfidenceScore(); 
			if(confidenceScore!=97.0) {
				flag=true;
				message+="Expected confidenceScore not found. Expected - 97.0. Found - "+confidenceScore;
			}
			int startIndex = nerDetails.get(0).getStartIndex(); 
			if(startIndex!=0) {
				flag=true;
				message+="Expected startIndex not found. Expected - 0. Found- "+startIndex;
			}
			int endIndex = nerDetails.get(0).getEndIndex(); 
			if(endIndex!=16) {
				flag=true;
				message+="Expected endIndex not found. Expected - 16. Found - "+endIndex;
			}
			if(flag==false) {
				message+="Named Entity Recognition case passed.";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase106(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		String expKeywords="TCO,solutions,complex,Catalyst,host,ownership,";
		String expKeyPhrase="full-stack development platform,lowest total cost,easy learning curve,bold innovations,";
		String foundKeywords="";
		String foundKeyPhrase="";
		try {
			JSONArray textArray = new JSONArray();
			textArray.add("Catalyst is a full-stack development platform that simplifies the complex. Build, test, host, deploy, and optimize solutions like never before. Its easy learning curve and eliminates complexities, empowering you to craft bold innovations at the lowest total cost of ownership (TCO).");
			//Input text to be processed 
			List<ZCKeywordExtractionData> listOfKeywordExtractionData = ZCML.getInstance().getKeywordExtraction(textArray);
			//Text is passed 
			ZCKeywordExtractionData keywordExtractionData = listOfKeywordExtractionData.get(0); 
			List<String>keywordsList = keywordExtractionData.getKeywords(); 
			//To fetch the keywords 
			for(String keyword:keywordsList) {
				foundKeywords+=keyword+",";
			}
			if(!foundKeywords.equals(expKeywords)) {
				message+="Expected keywords are not present. Found -"+foundKeywords;
			}
			List<String> keyphrasesList = keywordExtractionData.getKeyphrases(); //To fetch the keyphrases
			for(String keyphrase:keyphrasesList) {
				foundKeyPhrase+=keyphrase+",";
			}
			if(!foundKeyPhrase.equals(expKeyPhrase)) {
				message+="Expected keyphrases are not present. Found -"+foundKeyPhrase;
			}
			if(flag==false) {
				message+="Keywords extraction case passed.";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
	public void testCase107(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject responseData = new JSONObject();
		Boolean flag=false;
		String message="";
		
		try {
			JSONArray textArray = new JSONArray(); 
			textArray.add("Zoho Corporation, is an Indian multinational technology company that makes web-based business tools. It is best known for Zoho Office Suite. The company was founded by Sridhar Vembu and Tony Thomas and has a presence in seven locations with its global headquarters in Chennai, India, and corporate headquarters in Pleasanton,California."); 
			//Input text to be processed 
			JSONArray keywords = new JSONArray(); 
			keywords.add("Zoho"); 
			//Optional keywords for Sentiment Analysis 
			List<ZCTextAnalyticsData> listOfTextAnalyticsData = ZCML.getInstance().getTextAnalytics(textArray);
			//Text and keywords are passed 
			ZCTextAnalyticsData textAnalyticsData = listOfTextAnalyticsData.get(0);
			ZCKeywordExtractionData keywordExtractionData = textAnalyticsData.getKeywordExtractionData(); 
			//To perform Keyword Extraction on the text Z
			ZCNERData nerData = textAnalyticsData.getNERData(); 
			//To perform NER on the text
			ZCSentimentAnalysisData sentimentAnalysisData = textAnalyticsData.getSentimentAnalysisData(); 
			//To perform Sentiment Analysis on the text
			if(flag==false) {
				message+="Text analytics case passed.";
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
			responseData.put("value","exception");
			response.setContentType("application/json");
			response.getWriter().write(responseData.toString());
			response.setStatus(500);
		}
	}
}