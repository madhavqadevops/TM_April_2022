package com.webutlilities;

import com.excep.customException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class webUtil {
    private Logger logger = Logger.getLogger(webUtil.class.getName());
    //Public static WebDriver driver;
    public static WebDriver driver;
    /*
    @Method Name:-launchBrowser
    @purpose:-To launch any browser.
    @inputParams:-browser type
    @OutputParams:-none
     */
    @Step
    public void launchBrowser(String browser) throws InterruptedException {
        logger.log(Level.INFO, "Launching {0} driver", new Object[]{browser});
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
                break;

            default:
                throw new customException("Inavlid browser type");
        }
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        logger.log(Level.INFO, "Driver Launched Successfully {0}", new Object[]{browser});
    }

    /*
  @Method Name:-closing browser
  @purpose:-Close already opened browser
  @inputParams:-none
  @OutputParams:-none
   */
    @Step
    public  void closeBrowser() {
        logger.log(Level.INFO, ",closing {0} driver", new Object[]{"Browser"});
        driver.close();
        driver.quit();
        logger.log(Level.INFO, ",Browser closed Successfully");
    }

    /*
  @Method Name:-get page title
  @purpose:-To get title of page
  @inputParams:-none
  @OutputParams:-string
   */
    @Step
    public String getPageTitle() {
        logger.log(Level.INFO, ",Fetching Page Title");
        return driver.getTitle();
    }

    /*
  @Method Name:-get current page url
  @purpose:-To get url of current page
  @inputParams:-none
  @OutputParams:-String
   */
    @Step
    public String getPageUrl() {
        logger.log(Level.INFO, ",Fetching current page url");
        return driver.getCurrentUrl();
    }

    /*

     */
    @Step
    public  boolean verifyElementExist(String pageName, String elementName, WebElement element) {
        boolean elementExist = false;
        try {
            if (element.isDisplayed()) {
                elementExist = true;
                logger.log(Level.INFO, "Element {0}exists on the page {1}", new Object[]{elementName, pageName});
            } else {
                logger.log(Level.INFO, "Element {0 } NOT EXISTS on the page {1}", new Object[]{elementName, pageName});
            }
        } catch (customException e) {
            logger.log(Level.INFO, "Element {0 } NOT EXISTS on the page {1}", new Object[]{elementName, pageName});
            elementExist = false;
        }
        return elementExist;
    }
    @Step
    public  void sendData(String pageName, String elementName, WebElement element, String data) {
        try {
            logger.log(Level.INFO, "Enter Test Data in {0} field of page {1}", new Object[]{elementName, pageName});
            element.click();
            //Thread.sleep(2000);
            element.clear();
            // Thread.sleep(2000);
            element.sendKeys(data);
            // Thread.sleep(2000);
            logger.log(Level.INFO, "Test data for {0} is successfully passed in page {1}", new Object[]{elementName, pageName});
        } catch (customException e) {
            logger.log(Level.INFO, "Entering Test data for {0} is Failed in page {1}", new Object[]{elementName, pageName});
        }

    }
    @Step
    public void clickElement(String pageName, String elementName, WebElement element) {
        try {
            logger.log(Level.INFO, "hovering and clicking {0} in page {1}", new Object[]{elementName, pageName});
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
        } catch (customException e) {
            logger.log(Level.INFO, "ERROR EHILE overing and clicking {0} in page {1}", new Object[]{elementName, pageName});
        }
    }

    @Step
    public  boolean radioButtonSelection(String pageName, String elementName, WebElement element) {
        boolean elementselected = false;
        try {
            if (element.isSelected()) {
                logger.log(Level.INFO, "Verifying {0} in page {1} is enabled or not", new Object[]{elementName, pageName});
                elementselected = true;
                logger.log(Level.INFO, "{0} in page {1} is Enabled", new Object[]{elementName, pageName});
            } else {
                logger.log(Level.INFO, "{0} in page {1} is not selected", new Object[]{elementName, pageName});
            }
        } catch (customException e) {
            logger.log(Level.INFO, "{0} in page {1} is not selected", new Object[]{elementName, e.getStackTrace()});
        }
        return elementselected;
    }

    @Step
    public  void scroll(String pageName, String elementName, WebElement element) {

        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).perform();
            logger.log(Level.INFO, "Successfully scrolled to {0} in page {1}", new Object[]{elementName, pageName});
        } catch (customException e) {
            System.out.println(e.getStackTrace());
            logger.log(Level.INFO, "couild not scroll to {0} in page {1}", new Object[]{elementName, pageName});
        }
    }
    @Step
    public  void selectItem(String elementName, String value, WebElement element) {

        try {
            Select selectItem = new Select(element);
            selectItem.selectByValue(value);

            logger.log(Level.INFO, "Successfully selected to {0} in Field {1}", new Object[]{value, elementName});
        } catch (customException e) {
            System.out.println(e.getStackTrace());
            logger.log(Level.INFO, "couild not select {0} in field {1}", new Object[]{value, elementName});
        }
    }
    @Step
    public  void comapreData(WebElement e1, String elementName1, WebElement e2, String elementName2) {
        String t1 = e1.getText();
        String t2 = e2.getText();

        try {
            if (e1.equals(e2)) {
                logger.log(Level.INFO, "Data Displayed in {0} same as {1}", new Object[]{elementName1, elementName2});
            } else {
                logger.log(Level.INFO, "Data Displayed in {0} is NOT SAME AS {1}", new Object[]{elementName1, elementName2});
            }
        } catch (customException e) {
            System.out.println(e.getStackTrace());
            logger.log(Level.INFO, "Data Displayed in {0} is NOT SAME AS {1}", new Object[]{elementName1, elementName2});
        }
    }
    @Step
    public  boolean waitForWebElement(String elementXPATH, int timeout) {
        boolean elementFound = false;

        try {
            WebDriverWait WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPATH)));
            elementFound = true;
        } catch (Exception e) {
            elementFound = false;
            System.out.println(e.getStackTrace());
        }
        return elementFound;
    }

    /*
     * Arbitary Wait
     * we make this wait*/
    @Step("waiting for webelement")
    public  void waitForElement(WebElement element, int timeout) {
        Actions actions = new Actions(driver);
        for (int i = 1; i <= timeout; i++) {
            try {

                actions.moveToElement(element);
            } catch (Exception e) {
                System.out.println("____________________");
            }
        }
    }
}

