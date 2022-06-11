package com.fileutils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class readExcel {
    public static void main(String[] args) throws IOException {
        File mfile=new File(System.getProperty("user.dir") + "\\TestData\\Production Analysis.xlsx");
        System.out.println(System.getProperty("user.dir") + "\\TestData\\Production Analysis.xlsx");
        FileInputStream fis =new FileInputStream(mfile);
        XSSFWorkbook XSSFWorkbook =new XSSFWorkbook(fis);

        XSSFSheet XSSFSheet = XSSFWorkbook.getSheet("Report Data");
        XSSFRow XSSFRow = XSSFSheet.getRow(0);

        XSSFCell XSSFCell = XSSFRow.getCell(0);
        System.out.println(XSSFCell.getStringCellValue());
    }
}
