package syj.board.model;


/**
* BoardVo.java
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
public class BoardVo {
	
	private int board_no;				//게시판번호
	private String board_name;			//게시판이름
	private String board_use_confirm;	//게시판사용여부
	
	
	public BoardVo() { }
	

	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use_confirm() {
		return board_use_confirm;
	}
	public void setBoard_use_confirm(String board_use_confirm) {
		this.board_use_confirm = board_use_confirm;
	}


	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", board_name=" + board_name
				+ ", board_use_confirm=" + board_use_confirm + "]";
	}
	
}
