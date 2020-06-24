package org.mk.generator.domain;

import java.util.Set;

public class MobileKeyVO {
	private Set<String> mobileKeys;
	private long totalMobileKeys;
	private int pageNbr;
	
	public Set<String> getMobileKeys() {
		return mobileKeys;
	}
	public void setMobileKeys(Set<String> mobileKeys) {
		this.mobileKeys = mobileKeys;
	}
	public long getTotalMobileKeys() {
		return totalMobileKeys;
	}
	public void setTotalMobileKeys(long totalMobileKeys) {
		this.totalMobileKeys = totalMobileKeys;
	}
	public int getPageNbr() {
		return pageNbr;
	}
	public void setPageNbr(int pageNbr) {
		this.pageNbr = pageNbr;
	}
	
	
}
