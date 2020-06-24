package org.mk.generator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import org.mk.generator.constants.MobileKeyConstants;
import org.springframework.stereotype.Service;

/**
 * @author Suresh Guttikonda
 *
 */

@Service
public class MobileKeyServiceImpl implements MobileKeyService {
	
	private static final int NBR_OF_RECORDS_PER_PAGE = 10;
	
	/**
	 *
	 */
	@Override
	public Map<String, Set<String>> getMobileKeys(String mobileNbr, int recordsPerPage) {

		List<String> generatedMobileKeys = new ArrayList<>();
		Map<String, Set<String>> mobileKeysPageMap = new HashMap<>();
		if (recordsPerPage <= 0)
			recordsPerPage = NBR_OF_RECORDS_PER_PAGE;

		addMobileKeys(mobileNbr.toCharArray(), generatedMobileKeys);

		populateMobileKeysPageMap(mobileNbr, mobileKeysPageMap, generatedMobileKeys, recordsPerPage);

		return mobileKeysPageMap;
	}

	/**
	 * This method splits the generated keys into
	 * individual collection based on the user request of
	 * maximum no of keys to be displayed per page
	 *   
	 * @param mobileNbr
	 * @param mobileKeysPageMap
	 * @param generatedMobileKeys
	 * @param recordsPerPage
	 */
	private void populateMobileKeysPageMap(String mobileNbr, Map<String, Set<String>> mobileKeysPageMap, List<String> generatedMobileKeys,
			int recordsPerPage) {
		int maxKeys = mobileNbr.length() * MobileKeyConstants.ALPHABETS_NBR;

		int totalPages = getTotalPages(recordsPerPage, maxKeys);
		int listIndex = 0;
		
		for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
			String mobileUniqueKey = mobileNbr + "_" + pageNumber;
			Set<String> mobileKeys = mobileKeysPageMap.get(mobileUniqueKey);
			if (mobileKeys == null || mobileKeys.isEmpty()) {
				mobileKeys = new HashSet<>(recordsPerPage);
				for (int loopIndex = 0; loopIndex < recordsPerPage; loopIndex++) {
					mobileKeys.add(generatedMobileKeys.get(listIndex));
					listIndex += 1;
					if (listIndex >= generatedMobileKeys.size())
						break;
				}
				mobileKeysPageMap.put(mobileUniqueKey, mobileKeys);
			}
		}
	}

	/**
	 * Method to calculate total pages based on records per page
	 *  and the total count of mobile keys generated
	 *  
	 * @param recordsPerPage
	 * @param maxKeys
	 * @return
	 */
	private int getTotalPages(int recordsPerPage, int maxKeys) {
		
		int pages = maxKeys / recordsPerPage;
		if(maxKeys%recordsPerPage > 0)
			pages += 1;
		
		return pages;
	}

	
	/**
	 * Method to generate the all combinations of Mobile Keys
	 *  and add them to the list
	 *  
	 * @param mobileNbrCharArray
	 * @param generatedMobileKeys
	 */
	private void addMobileKeys(char[] mobileNbrCharArray, List<String> generatedMobileKeys) {
		IntStream.rangeClosed(1, mobileNbrCharArray.length).forEach(replacementPosition -> {
			String newMobileNbrStr = new String(mobileNbrCharArray);
			char[] newMobileChar = newMobileNbrStr.toCharArray();
			IntStream.rangeClosed(MobileKeyConstants.CHAR_START_NBR, MobileKeyConstants.CHAR_END_NBR)
					.forEach(replacementCharNbr -> {
						char replacementChar = (char) replacementCharNbr;
						newMobileChar[replacementPosition - 1] = replacementChar;
						generatedMobileKeys.add(String.valueOf(newMobileChar));
					});
		});
	}

	
}
