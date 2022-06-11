package com.fileutils;
import com.excep.customException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  excelPlugin<logger> {
    public static XSSFWorkbook xssfWorkbook;
    String coloumnNames = "";
    String firstNames = "";
    String lastNames = "";
    String emailIds = "";

   public Logger logger = Logger.getLogger(this.getClass().getName());

    public void loadExcel(String name) throws IOException {
        try {
            logger.log(Level.INFO, "Loading Excel File");
            File mfile = new File(System.getProperty("user.dir") + "\\TestData\\" + name + ".xlsx");
            System.out.println(System.getProperty("user.dir") + "\\TestData\\Production Analysis.xlsx");
            FileInputStream fis = new FileInputStream(mfile);
            this.xssfWorkbook = new XSSFWorkbook(fis);
            logger.log(Level.INFO, "Excel File loaded Successfully");
        } catch (customException e) {
            e.printStackTrace();
            logger.log(Level.INFO, "Failed to load Excel File,Error {0}", new Object[]{e.getMessage()});
        }
    }

    public  int getRowCount(String sheetname) {
        int rowCount = 0;
        try {
            logger.log(Level.INFO, "Getting rowcount from the sheet");
            rowCount = xssfWorkbook.getSheet("Sheet1").getLastRowNum();
            logger.log(Level.INFO, "Total Row Count from sheet {0} : {1}", new Object[]{"Sheet1", rowCount});
        } catch (customException e) {
            e.printStackTrace();
            logger.log(Level.INFO, "Failed to row count,Error {0}", new Object[]{e.getMessage()});
        }
        return rowCount;
    }


    public  int getColCount(String sheetname) {
        int colCount = 0;
        try {
            logger.log(Level.INFO, "Getting rowcount from the sheet");
            colCount = xssfWorkbook.getSheet(sheetname).getRow(0).getLastCellNum();
            logger.log(Level.INFO, "Total coloumn Count from sheet {0} : {1}", new Object[]{sheetname, colCount});
        } catch (customException e) {
            e.printStackTrace();
            logger.log(Level.INFO, "Failed to get coloumns count,Error {0}", new Object[]{e.getMessage()});
        }
        return colCount;

    }

    public  int searchColoumn(String sheetname, String colName) {
        int colNumber = 0;
        int totalcols = getColCount(sheetname);
        if (totalcols != 0) {
            for (int c = 0; c < totalcols; c++) {
                String cName = xssfWorkbook.getSheet(sheetname).getRow(0).getCell(c).getStringCellValue();
                //System.out.println(cName);
                if (colName.trim().equals(cName.trim())) {
                    colNumber = c;
                    logger.log(Level.INFO, "Coloumn found at number {0} from sheet {1}", new Object[]{colNumber, sheetname});
                    break;
                }
            }
        } else {
            throw new customException("Found coloumns as zero, unable to search for the result  {0}", new Object[]{colName});
        }
        return colNumber;
    }

    public  int searchTestcase(String sheetname, String testCase) {
        int rownum = 0;
        int totalRows = getRowCount(sheetname);
        if (totalRows != 0) {
            for (int r = 1; r <= totalRows; r++) {
                String tcName = xssfWorkbook.getSheet(sheetname).getRow(r).getCell(0).getStringCellValue();

                if (tcName.trim().equals(testCase.trim())) {
                    rownum = r;
                    logger.log(Level.INFO, "Testcase found  at row {0} from sheet {0} : {1}", new Object[]{rownum, sheetname});
                    break;
                }
            }
            return rownum;
        } else {
            throw new customException("Found Rows count as zero, unable to search tests case");
        }

    }

    public  String getData(String sheetname, String testCaseName, String colName) {
        String data=null;
        int row = searchTestcase(sheetname, testCaseName);
        int col = searchColoumn(sheetname, colName);
        switch (xssfWorkbook.getSheet(sheetname).getRow(row).getCell(col).getCellType()) {

            case STRING:
                data = xssfWorkbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
                //System.out.println(data);
                break;
            case NUMERIC:
                data =String.valueOf(xssfWorkbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue()) ;
                //System.out.println(data);
                break;
        }
        //System.out.println(data);
        return data;
    }
}





