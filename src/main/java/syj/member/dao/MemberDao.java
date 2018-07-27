package syj.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.login.model.MemberVo;
import syj.mybatis.SqlMapSessionFactory;

public class MemberDao implements MemberDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
		SqlSession session = sqlSessionFactory.openSession();
		MemberVo memberVo = session.selectOne("member.getMemberInfo", mem_id);
		session.close();
		return memberVo;
	}

}
