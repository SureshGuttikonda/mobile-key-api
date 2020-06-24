package org.mk.generator.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.mk.generator.constants.MobileKeyConstants;
import org.mk.generator.domain.MobileKeyVO;
import org.mk.generator.service.MobileKeyService;
import org.mk.generator.transform.MobileKeyVOTranform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileKeyController {
	
	Map<String, Map<String, Set<String>>> globalMobileKeysMap = new HashMap<>();
	
	@Autowired
	public MobileKeyService mobileKeyService;
	
	@RequestMapping(value = MobileKeyConstants.MOBILE_KEY_URI, method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<MobileKeyVO> getMobileKey(@PathVariable String mobile_nbr, @RequestParam int pageNbr,
			@RequestParam int recordsPerPage) {
		
		//TODO: Change to Cache implementation
		Map<String, Set<String>> mobileKeysMap = globalMobileKeysMap.get(mobile_nbr);
		if(mobileKeysMap == null) {
			mobileKeysMap = mobileKeyService.getMobileKeys(mobile_nbr, recordsPerPage);
			globalMobileKeysMap.put(mobile_nbr, mobileKeysMap);
		}
			
		
		MobileKeyVO mobileKeyVO = MobileKeyVOTranform.mobileKeyDataTransform(mobileKeysMap.get(mobile_nbr+"_"+pageNbr), mobile_nbr, pageNbr);
		return new ResponseEntity<MobileKeyVO>(mobileKeyVO, HttpStatus.OK);
	}
	
	

}
