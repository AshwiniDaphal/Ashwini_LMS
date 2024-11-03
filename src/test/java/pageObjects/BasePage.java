package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.Data;

@Data
public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ----------------------WebElements-------------------------------

	@FindBy(xpath = "//div[contains(text(),'In total there are') and contains(text(),'programs.')] ")
	private WebElement footerText; // common for all

	@FindBy(xpath = "//span[contains(text(),'Showing') and contains(text(),'of') and contains(text(),'entries')]")
	private WebElement paginationText; // common for all

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted' and (contains(text(),'Showing'))]")
	private WebElement showingEntriesMsg;

	// ----------------Common Methods for all Modules------------------

	public void justClick() {
		Actions myAction = new Actions(driver);
		myAction.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();
	}

	public void waitForElementVisibility(WebElement element) {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	// -------------------- Find Broken Link -------------------------------
	public Boolean findBrokenLinks(List<WebElement> ListOfPageLinks) {
		List<WebElement> allLinks = ListOfPageLinks;
		boolean hasBrokenLinks = false; // Flag to track if there are broken links
		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				try {
					// Check if the link is broken
					HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode = connection.getResponseCode();
					// If response code is not 200, consider it a broken link
					if (responseCode != 200) {
						System.out.println("Broken link: " + url + " - " + responseCode);
						hasBrokenLinks = true; // Set flag to true if a broken link is found
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception occurred while checking link: " + url);
					hasBrokenLinks = true; // Set flag to true if an exception occurs
				}
			} else {
				System.out.println("Link is either null or empty: " + link.getText());
			}
		}
		// Print a message if there are broken links
		if (hasBrokenLinks) {
			System.out.println("There are broken links on the page.");
			return true;
		} else {
			System.out.println("All links are valid.");
			return false;
		}
	}

	// -------------------- Check Spelling for Login and DashBoard
	public void checkSpelling() throws Exception {
		Thread.sleep(500);
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentPageUrl);
		WebElement bodyElement = driver.findElement(By.tagName("body"));
		String pageText = bodyElement.getText();
		System.out.println("Page Text: \n" + pageText);
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		try {
			List<org.languagetool.rules.RuleMatch> matches = langTool.check(pageText);
			if (matches.isEmpty()) {
				System.out.println("No spelling mistakes found.");
			} else {
				System.out.println("Spelling mistakes found:");
				for (org.languagetool.rules.RuleMatch match : matches) {
					System.out.println("Spelling mistakes found:" + match);
					System.out.println("Context: " + match.getShortMessage());
					System.out.println("Potential typo at line " + match.getLine() + ", column " + match.getColumn());
					System.out.println("Suggested corrections: "
							+ org.apache.commons.lang3.StringUtils.join(match.getSuggestedReplacements()));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//-------------------Sort check-------------------------
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

	// ------------------------Pagination-------------------------
	public boolean currentPageValidation(String page) {
		boolean correctPage = false;
		if (showingEntriesMsg.isDisplayed()) {
			String paginationText = showingEntriesMsg.getText();
			String[] paginationTextArray = paginationText.split(" ");
			int totalEntries = Integer.parseInt(paginationTextArray[5]);
			int showingEntries = Integer.parseInt(paginationTextArray[3]);
			int priorlastEntries = totalEntries - (totalEntries % 5);
			switch (page) {
			case "last": {
				if (totalEntries == showingEntries) {
					correctPage = true;
					break;
				}
			}
			case "priorLast": {
				if (priorlastEntries == showingEntries) {
					correctPage = true;
					break;
				}
			}
			case "first": {
				if (showingEntries == 5) {
					correctPage = true;
					break;
				}
			}
			default: {
				System.out.println("Incorrect page entered...");
				break;
			}
			}
		}
		return correctPage;
	}

	public boolean paginationValidation() throws InterruptedException {
		justClick();
		Thread.sleep(3000);
		boolean pagination = false;
		if (showingEntriesMsg.isDisplayed()) {
			String paginationMsg = showingEntriesMsg.getText();
			System.out.println("Pagination text: " + paginationMsg);

			String[] paginationTextArray = paginationMsg.split(" ");
			int totalMNoInPaginationText = Integer.parseInt(paginationTextArray[5]);
			System.out.println("Total number in pagination text: " + totalMNoInPaginationText);

			String footerMsg = footerText.getText();
			System.out.println("Footer text: " + footerMsg);

			String[] footerTextArray = footerMsg.split(" ");
			int totalNoInFooter = Integer.parseInt(footerTextArray[4]);
			System.out.println("Total number in footer text: " + totalNoInFooter);

			if (totalMNoInPaginationText == totalNoInFooter) {
				pagination = true;
			}
		}
		return pagination;
	}

	//-------------------Footer Validation-----------------
	public boolean footerValidation(String moduleName) {
		boolean footer = false;
		waitForElementVisibility(footerText);
		if (footerText.isDisplayed() == true) {
			String footerMsg = footerText.getText();
			System.out.println("Footer test: " + footerMsg);

			String[] footerTextArray = footerMsg.split(" ");
			int totalNoInFooter = Integer.parseInt(footerTextArray[4]);
			System.out.println("Total number of " + moduleName + " in footer text: " + totalNoInFooter);

			String paginationMsg = paginationText.getText();
			System.out.println("Pagination text: " + paginationMsg);

			String[] paginationTextArray = paginationMsg.split(" ");
			int totalNoInPaginationText = Integer.parseInt(paginationTextArray[5]);
			System.out.println("Total number of " + moduleName + " in pagination text: " + totalNoInPaginationText);

			if (totalNoInFooter == totalNoInPaginationText) {
				footer = true;
			}
		}
		return footer;
	}
}



//package pageObjects;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.languagetool.JLanguageTool;
//import org.languagetool.language.BritishEnglish;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class BasePage {
//	WebDriver driver;
//
//	public BasePage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		
//	}
//	public void waitForElementVisibility(WebElement element) {
//		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.visibilityOf(element));
//	}
//	
//	//--------------------  Find Broken Link -------------------------------
//	public Boolean findBrokenLinks(List<WebElement> ListOfPageLinks) {
//		List<WebElement> allLinks = ListOfPageLinks;
//		boolean hasBrokenLinks = false; // Flag to track if there are broken links
//		for (WebElement link : allLinks) {
//			String url = link.getAttribute("href");
//			if (url != null && !url.isEmpty()) {
//				try {
//					// Check if the link is broken
//					HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
//					connection.setRequestMethod("HEAD");
//					connection.connect();
//					int responseCode = connection.getResponseCode();
//
//					// If response code is not 200, consider it a broken link
//					if (responseCode != 200) {
//						System.out.println("Broken link: " + url + " - " + responseCode);
//						hasBrokenLinks = true; // Set flag to true if a broken link is found
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("Exception occurred while checking link: " + url);
//					hasBrokenLinks = true; // Set flag to true if an exception occurs
//				}
//			} else {
//				System.out.println("Link is either null or empty: " + link.getText());
//			}
//		}
//		// Print a message if there are broken links
//		if (hasBrokenLinks) {
//			System.out.println("There are broken links on the page.");
//			return true;
//		} else {
//			System.out.println("All links are valid.");
//			return false;
//		}
//	}
//
//	//-------------------- Check Spelling for Login and DashBoard -------------------------------
//	public void checkSpelling() throws Exception
//	{
//		Thread.sleep(500);
//        String currentPageUrl = driver.getCurrentUrl();
//        System.out.println("Current URL: " + currentPageUrl);
//        
//        WebElement bodyElement = driver.findElement(By.tagName("body"));
//        String pageText = bodyElement.getText();
//        System.out.println("Page Text: \n" + pageText);
//        JLanguageTool langTool = new JLanguageTool(new BritishEnglish()); 
//        try {
//        List<org.languagetool.rules.RuleMatch> matches = langTool.check(pageText); 
//        
//        if (matches.isEmpty()) {
//            System.out.println("No spelling mistakes found.");
//        } else {
//            System.out.println("Spelling mistakes found:");
//            for (org.languagetool.rules.RuleMatch match : matches) 
//            {
//            	System.out.println("Spelling mistakes found:"+match);
//            	System.out.println("Context: " + match.getShortMessage());
//                System.out.println("Potential typo at line " + match.getLine() + ", column " + match.getColumn());
//                System.out.println("Suggested corrections: " + org.apache.commons.lang3.StringUtils.join(match.getSuggestedReplacements()));
//            }
//        }
//		
//       }
//        catch(IOException e) 
//        {
//        	e.printStackTrace();
//        }	
//	}
//	
//	public void justClick() {
//		Actions myAction = new Actions(driver);
//		myAction.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();
//	}
//	
//	//-------------------- Common Sort -------------------------------
//	public boolean commonSortCheck(WebElement header, List<WebElement> eles)
//	{
//		justClick();
//		ArrayList<String> values=new ArrayList<String>();
//		ArrayList<String> expectedSortValues=new ArrayList<String>();
//
//		for(WebElement ele:eles)
//		{
//			values.add(ele.getText());
//			expectedSortValues.add(ele.getText());
//		}
//
//		if(header.getAttribute("aria-sort").equals("ascending"))
//		{
//			//exo value
//			Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER);
//		}
//		else
//		{
//			//exo value
//			Collections.sort(expectedSortValues, String.CASE_INSENSITIVE_ORDER.reversed());
//		}
//
//		System.out.println("Values -> "+StringUtils.join(values));
//		System.out.println("expectedSortValues -> "+StringUtils.join(expectedSortValues));
//
//		for(int i=0;i<values.size();i++)
//		{
//			if(!values.get(i).equals(expectedSortValues.get(i)))
//			{
//				return false;
//			}
//		}
//
//		return true;
//	}
//}
