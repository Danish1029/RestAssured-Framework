package dataProviders;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class NegativePetDataProvider {

    @DataProvider(name = "PetData")
    public Object[][] getPetData() {

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/testData/PetData.xlsx";
        System.out.println("Excel Path : " + filePath);
        ExcelUtils excel = new ExcelUtils(filePath,"NegativePetData");

        int rows = excel.getRowCount();

        Object[][] data = new Object[rows][1];

        for (int i = 1; i <= rows; i++) {

            HashMap<String, String> rowData = excel.getRowData(i);

            data[i - 1][0] = rowData;

        }

        excel.closeWorkbook();

        return data;
    }

}