package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
   

	private WebDriver driver;

	@FindBy(id = "nav-link-accountList")
	private WebElement signInLink;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchInput;

	@FindBy(id = "nav-cart")
	private WebElement cartIcon;

	public HomePage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	public String getTitle() {
	    return driver.getTitle();
	}

	public void clickSignIn() {
	    signInLink.click();
	}

	public void searchProduct(String productName) {
	    searchInput.sendKeys(productName);
	    searchInput.submit();
	}

	public void viewCart() {
	    cartIcon.click();
	}
}

