package com.thinkitive.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditLogDetailsController {

	@Autowired
	AuditLogDetailsService auditLogDetailsService;
	@Autowired 
	AuditLogService auditLogService;

	@PostMapping("/audit-log/add-audit-log-details")
	public AuditLogDetails createAuditLogDetails(@RequestBody AuditLogDetails auditLogDetails,int auditLogDetailsID) {
		return auditLogDetailsService.createDetails(auditLogDetailsID, auditLogDetails);
	}

	@PutMapping("/audit-log/{auditLogEntity_id}/update-audit-log-details/{auditLogDetailsID}")
	public AuditLogDetails updateAuditLogDetails(@PathVariable (value = "auditLogEntity_id") int auditLogEntityId, @PathVariable int auditLogDetailsID, @RequestBody AuditLogDetails auditLogDetailsUpdate) {
		return auditLogDetailsService.updateDetails(auditLogDetailsID, auditLogDetailsUpdate);
	}
 
//	@DeleteMapping("/audit-logs/{auditLogEntityId}/delete-audit-log-details/{auditLogDetailsID}") 
//	public ResponseEntity<Object> deleteAuditLogDetails(@PathVariable int auditLogDetailsID,@PathVariable int auditLogEntityId) {
//		return auditLogDetailsService.deleteDetails(auditLogEntityId);
//	}

}
