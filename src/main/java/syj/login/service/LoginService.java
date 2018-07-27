package syj.login.service;

import syj.login.dao.LoginDao;
import syj.login.dao.LoginDaoInf;
import syj.login.model.MemberVo;

public class LoginService implements LoginServiceInf {
	
	LoginDaoInf loginDao = new LoginDao();

	@Override
	public int checkMember(MemberVo memberVo) {
		return loginDao.checkMember(memberVo);
	}

	@Override
	public int joinMember(MemberVo memberVo) {
		return loginDao.joinMember(memberVo);
	}

}
