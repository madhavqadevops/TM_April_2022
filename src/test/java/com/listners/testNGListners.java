package com.listners;

import com.fileutils.excelPlugin;
import org.testng.*;
import com.webutlilities.webUtil;

import java.io.IOException;

public class testNGListners implements ITestListener, IInvokedMethodListener  {
    public void onStart(ITestContext context) {
        System.out.println("before Suite");
git
        try {
            webUtil webUtil1 = new webUtil();
            webUtil1.launchBrowser("http://automationpractice.com/");
            excelPlugin excelPlugin = new excelPlugin();
            excelPlugin.loadExcel("EMP_Data");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    public void onFinish(ITestContext context) {
        System.out.println("after Suite");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started" +result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Method" +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method" +result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Method" +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        System.out.println("Before Invocation Method Started For: " + method.getTestMethod().getMethodName() + "of Class:" + testResult.getTestClass());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        System.out.println("After Invocation Method Started For: " + method.getTestMethod().getMethodName() + "of Class:" + testResult.getTestClass());

    }


}