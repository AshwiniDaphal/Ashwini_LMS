package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutPage;
import utilities.LoggerLoad;

public class Logout_steps {

	
	TestContextSetup context;
	private LogoutPage logoutPage;

	LoggerLoad loggerLoad;

	public Logout_steps(TestContextSetup context) {
		this.context = context;
		logoutPage = context.getLogoutPage();
	}
	
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		logoutPage.logout();
		LoggerLoad.info("clicked Logout Button");
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		context.getDriver().navigate().to(context.launchAppUrl());
		String actualUrl=context.launchAppUrl();
		Assert.assertEquals(logoutPage.Login_url,actualUrl,"Admin not on login page");
		LoggerLoad.info("Test passed Currently Admin on login page");
	}

	@Given("Admin is logged out of the application")
	public void admin_is_logged_out_of_the_application() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logoutPage.logout();
		LoggerLoad.info("clicked Logout Button");
		context.getDriver().navigate().to(context.launchAppUrl());
		LoggerLoad.info("Currently Admin on login page");
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		String actTitle=context.getDriver().getTitle();
		String expTitle ="LMS";
		Assert.assertEquals(actTitle, expTitle, "User is not on login page");
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		context.getDriver().navigate().back();		
		LoggerLoad.info("Admin clicked on back Button");
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
	   boolean expErrorMsg=true;
	   Assert.assertEquals(false,expErrorMsg,"Admin do not get any Error message---->Test Failed");
	
	}

}
