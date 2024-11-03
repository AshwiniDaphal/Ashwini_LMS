package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;
import utilities.LoggerLoad;
@Data
public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	//---------------------------------------- WebElement ----------------------------------------------------
	public String Login_url="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login";
	@FindBy(xpath = "//button[@id='logout']")
	public WebElement logoutBtn;
	
	@FindBy(xpath = "//span[contains(text(),'LMS')]")
	public WebElement LMSAppName;
	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']")
    WebElement LMSAppToolbar;
	
	@FindBy(xpath = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/div[1]")
	private WebElement NavBarText;
	
	//---------------------------------------- Methods-------------------------------------------------------
	public long navigationTime()
	{
		long startTime = System.currentTimeMillis();
		driver.getCurrentUrl();
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime ;

		System.out.println("Total Time for page load - " + totalTime); 

		return totalTime;
		
	}

	public static int getNumberOfSpaces(String s)
	{
		int ct=0;
		for(char c:s.toCharArray())
		{
			if(c==' ')
			{
				ct++;
			}
		}		
		return ct;			
	}
	
	
	public  Boolean alignNavBarTextModule()
	{
		int TotalWidth=Math.addExact(LMSAppToolbar.getLocation().getX(),LMSAppToolbar.getRect().getWidth());
		System.out.println("Totl toolbar Width:"+TotalWidth);
		
		int endxOfMenu=NavBarText.getRect().getX()+NavBarText.getRect().getWidth();//1423 size of nav module
		System.out.println("end of endxOfmodule "+endxOfMenu);
		
		int menuY=NavBarText.getRect().getY();
		
		System.out.println("Start of y Ofmodule "+endxOfMenu);
		//Top Left
		if(endxOfMenu>=LMSAppToolbar.getRect().getWidth()-70 && menuY<=50)
		{
			LoggerLoad.info("Navigation modules is in top right position");
			return true;
		}
		return false;

	}
	
	public  Boolean alignLmsTitle()
	{
		
		int startxOfTitle=LMSAppName.getRect().getX();
		int startyOfTitle=LMSAppName.getRect().getY();

		//Top Left
		if(startxOfTitle<=30 && startyOfTitle<=30)
		{
			LoggerLoad.info("Title is in top left position");
			return true;
		}
		
		return false;
		
	}
	
	public int spellAndSpaceLMS() throws Exception
	{
		String lmsTitletext=LMSAppName.getText();
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish()); 
        try {
        List<org.languagetool.rules.RuleMatch> matches = langTool.check(lmsTitletext); 
        
        if (matches.isEmpty()) {
            System.out.println("No spelling mistakes found.");
        } else {
            System.out.println("Spelling mistakes found:");
            for (org.languagetool.rules.RuleMatch match : matches) 
            {
            	System.out.println("Spelling mistakes found:"+match);
            	System.out.println("Context: " + match.getShortMessage());
                System.out.println("Potential typo at line " + match.getLine() + ", column " + match.getColumn());
                System.out.println("Suggested corrections: " + org.apache.commons.lang3.StringUtils.join(match.getSuggestedReplacements()));
            }
        }
       }
        catch(IOException e) 
        {
        	e.printStackTrace();
        }	
        int noOfSpacesLmsTitle=getNumberOfSpaces(lmsTitletext);
        System.out.println("LMS - Learning Management System has "+noOfSpacesLmsTitle+" spaces" );
    return noOfSpacesLmsTitle;
	}
	
	
	public Boolean checkModuleInd(int expInd,String name)
	{
		TreeMap<Integer, String> locMap=new TreeMap<Integer, String>();

		List<WebElement> ele=LoginPage.NoofBtnDashboard;
		for (WebElement webElement : ele) {

			locMap.put(webElement.getRect().getX(), webElement.getText());
		}
		int ctr=0;
		boolean found=false;

		for(Integer xLoc:locMap.keySet())
		{
			ctr++;
			if(ctr==expInd)
			{
				found=true;
				if(locMap.get(xLoc).equals(name))
				{
					System.out.println("PASS");
					return true;
				}
				else
				{
					System.err.println("FAIL, Expected : "+name+", Actual : "+locMap.get(xLoc));
					return false;
				}
			}
		}
		if(!found)
		{
			System.err.println("FAIL, "+name+" nav/menu not found at expected location "+expInd+"!");
		}
		return false;
		
	}
	
}
