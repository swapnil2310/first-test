package com.rest.demo.restapidemo.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.rest.demo.restapidemo.custom.QueryReader;
import com.rest.demo.restapidemo.custom.SQLInitConfiguration;

/**
 * This class acts as utility for calling ansible and reading output.
 * 
 * @author swasrivastava
 *
 */
@Component
public class ApplicationUtility {

	private static final String IDENTITY = "/home/ec2-user/application/gaurav";
	private static final String USER = "ec2-user";
	private static final String HOST = "13.127.222.47";
	private static final String CHANNEL = "exec";
	private static final String HOST_KEY_CHECKING = "StrictHostKeyChecking";
	private static final String NO = "no";
	private static final String READ_FILE = "/home/ec2-user/";
	@Autowired
	private String INSERT;
	

	/**
	 * This method opens a connection to ec-2 instance and calls the ansible
	 * playbook.
	 * 
	 * @param command
	 */
	public void callAnsiblePlaybook(String command) {
		try {
			JSch jsch = new JSch();
			int port = 22;

			jsch.addIdentity(IDENTITY);

			Session session = jsch.getSession(USER, HOST, port);
			java.util.Properties config = new java.util.Properties();
			config.put(HOST_KEY_CHECKING, NO);
			session.setConfig(config);

			session.connect();
			Channel channel = session.openChannel(CHANNEL);
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			channel.setOutputStream(System.out);
			
			
			channel.connect();
		} catch (JSchException jSchException) {
			jSchException.getMessage();
		}
	}

	/**
	 * This method reads the file which contains the status of the job submitted in
	 * jenkins.
	 * 
	 * @param jobName
	 * @return
	 */
	public String readOutput(String jobName) {
		File f = new File(READ_FILE + jobName);
		boolean isFileAvailable = false;
		int retryCount = 0;
		while (!isFileAvailable && retryCount < 20) {
			if (f.exists() && !f.isDirectory()) {
				isFileAvailable = true;
			} else {
				retryCount++;
			}

		}
		String st = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			st = br.readLine();
		} catch (IOException e) {
			e.getMessage();
		}

		return st;
	}
	
	public String test() {
		System.out.println(INSERT);
		System.out.println(SQLInitConfiguration.insertEmployee);
		return INSERT;
	}

}
