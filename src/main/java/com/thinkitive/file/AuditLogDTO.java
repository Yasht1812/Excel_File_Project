package com.thinkitive.file;

import java.util.List;

public class AuditLogDTO {
	private Integer id;
	private String ehr;
	private String method;
	private String requestUrl;
	private Integer responseStatus;
	private String timeStamp;
	private List<AuditLogDetailDTO> auditLogDetailDTOs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEhr() {
		return ehr;
	}

	public void setEhr(String ehr) {
		this.ehr = ehr;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public Integer getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(Integer responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<AuditLogDetailDTO> getAuditLogDetailDTOs() {
		return auditLogDetailDTOs;
	}

	public void setAuditLogDetailDTOs(List<AuditLogDetailDTO> auditLogDetailDTOs) {
		this.auditLogDetailDTOs = auditLogDetailDTOs;
	}

	@Override
	public String toString() {
		return "AuditLogDTO [id=" + id + ", ehr=" + ehr + ", method=" + method + ", requestUrl=" + requestUrl
				+ ", responseStatus=" + responseStatus + ", timeStamp=" + timeStamp + ", auditLogDetailDTOs="
				+ auditLogDetailDTOs + "]";
	}



	
}
