package com.thinkitive.file;

import org.springframework.http.ResponseEntity;

public interface AuditLogDetailsService {
	AuditLogDetails updateDetails( int auditLogDetailsID, AuditLogDetails auditLogDetailsUpdate);
	
	AuditLogDetails createDetails(  int auditLogDetailsID ,AuditLogDetails auditLogDetails);
	
	//ResponseEntity<Object> deleteDetails(int auditLogDetailsID );
}
