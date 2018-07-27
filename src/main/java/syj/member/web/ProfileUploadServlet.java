package syj.member.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/profileUpload")
//bytes
//1kb = 1024bytes
//1mb = 1024kbytes
//5mb = 1mb * 5 == 1kb *1024 * 5 = 1024 * 1024 * 5
@MultipartConfig(maxFileSize= 1024 * 1024 * 5, maxRequestSize= 1024 * 1024 * 16)
public class ProfileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(ProfileUploadServlet.class);
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part uploadFilePart = request.getPart("uploadFile");
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		
		String fileName = ProfileUtil.getFileName(contentDisposition);
		logger.debug("filename : " + fileName);
		
		//파일 저장 경로 설정
		//실무 : 별도 storage
		//개발환경 : 임의 영역(서버 변경시, 재기동시 업로드 파일 삭제됨)
		//fileUpload 디렉토리에 임의로 작성
		//D:\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
		
		//url --> realpath : application 객체에서 제공해주는 메서드
		//doPost 메서드 안에서 application(servletContext) 객체를 구한다
		
		//1. request.getServletContext()
		//2. getServletContext() (서블릿에서 제공해주는 메서드)
		
		//임의의 배포경로
//		ServletContext servletContext = getServletContext();
//		String path = servletContext.getRealPath("/fileUpload");

		//고정된 영역으로 배포
		String path = ProfileUtil.fileUploadPath;
		
		
		//fileSize가 정상적인 경우에만 업로드를 수행한다
		if( uploadFilePart.getSize() > 0 ) {
//			uploadFilePart.write(path + File.separator + fileName);
			//사용자가 업로드한 실제 파일명은 디비상에 저장하고, 물리적 파일명은 임의로 적용
			
			uploadFilePart.write(path + File.separator + UUID.randomUUID().toString());
			
			//path : D:\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp\fileUpload
			//fileName : sally.png
			//더해줄때 중간에 \ 이게 없음.  ==> File.separator			
			uploadFilePart.delete();
		} 
		
	}

}
