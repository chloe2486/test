package bean;

public class keijiban_bean {

	private String id;
	private String mail;
	private String name;
	private String comment;
	private String time;
	public keijiban_bean(String id, String mail,String name, String comment, String time) {
		super();
		this.id = id;
		this.mail = mail;
		this.name = name;
		this.comment = comment;
		this.time = time;
	}
	public keijiban_bean(String mail, String name, String comment) {
		super();
		this.mail = mail;
		this.name = name;
		this.comment = comment;
	}
	public keijiban_bean(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


}
