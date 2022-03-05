package com.thinkitive.file;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
public class AuditLogDetailsServiceImpl implements AuditLogDetailsService {
	
	@Autowired
	AuditLogDetailsRepository auditLogDetailsRepository;
	@Autowired
	AuditLogRepository auditLogRepository;

	@Override
	public AuditLogDetails updateDetails( int auditLogDetailsID , AuditLogDetails auditLogDetailsUpdate) {
		if (!auditLogRepository.existsById(auditLogDetailsID)) {
		throw new RuntimeException(" not found"  );
		}
		return auditLogDetailsRepository.findById(auditLogDetailsID).map(auditLogDetails -> {
			auditLogDetails.setName(auditLogDetailsUpdate.getName());
			auditLogDetails.setSalary(auditLogDetailsUpdate.getSalary());
			return auditLogDetailsRepository.save(auditLogDetails);
		}).orElseThrow(() -> new RuntimeException("auditLogDetailsNotFound"));
	}
	@Override
	public AuditLogDetails createDetails(int auditLogDetailsID,  AuditLogDetails auditLogDetails) {
		
		return auditLogRepository.findById(auditLogDetailsID).map(auditLogEntity -> {
			//auditLogDetails.setAuditLogEntity(auditLogDetailsID);
			return auditLogDetailsRepository.save(auditLogDetails);
		}).orElseThrow(() -> new RuntimeException("auditLogEntity not found"));
				
	}
//	@Override
//	public ResponseEntity<Object> deleteDetails(int auditLogDetailsID  ) {
//		return auditLogDetailsRepository.findByAidAndAuditLogDetailsID(auditLogDetailsID ).map(auditLogDetails -> {
//			auditLogDetailsRepository.delete(auditLogDetails);
//			return ResponseEntity.ok().build();
//		}).orElseThrow(() -> new RuntimeException("auditLogEntity not found"));
//		
//	}

}
