package com.thinkitive.file;

import java.util.List;

import org.springframework.http.ResponseEntity;
public interface AuditLogService {
	List<AuditLogEntity> saveAuditDetails();

	List<AuditLogEntity> getAllDetails();
	
	AuditLogEntity getDetailsById(int id);
	
	ResponseEntity<Object> updateDetails(int id , AuditLogEntity auditLogEntity);
	
	AuditLogEntity createDetails(AuditLogEntity auditLogEntity);
	
	void deleteDetails(int id);
}
