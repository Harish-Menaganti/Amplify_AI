package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage{


	@FindBy(id = "sc-active-cart")
	private WebElement cartContainer;

	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToBuyBtn;

	public CartPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}

	public boolean isCartNotEmpty() {
	    return cartContainer.isDisplayed();
	}

	public void clickCheckout() {
	    proceedToBuyBtn.click();
	}
}
