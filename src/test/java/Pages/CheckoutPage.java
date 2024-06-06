package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage  {
	
	@FindBy(xpath = "//h1[contains(text(),'Checkout')]")
	private WebElement pageTitle;

	@FindBy(xpath = "//span[contains(text(),'Cash on Delivery/Pay on Delivery')]")
	private WebElement cashOnDeliveryOption;

	@FindBy(id = "confirmation-message")
	private WebElement confirmationMessage;

	@FindBy(id = "shipToThisAddressButton")
	private WebElement selectAddress;

	@FindBy(name = "ppw-widgetEvent:SetPaymentPlanSelectContinueEvent")
	private WebElement useThisPaymentMethod;

	public CheckoutPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}

	public String getTitle() {
	    return pageTitle.getText();
	}

	public void selectPaymentAddress() {
	    selectAddress.click();
	}

	public void selectPaymentMethod(String paymentMethod) {
	    cashOnDeliveryOption.click();
	}

	public String getSelectedPaymentMethod() {
	    return cashOnDeliveryOption.getText();
	}

	public void clickOnUseThisPaymentMethod() {
	    useThisPaymentMethod.click();
	}

	public boolean isConfirmationMessageDisplayed() {
	    return confirmationMessage.isDisplayed();
	}
}
	
	


