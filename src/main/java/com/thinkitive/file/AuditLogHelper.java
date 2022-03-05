package com.thinkitive.file;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AuditLogHelper {
	public static List<AuditLogEntity> excelToDb() {
		List<AuditLogEntity> auditLogEntities = new ArrayList<AuditLogEntity>();
		try {
			ClassLoader classLoader = AuditLogEntity.class.getClassLoader();
			String SHEET = "1.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(classLoader.getResource(SHEET).getFile()));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int index = 0; index <= sheet.getPhysicalNumberOfRows(); index++) {
				if (index > 0) {
					AuditLogEntity auditLogEntity2 = new AuditLogEntity();
					XSSFRow row = sheet.getRow(index);
					Integer id = (int) row.getCell(0).getNumericCellValue();
					auditLogEntity2.setId(id);
					auditLogEntity2.setEhr(row.getCell(1).getStringCellValue());
					auditLogEntity2.setMethod(row.getCell(2).getStringCellValue());
					auditLogEntity2.setRequestUrl(row.getCell(3).getStringCellValue());
					Integer responseStatus = ((int) row.getCell(4).getNumericCellValue());
					auditLogEntity2.setTimeStamp(row.getCell(5).getStringCellValue());
					auditLogEntity2.setResponseStatus(responseStatus);
					auditLogEntities.add(auditLogEntity2);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return auditLogEntities;
	}
}