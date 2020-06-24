package org.mk.generator.transform;

import java.util.Set;

import org.mk.generator.constants.MobileKeyConstants;
import org.mk.generator.domain.MobileKeyVO;

public class MobileKeyVOTranform {

	public static MobileKeyVO mobileKeyDataTransform(Set<String> mobileKeys, String mobileNbr, int pageNbr) {
		MobileKeyVO mobileKeyVO = new MobileKeyVO();
		mobileKeyVO.setMobileKeys(mobileKeys);
		mobileKeyVO.setTotalMobileKeys(mobileNbr.length() * MobileKeyConstants.ALPHABETS_NBR);
		mobileKeyVO.setPageNbr(pageNbr);
		return mobileKeyVO;
	}
}