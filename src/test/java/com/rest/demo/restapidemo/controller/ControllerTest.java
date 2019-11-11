package com.rest.demo.restapidemo.controller;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rest.demo.restapidemo.utility.ApplicationUtility;

/**
 * @author swasrivastava
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	
	@Mock
	ApplicationUtility ansibleUtility;
	@InjectMocks
	Controller controller;

	@Test
	public void buildJenkinTest() throws IOException {
		controller.buildJenkin("jobName");
	}

}
