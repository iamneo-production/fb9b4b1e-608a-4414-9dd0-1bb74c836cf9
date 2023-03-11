package com.jobportal.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportal.DAO.JobDAO;
import com.jobportal.DAO.UserDAO;
import com.jobportal.pojo.Job;
import com.jobportal.pojo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class JobController {
	@Autowired
	JobDAO jobdao;
	
	@Autowired
	UserDAO userdao;
	@PostMapping("/postJob.htm")
	public String addJob(HttpServletRequest request,  @ModelAttribute("job") Job job) throws Exception {
		

		//jobdao= new JobDAO();
		job.setCompany(request.getParameter("company"));
		job.setDescription(request.getParameter("description"));
		job.setLocation(request.getParameter("location"));
		job.setRoleName(request.getParameter("roleName"));
		job.setPay(Long.parseLong(request.getParameter("pay")));
		job.setSkills(request.getParameter("skills"));
		jobdao.register(job);

		return "postJobMsg";

	}
	@GetMapping("/postJob.htm")
	public String postJob(){
		return "job";
	}
	@GetMapping("/viewJob.htm")
	public String viewJob(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		List<Job> jobList=jobdao.getAllJobs();
		session.setAttribute("jobList", jobList);
		return "viewJob";

	}
	
	@GetMapping("/editJob.htm/{jobid}")
	public String editJob(@PathVariable("jobid") String JobId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		Job job=jobdao.getJobById(JobId);
		session.setAttribute("job", job);
		return "editJob";

	}
	@PostMapping("/editJob.htm/{jobid}")
	public String editJobPost(@PathVariable("jobid") String JobId,HttpServletRequest request,  @ModelAttribute("job") Job job) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		job.setCompany(request.getParameter("company_e"));
		job.setDescription(request.getParameter("description_e"));
		job.setLocation(request.getParameter("location_e"));
		job.setRoleName(request.getParameter("roleName_e"));
		job.setPay(Long.parseLong(request.getParameter("pay_e")));
		job.setSkills(request.getParameter("skills_e"));
		jobdao.updateJob(job,JobId);
		session.setAttribute("jobList", job);
		return "editJobMsg";

	}
	@PostMapping("/deleteJob.htm")
	public String deleteJob(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		List<Job> jobList=jobdao.getAllJobs();
		session.setAttribute("jobList", jobList);
		return "deletedJobMsg";

	}
	@GetMapping("/deleteJob.htm/{jobid}")
	public String deleteJobPost(@PathVariable("jobid") String JobId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		Job job =jobdao.deleteJobById(JobId);
		session.setAttribute("job", job);
		return "deletedJobMsg";
	}
	
	@GetMapping("/viewAllJobs.htm")
	public String viewAllJobs(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		//jobdao= new JobDAO();
		List<Job> jobList=jobdao.getAllJobs();
		jobList=jobdao.getAllJobs();
		session.setAttribute("jobList", jobList);
		return "applyJobs";
	}
	
	@RequestMapping("/applyJob.htm/{id}")
	public String applyJob(@PathVariable("id") String JobId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		//jobdao= new JobDAO();
		//UserDAO userdao= new UserDAO();
		Job job = jobdao.getJobById(JobId);
		//job.getUsers().add(u);
		jobdao.update(job,u);
		//userdao.update(u, job);
		return "ApplyJobMsg";
	}
	
	@RequestMapping("/appliedJob.htm")
	public String appliedJob(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Job> appliedList=jobdao.getAppliedJobs(u);
		session.setAttribute("appliedJobList",appliedList);
		return "appliedJobsUser";
	}
	
	@RequestMapping("/deleteAppliedJob.htm/{id}")
	public String appliedJob(@PathVariable("id") String JobId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		jobdao.deleteAppliedJob(u, JobId);
		return "deletedJob";
	}
	
	@RequestMapping("/viewApplicantsJob.htm/{id}")
	public String viewApplicantsJob(@PathVariable("id") String JobId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Job j=jobdao.getJobById(JobId);
		//List<User> appliedUsers=jobdao.getAppliedJobs(u);
		session.setAttribute("appliedUsers",j.getUsers());
		session.setAttribute("job",j);
		return "ApplicantsForJob";
	}
	
	@RequestMapping("/removeApplicant.htm/{jobid}/{userid}")
	public String removeApplicant(@PathVariable("jobid") String JobId,@PathVariable("userid") String UserId,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = userdao.getUserById(UserId);
		Job j=jobdao.getJobById(JobId);
		//List<User> appliedUsers=jobdao.getAppliedJobs(u);
		for (Iterator<User> iterator = j.getUsers().iterator(); iterator.hasNext();) {
		    User s =  iterator.next();
		    if (s.getId()==	Long.parseLong(UserId)) {
		        iterator.remove();
		    }       
		}
		return "ApplicantsForJob";
	}
	@GetMapping("/viewUnappliedJobs.htm")
	public String viewUnappliedJobs(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		//jobdao= new JobDAO();
		List<Job> jobList=jobdao.getAllJobs();
		jobList=jobdao.getAllunappliedJobs(u);
		session.setAttribute("jobListUnapp", jobList);
		return "unAppliedJobs";
	}
}
