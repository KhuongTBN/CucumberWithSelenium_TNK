package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	WebDriver driver;
	
	@Given("^Open the Firefox and launch the application$")
	public void open_the_firefox_and_launch_the_application() throws Throwable{
		System.out.println("This step opens the Firefox and launch the application.");
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
	}
	
	//@When("^Enter the Username and Password$")
	@When("^Enter the Username \"(.*)\" and Password \"(.*)\"$")
	public void enter_the_username_and_password(String username, String password) throws Throwable{
		System.out.println("This step enters the Username and Password on the login page.");
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@Then("^Reset the credential$")
	public void reset_the_credential() throws Throwable{
		System.out.println("This step clicks on the Reset button.");
		driver.findElement(By.name("btnReset")).click();
	}

}
