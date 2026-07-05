package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final DataFormatter formatter = new DataFormatter();

    public ExcelUtils(String filePath, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fis);
            
            System.out.println("Available Sheets:");

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println(workbook.getSheetName(i));
            }

            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found : " + sheetName);
            }

        } catch (IOException e) {

            throw new RuntimeException("Unable to open Excel file : " + e.getMessage());

        }

    }

    public int getRowCount() {

        return sheet.getLastRowNum();

    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();

    }

    public String getCellData(int rowNum, int colNum) {

        Row row = sheet.getRow(rowNum);

        if (row == null)
            return "";

        Cell cell = row.getCell(colNum);

        if (cell == null)
            return "";

        return formatter.formatCellValue(cell);

    }

    public String getCellData(String columnName, int rowNum) {

        Row headerRow = sheet.getRow(0);

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {

            String header = formatter.formatCellValue(headerRow.getCell(i));

            if (header.equalsIgnoreCase(columnName)) {

                return getCellData(rowNum, i);

            }

        }

        return "";

    }

    /**
     * Returns one Excel row as a Map.
     * Key = Column Name
     * Value = Cell Value
     */
    public HashMap<String, String> getRowData(int rowNum) {

        HashMap<String, String> rowData = new LinkedHashMap<>();

        Row headerRow = sheet.getRow(0);

        int cols = headerRow.getLastCellNum();

        for (int i = 0; i < cols; i++) {

            String key = formatter.formatCellValue(headerRow.getCell(i));

            String value = getCellData(rowNum, i);

            rowData.put(key, value);

        }

        return rowData;

    }

    public void closeWorkbook() {

        try {

            workbook.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}