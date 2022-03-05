package com.thinkitive.file;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AuditLogController {

	@Autowired
	AuditLogService auditLogService;
	@Autowired
	AuditLogDetailsService auditLogDetailsService;
	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/update-database-using-excel")
	public List<AuditLogEntity> savEntities(@RequestParam("file") MultipartFile multipartFile) {
		return auditLogService.saveAuditDetails();
	}
	
	@GetMapping("/show-details-by-id/{id}")
	public ResponseEntity<AuditLogDTO> getDetailsById(@PathVariable(name = "id") int id){
		AuditLogEntity auditLogEntity = auditLogService.getDetailsById(id);
		AuditLogDTO auditLogDTOResponse = modelMapper.map(auditLogEntity, AuditLogDTO.class);
		return ResponseEntity.ok().body(auditLogDTOResponse);
	}

	@PostMapping("/add-details-audit-log")
	public AuditLogEntity createEntity(@RequestBody AuditLogEntity auditLogEntity ) {

		return auditLogService.createDetails(auditLogEntity);
	}

	@DeleteMapping("/delete-details-audit-log/{id}")
	public void deleteEntity(@PathVariable int id) {
		auditLogService.deleteDetails(id);
	}

	@PutMapping("/update-details-audit-log/{id}")
	public ResponseEntity<Object> updateEntity(@PathVariable int id, @RequestBody AuditLogEntity auditLogEntity) {
		return auditLogService.updateDetails(id, auditLogEntity);
	}
}
