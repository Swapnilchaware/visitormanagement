package swapdemocode.DemoEntity;

import java.util.Date;

public class VisitorWe {
	
	
	private int id;
	private String name;
	public Date loginTime;
	public Date logoutTime;
	public String getName() {
		return name;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public VisitorWe(int id, String name, Date loginTime, Date logoutTime) {
		super();
		this.id = id;
		this.name = name;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}


	@Override
	public String toString() {
		return "VisitorWe [id=" + id + ", name=" + name + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
				+ "]";
	}
	

	
	
	
	
	
}
