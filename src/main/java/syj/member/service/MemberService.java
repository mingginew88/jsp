package syj.member.service;

import syj.login.model.MemberVo;
import syj.member.dao.MemberDao;
import syj.member.dao.MemberDaoInf;

public class MemberService implements MemberServiceInf {
	
	MemberDaoInf memberDao = new MemberDao();

	/**
	* Method : getMemberInfo
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 로그인 된 회원 정보 조회
	*/
	@Override
	public MemberVo getMemberInfo(String mem_id) {
		return memberDao.getMemberInfo(mem_id);
	}

}
