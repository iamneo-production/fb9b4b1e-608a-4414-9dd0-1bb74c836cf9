package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages={"com.jobportal.controller"})
@ComponentScan({"com.jobportal.controller", "com.jobportal.DAO", "com.jobportal.pojo"})
public class EmploymentPortalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploymentPortalManagementApplication.class, args);
	}

}
