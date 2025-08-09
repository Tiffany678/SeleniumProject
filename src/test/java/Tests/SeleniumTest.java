package Tests;

import Pages.HomePage;
import Pages.ProductsPages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {
    public static WebDriver driver;
    ExtentReports report;
    static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeSuite
    public static void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage","--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

        ExtentSparkReporter spark = new ExtentSparkReporter("docs/reports/ExtentSparkReport.html");
        extent.attachReporter(spark);

        HomePage.click_hamburger_menu();
        HomePage.click_onlineProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException, IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile,Dest );
        return errflpath;
    }

    @Test
    void ValidateTitles_onlineProducts() {
        test = extent.createTest("Validate shoe Titles on Product page", "This test validates that the different shoe types are correct on products page");
        ProductsPages.formalShoes_verifyTitle();
        ProductsPages.sportsShoes_verifyTitle();
        ProductsPages.sneakersShoes_verifyTitle();
    //   extent.flush();
    }

    @Test
    void validateFirstFormalShoes() {
        test = extent.createTest("Validate First formal shoes on Product page", "This test validates first formal shoes on products page");
        ProductsPages.formalShoes_firstShoe_verify();
    }

    @Test
    void validateFirstSportShoes() {
        test = extent.createTest("Validate First sport shoes on Product page", "This test validates first sport shoes on products page");
        ProductsPages.sportsShoes_firstShoe_verify();
    }

    @Test
    void validateFirstSneakerShoes() {
        test = extent.createTest("Validate First sneaker shoes on Product page", "This test validates first sneaker shoes on products page");
        ProductsPages.sneakersShoes_firstShoe_verify();
    }

    @AfterSuite
    public static void cleanup() {
        extent.flush();
    }
}
