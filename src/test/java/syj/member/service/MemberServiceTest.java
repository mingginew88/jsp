package syj.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import syj.login.model.MemberVo;

public class MemberServiceTest {
	
	MemberServiceInf memberService = new MemberService();

	/**
	* Method : getMemberInfoTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 로그인 된 회원 정보 조회
	*/
	@Test
	public void getMemberInfoTest() {
		/***Given***/
		String mem_id = "syjun88";
		
		/***When***/
		MemberVo memberVo = memberService.getMemberInfo(mem_id);

		/***Then***/
		assertEquals("서영준", memberVo.getMem_name());

	}


}
