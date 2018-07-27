package syj.member.web;

public class ProfileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload";


	public static String getFileName(String contentDisposition) {
		String[] fileNames = contentDisposition.split("; ");
		
		String result ="";
		
		for (String fileStr : fileNames) {
			String[] stringValue = fileStr.split("=");
			
			if(stringValue[0].equals("filename")) {
				String[] fileName = stringValue[1].split("\\\"");
				result = fileName[1];
				break;
			}
		}
		return result;
	}
	
	
	
//	public static String getFileName(String contentDisposition) {
//		String[] cdSplit = contentDisposition.split("; ");
//		String fileName ="";
//		
//		for (String str : cdSplit) {
//			if(str.startsWith("filename")) {
//				fileName = str.substring("filename".length()+2, str.length()-1);
//				break;
//			}
//		}
//		return fileName;
//	}
	
	
	
	
	
	
	
	
	

}



