package syj.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import syj.encrypt.kisa.sha256.KISA_SHA256;
import syj.login.model.MemberVo;
import syj.login.service.LoginService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("loginId");
		String mem_pw = request.getParameter("loginPassword");
		
		String pw = KISA_SHA256.encrypt(mem_pw);
		
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_pw(pw);
		
		LoginService loginService = new LoginService();
		int checkMember = loginService.checkMember(memberVo);
		
		if(checkMember == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", mem_id);
			request.getRequestDispatcher("/main/main.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		
	}

}