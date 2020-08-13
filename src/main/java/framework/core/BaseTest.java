package framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {

	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		ChromeDriverManager.chromedriver();
		String chromeDriverPath = "./drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-gpu", "--window-size=1920,1200",
				"--ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
	}

	@AfterSuite
	public void afterSuite() {
		if (null != driver) {
			driver.close();
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
