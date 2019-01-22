package com.emp.modal;

import java.util.List;

public class HostelData {

	private HostelOwnerData hostelOwnerData;
	private List<HostelDetailData> hostelDetailDataList;

	public List<HostelDetailData> getHostelDetailDataList() {
		return hostelDetailDataList;
	}

	public void setHostelDetailDataList(List<HostelDetailData> hostelDetailDataList) {
		this.hostelDetailDataList = hostelDetailDataList;
	}

	public HostelOwnerData getHostelOwnerData() {
		return hostelOwnerData;
	}

	public void setHostelOwnerData(HostelOwnerData hostelOwnerData) {
		this.hostelOwnerData = hostelOwnerData;
	}

}
