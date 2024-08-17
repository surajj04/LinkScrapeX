package org.bytetech.LinkScrapeX.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    public List<String> dataReadTest(File file) {

        List<String> list = new ArrayList<>();

        try (Workbook workbook = createWorkbook((MultipartFile) file)) {
            if (workbook != null) {
                Sheet sheet = workbook.getSheetAt(0);
                int lastRowNum = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowNum; i++) {
                    if (sheet.getRow(i) != null) {
                        for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
                            Cell cell = sheet.getRow(i).getCell(j);
                            if (cell != null && cell.getCellType() == CellType.STRING) {
                                String entry = cell.getStringCellValue();
                                if (entry.contains("https://www.linkedin.com")) {
                                    list.add(entry);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    private Workbook createWorkbook(MultipartFile file) throws IOException {
        if (file.getOriginalFilename().endsWith(".xls")) {
            return new HSSFWorkbook(file.getInputStream()); // For .xls files
        } else if (file.getOriginalFilename().endsWith(".xlsx")) {
            return new XSSFWorkbook(file.getInputStream()); // For .xlsx files
        }
        return null;
    }
}
