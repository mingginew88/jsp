package syj.member.service;

import syj.login.model.MemberVo;


public interface MemberServiceInf {
	
	/**
	* Method : getMemberInfo
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 로그인 된 회원 정보 조회
	*/
	MemberVo getMemberInfo(String mem_id);
	

}
