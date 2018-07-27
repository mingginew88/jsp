package syj.attachment.model;

public class AttachmentVo {
	
	private int 	attach_no;				//첨부파일번호
	private String 	attach_upload_name;		//첨부업로드파일명
	private String 	attach_path;			//첨부파일경로
	private String 	attach_name;			//첨부파일명
	private int 	article_no;				//해당게시글번호
	
	
	public int getAttach_no() {
		return attach_no;
	}
	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}
	public String getAttach_upload_name() {
		return attach_upload_name;
	}
	public void setAttach_upload_name(String attach_upload_name) {
		this.attach_upload_name = attach_upload_name;
	}
	public String getAttach_path() {
		return attach_path;
	}
	public void setAttach_path(String attach_path) {
		this.attach_path = attach_path;
	}
	public String getAttach_name() {
		return attach_name;
	}
	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	
	
	@Override
	public String toString() {
		return "AttachmentVo [attach_no=" + attach_no + ", attach_upload_name="
				+ attach_upload_name + ", attach_path=" + attach_path
				+ ", attach_name=" + attach_name + ", article_no=" + article_no
				+ "]";
	}
	

}
