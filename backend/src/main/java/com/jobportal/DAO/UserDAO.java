package com.jobportal.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.jobportal.pojo.*;



@Component
public class UserDAO extends DAO{
	public UserDAO() {
	}
	public User register(User u) throws Exception {
		try {
			getSession();
			begin();
			User user= new User(u.getId(),u.getName(),u.getEmail(),u.getPassword());
			getSession().save(user);
			commit();
			close();
			return u;

		} catch (HibernateException e) {
			
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	public User getUserByName(String username) throws Exception {
		try {
			getSession();
			begin();
			Query q = getSession().createQuery("from User where Username = :username");
			q.setString("username", username);
				
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
			
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + username, e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public User getUserById(String id) throws Exception {
		try {
			getSession();
			begin();
			Query q = getSession().createQuery("from User where id = :id");
			q.setString("id", id);
				
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
			
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + id, e);
		}
	}
	

	public void update(User user, Job job) throws Exception {
        try {
        	getSession();
            begin();
            user.getJoblist().add(job);
            getSession().merge(user);
            commit();
            close();
        } catch (HibernateException e) {
            throw new Exception("Could not update the user", e);
        }
    }
	
	public List<User> getAppliedJobs(Job j) throws Exception {
	    try {

	    	getSession();
			begin();
			Query q = getSession().createQuery("from Job j JOIN fetch j.users where jobid = :id");
			q.setString("id",String.valueOf(j.getJobid()));	
			List<User> userlist = q.getResultList();
			commit();
			close();
			return userlist;
	    } catch (HibernateException e) {
	        throw new Exception("Could not update the job", e);
	    }
	}
}
