package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.DashboardPage;
import utilities.LoggerLoad;

public class Dashboard_steps {

	TestContextSetup context;
	private DashboardPage dashboardPage;

	LoggerLoad loggerLoad;

	public Dashboard_steps(TestContextSetup context) {
		this.context = context;
		dashboardPage = context.getDashboardPage();
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(long time) {

		Assert.assertTrue(dashboardPage.navigationTime()<=time,"Time Exceeds 30 second");
		LoggerLoad.info("Test Pass");
	}
	@Then("Admin should see correct spelling and {int} space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title(Integer int1) throws Exception {

		Assert.assertEquals(dashboardPage.spellAndSpaceLMS(), int1,"Test failed No of spaces not matched");
		System.out.println("Test Passed");

	}
	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		dashboardPage.LMSAppName.getText();
		Assert.assertTrue(dashboardPage.LMSAppName.isDisplayed(),"LMS -Learning management system is not displayed");

	}
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		Assert.assertTrue(dashboardPage.alignNavBarTextModule(), "Nav Bar Text title is on Left");

	}
	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws Exception {

		System.out.println("Admin is on page :"+context.getDriver().getCurrentUrl());

		dashboardPage.checkSpelling();

	}
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {

		Assert.assertTrue(dashboardPage.alignLmsTitle(), "Lms title is on right");
	}
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {

	}
	@Then("Admin should see Home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
		Assert.assertTrue(dashboardPage.checkModuleInd(1, "Home"),"Not found at given location");
	}
	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		Assert.assertTrue(dashboardPage.checkModuleInd(2, "Program"),"Not found at given location");
	}
	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {

		Assert.assertTrue(dashboardPage.checkModuleInd(3, "Batch"),"Not found at given location");

	}
	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
		Assert.assertTrue(dashboardPage.checkModuleInd(4, "Class"),"Not found at given location");

	}
	@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() {
		Assert.assertTrue(dashboardPage.checkModuleInd(5, "Logout"),"Not found at given location");
	}
	
	

}
