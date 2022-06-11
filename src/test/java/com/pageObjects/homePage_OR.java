package com.pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

//import javax.xml.xpath.XPath;

@Test
public class homePage_OR {

    @FindBy(xpath="//a[normalize-space(text())='Sign in']")
    public WebElement signin;


    @FindBy(xpath="//*[@name='search_query']")
    public  WebElement searchbox;


}
