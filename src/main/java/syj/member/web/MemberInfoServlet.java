package syj.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import syj.login.model.MemberVo;
import syj.member.service.MemberService;


/**
 * Servlet implementation class MemberInfoServlet
 */
@WebServlet("/memberInfo")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		MemberService memberService = new MemberService();
		MemberVo memberVo = memberService.getMemberInfo(mem_id);
		
		request.setAttribute("memberVo", memberVo);
		request.getRequestDispatcher("/member/memberInfo.jsp").forward(request, response);		
		
	}

}
