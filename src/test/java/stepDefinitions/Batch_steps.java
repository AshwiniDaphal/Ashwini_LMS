package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;

public class Batch_steps {

	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private BatchPage batchPage;
	
	public Batch_steps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
		this.batchPage = context.getBatchPage();
		
		
	}
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
		batchPage.checkDashBoard();
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		batchPage.clickheaderBatchButton();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	   context.getbatchURL();
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String titleLMS) {
	batchPage.checkLMSTitle(titleLMS);
	   
	}
	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String mngBatTitle) {
	   batchPage.checkManageBatchTitle(mngBatTitle);
	}
	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
	   batchPage.checkDeleteIcon();
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	    batchPage.checkPagination();
	}
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		batchPage.checkEditIconOnEachRow();
	}
	
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		batchPage.checkDeleteIconOnEachRow();
	}
	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	   batchPage.checkBatchNameHeader();
	   batchPage.checkBatchDescHeader();
	   batchPage.checkBatchStatusHeader();
	   batchPage.checkNoOfClassesHeader();
	   batchPage.checkPgMNameHeader();
	   batchPage.checkEditDeleteHeader();
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
	   batchPage.checkHeaderCheckBox();
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		batchPage.checkSortIcons();
	}
	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() {
		// context.getbatchURL();
		batchPage.clickheaderBatchButton();
		 batchPage.justClick();
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String addNewBtText) {
		batchPage.checkAddNewBatchBtn(addNewBtText);
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
	   batchPage.clickAddNewBatchBtn();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		batchPage.checkbatchDtlsPopup();
		//batchPage.getPaginationSize();
	}
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
	   batchPage.paginationValidation();
	}
	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
		//batchPage.paginationNextArrowLinkEnabled();
	}

	@Given("Admin is on the Add new batch pop up")
	public void admin_is_on_the_add_new_batch_pop_up() {
		context.getbatchURL();
		batchPage.clickAddNewBatchBtn();
	}
	@Given("Admin is on the Batch Details Pop Up WIndow")
	public void admin_is_on_the_batch_details_pop_up_w_indow() {
		batchPage.batchPOPup();
	}
	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
		batchPage.checkPopUpFields();
	}
	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		batchPage.checkPopUpFormComponents();
	}
	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		batchPage.clickDropdown();
	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
	    
	}
	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		batchPage.batcnamesendkeys();
		
	}
	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		batchPage.checkBatNameErromsg();
	}
	
	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		batchPage.batchprefixtextbox();
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		batchPage.batchprefixtextboxreadonly();
	}

	@When("Admin enters the data only to the mandatory fiields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fiields_and_clicks_save_button() {
		batchPage.manadatoryFieldcheck();
		batchPage.clickSave();
	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
		batchPage.successMsg();
	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
	   batchPage.errmsgCheckformanadatoryField();
	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
	   // batchPage.pgmNameFieldRqdErrMsgcheck();
		List<String> expectedOrderOfModuleNames = List.of("Program Name is required.", "Batch Name is required.", "Batch Description is required.", "Status is required.","Number of classes is required.");

		System.out.println("expectedOrderOfModuleNames: " + expectedOrderOfModuleNames);

		List<String> currentOrderOfModuleNames = batchPage.errmsgCheckformanadatoryField();

		System.out.println("currentOrderOfModuleNames: " + currentOrderOfModuleNames);

		System.out.println("Admin is able to see the required msgs");

		Assert.assertEquals(currentOrderOfModuleNames, expectedOrderOfModuleNames,
				"The module names are not in the expected order.");// Assert.assertEquals(actual,expected,"error msg")
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
	   
	}

	@Then("Admin should get a succesesful message")
	public void admin_should_get_a_succesesful_message() {
	   
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		batchPage.manadatoryFieldcheck();
		batchPage.clickCancelBtn();
	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		batchPage.batcjDtlsPopupClose();
	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {
		batchPage.clickCloseIcon();
	}

	@Then("batch details pop up closes")
	public void batch_details_pop_up_closes() {
		batchPage.popupCloses();
	}
	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {
		
		batchPage.clicktddeleteIcon();
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		batchPage.confirmDialog();
	}

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
		batchPage.clicktddeleteIcon();
		batchPage.confirmDialog();
	}

	@When("Admin clicks on the delete icon and click yes buttton")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton() {
		batchPage.clickDeletYesBtn();
	}

	@Then("Admin should see the successfull message and the batch should be deleted")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted() {
		batchPage.deleteSuccessMessage();
	}

	@When("Admin clicks on the delete icon and click no buttton")
	public void admin_clicks_on_the_delete_icon_and_click_no_buttton() {
		batchPage.clickDeletNoBtn();
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		context.getbatchURL();
		Assert.assertTrue(batchPage.searchbox());
		//Assert.assertFalse(batchPage.deletealertboxClosed());	
		}

	@When("Admin clicks on the close icon of delete alert")
	public void admin_clicks_on_the_close_icon_of_delete_alert() {
		batchPage.deletealertcross();
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
	  context.getbatchURL();
	}

	@Given("Admin is on the batch page")
	public void admin_is_on_the_batch_page() {
	    
	}

	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
		
	  //-------------To Select Top 3 Check Boxes-----------------
		for(int i=1; i<=3; i++){
			batchPage.clickMultipleCheckBoxesOfProgramTable(i);}
			batchPage.clickTopLeftDeleteIcon();		
	}
	

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
		Assert.assertTrue(batchPage.searchbox());
	}

	

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
	 batchPage.clickeditIcon();
	}

	@Then("Admin should see the Batch Details pop up window for edit")
	public void admin_should_see_the_batch_details_pop_up_window_for_edit() {
		batchPage.editDialog();
	}


	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
	   batchPage.pgmFieldDisabledforediting();
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		batchPage.batchNmeFieldDisabledforediting();
	}

	@When("Admin enters the batch name in the serach text box")
	public void admin_enters_the_batch_name_in_the_serach_text_box() {
		batchPage.sendValuetosearchbox();
	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
	  Assert.assertTrue(batchPage.searchfilteredresults());
	}

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
		batchPage.clicklogoutBtn();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
	   context.getLoginPage();
	}





}
