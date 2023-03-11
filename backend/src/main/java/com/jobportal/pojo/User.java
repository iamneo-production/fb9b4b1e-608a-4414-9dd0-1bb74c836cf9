package com.jobportal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="User")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="UserId")
	long id;
	
	@Basic
	@Column(name="Name")
	private String name;
	@Basic
	@Column(name="Username")
	private String email;
	@Basic
	@Column(name="Password")
	private String password;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable (
       name="user_job_table",
       joinColumns = {@JoinColumn(name="UserId")},
       inverseJoinColumns = {@JoinColumn(name="jobid" )}
       
    )
	private Set<Job> joblist;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Job> getJoblist() {
		return joblist;
	}

	public void setJoblist(Set<Job> joblist) {
		this.joblist = joblist;
	}
	
    public void addJob(Job job) {
        joblist.add(job);
    }
	
	public User(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User() {
		//joblist= new HashSet<>();
	}

	
}
