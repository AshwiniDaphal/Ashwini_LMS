package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverSetup.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	private TestContextSetup context;

	public Hooks(TestContextSetup context) {
		this.context = context;
	}

	@After
	public void tearDown() {
		if (context.getDriver() != null) {
			System.out.println("Running After hook...");
			context.getDriver().quit();
			context.setDriver(null);
		}

	}

	@AfterStep
	public void afterStep(Scenario scenario) { 
        //---------------- Capturing ScreenShot if Failed -------------------
		if (scenario.isFailed()) { 
			utilities.LoggerLoad.error("Steps Failed, Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) context.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
//			Allure.addAttachment("MyScreenshot",
//					new ByteArrayInputStream(((TakesScreenshot) context.getDriver()).getScreenshotAs(OutputType.BYTES)));
		}
	}
}
