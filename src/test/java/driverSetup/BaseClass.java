package driverSetup;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver = null;

	public Properties prop;

	public BaseClass() {
		
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		System.out.println("Inside BaseClass called ........................");
		WebDriverManager();
	}

	public String getStringProperty(String key) {
		return prop.getProperty(key);
	}

	public WebDriver WebDriverManager() {
		try {
			if (driver == null) {
				String browser = prop.getProperty("browser");
				if (browser.equalsIgnoreCase("Chrome")) {
//					ChromeOptions options = new ChromeOptions();
//					options.addArguments("--headless"); 
//					driver = new ChromeDriver(options);
					driver = new ChromeDriver();

				} else if (browser.equalsIgnoreCase("Firefox")) {
					FirefoxOptions options = new FirefoxOptions();
//					options.addArguments("--headless"); 
					driver = new FirefoxDriver(options);
				} else if (browser.equalsIgnoreCase("Edge")) {
					EdgeOptions options = new EdgeOptions();
					WebDriverManager.edgedriver().clearDriverCache().setup();
					WebDriverManager.edgedriver().clearResolutionCache().setup();
//					options.addArguments("--headless");
					driver = new EdgeDriver(options);
				} 
			}
		} catch (Exception e) {
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}
	

}
