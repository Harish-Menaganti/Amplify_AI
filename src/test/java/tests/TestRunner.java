package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import StepDefinitions.VerifyItemAddedToCart;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature", glue = "StepDefinitions")
public class TestRunner {
	private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        VerifyItemAddedToCart.setDriver(driver);
    }

    @AfterClass
    public static void tearDown() {
        // Close the browser window
        driver.quit();
    }

   
}