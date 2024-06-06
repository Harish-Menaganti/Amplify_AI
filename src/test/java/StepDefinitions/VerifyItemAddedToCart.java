package StepDefinitions;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utils.CSVReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyItemAddedToCart {
	private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private static WebDriver driver;
    
    public VerifyItemAddedToCart() {
    	homePage = new HomePage(driver);
    	loginPage = new LoginPage(driver);
    	cartPage = new CartPage(driver);
    	checkoutPage = new CheckoutPage(driver);
    	productPage = new ProductPage(driver);  	
    }
     
    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
        
    }


    @Given("Open a web browser")
    public static void openWebBrowser() {
        // No code needed, handled in @Before BasePgae
    }

    @When("Navigate to the Amazon.in website")
    public void navigateToAmazonWebsite() {
        driver.get("https://www.amazon.in/");
    }

    @Then("Verify that the user is on the Amazon.in website")
    public void verifyUserOnAmazonWebsite() {
        assertTrue(homePage.getTitle().contains("Amazon.in"));
    }

    @When("Log in to the user's account")
    public void loginUser() {
        homePage.clickSignIn();
        loginPage.login("9948035130", "Password@123");
    }

    @When("Search for a product and add it to the cart")
    public void searchAndAddToCart() {
        homePage.searchProduct("Iphone 15 case");
        new WebDriverWait(driver, 5);
        productPage.addToCart();
    }

    @When("Click on the cart icon to view the items in the cart")
    public void clickCartIcon() throws InterruptedException {
    	//new WebDriverWait(driver, 5);
    	Thread.sleep(5000);
        homePage.viewCart();
    }

    @Then("Verify that the items are added to the cart")
    public void verifyItemsInCart() throws InterruptedException {
    	Thread.sleep(3000);
        assertTrue(cartPage.isCartNotEmpty());
    }

    @When("Click on the \"Checkout\" button")
    public void clickCheckoutButton() {
        cartPage.clickCheckout();
    }

    @Then("Verify that the user is on the checkout page")
    public void verifyUserOnCheckoutPage() {
        assertEquals("Checkout", checkoutPage.getTitle());
    }

    @When("Select the \"Cash on Delivery\" option as the payment method")
    public void selectCashOnDelivery() {
    	checkoutPage.selectPaymentAddress();
        checkoutPage.selectPaymentMethod("Cash on Delivery");
        checkoutPage.clickOnUseThisPaymentMethod();
    }

    @Then("Verify that the payment method is set to \"Cash on Delivery\"")
    public void verifyPaymentMethod() {
        assertTrue(checkoutPage.getSelectedPaymentMethod().contains("Cash on Delivery"));
    }

    @Then("Verify that a confirmation message for selecting \"Cash on Delivery\" is displayed")
    public void verifyConfirmationMessage() {
        assertTrue(checkoutPage.isConfirmationMessageDisplayed());
    }
    
    

    
}
