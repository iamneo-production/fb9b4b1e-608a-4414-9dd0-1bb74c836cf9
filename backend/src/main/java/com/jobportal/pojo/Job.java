package com.jobportal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long jobid;
	private String description;
	@Column(name="role")
	private String roleName;
	private String company;
	private String skills;
	private String location;
	private long pay;
	@ManyToMany(mappedBy="joblist",fetch = FetchType.EAGER) 
	private Set<User> users;
	public Job() {
		//users=new HashSet<>();
	}
	
	
	public Job(long jobid, String description, String roleName, String company, String skills, String location,
			long pay) {
		super();
		this.jobid = jobid;
		this.description = description;
		this.roleName = roleName;
		this.company = company;
		this.skills = skills;
		this.location = location;
		this.pay = pay;
	}


	public long getJobid() {
		return jobid;
	}
	public void setJobid(long jobid) {
		this.jobid = jobid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPay() {
		return pay;
	}
	public void setPay(long pay) {
		this.pay = pay;
	}

	public Set<User> getUsers() {

		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	
}
