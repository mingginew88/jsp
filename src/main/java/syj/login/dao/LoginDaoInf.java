package syj.login.dao;

import syj.login.model.MemberVo;

public interface LoginDaoInf {
	
	
	/**
	* Method : checkMember
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return 1(회원 존재) 0(회원 미존재)
	* Method 설명 : 로그인 시 회원 정보 여부
	*/
	int checkMember(MemberVo memberVo);
	
	
	/**
	* Method : joinMember
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return 1(가입성공) 0(가입실패)
	* Method 설명 : 회원가입
	*/
	int joinMember(MemberVo memberVo);

}
