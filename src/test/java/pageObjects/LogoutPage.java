package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}
	//---------------------------------------- WebElement ----------------------------------------------------
	public String Login_url="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login";
	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutBtn;
	
	//---------------------------------------- Methods---- ---------------------------------------------------
	public void logout()
	{
		if(logoutBtn.isDisplayed() && logoutBtn.isEnabled())
		{
		logoutBtn.click();
		}
	}
}
