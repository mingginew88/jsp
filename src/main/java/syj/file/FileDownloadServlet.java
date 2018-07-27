package syj.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.attachment.model.AttachmentVo;
import syj.attachment.service.AttachmentService;
import syj.attachment.service.AttachmentServiceInf;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		int attach_no = Integer.parseInt(request.getParameter("attach_no"));
		
		AttachmentServiceInf attachmentService = new AttachmentService();
		AttachmentVo attachmentVo =  attachmentService.getAttachment(attach_no);
		System.out.println(attachmentVo.getAttach_upload_name());
		response.setHeader("Content-Disposition", "attachment; filename=\""+attachmentVo.getAttach_upload_name()+"\"");		
		response.setContentType("application/octet-stream");

		String file = attachmentVo.getAttach_path() + File.separator + attachmentVo.getAttach_name();
		System.out.println(file);
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		
		byte[] b = new byte[512];
		int len = 0;
		while( (len = fis.read(b)) != -1 ) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
