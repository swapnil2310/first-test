package com.rest.demo.restapidemo.utility;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnsibleUtilityTest {
	
	@InjectMocks
	ApplicationUtility ansibleUtility;
	
	@Test
	public void testCallAnsiblePlaybook() {
		ansibleUtility.callAnsiblePlaybook("testAnsible");
		
	}
	
	@Test
	public void testreadOutput() {
		ansibleUtility.readOutput("testAnsible");
		
	}

}
