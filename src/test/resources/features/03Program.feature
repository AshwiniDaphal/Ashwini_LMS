@Team2_SeleniumSharks_LMS_UI
Feature: In Program module Navigation

  Background: 
    Given Admin is logged in to LMS Portal

  @Navigation
  Scenario: Verify that Admin is able to navigate to Program module
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program module

  @SortingProgramName
  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
		
  @SortingProgramDescription
  Scenario: Verify sorting of  Program Description in  Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		
  @SortingProgramstatus
  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
		
@MenuBar1
  Scenario: Verify any broken links on program page
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should not have any broken links for Program module

  @MenuBar2
  Scenario: Verify heading in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading LMS - Learning Management System

  @MenuBar3
  Scenario: Verify other modules name displayed in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the module names as in order Program, Batch, Class, Logout

  @MenuBar4
  Scenario: Verify Logout displayed in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Logout in menu bar

  @MenuBar5
  Scenario: Verify sub menu displayed in program menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see sub menu in menu bar as Add New Program

  @ManageProgramPageValidation1
  Scenario: Verify heading in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading Manage Program

  @ManageProgramPageValidation2
  Scenario: Verify view details of programs
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should able to see Program name, description, and status for each program

  @ManageProgramPageValidation3
  Scenario: Verify the Multiple Delete button state
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled

  @ManageProgramPageValidation4
  Scenario: Verify the Search button
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar with text as "Search..."

  @ManageProgramPageValidation5
  Scenario: Verify column header name of data table
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete

  @ManageProgramPageValidation6
  Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header as

  @ManageProgramPageValidation7
  Scenario: Verify checkboxes default state beside each Program names in the data table
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  @ManageProgramPageValidation8
  Scenario: Verify Sort icon in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  @ManageProgramPageValidation9
  Scenario: Verify edit and delete icon in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

  @ManageProgramPageValidation10
  Scenario: Verify pagination icons below data table in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page, y-ending record number on that page, z-Total number of records

  @ManageProgramPageValidation11
  Scenario: Verify footer message in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as In total there are z programs. z- Total number of records

  @MenuBarProgramAddNewProgram1
  Scenario: Verify add New Program
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin clicks on New Program under the Program menu bar
  # Then Admin should see pop up window for program details
    Then Admin should see window title as Program Details
  @MenuBarProgramAddNewProgram2
  Scenario: Verify title of the pop up window
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin clicks on New Program under the Program menu bar
    Then Admin should see window title as Program Details

  @MenuBarProgramAddNewProgram3
  Scenario: Verify mandatory fields with red "*" mark
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin clicks on New Program under the Program menu bar
    Then Admin should see red star mark beside mandatory field Name

  @MenuBarProgramAddNewProgram4
  Scenario: Verify empty form submission
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks save button without entering mandatory
    Then Admin gets message field is required

  @MenuBarProgramAddNewProgram5
  Scenario: Verify cancel button
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears

  @MenuBarProgramAddNewProgram6
  Scenario: Verify enter program name
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enters the Name in the text box
    Then Admin can see the text entered

  @MenuBarProgramAddNewProgram7
  Scenario: Verify enter description
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enters the Description in text box
    Then Admin can see the text entered in description box

  @MenuBarProgramAddNewProgram8
  Scenario: Verify select Status
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin selects the status of the program by clicking on the radio button Active/InActive
    Then Admin can see Active/Inactive status selected

  @MenuBarProgramAddNewProgram9
  Scenario Outline: Verify Admin is able to save the program details
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enter valid details for mandatory fields <ProgramName>,<ProgramDescription>,<ProgramStatus> and Click on save button
    Then Admin gets message <Message>

    Examples: 
      | ProgramName        | ProgramDescription | ProgramStatus | Message      |
      | "proDetailsNameU"  | "proDetails Desc"  | "Active"      | "Successful" |
      | "proDetailsNameV"  | "proDetails Desc"  | "Inactive"    | "Successful" |
      | "proDetailsName6 " | "proDetails Desc"  | "Active"      | "Failed"     |
      | "proDetailsName6 " | "proDetails Desc"  | "Inactive"    | "Failed"     |

  @MenuBarProgramAddNewProgram10
  Scenario: Verify cancel program details
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see program details form disappear

  @MenuBarProgramAddNewProgram11
  Scenario: Verify added Program is created
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin searches with newly created Program Name
    Then Records of the newly created Program Name is displayed and match the data entered

  @MenuBarProgramAddNewProgram12
  Scenario: Verify close window with "X"
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin Click on Cross button
    Then Admin can see program details form disappear
		
		
	