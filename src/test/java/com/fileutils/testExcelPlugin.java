package com.fileutils;

import java.io.IOException;

public class testExcelPlugin {
    public static void main(String[] args) throws IOException {
        excelPlugin excelPlugin=new excelPlugin();
        excelPlugin.loadExcel("EMP_Data");
        excelPlugin.getRowCount("Sheet1");
        //excelPlugin.getColCount("Sheet1");
        //excelPlugin.searchColoumn("Sheet1","First Name");
        //excelPlugin.searchTestcase("Sheet1","TC_08");
        //excelPlugin.getData("Sheet1","TC_08","Test_Case_Name");
        //excelPlugin.getData("Sheet1","TC_01","Title");

    }
}
