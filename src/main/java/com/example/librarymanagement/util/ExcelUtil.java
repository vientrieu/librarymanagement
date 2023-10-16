package com.example.librarymanagement.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mangvientrieu
 */
public final class ExcelUtil {
	private ExcelUtil() {
	}

	public static List<Map<String, Object>> readExcel(MultipartFile multipartFile) {
		try {
			Workbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);

			List<Map<String, Object>> data = new ArrayList<>();
			List<String> header = new ArrayList<>();
			sheet.getRow(0).forEach(cell -> header.add(cell.getStringCellValue()));
			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					row.forEach(cell -> header.add(cell.getStringCellValue()));
				} else {
					Map<String, Object> rowData = readDataOfRow(row, header);
					data.add(rowData);
				}
			}
			return data;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Map<String, Object> readDataOfRow(Row row, List<String> header) {
		Map<String, Object> rowData = new HashMap<>();
		for (Cell cell : row) {
			switch (cell.getCellType()) {
				case STRING: {
					rowData.put(header.get(cell.getColumnIndex()), cell.getStringCellValue());
					break;
				}
				case NUMERIC: {
					if (DateUtil.isCellDateFormatted(cell)) {
						rowData.put(header.get(cell.getColumnIndex()), cell.getDateCellValue());
					} else {
						rowData.put(header.get(cell.getColumnIndex()), cell.getNumericCellValue());
					}
					break;
				}
				case BOOLEAN: {
					rowData.put(header.get(cell.getColumnIndex()), cell.getBooleanCellValue());
					break;
				}
				case FORMULA: {
					rowData.put(header.get(cell.getColumnIndex()), cell.getCellFormula());
					break;
				}
				default: {
					rowData.put(header.get(cell.getColumnIndex()), "");
					break;
				}
			}
		}
		return rowData;
	}
}
