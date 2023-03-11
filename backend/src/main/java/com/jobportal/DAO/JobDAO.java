package com.jobportal.DAO;


import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;


import com.jobportal.pojo.Job;
import com.jobportal.pojo.User;

@Component
public class JobDAO extends DAO{
	public Job register(Job j) throws Exception {
		try {
			getSession();
			begin();
			Job job= new Job(j.getJobid(),j.getDescription(),j.getRoleName(),j.getCompany(),j.getSkills(),j.getLocation(),j.getPay());
			getSession().save(job);
			commit();
			close();
			return j;

		} catch (HibernateException e) {
			
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	public List<Job> getAllJobs() throws Exception {
		try {
			getSession();
			begin();
			Query q = getSession().createQuery("from Job");
			List<Job> j= q.list();
			
			commit();
			close();
			return j;
			
		} catch (HibernateException e) {

			throw new Exception( e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public Job getJobById(String JobId) throws Exception {
		try {
			getSession();
			begin();
			Query q = getSession().createQuery("from Job where jobId = :jobid");
			q.setString("jobid",JobId);
				
			Job job = (Job) q.uniqueResult();
			commit();
			close();
			return job;
			
		} catch (HibernateException e) {

			throw new Exception("Could not get job ", e);
		}
	}
	public Job deleteJobById(String JobId) throws Exception {
		try {
			getSession();
			Job j=getJobById(JobId);
			
			begin();
			Query q = getSession().createQuery("delete from Job where jobId= :jobId");
			
			q.setInteger("jobId", Integer.parseInt(JobId));
			System.out.println(q.executeUpdate());
			commit();
			close();
			return j;
			
			
		} catch (HibernateException e) {

			throw new Exception( e);
		}
	}
	
	public Job updateJob(Job job,String JobId) throws Exception {
		try {
			getSession();
			Job j=getJobById(JobId);
			begin();
			Query q = getSession().createQuery("update from Job set "
					+ "description= :description, "+
					"company=:company, "+
					"role=:roleName, "+
					"location=:location, "+
					"skills=:skills, "+
					"pay=:pay "+ 
					"where jobId= :jobId");
			
			q.setInteger("jobId", Integer.parseInt(JobId));
			q.setString("description", job.getDescription());
			q.setString("company", job.getCompany());
			q.setString("roleName", job.getRoleName());
			q.setString("skills", job.getSkills());
			q.setString("location", job.getLocation());
			q.setLong("pay", job.getPay());
			
			System.out.println(q.executeUpdate());
			commit();
			close();
			return j;
			
			
		} catch (HibernateException e) {

			throw new Exception( e);
		}
	}

	public void update(Job job,User u) throws Exception {
	    try {
			getSession();
	        begin();
	        job.getUsers().add(u);
	        u.getJoblist().add(job);
	        getSession().update(u);
	        getSession().update(job);
	        commit();


	        close();

	        System.out.println("Updated the job");
	    } catch (HibernateException e) {
	        throw new Exception("Could not update the job", e);
	    }
	}
	
	public List<Job> getAppliedJobs(User u) throws Exception {
	    try {

	    	getSession();
			begin();
			Query q = getSession().createQuery("SELECT j from Job j JOIN j.users u where u.id=:id");
			q.setString("id",String.valueOf(u.getId()));	
			List<Job> joblist = q.getResultList();
			commit();
			close();
			return joblist;
	    } catch (HibernateException e) {
	        throw new Exception("Could not update the job", e);
	    }
	}
	
	public void deleteAppliedJob(User u,String JobId) throws Exception {
	    try {
	    	Job j= getJobById(JobId);
			getSession();
	        begin();
			for (Iterator<User> iterator = j.getUsers().iterator(); iterator.hasNext();) {
			    User s =  iterator.next();
			    if (s.getId()==	u.getId()) {
			        iterator.remove();
			    }       
			}
			for (Iterator<Job> iterator = u.getJoblist().iterator(); iterator.hasNext();) {
			    Job s =  iterator.next();
			    if (s.getJobid()==	j.getJobid()) {
			        iterator.remove();
			    }       
			}
	        getSession().update(u);
	        commit();
	        close();
	    } catch (HibernateException e) {
	        throw new Exception("Could not update the job", e);
	    }
	}
	
	@SuppressWarnings("deprecation")
	public List<Job> getAllunappliedJobs(User u) throws Exception {
		try {
			List<Job> jlist= getAllJobs();
			getSession();
			begin();
			for(Job j : u.getJoblist()) {
				for(int i=0;i<jlist.size();i++) {
					if(j.getJobid()==jlist.get(i).getJobid())
						jlist.remove(i);
				}
			}
			
			commit();
			close();
			return jlist;
			
		} catch (HibernateException e) {

			throw new Exception( e);
		}
	}
	

}
