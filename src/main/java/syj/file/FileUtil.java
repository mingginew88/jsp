package syj.file;

public class FileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload";
	
	
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC17
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Dispostion header로 부터 업로드 파일명을 리턴한다
	* 
	* ex : form-data; name="uploadFile"; filename="moon.png"
	* return : sally.png
	* 
	*/
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

}



