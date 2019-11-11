package com.rest.demo.restapidemo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.restapidemo.model.Task;
import com.rest.demo.restapidemo.utility.ApplicationUtility;

/**
 * This class is the rest controller of the application.
 * 
 * @author swasrivastava
 *
 */
@RestController
@RequestMapping("/service")
public class Controller {

	private static final String RUN_BUILD_PLAYBOOK = "ansible-playbook jenkinsrunfinal.yml --extra-vars \"job_name=";
	private static final String SLASH = "\"" ;
	@Autowired
	private ApplicationUtility applicationUtility;

	/**
	 * This method submits a request to ansible with job name and reads the output
	 * from a file from server for getting the status of the job.
	 * 
	 * @param jobName
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/buildJenkin/{jobName}")
	public String buildJenkin(@PathVariable("jobName") String jobName) {

		applicationUtility.callAnsiblePlaybook(RUN_BUILD_PLAYBOOK + jobName + SLASH);
		return applicationUtility.readOutput(jobName);

	}
	
	@CrossOrigin
	@PostMapping("/time")
	public Task time(@RequestBody Task task) {
	//	Date sqlDate = new java.sql.Date(task.getUtil_date().getTime());
		Timestamp ts = Timestamp.valueOf(task.getCreated_date());
		ts.toLocalDateTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ss:S");
        simpleDateFormat.format(ts);
        task.setCreated_date(ts.toLocalDateTime());
        
        Timestamp ts1 = new Timestamp(task.getUtil_date().getTime());
        task.setUtil_date(ts1);
        
		return  task;

	}
	
	@GetMapping("/test")
	public String test() {
		return applicationUtility.test();
	}

}
