package com.thinkitive.file;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AuditLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String ehr;
	private String method;
	private String requestUrl;
	private Integer responseStatus;
	private String timeStamp;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auditLogDetails_id")
	private AuditLogDetails auditLogDetails;

	public AuditLogDetails getAuditLogDetails() {
		return auditLogDetails;
	}

	public void setAuditLogDetails(AuditLogDetails auditLogDetails) {
		this.auditLogDetails = auditLogDetails;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

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

	@Override
	public String toString() {
		return "AuditLogEntity [id=" + id + ", ehr=" + ehr + ", method=" + method + ", requestUrl=" + requestUrl
				+ ", responseStatus=" + responseStatus + ", timeStamp=" + timeStamp + ", auditLogDetails="
				+ auditLogDetails + "]";
	}

}
