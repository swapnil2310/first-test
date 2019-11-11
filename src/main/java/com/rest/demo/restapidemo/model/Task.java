package com.rest.demo.restapidemo.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author swasrivastava
 *
 */
public class Task {

	private int playbook_id;
	private String task_name;
	private String task_desc;
	private LocalDateTime created_date;
	private Date util_date;
	private int user_id;
	

	public Date getUtil_date() {
		return util_date;
	}

	public void setUtil_date(Date util_date) {
		this.util_date = util_date;
	}

	public int getPlaybook_id() {
		return playbook_id;
	}

	public void setPlaybook_id(int playbook_id) {
		this.playbook_id = playbook_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
