package syj.login.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.encrypt.kisa.sha256.KISA_SHA256;
import syj.login.model.MemberVo;
import syj.login.service.LoginService;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/joinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberVo memberVo = new MemberVo();
		
		String mem_id 		= request.getParameter("joinId");
		String mem_name 	= request.getParameter("joinName");
		String mem_pw 		= request.getParameter("joinPassword");
		String mem_email 	= request.getParameter("joinEmail");
		String mem_tel 		= request.getParameter("joinTel");
		String mem_addr1 	= request.getParameter("joinAddr1");
		String mem_addr2 	= request.getParameter("joinAddr2");
		Date mem_joindate	= new Date();
		
		String pw = KISA_SHA256.encrypt(mem_pw);
		
		memberVo.setMem_id(mem_id);
		memberVo.setMem_name(mem_name);
		memberVo.setMem_pw(pw);
		memberVo.setMem_email(mem_email);
		memberVo.setMem_tel(mem_tel);
		memberVo.setMem_addr1(mem_addr1);
		memberVo.setMem_addr2(mem_addr2);
		memberVo.setMem_joindate(mem_joindate);
		
		LoginService loginService = new LoginService();
		
		int joinMember = loginService.joinMember(memberVo);
		
		if(joinMember == 1) {
			//회원가입 성공 알람창 띄우고 싶은데...
			RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
		}
		else {
			//실패시 알람창...
			RequestDispatcher rd = request.getRequestDispatcher("/main/main.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
