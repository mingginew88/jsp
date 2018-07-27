package syj.member.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.login.model.MemberVo;
import syj.member.service.MemberService;


/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/memberProfile")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//<img src="/pic?id=2 />
		String mem_id = request.getParameter("mem_id");
		
		MemberService studentService = new MemberService();
		MemberVo memberVo = studentService.getMemberInfo(mem_id);
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+memberVo.getMem_profile()+"\"");		
		response.setContentType("application/octet-stream");
				
		//D:\A_TeachingMaterial\7.JspSrpgin\fileUpload\sally.png
		String file = memberVo.getProfile_path() + File.separator + memberVo.getProfile_name();
		System.out.println(memberVo.getProfile_path());
		System.out.println(memberVo.getProfile_name());
		
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
