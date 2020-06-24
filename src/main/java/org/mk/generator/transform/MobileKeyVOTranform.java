package org.mk.generator.transform;

import java.util.Set;

import org.mk.generator.domain.MobileKeyVO;

public class MobileKeyVOTranform {

	public static MobileKeyVO mobileKeyDataTransform(Set<String> mobileKeys, String mobileNbr, int pageNbr,
			int mobileKeysTotal) {
		MobileKeyVO mobileKeyVO = new MobileKeyVO();
		mobileKeyVO.setMobileKeys(mobileKeys);
		mobileKeyVO.setTotalMobileKeys(mobileKeysTotal);
		mobileKeyVO.setPageNbr(pageNbr);
		return mobileKeyVO;
	}
}