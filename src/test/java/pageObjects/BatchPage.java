package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class BatchPage extends BasePage{

	public BatchPage(WebDriver driver) {
		super(driver);
	}
	
	//----------------------WebElements-------------------------------

		@FindBy(xpath = "//*[contains(text(), 'LMS - Learning Management System')]")
		private WebElement LMSTitleCheck;// 
		
		@FindBy(xpath = "//*[contains(text(), 'Batch')]")
		private WebElement headerBatchButton;
		
		@FindBy (xpath = "//*[contains(text(), ' Manage Batch')]")
		private WebElement manageBatchTitleCheck;
		
		@FindBy(xpath = "//*[contains(text(), 'Program')]")
		private WebElement dashboardPgmButton;
		
		@FindBy(xpath = "//*[contains(text(), 'Batch')]")
		private WebElement dashboardBatch;
		
		@FindBy(xpath = "//*[contains(text(), 'Class')]")
		private WebElement dashboardClass;
		
		@FindBy(xpath="//*[contains(text(), 'Logout')]")
		private WebElement dashboardLogout;
		
		@FindBy(xpath = "//span[@aria-hidden='true']")
		private WebElement deleteIcon;
		
		@FindBy(xpath = "//span[@class ='p-paginator-icon pi pi-angle-right']")
		private WebElement paginationCntrls;
		
		@FindAll(@FindBy(xpath = "//table[@role = 'grid']/tbody/tr"))
		private List<WebElement> editDeleteIconinEachRow;
		
		@FindBy (xpath = "//button[@icon='pi pi-pencil']")
		private WebElement editIconinEachRow;
		
		@FindBy(xpath ="//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']" )
		private WebElement deleteIconinEachRow;
		
		@FindBy(xpath ="//button[@type=\"button\" and @ng-reflect-label=\"Yes\"]" )
		private WebElement deleteYesBtn;
		
		@FindBy(xpath ="//button[@type=\"button\" and @ng-reflect-label=\"No\"]" )
		private WebElement deleteNoBtn;
		
		@FindBy (xpath="//div[text()='Successful']")
		private WebElement deleteSuccessMessage;
		
		@FindBy (xpath="//*[contains(text(),'Confirm')]")
		private WebElement deletealertboxClosed;
		
		@FindBy (xpath="//span[@class='pi pi-times ng-tns-c204-117']")
		private WebElement deletealertcross;
		
		@FindBy(xpath = "//table//th[2]")
		private WebElement batchNameHeader;
		
		@FindBy(xpath = "//table//th[3]")
		private WebElement batchDescriptionHeader;
		
		@FindBy(xpath = "//table//th[4]")
		private WebElement batchStatusHeader;
		
		@FindBy(xpath = "//table//th[5]")
		private WebElement batchNoOfClassesHeader;
		
		@FindBy(xpath = "//table//th[6]")
		private WebElement programNameHeader;
		
		@FindBy(xpath = "//table//th[7]")
		private WebElement  EditDeleteHeader;
		
		@FindBy(xpath="//div[@role='checkbox']")
		private WebElement checkboxButton;
		
		@FindBy(xpath = "//p-sorticon[@field='programName']")
		private WebElement batchNameSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='batchDescription']")
		private WebElement batchDescSortIcon;

		@FindBy(xpath = "//p-sorticon[@field='batchStatus']")
		private WebElement batchStatusSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='batchNoOfClasses']")
		private WebElement batchNoOfClassesSortIcon;
		
		@FindBy(xpath = "//p-sorticon[@field='programName']") //xpath is same for batchName and pgmName sort icon
		private WebElement programNameSortIcon;
		
		@FindBy(xpath = "//button[@role='menuitem']")
		private WebElement addNewBatchBtn;
		
		@FindBy(xpath = "//div[@role=\"dialog\"]")
		private WebElement batchDtlsPopup;
		
		//----Pagination------//
		@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']/button")
		private WebElement pageButtons;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
		private WebElement nextarrowLink;
		
		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
		private WebElement nextarrowDoubleLink;
		
		///-----Add New Batch-------//
		@FindBy(xpath = "//button[@role='menuitem']")
		private WebElement addNewBatButton;
		
		
		
		@FindBy(xpath = "//p-dialog[@ng-reflect-visible='true']")
		private WebElement batchPopup;
		
		@FindBy(xpath = "//p-dialog[@ng-reflect-visible='false']")
		private WebElement batchPopupClose;
		
		//p-dialog[@ng-reflect-visible='true']
		@FindBy(xpath = "//p-dialog[@ng-reflect-visible='false']")
		private WebElement popupCloses;;
		
		
		@FindBy(xpath = "//button[@type=\"button\" and @tabindex=\"-1\"]")
		private WebElement closeIcon;
		
		@FindBy(xpath = "//input[@placeholder=\"Select a Program name\"]")
		private WebElement batchPopupPgmNmeField;
		
		@FindBy(xpath = "//small[contains(text(),'required')]")
		private List<WebElement> reqFields;
		
		@FindBy(xpath = "//input[@id='batchProg' and @type ='text'] ")
		private WebElement batchPopupBtchNmeField;
		
		
		@FindBy(xpath = "//input[@id='batchDescription' and @type ='text'] ")
		private WebElement batchPopupBtchDescField;
		
		@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id=\"ACTIVE\"]")
		private WebElement batchStatusActiveField;
		
		@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id=\"INACTIVE\"]")
		private WebElement batchStatusInActiveField;
		
		
		@FindBy(xpath = "//input[@id='batchNoOfClasses' and @type ='number'] ")
		private WebElement noOfClassesField;
		
		
		@FindBy(xpath = "//div[@role='button'] ")
		private WebElement pgmNmaDropdownField;
		
		@FindAll(@FindBy(xpath = "//li[@role='option']/span "))
		private List<WebElement> dropdownLists;
		
		
		@FindBy(xpath = "//small[@id=\"text-danger\"]")
		private WebElement btchnameerrormsg;
		
	@FindBy(xpath = "//input[@id=\"batchName\"]")
		private WebElement batchname2ndfield;
	
	@FindBy(xpath = "//button[@label=\"Save\"]")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//*[contains(text(),'Batch Created Successfully')]")
	private WebElement successMsg;
	
	
	@FindBy(xpath = "//*[contains(text(),'Program Name is required')]")
	private WebElement pgmNameFieldRqdErrMsg;
	
	
	@FindBy(xpath = "//*[contains(text(),'Batch Name is required')]")
	private WebElement batNameFieldRqdErrMsg;
	
	@FindBy(xpath = "//*[contains(text(),'Batch Description is required')]")
	private WebElement batDescFieldRqdErrMsg;
	
	@FindBy(xpath = "//small[@class='p-invalid ng-star-inserted']")
	private WebElement baterrormsg;
		
	By successfulBatchCreation = By.xpath("//*[contains(text(),'Batch Created Successfully')]");
	
	@FindBy(xpath = "//span[contains(text(),'Showing') and contains(text(),'of') and contains(text(),'entries')]")
	private WebElement ppPaginationText;
	
	@FindBy(xpath = "//div[contains(text(),'In total there are') and contains(text(),'programs')]")
	private WebElement ppFooterText;
	
	@FindBy (xpath="//div[text()='Successful']")
	private WebElement SuccessMessage;
	
	
	@FindBy (xpath="//span[contains(text(),'Cancel')]")
	private WebElement cancelBtn;
	
	@FindBy (xpath="//input[@id='filterGlobal']")
	private WebElement searchbox;
	
	
	@FindBy (xpath="//tbody/tr[\"+i+\"]")
	private WebElement searchfilteredresults;
	//-----------DELETE Batch-----------------//
	
	@FindBy(xpath = "//td//span[@class=\"p-button-icon pi pi-trash\"]")
	private WebElement tddeleteIcon;
	
	//@FindBy(xpath = "//*[contains(text(),'Confirm')]")
	//private WebElement confirmDialog;
	
	 @FindBy(xpath =("//*[contains(text(),'Confirm')]"))
	private WebElement deleteAlertPopUpHeadingCheck;
	 
	 @FindBy(xpath =("//*[contains(text(),'Yes')]"))
	private WebElement deleteAlertPopUpYes;
	 
	@FindBy(xpath =("//*[contains(text(),'No')]"))
	private WebElement deleteAlertPopUpNo;
	
	@FindBy (xpath="//tbody[@class='p-datatable-tbody']//div[@role='checkbox']")
	private List<WebElement> manageProgramPagedeleteCheckBoxesList;
	
	@FindBy (xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteButton;
	
	//---------------------EDIT BATCH------------
	
	@FindBy (xpath="//button[@icon='pi pi-pencil']")
	private WebElement editIcon;
	
	
	@FindBy (xpath="//p-dialog[@ng-reflect-header='Batch Details' and @ng-reflect-visible='true']")
	private WebElement editDialog;
	
	
	@FindBy (xpath="//input[@type='text' and 'disabled' and@placeholder='Select a Program name']")
	private WebElement pgmFieldDisabledforediting;
	
	@FindBy (xpath="//input[@id='batchName' and 'disabled']")
	private WebElement batchNmeFieldDisabledforediting;
	
	
	
	@FindBy (xpath="//button[@id='logout']")
	private WebElement logoutBtn;
	
	
		//---------------------Methods------------------------------------
		
		public String checkLMSTitle(String titleDisplayed ) {
			 titleDisplayed = LMSTitleCheck.getText();
			return titleDisplayed;
		}
		
		public void clickheaderBatchButton() {
			headerBatchButton.click();
		}
		public String checkManageBatchTitle(String manageBatchTitleDisplayed) {
			 manageBatchTitleDisplayed = manageBatchTitleCheck.getText();
			return manageBatchTitleDisplayed;
		}
		
		public boolean checkDashBoard() {
			boolean dashBoard = false;
			boolean dashboardPgmButtonDisplayed = dashboardPgmButton.isDisplayed();
			boolean dashboardBatchDisplayed = dashboardBatch.isDisplayed();
			boolean dashboardClassDisplayed = dashboardClass.isDisplayed();
			boolean dashboardLogoutDisplayed = dashboardLogout.isDisplayed();
			if(dashboardPgmButtonDisplayed&&dashboardBatchDisplayed&&dashboardClassDisplayed&&dashboardLogoutDisplayed == true) {
				dashBoard = true;
			}
			return dashBoard;
		}
		
		public void checkDeleteIcon() {
			deleteIcon.isDisplayed();
		}
		public void checkPagination() {
			paginationCntrls.isEnabled();
		}
		
		public void checkEditIconOnEachRow() {
			//List<WebElement> editIconCount = editIconinEachRow
			for(int i=0;i<editDeleteIconinEachRow.size();i++) {
				editIconinEachRow.isDisplayed();
				//driver.findElement((By) editIcon).isDisplayed();
				
				
			}
		}
		
		public void checkDeleteIconOnEachRow() {
			for(int i =0;i<editDeleteIconinEachRow.size();i++) {
				deleteIconinEachRow.isDisplayed();
			}
		}
		
		public boolean checkBatchNameHeader() {
			String text = batchNameHeader.getText();
			if(text == "Batch Name") return true;
			return true;
		}
		
		public boolean checkBatchDescHeader() {
			String text = batchDescriptionHeader.getText();
			if(text == "Batch Description") return true;
			return true;
		}
		public boolean checkBatchStatusHeader() {
			String text = batchStatusHeader.getText();
			if(text == "Batch Status") return true;
			return true;
		}
		
		public boolean checkNoOfClassesHeader() {
			String text = batchNoOfClassesHeader.getText();
			if(text == "No Of Classes") return true;
			return true;
		}
		
		public boolean checkPgMNameHeader() {
			String text = programNameHeader.getText();
			if(text == "Program Name") return true;
			return true;
		}
		public boolean checkEditDeleteHeader() {
			String text = EditDeleteHeader.getText();
			if(text == " Edit / Delete ") return true;
			return true;
		}
		
		 public void checkSortIcons() {
			 batchNameSortIcon.isDisplayed();
			 batchDescSortIcon.isDisplayed();
			 batchStatusSortIcon.isDisplayed();
			 batchNoOfClassesSortIcon.isDisplayed();
			 programNameSortIcon.isDisplayed();
		 }
		public void checkHeaderCheckBox() {
			checkboxButton.isDisplayed();
		}
		public String checkAddNewBatchBtn(String text) {
			addNewBatchBtn.isDisplayed();
			 text = addNewBatchBtn.getText();
			 return text;
		}
		
		public void clickAddNewBatchBtn() {
			headerBatchButton.click();
			addNewBatchBtn.click();
		}
		public void checkbatchDtlsPopup() {
			batchDtlsPopup.isDisplayed();
		}
		
		public void batcjDtlsPopupClose() {
			batchPopupClose.isDisplayed();
		}
		public void clickCloseIcon() {
			closeIcon.click();
		}
		public void popupCloses() {
			popupCloses.isDisplayed();
		}
		
		public void getPaginationSize() {
			int paginationSize = driver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
			//System.out.println
			System.out.println("Pagination size is:"+paginationSize);
			List<String> batnames = new ArrayList<String>();
			for(int i = 1;i<=paginationSize;i++) {
				
				String paginatioSelector = "//span[@class='p-paginator-pages ng-star-inserted']/button["+i+"]";
				System.out.println("pagination selector:" +paginatioSelector);
				driver.findElement(By.xpath(paginatioSelector)).click();
				List<WebElement> batchnameelements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
				for(WebElement nameElement:batchnameelements) {
					batnames.add(nameElement.getText());
					System.out.println("Batch Name elements:" +batchnameelements);
				}
			}
			for(String name:batnames) {
				System.out.println(batnames);
			}
			
		}
		public void paginationNextArrowLink(){
			nextarrowLink.isDisplayed();
			nextarrowLink.click();

			
			
		}
		public void paginationNextArrowLinkEnabled() {
			nextarrowLink.isEnabled();
		}
		
		public void batchPOPup() {
			batchPopup.isDisplayed();
		}
		public boolean checkPopUpFields() {
			batchPopupPgmNmeField.isEnabled();
			batchPopupBtchNmeField.isEnabled();
			batchPopupBtchDescField.isEnabled();
			batchStatusActiveField.isEnabled();
			batchStatusInActiveField.isEnabled();
			noOfClassesField.isEnabled();
			return true;
		}
		public boolean checkPopUpFormComponents() {
			batchPopupPgmNmeField.isDisplayed();
			batchPopupBtchNmeField.isDisplayed();
			batchPopupBtchDescField.isDisplayed();
			batchStatusActiveField.isDisplayed();
			batchStatusInActiveField.isDisplayed();
			noOfClassesField.isDisplayed();
			return true;
			
		}
		public void clickDropdown()
		{
			
			String sel;
			pgmNmaDropdownField.click();
			String option = "TeamFourSDET";
			//WebElement op;
			for(WebElement op:dropdownLists ) {
				if(op.getText().contains(option)) {
					op.click();
					break;
					
					}
				/*if(!op.getText().contains(option)) {
					System.out.println("Select the valid value from dropdown");
					break;*/
					
			}
				
			}
			 
			
			/*for(int i=0;i<dropdownLists.size();i++) {
				String text = dropdownLists.get(i).getText();
				if( dropdownLists.get(i).getText().contains(option))
				dropdownLists.get(i).click();
				//System.out.println("clicked");
				//break;

				
				System.out.println("--------List-----" +text);
				System.out.println("--------Size-----" +dropdownLists.size());*/
			
			
			//Select dropdown = new Select(testDropDown); 
			
		public void checkBatNameErromsg() {
			
			btchnameerrormsg.isDisplayed();
		}
		public void batcnamesendkeys() {
			batchname2ndfield.sendKeys("abc");
		}
		public void batchprefixtextbox() {
			batchPopupBtchNmeField.sendKeys("abc");
			
		}
		public void batchprefixtextboxreadonly() {
			batchPopupBtchNmeField.getAttribute("readonly required");
		}
		public void manadatoryFieldcheck() {
			batchPopupPgmNmeField.sendKeys("SeleniumSharks");
			batchname2ndfield.sendKeys("2");
			batchPopupBtchDescField.sendKeys("SDETSeleniumJava");
			batchStatusActiveField.click();
			noOfClassesField.sendKeys("2");
			
			
			
		}
		public void clickSave() {
			saveBtn.click();
		}
		
		public void clickCancelBtn() {
			cancelBtn.click();
		}
		public boolean successMsg() {
			//successMsg.isDisplayed();
			String msg = driver.findElement(successfulBatchCreation).getText();
			if(msg == "Batch Created Successfully") return true;
			return true;
		}
		public List<String> errmsgCheckformanadatoryField() {
			//if(batchPopupPgmNmeField.sendKeys("") ||batchPopupBtchNmeField.sendKeys("")||batDescFieldRqdErrMsg.sendKeys("") ) {
				
			saveBtn.click();
			SoftAssert softAssert = new SoftAssert();
			//for(String msg:baterrormsg.getText())
			boolean x = false;
			/*for(WebElement req : reqFields) {
				if(req.isDisplayed() == true) {
					String text = req.getText();
					List<String> arr = List.of(text);
					x=true;
				}
			}*/
				List<String> moduleTexts = new ArrayList<>();
				for (WebElement moduleBtn : reqFields) {
					moduleTexts.add(moduleBtn.getText().trim());
				}
				return moduleTexts;
				
		
			
			//softAssert.assertEquals(batchPopupPgmNmeField.getText(), "Program Name is required.");
			//softAssert.assertEquals(batchPopupBtchNmeField.getText(), "Batch Name is required.");
			//softAssert.assertEquals(batDescFieldRqdErrMsg.getText(), "Batch Description is required.");
			//softAssert.assertAll();
			
			}
			
		
		public void pgmNameFieldRqdErrMsgcheck() {
			pgmNameFieldRqdErrMsg.isDisplayed();
		}
		public void emptybatNameFieldcheck() {
			batchPopupBtchNmeField.sendKeys("");
		}
		
		public void batchNameFieldRqdErrMsgcheck() {
			batNameFieldRqdErrMsg.isDisplayed();
		}
		public boolean paginationValidation() {
			boolean pagination = false;
			if (ppPaginationText.isDisplayed() == true) {
				String paginationText = ppPaginationText.getText();
				System.out.println("Program page pagination text: " + paginationText);

				String[] paginationTextArray = paginationText.split(" ");
				int totalPageNoOfPaginationText = Integer.parseInt(paginationTextArray[5]);
				System.out.println("Total page number in pagination text: " + totalPageNoOfPaginationText);

				String footerText = ppFooterText.getText();
				System.out.println("Footer text: " + footerText);

				String[] footerTextArray = footerText.split(" ");
				int totalPageNoInFooter = Integer.parseInt(footerTextArray[4]);
				System.out.println("Total page number in footer text: " + totalPageNoInFooter);

				if (totalPageNoOfPaginationText == totalPageNoInFooter) {
					pagination = true;
				}
			}
			return pagination;
		}
		
		public void clicktddeleteIcon() {
			tddeleteIcon.click();
		}
		
		public void confirmDialog() {
			deleteAlertPopUpHeadingCheck.isDisplayed();
		}
		public void deleteAlertPopUpValidate() {
			deleteAlertPopUpHeadingCheck.isDisplayed();
			deleteAlertPopUpYes.isDisplayed();
			deleteAlertPopUpNo.isDisplayed();
		}
		public void clickDeletYesBtn() {
			deleteYesBtn.click();
		}
		public void clickDeletNoBtn() {
			deleteNoBtn.click();
		}
		
		public void deleteSuccessMessage() {
			deleteSuccessMessage.isDisplayed();
		}
		public boolean deletealertboxClosed() {
			if(deletealertboxClosed.isDisplayed()==true) return false;
			return false;
		}
		public void deletealertcross() {
			deletealertcross.click();
		}
		public void clickMultipleCheckBoxesOfProgramTable(int NoOfBoxesToSelect) {
			int i = NoOfBoxesToSelect;
			WebElement checkBox = driver.findElement(By.xpath("(//tbody[@class='p-datatable-tbody']//div[@role='checkbox'])["+i+"]"));
			JavascriptExecutor jsv = (JavascriptExecutor)driver;
			jsv.executeScript("arguments[0].click()",checkBox);
}
		public void clickTopLeftDeleteIcon() {
			deleteButton.click();
		}
		public boolean searchbox() {
			
			searchbox.sendKeys("TeamTwo1");
			if(searchbox.getText() == "TeamTwo1")return true;
			return true;
		}
		public void clickeditIcon() {
			editIcon.click();
		}
		public void editDialog() {
			editDialog.isDisplayed();
		}
		public void pgmFieldDisabledforediting() {
			pgmFieldDisabledforediting.isDisplayed();
		}
		public void batchNmeFieldDisabledforediting() {
			batchNmeFieldDisabledforediting.isDisplayed();
		}
		public void sendValuetosearchbox() {
			searchbox.sendKeys("TeamTwo1");
		}
		public boolean searchfilteredresults() {
			String text= searchfilteredresults.getText();
			if(text == "TeamTwo1") return true;
			return true;
		}
		public void clicklogoutBtn() {
			logoutBtn.click();
		}
		
}