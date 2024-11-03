Feature: Batch Page Navigation 

Background: 
Given Admin is logged in to LMS Portal

@batchNavigation
Scenario: Verify Admin Navigate to Batch page successfully
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should be in the Manage Batch Page
@batchNavigation2
Scenario: Validate "Title" in Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the "LMS-Learning Management System" Title
@batchNavigation3
Scenario: Validate "heading" in the Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the "Manage Batch" Heading
@batchNavigation4
Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the disabled "Delete Icon" under the header
@batchNavigation6
Scenario: Validate pagination in the Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the enabled pagination controls under the data table
@editicon
Scenario: Validate edit icon in each data rows
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the edit icon in each row
@deleteicon
Scenario: validate delete icon in each data rows
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the delete icon in each row
@tableheaders
Scenario: Validate Datatable headers
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete
@chekbox
Scenario: Validate "Checkbox" in the Datatable header row
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the checkbox  in the datatable header row
@sorticon
Scenario: Validate "sort icon" next to all the datatable header
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the sort icon next to all Datatable headers

##########################ADD NEW BATCH FEATURE#######################################
@addNewBtach1
Scenario: Verify sub menu displayed in batch menu bar
Given Admin is on batch page
When Admin Clicks on the Batch menu from the header 
Then Admin should see sub menu in menu bar as "Add New Batch"

@addNewBtach2
Scenario: Validate Admin able to click on the Add new Batch Option
Given Admin is on the Dashboard Page
When Admin clicks on "Add New batch" under the "batch" menu bar
Then Admin should see the Batch Details pop up window


##########################PAGINATION######################
@pagination
Scenario: Validate next page link
Given Admin is on batch page
When Admin clicks next page link on the data table
Then Admin should see the Next enabled link
@addnewBatch
Scenario: Validate all the fields exist in pop up 
Given Admin is on the Add new batch pop up
And  Admin is on the Batch Details Pop Up WIndow
When Admin checks all the fields are enabled
Then The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down Status as radio button
@selectDropdown
Scenario: Validate batchname prefix selected program name
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin selects program name present in the dropdown
Then Admin should see selected program name in the batch name prefix box
@errormsg
Scenario: Validate batch name suffix box should accept only numbers
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name suffix box
Then Admin should get error message below the text box of respective field
@readonlytextbox
Scenario: Validate batch name prefix box is not editable
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name prefix box
Then Admin should see empty text box
@successmsg
Scenario: Validate input data only for mandatory fields
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin enters the data only to the mandatory fiields and clicks save button
Then Admin should get a successful message
@softAssert
Scenario: validate input data missing for mandatory fields
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin leaves blank one of the mandatory fields
Then Admin should get a error message on the respective mandatory field
@saveBtn
Scenario: validate save button in Batch details pop up
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin enters the valid data to all the mandatory fields and click save button 
Then Admin should get a succesesful message
@cancelBtn
Scenario: validate cancel button in Batch details pop up
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin enters the valid data to all the mandatory fields and click cancel button 
Then Admin can see the batch details popup closes without creating any batch
@closeIcon
Scenario: validate close icon on the batch details pop up
Given Admin is on the Add new batch pop up
And Admin is on the Batch Details Pop Up WIndow
When Admin clicks on the close icon
Then batch details pop up closes 

################Delete Batch################
@deleteBat
Scenario: validate delete Icon on any row
Given Admin is on batch page
When Admin clicks the delete Icon on any row
Then Admin should see the confirm alert box with yes and no button
@deleteYesBtn
Scenario: Validate yes button on the confirm alert box
Given Admin is on batch page
And Admin is on the batch confirm popup page
When Admin clicks on the delete icon and click yes buttton
Then Admin should see the successfull message and the batch should be deleted
@deleteNoBtn
Scenario: validate no button on the confirm alert box
Given Admin is on batch page
And Admin is on the batch confirm popup page
When Admin clicks on the delete icon and click no buttton
Then Admin should see the alert box closed and the batch is not deleted
@deleteClosed--
Scenario: validate close Icon on the alert box
Given Admin is on batch page
And Admin is on the batch confirm popup page
When Admin clicks on the close icon of delete alert 
Then Admin should see the alert box closed 

#########Delete Multiple Batches##########
@multipledelete
Scenario: Validate single row delete with checkbox
Given Admin is on batch page
When Admin clicks on the delete icon under the Manage batch header
Then The respective row in the table should be deleted



###############Edit Batch#######
@editBatch
Scenario: Validate Edit icon feature in any row
Given Admin is on batch page
When Admin clicks the edit icon
Then Admin should see the Batch Details pop up window for edit
@editBatch1
Scenario: Validate program name  value is disabled to edit
Given Admin is on batch page
When Admin clicks the edit icon
Then Admin should see Program name value field is disabled for editing
@editBatch2
Scenario: Validate batch name  value is disabled to edit
Given Admin is on batch page
When Admin clicks the edit icon
Then Admin should see batch name value field is disabled for editing

##########Search Text Box Validation#####
@search
Scenario: validate serach box functionality
Given Admin is on batch page
When Admin enters the batch name in the serach text box
Then Admin should see the filtered batches in the data table


########Logout#######
@logout
Scenario: Validate logout option in the header is visible and enabled from the batch page
Given Admin is on the batch page
When Admin clicks on the logout button
Then Admin should see the Login screen Page
