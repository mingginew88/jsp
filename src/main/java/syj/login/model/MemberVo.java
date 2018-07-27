package syj.login.model;

import java.util.Date;


/**
* MemberVo.java
*
* @author PC17
* @since 2018. 7. 18.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 7. 18. PC17 최초 생성
*
* </pre>
*/
public class MemberVo {
	
	private String 	mem_id;			//회원아이디	
	private String 	mem_name;		//회원이름
	private String 	mem_pw;			//회원비밀번호
	private String 	mem_email;		//회원이메일
	private String 	mem_tel;		//회원전화번호	
	private String 	mem_addr1;		//회원주소
	private String 	mem_addr2;		//회원상세주소
	private String 	mem_zipcd;		//회원우편번호
	private String 	mem_profile;	//회원프로필사진
	private int 	mem_call_cnt;	//회원호출횟수
	private String 	profile_path;	//프로필사진파일경로
	private String 	profile_name;	//프로필사진파일이름
	private Date 	mem_joindate;	//회원가입일
	
	
	public MemberVo() { }

	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_zipcd() {
		return mem_zipcd;
	}
	public void setMem_zipcd(String mem_zipcd) {
		this.mem_zipcd = mem_zipcd;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	public int getMem_call_cnt() {
		return mem_call_cnt;
	}
	public void setMem_call_cnt(int mem_call_cnt) {
		this.mem_call_cnt = mem_call_cnt;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public Date getMem_joindate() {
		return mem_joindate;
	}
	public void setMem_joindate(Date mem_joindate) {
		this.mem_joindate = mem_joindate;
	}

	
	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_name=" + mem_name
				+ ", mem_pw=" + mem_pw + ", mem_email=" + mem_email
				+ ", mem_tel=" + mem_tel + ", mem_addr1=" + mem_addr1
				+ ", mem_addr2=" + mem_addr2 + ", mem_zipcd=" + mem_zipcd
				+ ", mem_profile=" + mem_profile + ", mem_call_cnt="
				+ mem_call_cnt + ", profile_path=" + profile_path
				+ ", profile_name=" + profile_name + ", mem_joindate="
				+ mem_joindate + "]";
	}
	
	
}
