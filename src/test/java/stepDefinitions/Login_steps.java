package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.LoggerLoad;

public class Login_steps {

	TestContextSetup context;
	private LoginPage loginPage;

	LoggerLoad loggerLoad;

	public Login_steps(TestContextSetup context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {

		context.launchBrowser();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {

		context.launchUrl();

		String currentUrl = context.getDriver().getCurrentUrl();
		System.out.println("currentUrl: " + currentUrl);
	
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {

		String loginPageTitle = context.getDriver().getTitle();
		Assert.assertNotNull(loginPageTitle, loginPageTitle);
		System.out.println("Login page title: " + loginPageTitle);
	}

	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		
			context.getDriver().get(loginPage.invalid_url);
	}

	@Then("Admin should recieve page not found error")
	public void admin_should_recieve_page_not_found_error() {

		String errorMsg = loginPage.invalidUrlmsg();
		System.out.println("Actual Error msg--->" + errorMsg);
		String expmsg = "This site can’t be reached";
		Assert.assertEquals(errorMsg, expmsg, "Message is not match");
	}

	
	@Then("HTTP response >= {int} the link is broken")
	public void http_response_the_link_is_broken(Integer int1) {
		
		Assert.assertTrue(loginPage.findBrokenLinks(loginPage.ValidateBrokenLinks), "No Broken Links");
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() throws Exception {
		
			loginPage.checkSpelling();
		
	}

	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {
		loginPage.validateimage();

	}

	@Then("Admin should see app name {string}")
	public void admin_should_see_app_name(String exp) {

		loginPage.verifyImageText(exp);

	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {

		loginPage.verifyImageText("NumpyNinja");
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		String text=loginPage.PlsLoginText();
		Assert.assertEquals(text, string);
	}

	@Then("Admin should see {int} text field")
	public void admin_should_see_text_field(Integer int1) {
		int actCount=loginPage.getNumberOFTextboxes( );
		LoggerLoad.info("Actual text field on login Page ---> "+actCount+ " Expected count ---> "+int1);
		Assert.assertEquals(actCount, int1);
	}

	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String string) {
		loginPage.userPlaceHolder();

	}

	@Then("Admin should see field mandatory * symbol next to User text")
	public void admin_should_see_field_mandatory_symbol_next_to_user_text() {
		loginPage.astrikValidationUser();
	}
	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		loginPage.astrikValidationPass();
	}
	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String string) {
		loginPage.passwordPlaceHolder();
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		Assert.assertTrue(loginPage.verifyTextBoxAlignment(), "Not in center");
		
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {

		Assert.assertTrue(loginPage.verifyLoginBtnAlignment(), "Not in center");
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Boolean Loginbtn=loginPage.LoginButton();
		Assert.assertEquals(Loginbtn, true);
		LoggerLoad.info("Admin sees the Login Button");
	}

	@Then("Admin should see Admin in gray color")
	public void admin_should_see_admin_in_gray_color() {
		loginPage.userTextColor();
	}
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		loginPage.passTextColor();
	}
	// ------------------------------- Valid Scenario steps ---------------------------------------
	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
		context.launchUrl();

	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {

		loginPage.Login(context.getPropUsername(), context.getPropPassword());

	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {

		String Title = context.getDriver().getTitle();
		String expTitle = "LMS";
		LoggerLoad.info("Actual title of page ---->" + Title);
		int buttonsDashboard=loginPage.dashboardValidation();
		int expButtons=4;
		Assert.assertEquals(buttonsDashboard,expButtons);
		Assert.assertEquals(Title, expTitle);
		LoggerLoad.info("Both title and Dashboard button verified");
	}
	//------------------------------------------------------------------------------
	@When("Admin enter invalid credentials {string} and {string} clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button(String username, String password) {
		loginPage.InvalidLogin(username, password);
	}

	@Then("Admin get an {string} message")
	public void Admin_get_an_message(String errormsg) {

		String actualMsg=loginPage.errorMsg_up_Invalid();
		String expMsg=errormsg;
		Assert.assertEquals(actualMsg, expMsg);
		LoggerLoad.info("\n Error msg verified \n");
	}

	@Then("Admin Sees {string} message for one text field empty")
	public void admin_sees_message_for_one_text_field_empty(String errormsg) {

		String actualMsg=loginPage.errorMsg_Invalid();
		String expMsg=errormsg;
		Assert.assertEquals(actualMsg, expMsg);
		LoggerLoad.info("\n Error msg verified \n");
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		loginPage.loginBtnKeyboard();

	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		loginPage.loginBtnMouse();
	}


}
