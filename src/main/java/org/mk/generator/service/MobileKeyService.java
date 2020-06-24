package org.mk.generator.service;

import java.util.Map;
import java.util.Set;

public interface MobileKeyService {
	public Map<String, Set<String>> getMobileKeys(String mobileNbr, int recordCount);
}
