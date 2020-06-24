package org.mk.generator.service;

import java.util.Map;
import java.util.Set;

public interface MobileKeyService {
	
	/**
	 * Method to get all the pages that has
	 *  all the combinations of mobile keys
	 *  
	 * @param mobileNbr
	 * @param recordCount
	 * @return
	 */
	public Map<String, Set<String>> getMobileKeys(String mobileNbr, int recordCount);
}
