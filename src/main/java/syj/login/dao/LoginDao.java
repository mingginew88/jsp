package syj.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.login.model.MemberVo;
import syj.mybatis.SqlMapSessionFactory;

public class LoginDao implements LoginDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : checkMember
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return
	* Method 설명 : 로그인 시 회원 정보 여부
	*/
	@Override
	public int checkMember(MemberVo memberVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int checkMember = session.selectOne("member.checkMember", memberVo);
		session.close();
		
		return checkMember;
	}

	
	/**
	* Method : joinMember
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param memberVo
	* @return
	* Method 설명 : 회원가입
	*/
	@Override
	public int joinMember(MemberVo memberVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int joinMember = session.insert("member.joinMember", memberVo);
		session.commit();
		session.close();		
		return joinMember;
	}
	
	
	
	
	

}
