package org.mule.module.google.calendar.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.google.calendar.model.AclRule;
import org.mule.module.google.calendar.model.Calendar;

public class UpdateAclRuleTestCases extends GoogleCalendarTestParent {
	

	
	@Before
	public void setUp() {
		try {
			testObjects = (Map<String, Object>) context.getBean("updateAclRule");
			
			// Insert calendar and get reference to retrieved calendar
			Calendar calendar = insertCalendar((Calendar) testObjects.get("calendarRef"));
			
			// Replace old calendar instance with new instance
			testObjects.put("calendarRef", calendar);
			testObjects.put("calendarId", calendar.getId());
			
			String roleBefore = testObjects.get("roleBefore").toString(); 
			testObjects.put("role", roleBefore);
		
			// Insert the ACL rule
			MessageProcessor flow = lookupFlowConstruct("insert-acl-rule");
			MuleEvent event = flow.process(getTestEvent(testObjects));
						
			AclRule returnedAclRule = (AclRule) event.getMessage().getPayload();
			testObjects.put("aclRule", returnedAclRule);	
			testObjects.put("ruleId", returnedAclRule.getId());
			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Category({SmokeTests.class, SanityTests.class})
	@Test
	public void testUpdateAclRule() {
		try {
			String roleAfter = testObjects.get("roleAfter").toString();
			
			AclRule aclRule = (AclRule) testObjects.get("aclRule");
			aclRule.setRole(roleAfter);
			testObjects.put("aclRuleRef", aclRule);			
			
			MessageProcessor flow = lookupFlowConstruct("update-acl-rule");
			MuleEvent response = flow.process(getTestEvent(testObjects));
			
			aclRule = (AclRule) response.getMessage().getPayload();
			String roleAfterUpdate = aclRule.getRole();
			assertEquals(roleAfter, roleAfterUpdate);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@After
	public void tearDown() {
		try {
			String calendarId = testObjects.get("calendarId").toString();
			deleteCalendar(calendarId);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	
}
