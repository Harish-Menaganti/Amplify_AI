package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(id = "a-autoid-1-announce")
	private WebElement addToCartButton;

	public ProductPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}

	public void addToCart() {
	    addToCartButton.click();
	}
}
