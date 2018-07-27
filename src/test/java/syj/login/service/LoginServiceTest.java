package syj.login.service;

import static org.junit.Assert.*;

import org.junit.Test;

import syj.login.model.MemberVo;

public class LoginServiceTest {

	LoginServiceInf loginService = new LoginService();
	
	/**
	* Method : checkMemberTest
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 로그인 시 회원 정보 여부
	*/
	@Test
	public void checkMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		String id = "syjun88";
		String pw = "1234";
		memberVo.setMem_id(id);
		memberVo.setMem_pw(pw);

		/***When***/
		int checkResult = loginService.checkMember(memberVo);

		/***Then***/
		assertEquals(1, checkResult);
	}
	
	
	/**
	* Method : joinMemberTest
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 회원가입
	*/
	@Test
	public void joinMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		String mem_id 	 = "t002";
		String mem_name  = "서영준";
		String mem_pw 	 = "1234";
		String mem_email ="seo@naver.com";
		String mem_tel 	 = "010-1234-2222";
		String mem_addr1 ="대전";
		String mem_addr2 = "서구 월평동";
		
		memberVo.setMem_id(mem_id);
		memberVo.setMem_name(mem_name);
		memberVo.setMem_pw(mem_pw);
		memberVo.setMem_email(mem_email);
		memberVo.setMem_tel(mem_tel);
		memberVo.setMem_addr1(mem_addr1);
		memberVo.setMem_addr2(mem_addr2);

		/***When***/
		int joinResult = loginService.joinMember(memberVo);

		/***Then***/
		assertEquals(1, joinResult);		
	}
}
