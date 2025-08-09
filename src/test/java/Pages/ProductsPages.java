package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPages {
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakersShoes_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoesDropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoesDropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersShoesDropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakersShoes_firstShoeName = "/html/body/div[4]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle()  {
        String expectedTitle = "Formal Shoes";
        String actualTitle = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        try {
            Assert.assertEquals(expectedTitle, actualTitle);
            test.log(Status.PASS, "The First shoe name matches: " + actualTitle);
          //  test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+"Test passed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedTitle + "] but found [" + actualTitle + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }


    public static void sportsShoes_verifyTitle() {
        String expectedTitle = "Sports Shoes";
        String actualTitle = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        try {
            Assert.assertEquals(expectedTitle, actualTitle);
            test.log(Status.PASS, "First shoe name matches: " + actualTitle);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedTitle + "] but found [" + actualTitle + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }


    public static void sneakersShoes_verifyTitle() {
        String expectedTitle = "Sneakers";
        String actualTitle = driver.findElement(By.xpath(sneakersShoes_xpath)).getText();
        try {
            Assert.assertEquals(expectedTitle, actualTitle);
            test.log(Status.PASS, "First shoe name matches: " + actualTitle);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedTitle + "] but found [" + actualTitle + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }


    public static void formalShoes_firstShoe_verify() {
        String expectedFirstFormalShoes = "   Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        String actualFirstFormalShoes = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText();
        try {
            Assert.assertEquals(expectedFirstFormalShoes, actualFirstFormalShoes);
            test.log(Status.PASS, "First shoe name matches: " + actualFirstFormalShoes);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedFirstFormalShoes + "] but found [" + actualFirstFormalShoes + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }

    public static void sportsShoes_firstShoe_verify() {
        String expectedFirstSportShoes = "   Ultimate";
        driver.findElement(By.xpath(sportsShoesDropdown_xpath)).click();
        String actualFirstSportShoe = driver.findElement(By.xpath(sportsShoes_firstShoeName)).getText();

        try {
            Assert.assertEquals(expectedFirstSportShoes, actualFirstSportShoe);
            test.log(Status.PASS, "First shoe name matches: " + actualFirstSportShoe);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedFirstSportShoes + "] but found [" + actualFirstSportShoe + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }

    public static void sneakersShoes_firstShoe_verify() {
        String expectedFirstSneakerShoes = "   Archivo";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sneakersShoesDropdown_xpath)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        String actualFirstSneakerShoes = driver.findElement(By.xpath(sneakersShoes_firstShoeName)).getText();

        try {
            Assert.assertEquals(expectedFirstSneakerShoes, actualFirstSneakerShoes);
            test.log(Status.PASS, "First shoe name matches: " + actualFirstSneakerShoes);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: Expected [" + expectedFirstSneakerShoes + "] but found [" + actualFirstSneakerShoes + "]");
            throw e; // rethrow so the test fails in the test runner (like TestNG or JUnit)
        }
    }


}
