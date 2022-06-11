package com.pageBheviours;

import com.pageObjects.homePage_OR;
import com.webutlilities.webUtil;
import org.openqa.selenium.support.PageFactory;

public class homePage extends webUtil {
    homePage_OR homePage_or;
    public homePage(){
        this.homePage_or= PageFactory.initElements(driver,homePage_OR.class);
    }

    public void signin(){
        waitForElement(homePage_or.signin,40);
        clickElement("Home Page","signin",homePage_or.signin);

    }

}
