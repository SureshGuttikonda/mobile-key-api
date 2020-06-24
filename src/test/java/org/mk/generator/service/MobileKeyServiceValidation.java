package org.mk.generator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MobileKeyServiceImpl.class, loader = AnnotationConfigContextLoader.class)
public class MobileKeyServiceValidation {

	@Autowired
	private MobileKeyService mobileKeyService;
	
	@Test
	public void testGetMobileKeysFor7Digits() {
		String mobileNumber = "1234567";
		int recordsPerPage = 26;
		
		Map<String, Set<String>> mobileKeys = mobileKeyService.getMobileKeys(mobileNumber, recordsPerPage);
		Assert.notNull(mobileKeys, "Not Null");
		assertEquals(7, mobileKeys.size());
		assertEquals(true, mobileKeys.containsKey(mobileNumber+"_"+1));
		assertEquals(26, mobileKeys.get(mobileNumber+"_"+1).size());
	}
	
	@Test
	public void testGetMobileKeysFor10Digits() {
		String mobileNumber = "1234567890";
		int recordsPerPage = 10;
		
		Map<String, Set<String>> mobileKeys = mobileKeyService.getMobileKeys(mobileNumber, recordsPerPage);
		Assert.notNull(mobileKeys, "Not Null");
		assertEquals(26, mobileKeys.size());
		assertEquals(true, mobileKeys.containsKey(mobileNumber+"_"+1));
		assertEquals(10, mobileKeys.get(mobileNumber+"_"+1).size());
	}

}
