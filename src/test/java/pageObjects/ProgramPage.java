package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;
@Data
public class ProgramPage extends BasePage {

	public ProgramPage(WebDriver driver) {
		super(driver);
	}

	public String programModuleUrl="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/program";
	//----------------------WebElements-------------------------------

	@FindBy(xpath = "//span[text()='Program']")
	private WebElement programBtn;

	@FindBy(xpath = "//div[@class='ng-star-inserted']/button[2]")
	private WebElement batchBtn;

	@FindBy(xpath = "//button[normalize-space()='Add New Program']")
	private WebElement addNewProgramBtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement manageProgramTitle;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@id='editProgram']")
	private WebElement editIcon;

	@FindBy(xpath = "//span[text()='Program Details']")
	private WebElement programDetailsTitle;

	@FindBy(xpath = "//p-sorticon[@field='programName']/i")
	public WebElement sortProgramName;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[2]")
	public WebElement programNameHeader;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[3]")
	public WebElement programDesHeader;

	@FindBy(xpath = "//thead[@class='p-datatable-thead']/tr/th[4]")
	public WebElement programStatusHeader;

	@FindBy (xpath = "//tbody//tr//td[2]") 
	List<WebElement> progNames;

	@FindBy (xpath = "//tbody//tr//td[3]") 
	List<WebElement> prodDesc;

	@FindBy (xpath = "//tbody//tr//td[4]") 
	List<WebElement> progStatus;

	//aria-sort="ascending"
	// ----------------Methods------------------

	public void clickProgramBtn() {
		programBtn.click();
		justClick();
	}

	public void clickAddNewProgramBtn() {
		addNewProgramBtn.click();
	}

	public void clicksearchTextBox() {
		searchTextBox.click();
	}

	public boolean manageProgramTitleDisplay() {
		boolean display = manageProgramTitle.isDisplayed();
		return display;
	}

	public void ClickBatchBtn() {
		batchBtn.click();
	}

	//----------------------WebElements-------------------------------

		@FindBy(xpath = "(//span[@class='p-button-icon pi pi-pencil'])[1]")
		private WebElement editIcon1;

		@FindBy(xpath = "(//button[@id='deleteProgram'])[1]")
		private WebElement deleteIcon1;

		@FindBy(xpath = "//label[text()='Name']/span")
		private WebElement programDetailsNameAsterisk;

		@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/span[1]")
		private WebElement manageProgramPageLmsTitle;

		@FindBy(xpath = "//button[@id='logout']")
		private WebElement logoutBtn;

		@FindBy(xpath = "//div[@class='ng-star-inserted']/button/span[1]")
		private List<WebElement> moduleBtnList;

		@FindBy(xpath = "//link")
		private List<WebElement> programPageLinks;

		@FindBy(xpath = "//div[@class='p-field ng-star-inserted']/label[@for='programName']")
		private WebElement programDetailsPopupName;

		@FindBy(xpath = "//div[@class='p-field ng-star-inserted']/label[@for='programDescription']")
		private WebElement programDetailsPopupDescription;

		@FindBy(xpath = "//div[@class='radio ng-star-inserted']/div/lable")
		private WebElement programDetailsPopupStatus;

		@FindBy(xpath = "//button[@label='Cancel']")
		private WebElement cancelButton;

		@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
		private WebElement programPageDisabledDeleteBtn;

		@FindBy(xpath = "//th[@psortablecolumn='programName']")
		private WebElement dataTableProgramName;

		@FindBy(xpath = "//th[@psortablecolumn='programDescription']")
		private WebElement dataTableProgramDescription;

		@FindBy(xpath = "//th[@psortablecolumn='programStatus']")
		private WebElement dataTableProgramStatus;

		@FindBy(xpath = "//th[text()=' Edit / Delete ']")
		private WebElement dataTableEditDelete;

		@FindBy(xpath = "//thead[@class='p-datatable-thead']//input")
		private WebElement ppDataTableheaderCheckBox;

		@FindBy(xpath = "//div[@class='p-hidden-accessible']")
		private List<WebElement> ppAllRowCheckBox;

		@FindBy(xpath = "//p-sorticon[@field='programName']")
		private WebElement programNameSortIcon;

		@FindBy(xpath = "//p-sorticon[@field='description']")
		private WebElement programDescriptionSortIcon;

		@FindBy(xpath = "//p-sorticon[@field='status']")
		private WebElement programStatusSortIcon;

		@FindBy(xpath = "//button[@id='editProgram']")
		private List<WebElement> dataTableAllRowEditIcon;

		@FindBy(xpath = "//button[@id='deleteProgram']")
		private List<WebElement> dataTableAllRowDeleteIcon;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']")
		private WebElement ppPaginationBeginningPageArrow;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
		private WebElement ppPaginationEndingPageArrow;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
		private WebElement ppPaginationPreviousPageArrow;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
		private WebElement ppPaginationNextPageArrow;

		@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
		private WebElement paginationBar;

		@FindBy(xpath = "//label[@for='programName']/span")
		private WebElement programDetailsNameRedStar;

		@FindBy(xpath = "//button[@id='saveProgram']")
		private WebElement programDetailsSaveBtn;

		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[2])[1]")
		private WebElement programNameRow1;

		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[3])[1]")
		private WebElement programDescriptionRow1;

		@FindBy(xpath = "(//tbody[@class='p-datatable-tbody']//td[4])[1]")
		private WebElement programStatusRow1;

		@FindBy(xpath = "//small[text()='Program name is required.']")
		private WebElement redProgramDetailsNameFieldText;

		@FindBy(xpath = "//small[text()='Description is required.']")
		private WebElement redProgramDetailsDescriptionFieldText;

		@FindBy(xpath = "//small[text()='Status is required.']")
		private WebElement redProgramDetailsStatusFieldText;

		@FindBy(xpath = "//input[@id='programName']")
		private WebElement programNameTextBox;

		@FindBy(xpath = "//input[@id='programDescription']")
		private WebElement programDescriptionTextBox;

		@FindBy(xpath = "//div[contains(text(),'Active')]//div[@class='p-radiobutton-box']")
		private WebElement activeRadioButton;

		@FindBy(xpath = "//div[contains(text(),'Inactive')]//div[@class='p-radiobutton-box']")
		private WebElement InactiveRadioButton;

		@FindBy(xpath = "//div[text()='Successful']")
		private WebElement programPageMessage;

		@FindBy(xpath = "//span[text()='Confirm']")
		private WebElement confirmDeletePageTitle;

		@FindBy(xpath = "//span[text()='Yes']")
		private WebElement confirmDeleteYESBtn;

		@FindBy(xpath = "//div[text()='Successful']")
		private WebElement deleteSuccessMessage;

		@FindBy(xpath = "//div[@role='dialog']")
		private WebElement programPagePopUp;

		@FindBy(xpath = "//span[@class='p-dialog-header-close-icon ng-tns-c168-6 pi pi-times']")
		private WebElement close_X_Icon;

		@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted' and text()='Showing 0 to 0 of 0 entries']")
		private WebElement showingZeroElementsMsg;

		@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted' and (contains(text(),'Showing'))]")
		private WebElement showingEntriesMsg;

		@FindBy(xpath = "//div[contains(text(),'total')]")
		private WebElement ppFooterText;

		@FindBy(xpath = "//span[text()='No']")
		private WebElement NOBtnConfirmDeletePage;

		@FindBy(xpath = "//span[text()='Confirm']/parent::div//div//span")
		private WebElement ConfirmDeleteIconX;

		@FindBy(xpath = "//td")
		private List<WebElement> searchCreatedProgramValuesList;

		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//div[@role='checkbox']")
		private List<WebElement> manageProgramPageCheckBoxesList;

		@FindBy(xpath = "//div[@class='box']//span[@class='p-button-icon pi pi-trash']")
		private WebElement topLeftDeleteIcon;

		@FindBy(xpath = "//th//div[@role='checkbox']")
		private WebElement topLeftHeaderCheckBox;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']/parent::button")
		private WebElement singleRightArrowLinkPagination;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']/parent::button")
		private WebElement doubleRightArrowLinkPagination;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']/parent::button")
		private WebElement singleLeftArrowLinkPagination;

		@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']/parent::button")
		private WebElement doubleLeftArrowLinkPagination;

		
		// ------------------Sudha Methods-----------------------------

		public List<String> getListOfModuleBtnTexts() {
			List<String> moduleTexts = new ArrayList<>();
			for (WebElement moduleBtn : moduleBtnList) {
				moduleTexts.add(moduleBtn.getText().trim());
			}
			return moduleTexts;
		}

		public boolean programDetailsPopupDisplay() {
			boolean programDetailsPopup = false;

			boolean programDetailsPopupNameDisplay = programDetailsPopupName.isDisplayed();
			boolean programDetailsPopupDescriptionDisplay = programDetailsPopupDescription.isDisplayed();
			boolean programDetailsPopupStatusDisplay = programDetailsPopupStatus.isDisplayed();

			if (programDetailsPopupNameDisplay && programDetailsPopupDescriptionDisplay
					&& programDetailsPopupStatusDisplay) {
				programDetailsPopup = true;
			}

			return programDetailsPopup;
		}

		public boolean ppdataTableHeaderDisplay() {
			boolean dataTableHeader = false;

			boolean dataTableProgramNameDisplay = dataTableProgramName.isDisplayed();
			boolean dataTableProgramDescriptionDisplay = dataTableProgramDescription.isDisplayed();
			boolean dataTableProgramStatusDisplay = dataTableProgramStatus.isDisplayed();
			boolean dataTableEditDeleteDisplay = dataTableEditDelete.isDisplayed();

			if (dataTableProgramNameDisplay && dataTableProgramDescriptionDisplay && dataTableProgramStatusDisplay
					&& dataTableEditDeleteDisplay == true) {
				dataTableHeader = true;
			}

			return dataTableHeader;
		}

		public boolean ppRowCheckBoxUnchecked() {
			boolean eachRowCheckBoxUncheck = false;
			for (WebElement eachCheckbox : ppAllRowCheckBox) {
				if (!eachCheckbox.isSelected() == true) {
					eachRowCheckBoxUncheck = true;
				}
			}
			return eachRowCheckBoxUncheck;
		}

		public boolean ppSortIconDispay() {
			boolean sortIconInHeader = false;

			boolean programNameSortIconDisplay = programNameSortIcon.isDisplayed();
			boolean programDescriptionSortIconDisplay = programDescriptionSortIcon.isDisplayed();
			boolean programStatusSortIconDisplay = programStatusSortIcon.isDisplayed();

			if (programNameSortIconDisplay && programDescriptionSortIconDisplay && programStatusSortIconDisplay == true) {
				sortIconInHeader = true;
			}

			return sortIconInHeader;
		}

		public boolean dataTableEditDeleteIconDisplay() {
			boolean eachRowEditDeleteIcon = false;
			for (int i = 0; i < dataTableAllRowEditIcon.size(); i++) {
				WebElement eachEditIcon = dataTableAllRowEditIcon.get(i);
				WebElement eachDeleteIcon = dataTableAllRowDeleteIcon.get(i);
				if (eachEditIcon.isDisplayed() && eachDeleteIcon.isDisplayed() == true) {
					eachRowEditDeleteIcon = true;
				}
			}
			return eachRowEditDeleteIcon;
		}

		public boolean programDetailsRedFieldTextDisplay() {
			boolean fieldText = false;
			boolean nameFeildTextDisplay = redProgramDetailsNameFieldText.isDisplayed();
			boolean descriptionFeildTextDisplay = redProgramDetailsDescriptionFieldText.isDisplayed();
			boolean statusFeildTextDisplay = redProgramDetailsStatusFieldText.isDisplayed();

			if (nameFeildTextDisplay && descriptionFeildTextDisplay && statusFeildTextDisplay == true) {
				fieldText = true;
			}
			return fieldText;
		}

		public List<String> listOfCreatedProgramValues() {
			List<String> textArray = new ArrayList<>();
			int size = searchCreatedProgramValuesList.size();
			if (size >= 4) {
				for (int i = 1; i <= 3; i++) {
					WebElement programValue = searchCreatedProgramValuesList.get(i);
					textArray.add(programValue.getText().trim());
				}
			}
			return textArray;
		}
		
		// --------------------------Viji Methods----------------------------------

	
		public boolean programDetailsTitleDisplay() {
			return programDetailsTitle.isDisplayed();
		}

		public boolean editIconDisplay() {
			return editIcon1.isDisplayed();
		}

		public void clickEditIcon() {
			waitForElementVisibility(editIcon1);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", editIcon1);
		}

		public void clickDeleteIcon() {
			waitForElementVisibility(deleteIcon1);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", deleteIcon1);
		}

		public void enterProgramName(String name) {
			programNameTextBox.clear();
			programNameTextBox.sendKeys(name);
		}

		public void enterProgramDescription(String description) {
			programDescriptionTextBox.clear();
			programDescriptionTextBox.sendKeys(description);
		}

		public void clickActiveRadoBtn() {
			activeRadioButton.click();
		}

		public void clickInactiveRadoBtn() {
			InactiveRadioButton.click();
		}

		public void clickCancel() {
			cancelButton.click();
		}

		public boolean confirmDeletePageTitleDisplay() {
			waitForElementVisibility(confirmDeletePageTitle);
			return confirmDeletePageTitle.isDisplayed();
		}

		public void clickConfirmDeleteYESBtn() {
			confirmDeleteYESBtn.click();
		}

		public void clickConfirmDeleteNOBtn() {
			NOBtnConfirmDeletePage.click();
		}

		public void clickIconXConfirmDeletePage() {
			ConfirmDeleteIconX.click();
		}

		public boolean deleteSuccessfulMsgDisplay() {
			return deleteSuccessMessage.isDisplayed();
		}

		public void click_X_CloseIcon() {
			close_X_Icon.click();
		}

		public void editStatus() {
			if (activeRadioButton.isSelected()) {
				System.out.println("Active Status is selected already");
				InactiveRadioButton.click();
			} else if (InactiveRadioButton.isSelected()) {
				System.out.println("Inactive Status is selected already");
				activeRadioButton.click();
			}
		}

		public boolean programDetailsNameAsteriskDisplay() {
			String symbol = programDetailsNameAsterisk.getText();
			if (symbol.contentEquals("*"))
				return true;
			else
				return false;
		}

		public String row1ProgramName() {
			return programNameRow1.getText();
		}

		public String row1ProgramDescription() {
			return programDescriptionRow1.getText();
		}

		public String row1ProgramStatus() {
			return programStatusRow1.getText();
		}

		public void searchProgramDetails(String data) {
			searchTextBox.clear();
			searchTextBox.sendKeys(data);
		}

		public void addNewProgram(String name, String Desc) {
			addNewProgramBtn.click();
			enterProgramName(name);
			enterProgramDescription(Desc);
			activeRadioButton.click();
			programDetailsSaveBtn.click();
		}

		public void deleteProgram(String ProgramName) {
			searchProgramDetails(ProgramName);
			clickDeleteIcon();
			clickConfirmDeleteYESBtn();
		}

		public boolean NoProgDisplayOnSearch() {
			waitForElementVisibility(showingZeroElementsMsg);
			return showingZeroElementsMsg.isDisplayed();
		}

		public void clickMultipleCheckBoxesOfProgramTable(int NoOfBoxesToSelect) {
			int i = NoOfBoxesToSelect;
			waitForElementVisibility(topLeftDeleteIcon);
			WebElement checkBox = driver
					.findElement(By.xpath("(//tbody[@class='p-datatable-tbody']//div[@role='checkbox'])[" + i + "]"));
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", checkBox);
		}

		public boolean checkBoxesSelectedStatus(int i) {
			WebElement checkBox = driver
					.findElement(By.xpath("(//tbody[@class='p-datatable-tbody']//div[@role='checkbox'])[" + i + "]"));
			if (checkBox.getAttribute("aria-checked").equalsIgnoreCase("true")) {
				System.out.println("Check box " + i + " is Selected");
				return true;
			} else {
				System.out.println("Check box " + i + " is NOT Selected");
				return false;
			}
		}

		public void clickTopLeftDeleteIcon() {
			waitForElementVisibility(topLeftDeleteIcon);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", topLeftDeleteIcon);
		}

		public void clicktopLeftHeaderCheckBox() {
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", topLeftHeaderCheckBox);
		}

		public void clickSingleRightArrowPagination() {
			waitForElementVisibility(singleRightArrowLinkPagination);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", singleRightArrowLinkPagination);
		}

		public void clickDoubleRightArrowPagination() {
			waitForElementVisibility(doubleRightArrowLinkPagination);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", doubleRightArrowLinkPagination);
		}

		public void clickSingleLeftArrowPagination() {
			waitForElementVisibility(singleLeftArrowLinkPagination);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", singleLeftArrowLinkPagination);
		}

		public void clickDoubleLeftArrowPagination() {
			waitForElementVisibility(doubleLeftArrowLinkPagination);
			JavascriptExecutor jsv = (JavascriptExecutor) driver;
			jsv.executeScript("arguments[0].click()", doubleLeftArrowLinkPagination);
		}

		public boolean SingleRightArrowEnabled() {
			return singleRightArrowLinkPagination.isEnabled();
		}

		public boolean SingleLeftArrowEnabled() {
			return singleLeftArrowLinkPagination.isEnabled();
		}

		public boolean doubleRightArrowEnabled() {
			return doubleRightArrowLinkPagination.isEnabled();
		}

		public boolean doubleLeftArrowEnabled() {
			return doubleLeftArrowLinkPagination.isEnabled();
		}

		public boolean sortProgramName() {
			return commonSortCheck(programNameHeader, progNames);
		}

		public boolean sortProgramDesc() {
			return commonSortCheck(programDesHeader, prodDesc);
		}

		public boolean sortProgramStatus() {
			return commonSortCheck(programStatusHeader, progStatus);
		}

		public boolean commonSortCheck(WebElement header, List<WebElement> eles) {
			justClick();
			ArrayList<String> values = new ArrayList<String>();
			ArrayList<String> expectedSortValues = new ArrayList<String>();
			for (WebElement ele : eles) {
				values.add(ele.getText());
				expectedSortValues.add(ele.getText());
			}
			if (header.getAttribute("aria-sort").equals("ascending")) {
				// exo value
				Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER);
			} else {
				// exo value
				Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER.reversed());
			}
			System.out.println("Values -> " + StringUtils.join(values));
			System.out.println("expectedSortValues -> " + StringUtils.join(expectedSortValues));
			for (int i = 0; i < values.size(); i++) {
				if (!values.get(i).equals(expectedSortValues.get(i))) {
					return false;
				}
			}
			return true;
		}
	}


