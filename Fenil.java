package SecondMaven;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class Fenil{
    public static class Util extends BasePage {
        public static void ClickableElement(By by) {

            //driver.findElement(By.xpath("//a[@class= \'ico-register\']")).click();
            //1.clicking element
            BasePage.driver.findElement(by).click();
            driver.findElement(by).click();
        }

        //2. clear Text from Input box
        public static void clearField(By by) {
            BasePage.driver.findElement(by).clear();
        }


        //3.Enter Text in input field
        public static void enterText(By by, String text) {
            BasePage.driver.findElement(by).sendKeys(text);

        }


        //4.Clear and enter text in input field
        public void clearAndEnter(By by, String text) {
            BasePage.driver.findElement(by).clear();
            BasePage.driver.findElement(by).sendKeys(text);
        }


        //5. Checking WebElement Present in DOM
        public boolean isElementPresent(By by) {
            try {
                BasePage.driver.findElement(by).isEnabled();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }


        //6. Checking WebElement displayed or not
        public boolean isElementDisplayed(By by) {
            try {
                BasePage.driver.findElement(by).isDisplayed();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }


        //7.Wait for fixed time given for seconds
        public static void waitForWebElementToBeClickable(WebElement element, int seconds) {
            WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }


        //8. Try to click element three times if not available in first go
        public boolean retryForElement(By by) {
            boolean result = false;
            int attempt = 0;
            while (attempt < 3) {
                try {
                    Thread.sleep(10);
                    BasePage.driver.findElement(by).click();
                    result = true;
                    break;
                } catch (Exception e) {
                }
                attempt++;
            }
            return result;
        }


        //9.wait for locator to be clickable for given time in seconds
        public static void waitForLocatorToBeClickable(By by, int seconds) {
            WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }



        //wait for visibility of element with given time
        public static void explicitWaitForVisibility(By by, int seconds) {
            WebDriverWait wait = new WebDriverWait(BasePage.driver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }


        //select text from value
        public static String getActualText(By by) {
            String actualResult;
            return actualResult = BasePage.driver.findElement(by).getText();
        }


        //get selected value from dropdown
        public static void selectByValue(By by, String data) {
            Select dob = new Select(BasePage.driver.findElement(by));
            dob.selectByValue(data);
        }


        //  scroll to view element
        public void scrollToElement(By by, WebElement element, int seconds) {
            try {
                ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", element);
                BasePage.driver.findElement(by);
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //scroll to view element
        public void scrollTillElementFoundAndclick(By by, WebElement element) {
            ((JavascriptExecutor) BasePage.driver).executeScript("arguments[0].scrollIntoView(true);", element);
            BasePage.driver.findElement(by);
        }


        //wait for alert to display
        public boolean isAlertPresent() {
            boolean present = false;
            try {
                Alert alert = BasePage.driver.switchTo().alert();
                present = true;
                alert.accept();
            } catch (NoAlertPresentException ex) {
                ex.printStackTrace();
            }
            return present;
        }



        //get attribute of element
        public static String getAttributeOfElement(WebElement element, String attr) {
            String value = element.getAttribute(attr);
            return value;
        }



        //get css property of element
        public String getCssPropelement(WebElement element, String css) {
            String value = element.getCssValue(css);
            return value;

        }

    }

}
