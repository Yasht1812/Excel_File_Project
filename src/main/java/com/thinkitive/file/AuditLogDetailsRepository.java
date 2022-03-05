package com.thinkitive.file;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogDetailsRepository extends JpaRepository<AuditLogDetails, Integer>{
	//Optional<AuditLogDetails> findByAidAndAuditLogDetailsID( int auditLogDetailsID);

}
