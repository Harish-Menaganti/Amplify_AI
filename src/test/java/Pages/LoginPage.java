package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	
	@FindBy(id = "ap_email")
	private WebElement emailInput;

	@FindBy(id = "ap_password")
	private WebElement passwordInput;

	@FindBy(id = "signInSubmit")
	private WebElement signInButton; 

	@FindBy(id = "continue")
	private WebElement continueBtn; 

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	    emailInput.sendKeys(email);
	    continueBtn.click();
	    passwordInput.sendKeys(password);
	    signInButton.click();
	}
}