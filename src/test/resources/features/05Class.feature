Feature: Navigating the class module
Background: 
    Given Admin is logged in to LMS Portal
    
@NavigationonClass1
Scenario: Class link on navigation bar	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on Class link on Manage Class page	
Then Admin is re-directed to class page

@NavigationonClass2
Scenario: Class link to other module on navigation bar	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on any module link on Manage Class page	
Then Admin is re-directed to which module link they clicked

@NavigationonClass3
Scenario: Logout link on navigation bar	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on Logout link on Manage class page	
Then Admin is re-directed to Login page


@sortBatchName
Scenario: Sort Class by Batch name	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page
When Admin clicks on the Batch name sort icon	
Then Admin should see Class details are sorted by Batch Name

@sortClasstopic
Scenario: Sort Class by Class topic	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on the Class topic sort icon	
Then Admin should see Class details are sorted by Class Topic

@sortClassDescreption
Scenario: Sort Class by Class Descreption
Given Admin is on dashboard page after Login and clicks Class on the navigation bar	
And Admin is on Manage Class page	
When Admin clicks on the Class descreption  sort icon	
Then Admin should see Class details are sorted by Class Descreption

@sortClassStatus
Scenario: Sort Class by Status	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on the Status sort icon	
Then Admin should see Class details are sorted by Status

@sortClassDate
Scenario: Sort Class by Class date	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on the Class Date sort icon	
Then Admin should see Class details are sorted by Class Date

@sortClassstaff
Scenario: Sort Class by staff name	
Given Admin is on dashboard page after Login and clicks Class on the navigation bar
And Admin is on Manage Class page	
When Admin clicks on the Staff Name sort icon	
Then Admin should see Class details are sorted by Staff name

Scenario: Validating the class manage page
    Then Admin should land on the Manage class page

  Scenario: Validating the Title in the Manage class page
    Then Admin should see the "LMS-Learning Management System" Title

  Scenario: Validating the Header in the Manage class page
    Then Admin should see the "Manage Class" Header

  Scenario: Validating Search bar in class page
    Then Admin should see the Searchbar in Manage class page

  Scenario: Validating the data table headers in the class page
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit/Delete

  Scenario: Validating the text and pagination icon in the class page
    Then Admin should see the "showing x to y of z entries" and enabled pagination controls under the data table

  Scenario: Validate the sort icon of all the fields in the datatable
    Then Admin should see the Sort icon of all the fields in the datatable

  Scenario: Validating the Delete button under the Manage class
    Then Admin should see the "Delete button" under the Manage class page header

  Scenario: Validate the total number of classes in the manage class page
    Then Admin should see the Total number of classes below the data table

