package pageObjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import utilities.LoggerLoad;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}
	public String invalid_url="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp2.com/login";
	public String dashboard_page="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/";

	//--------------------WebElement-------------------------------

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameTextBox;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//mat-error[@id='errormessage']")
	private WebElement upInvalidErrorMsg;

	@FindBy(xpath = "//form[@class='ng-invalid ng-touched ng-dirty']")
	private WebElement errorMsg;

	@FindBy (xpath = "//div[@id='main-message']/h1/span") 
	WebElement siteUnreachable;

	@FindBy (xpath = "//span[@class='ng-tns-c78-0 ng-star-inserted']") 
	WebElement userElement;

	@FindBy (xpath = "//span[@class='ng-tns-c78-1 ng-star-inserted']") 
	WebElement passwordElement;

	@FindBy (xpath = "//p[contains(text(),'Please login')]") 
	WebElement plsLoginTextElement;

	@FindBy (xpath = "//span[@class='mat-button-wrapper']") 
	WebElement loginElement;

	@FindBy (xpath = "//img[@class='images']") 
	WebElement image;

	@FindBy (xpath = "//input") 
	List<WebElement> countTxtFieldLogin;

	@FindBy (xpath = "//input[@data-placeholder='User']") 
	WebElement userPlaceholder;

	@FindBy (xpath = "//input[@data-placeholder='Password']") 
	WebElement passwordPlaceholder;

	@FindBy (xpath = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']") 
	WebElement astrikPass;

	@FindBy (xpath = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']") 
	WebElement astrikUser;

	@FindBy (xpath = "//mat-card-content[@class='mat-card-content']")
	WebElement cenAlignText;

	@FindBy (xpath = "//div[@class='ng-star-inserted']/button")
	public static List<WebElement> NoofBtnDashboard;

	@FindBy (xpath = "//link")
	public static List<WebElement> ValidateBrokenLinks;

	//---------------------Methods------------------------------------

	public void Login(String username, String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginBtn.click();

	}

	public void InvalidLogin(String username, String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginBtn.click();
	}

	public String errorMsg_up_Invalid()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return upInvalidErrorMsg.getText();
	}

	public String errorMsg_Invalid()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return plsLoginTextElement.getText();
	}
	public String invalidUrlmsg()
	{
		return siteUnreachable.getText();
	}


	public String PlsLoginText()
	{
		String PL_login = null;
		if(plsLoginTextElement.isDisplayed())
		{
			highlightElement(driver, plsLoginTextElement);
			PL_login=plsLoginTextElement.getText();
			return PL_login;
		}
		else
		{
			LoggerLoad.info("not Displayed");
			return null;
		}
	}


	public Boolean LoginButton()
	{

		Boolean visibleLoginBtn=loginElement.isDisplayed();

		return visibleLoginBtn;
	}



	public void validateimage()
	{

		if(image.isDisplayed())
		{

			String alin=image.getCssValue("text-align");

			int imageHeight=image.getRect().getHeight();
			int imageWidth=image.getRect().getWidth();
			Dimension img= image.getRect().getDimension();

			System.out.println("height is "+imageHeight+" Width is "+imageWidth+" Dimension is :"+img);
			System.out.println("FullimageAlignment resp to browser is"+alin);
			System.out.println("X point "+image.getRect().getPoint().getX()+" Y Point "+image.getRect().getPoint().getY());
			if(image.getRect().getPoint().getX()<200 && image.getRect().getPoint().getY()<300)
			{
				System.out.println("LogoimageAlignment is on left");
			}	
			else
			{
				System.out.println("LogoimageAlignment is not on left");
			}

		}

	}

	public int getNumberOFTextboxes()
	{
		int txtFieldSize= countTxtFieldLogin.size();
		return txtFieldSize;	
	}

	public void userPlaceHolder()
	{
		highlightElement(driver,userPlaceholder);
		if(userPlaceholder.isDisplayed())
		{
			String value=userPlaceholder.getAttribute("data-placeholder");
			if(value.equals("User"))
				LoggerLoad.info("Correct User Placeholder Text--->"+value+ "---> is shown ......PASSED");
		}
		else
		{
			LoggerLoad.info("Correct value for user placeholder is NOT shown ......Failed");
		}
	}

	public void passwordPlaceHolder()
	{
		highlightElement(driver, passwordPlaceholder);
		if(passwordPlaceholder.isDisplayed())
		{
			String value=passwordPlaceholder.getAttribute("data-placeholder");
			if(value.equals("Password"))
				LoggerLoad.info("Correct Password Placeholder Text--->"+value+ "---> is shown ......PASSED");
		}
		else
			LoggerLoad.info("Correct value is NOT shown ......Failed");
	}

	public void astrikValidationPass()
	{
		highlightElement(driver, astrikPass);
		if(astrikPass.isDisplayed())
		{
			String value=astrikPass.getText();
			if(value.equals("*"))
				LoggerLoad.info("Astrick ---> "+value+ " ---> is seen next to password......PASSED");
		}
		else
			LoggerLoad.info("Astrick NOT shown ......Failed");
	}

	public void astrikValidationUser()
	{
		highlightElement(driver, astrikPass);
		String value=astrikUser.getText();
		if(value.equals("*"))
			LoggerLoad.info("Astrick ---> "+value+ " ---> is seen next to User......PASSED");
		else
			LoggerLoad.info("Astrick NOT shown ......Failed");
	}

	public static String rgbaToHex(int r, int g, int b, double a) {
		// Ensure values are within valid ranges
		r = Math.max(0, Math.min(255, r));
		g = Math.max(0, Math.min(255, g));
		b = Math.max(0, Math.min(255, b));
		a = Math.max(0, Math.min(1, a));
		// Convert alpha to 0-255 range
		int alpha = (int) Math.round(a * 255);
		// Format the hex string
		return String.format("#%02x%02x%02x%02x", r, g, b, alpha);
	}


	public void userTextColor()
	{

		String value=userNameTextBox.getCssValue("color");
		String value1=userNameTextBox.getCssValue("outline-color");
		Assert.assertEquals(value,value1);
		LoggerLoad.info("\nColor is verified\n");
	}

	public void passTextColor()
	{

		String value=passwordTextBox.getCssValue("color");

		String hex = rgbaToHex(0, 0, 0, 0.87);
		System.out.println("rgba "+value+" to hex color  :  "+hex);   
		String hexValueExpected = "#000000de";
		Assert.assertEquals(hex,hexValueExpected);
		LoggerLoad.info("color value--->"+value);
		LoggerLoad.info("\nColor is verified\n");
	}

	public void loginBtnKeyboard() {
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER)
		.sendKeys(userNameTextBox,"Sdet@gmail.com")
		.sendKeys(passwordTextBox,"LmsHackathon@2024")
		.moveToElement(loginBtn).click().perform();

	}

	public boolean verifyTextBoxAlignment()
	{
		if(verifyCenterAlignment(userNameTextBox) || verifyCenterAlignment(passwordTextBox))
		{
			LoggerLoad.info("User Alignment");
			verifyCenterAlignment(userNameTextBox);	
			LoggerLoad.info("Password Alignment");
			verifyCenterAlignment(passwordTextBox);	
			return true;
		}
		return false;

	}

	public boolean verifyLoginBtnAlignment()
	{
		return verifyCenterAlignment(loginBtn);	

	}

	private boolean verifyCenterAlignment( WebElement ele) {

		int contWidth= driver.manage().window().getSize().getWidth();

		Point userTxtloc=ele.getLocation();

		int userTxtlocWidth= ele.getRect().getWidth(); //400

		int expectedStartPoint=(contWidth-userTxtlocWidth)/2;  //16

		int actualStartPoint=userTxtloc.getX();

		if(expectedStartPoint==actualStartPoint)
		{
			LoggerLoad.info("In Center");
			System.out.println("expectedStartPoint "+expectedStartPoint+"= actualStartPoint "+actualStartPoint);
			return true;
		}
		else
		{
			LoggerLoad.info("Not In Center");
			System.err.println("expectedStartPoint "+expectedStartPoint+"!= actualStartPoint "+actualStartPoint);
			return false;
		}


	}


	public void loginBtnMouse()
	{
		Actions actions = new Actions(driver);	
		userNameTextBox.sendKeys("Sdet@gmail.com" +Keys.ENTER);
		passwordTextBox.sendKeys("LmsHackathon@2024" +Keys.ENTER);
		actions.contextClick(loginBtn).perform();
	}

	public void verifyImageText(String exp)
	{
		boolean found=false;
		String[] allExtractedLines=appTextExtract();
		for (String singleLine : allExtractedLines) {

			if(singleLine.contains(exp))
			{
				LoggerLoad.info("Expected text is "+exp);
				found=true;
				System.out.println("Test passed");
				break;
			}
		}
		if(!found)
		{
			System.err.println("Test failed");

		}
	}
	public String[] appTextExtract()
	{

		try {
			ITesseract tesseract = new Tesseract();

			String imageURL=image.getAttribute("src");
			URL url=null;
			url=new URL(imageURL);
			System.out.println("Load image URL"+url);
			String datapath ="/Users/ashwini/Downloads/Team2_SeleniumSharks_LMS_UI-main/tessdata";
			tesseract.setDatapath(datapath);
			tesseract.setLanguage("eng");
			BufferedImage image1=ImageIO.read(url);
			String fullLogoText = tesseract.doOCR(image1);
			System.out.println("Full text from image: " + fullLogoText); // full text contains some other things too
			String sp[]=fullLogoText.split("\n");
			System.out.println();
			return sp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int dashboardValidation()
	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		int btnOnDashboard=NoofBtnDashboard.size();
		LoggerLoad.info("These No of buttons seen on Dashboard is ----> "+btnOnDashboard+"\n\n User is on dashboard Page \n");
		return btnOnDashboard;
	}

	//=========================================== Optional ( Used for element to highlight during runtime to understand)======================================================
	public static void highlightElement(WebDriver driver,WebElement element) {
		try {
			String Scolor = "#00FF00";
			int iBlinkCount = 1;
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			if (element!=null)
			{
				String bgcolorOrg  = element.getCssValue("backgroundColor");
				String bgcolor  = ((JavascriptExecutor)driver).executeScript("return arguments[0].style.border;",element).toString();
				for (int i = 0; i < iBlinkCount; i++) 
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow';",element);
					changeColor(Scolor, element, js);
					changeColor(bgcolor, element, js);
					Thread.sleep(550);
					((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '"+bgcolorOrg+"';",element);
				}
				((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '"+bgcolorOrg+"';",element);
			}
		} catch (Exception e) {
		}
	}
	public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
		js.executeScript("arguments[0].style.border='"+color+"';",  element);
		try {
			Thread.sleep(10);
		}  catch (InterruptedException e) {
		}
	}



}
