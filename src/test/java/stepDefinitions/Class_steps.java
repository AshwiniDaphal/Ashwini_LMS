package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;
import pageObjects.LoginPage;
import utilities.LoggerLoad;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class Class_steps {

	private TestContextSetup context;
	private LoginPage loginPage;
	private ClassPage classPage;

	public Class_steps(TestContextSetup context) {
		this.context = context;
		this.classPage = context.getClassPage();
		this.loginPage = context.getLoginPage();
	}

	//---------------------------- Navigation --------------------------------------

	@Given("Admin is on dashboard page after Login and clicks Class on the navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_clicks_class_on_the_navigation_bar() throws InterruptedException {
		classPage.justClick();
		String Title = context.getDriver().getTitle();
		classPage.getClass_Dashboard_Button().click();
		
		classPage.justClick();
		Thread.sleep(2000);
	}

	@Given("Admin is on Manage Class page")
	public void admin_is_on_manage_class_page() {
		classPage.justClick();
		String actual=context.getDriver().getCurrentUrl();

		Assert.assertEquals(actual,classPage.getManage_Class_Pg() , "Admin is not on correct URL");
	}

	@When("Admin clicks on Class link on Manage Class page")
	public void admin_clicks_on_class_link_on_manage_class_page() {
		classPage.getClass_Dashboard_Button().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("Admin is re-directed to class page")
	public void admin_is_re_directed_to_class_page() throws InterruptedException {

		classPage.justClick();
		Thread.sleep(2000);
		String actUrl=context.getDriver().getCurrentUrl();
		String expUrl=classPage.getManage_Class_Pg();
		Assert.assertEquals(actUrl, expUrl,"Not on class page Taking time to load Dom");

		//---------------- try with this too
		//		class="mat-focus-indicator mat-menu-trigger mat-button mat-button-base"
		//		class="mat-focus-indicator mat-menu-trigger mat-button mat-button-base cdk-focused cdk-mouse-focused"

	}


	static java.util.Map<String,String> linksMap;

	@When("Admin clicks on any module link on Manage Class page")
	public void admin_clicks_on_any_module_link_on_manage_class_page() throws InterruptedException {
		classPage.justClick();
		linksMap= classPage.Navi_Modules();
	
	}

	@Then("Admin is re-directed to which module link they clicked")
	public void admin_is_re_directed_to_which_module_link_they_clicked() {
	
		for(String menu : linksMap.keySet() )
		{
			System.out.println("menu : "+menu);
			System.out.println("utl : "+linksMap.get(menu));

			if(linksMap.get(menu).toLowerCase().endsWith("/"+menu))
			{
				System.out.println(menu+ " : Pass");
			}
			else
			{
				System.out.println(menu+ " : Fail");
				
			}
		}
	}

	@When("Admin clicks on Logout link on Manage class page")
	public void admin_clicks_on_logout_link_on_manage_class_page() {
		classPage.getLogoutBtn().click();
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
		Assert.assertEquals(context.getDriver().getCurrentUrl(), context.launchAppUrl(),"Url not matched"); 
		LoggerLoad.info("Test Passed");

	}

	//------------------ Sorting ------------------------
	

	@When("Admin clicks on the Batch name sort icon")
	public void admin_clicks_on_the_batch_name_sort_icon() {
		classPage.getSortBatchNames().click();
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
		Assert.assertTrue(classPage.sortBatchName(),"Batch Name is not sorted Ascending order\\/Descending order");

	}

	@When("Admin clicks on the Class topic sort icon")
	public void admin_clicks_on_the_class_topic_sort_icon() {
		classPage.getClassTopicHeader().click();
	}

	@Then("Admin should see Class details are sorted by Class Topic")
	public void admin_should_see_class_details_are_sorted_by_class_topic() {
		Assert.assertTrue(classPage.sortClassTopic(),"Class Topic is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on the Class descreption  sort icon")
	public void admin_clicks_on_the_class_descreption_sort_icon() {
		classPage.getClassDescriptionHeader().click();
	}

	@Then("Admin should see Class details are sorted by Class Descreption")
	public void admin_should_see_class_details_are_sorted_by_class_descreption() {
		Assert.assertTrue(classPage.sortClassDescription(),"class description is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on the Status sort icon")
	public void admin_clicks_on_the_status_sort_icon() {
		classPage.getStatusHeader().click();
	}

	@Then("Admin should see Class details are sorted by Status")
	public void admin_should_see_class_details_are_sorted_by_status() {
		Assert.assertTrue(classPage.sortStatus(),"Status is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on the Class Date sort icon")
	public void admin_clicks_on_the_class_date_sort_icon() {
		classPage.getClassDateHeader().click();
	}

	@Then("Admin should see Class details are sorted by Class Date")
	public void admin_should_see_class_details_are_sorted_by_class_date() {
		Assert.assertTrue(classPage.sortClassDate(),"ClassDate is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on the Staff Name sort icon")
	public void admin_clicks_on_the_staff_name_sort_icon() {
		classPage.getStaffNameHeader().click();
	   
	}

	@Then("Admin should see Class details are sorted by Staff name")
	public void admin_should_see_class_details_are_sorted_by_staff_name() {
		Assert.assertTrue(classPage.sortStaff(),"Staff Name is not sorted Ascending order\\/Descending order");
	}
	

//	//----------------------------------------------Nazia shruti------------------------------------------------------------
//
//	
//	
//    @Given("Admin is on the dashboard page after login")
//    public void admin_is_on_the_dashboard_page_after_login() throws InterruptedException {
//        context.launchBrowser();
//        context.launchUrl();
//        loginPage.Login(context.getPropUsername(),context.getPropPassword());
//        Thread.sleep(2000);
//        System.out.println("Admin is on Dashboard page after logged in");
//    }
//    @When("Admin clicks the Class Navigation bar in the Header")
//    public void admin_clicks_the_class_navigation_bar_in_the_header() {
//        classPage.getClassBtn().click();
//    }
//
//    @Then("Admin should land on the Manage class page")
//    public void admin_should_land_on_the_manage_class_page() {
//        
//        assertTrue(classPage.getManageClassTitle().isDisplayed());
//        System.out.println("Admin is on the Manage class page");
//    }
//
//    @Then("Admin should see the {string} Title")
//    public void admin_should_see_the_title(String string) {
//        classPage.getLmsTitle().isDisplayed();
//        assertTrue(classPage.getLmsTitle().isDisplayed());
//        System.out.println("Admin should see the LMS - Learning Management System Title");
//    }
//
//    @Then("Admin should see the {string} Header")
//    public void admin_should_see_the_header(String string) {
//        boolean isDisplayed = classPage.getManageClassTitle().isDisplayed(); 
//        assertTrue(isDisplayed, "The Manage Class header is not displayed.");
//        System.out.println("Admin should see the Manage Class Title");
//    }
//
//    @Then("Admin should see the Searchbar in Manage class page")
//    public void admin_should_see_the_searchbar_in_manage_class_page() {
//        boolean isDisplayed = classPage.getSearchTextBox().isDisplayed();
//        assertTrue(isDisplayed, "The search bar is not displayed on the Manage class page.");
//        System.out.println("Admin should see the Searchbar in Manage class page");
//    }
//
//    @Then("Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit\\/Delete")
//    public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
//        boolean areHeadersDisplayed = classPage. areHeadersDisplayed();
//        assertTrue(areHeadersDisplayed, "The headers are not displayed on the Manage class page.");
//        System.out.println("Headers are displayed on the Manage class page.");
//    }
//
//
//    @Then("Admin should see the {string} and enabled pagination controls under the data table")
//    public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
//    classPage.checkPagination();
//
//    }
//
//    @Then("Admin should see the Sort icon of all the fields in the datatable")
//    public void admin_should_see_the_sort_icon_of_all_the_fields_in_the_datatable() {
//        classPage.verifySortIcons();
//    }
//
//
//    @Then("Admin should see the {string} under the Manage class page header")
//    public void admin_should_see_the_under_the_manage_class_page_header(String string) {
//        classPage.checkDeleteIcon();
//    }
//
//    @Then("Admin should see the Total number of classes below the data table")
//    public void admin_should_see_the_total_number_of_classes_below_the_data_table() {
//        String totalClassesText = classPage.getTotalClassesText();
//        assertTrue(totalClassesText.contains("Total there are 7 Classes"), "The total classes text is not displayed.");
//        System.out.println("Admin should see the Total number of classes below the data table");
//    }
//
}
