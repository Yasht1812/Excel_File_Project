package com.thinkitive.file;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

	@Autowired
	AuditLogRepository auditLogRepository;
	@Autowired
	AuditLogDetailsRepository auditLogDetailsRepository;

	@Override
	public List<AuditLogEntity> saveAuditDetails() {
		List<AuditLogEntity> auditLogEntities = null;

		try {
			auditLogEntities = AuditLogHelper.excelToDb();
			auditLogRepository.saveAll(auditLogEntities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auditLogEntities;
	}

	@Override
	public List<AuditLogEntity> getAllDetails() {
		return auditLogRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> updateDetails(int id, AuditLogEntity auditLogEntity) {
		Optional<AuditLogEntity> auditLogEntity2 = auditLogRepository.findById(id);
		if (!auditLogEntity2.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		auditLogEntity.setId(id);
		auditLogRepository.save(auditLogEntity);
		return null;
	}

	@Override
	public AuditLogEntity createDetails(AuditLogEntity auditLogEntity) {
		return auditLogRepository.save(auditLogEntity);
	}

	@Override
	public void deleteDetails(int id) {
		auditLogRepository.deleteById(id);
	}

	@Override
	public AuditLogEntity getDetailsById(int id) {
		Optional<AuditLogEntity> result = auditLogRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("id not found");
		}
	}

}
