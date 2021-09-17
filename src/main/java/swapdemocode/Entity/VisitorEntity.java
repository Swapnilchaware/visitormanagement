package swapdemocode.Entity;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="visitor")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "loginTime", "logoutTime" }, allowGetters = true)
public class VisitorEntity {

	@Id
	@GeneratedValue
	@Column(name="vid")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="company")
	private String company;
	
	@Column(name="phonenumber")
	private Long phoneNumber;
	
	@Column(name="typeofvisit")
	private String typeOfVisit;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="loginTime")
	public Date loginTime;
	
	@Column(name="status")
	public int status;
	
	@Column(name="logoutTime")
	public Date logoutTime;
	
	@ManyToOne
	@JoinColumn(name="aid")
	private AdminEntity adminEntity;

	public VisitorEntity() {
		super();
	}

	public VisitorEntity(int id) {
		super();
		this.id = id;
	}

	public VisitorEntity(String name, String address, String company, Long phoneNumber, String typeOfVisit,
			AdminEntity adminEntity) {
		super();
		this.name = name;
		this.address = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.typeOfVisit = typeOfVisit;
		this.adminEntity = adminEntity;
	}

	public int getStatus() {
		return status;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTypeOfVisit() {
		return typeOfVisit;
	}

	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}

	public VisitorEntity(int id, String name, String address, String company, Long phoneNumber, String typeOfVisit,
			Date loginTime, int status, Date logoutTime, AdminEntity adminEntity) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.typeOfVisit = typeOfVisit;
		this.loginTime = loginTime;
		this.status = status;
		this.logoutTime = logoutTime;
		this.adminEntity = adminEntity;
	}

	@Override
	public String toString() {
		return "VisitorEntity [id=" + id + ", name=" + name + ", address=" + address + ", company=" + company
				+ ", phoneNumber=" + phoneNumber + ", typeOfVisit=" + typeOfVisit + ", loginTime=" + loginTime
				+ ", status=" + status + ", logoutTime=" + logoutTime + ", adminEntity=" + adminEntity + "]";
	}

	
	


	
	
	
	
	
}
