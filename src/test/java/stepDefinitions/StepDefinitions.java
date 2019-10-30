package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	@When("^I login into stockAccounting Url on Chrome Browser$")
	public void i_login_into_stockAccounting_Url_on_Chrome_Browser() throws Throwable {
System.setProperty("webdriver.chrome.driver", "D:\\mrng930batch\\CucumberFramework\\driverrs\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://webapp.qedge.com");
		driver.manage().window().maximize();
	}
	
	@When("^I login into stockAccounting Url on \"([^\"]*)\"$")
	public void i_login_into_stockAccounting_Url_on(String browser) throws Throwable {
	    
		System.out.println("running on "+browser);
		if(browser.equalsIgnoreCase("chrome")){
	    	System.setProperty("webdriver.chrome.driver", "D:\\mrng930batch\\CucumberFramework\\driverrs\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://webapp.qedge.com");
			driver.manage().window().maximize();
	    }else if(browser.equalsIgnoreCase("ie")){
	    	System.out.println("running on ie  but driver not available");
	    }else if(browser.equalsIgnoreCase("firefox")){
	    	System.out.println("running on firefox  but driver not available");
	    }
	}
	
	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String username, String password) throws Throwable {
		System.out.println("running with "+username+" "+password);
		
		driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		
	}


	@When("^I click Reset Button on Login Page$")
	public void i_click_Reset_Button_on_Login_Page() throws Throwable {
	   driver.findElement(By.id("btnreset")).click();
	}

	@When("^I enter admin and master in UserNameField and PasswordField$")
	public void i_enter_admin_and_master_in_UserNameField_and_PasswordField() throws Throwable {
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.id("password")).sendKeys("master");
		
	}

	@When("^I click on Login Button$")
	public void i_click_on_Login_Button() throws Throwable {
		driver.findElement(By.id("btnsubmit")).click();
	}

	@When("^I wait for LogoutLink$")
	public void i_wait_for_LogoutLink() throws Throwable {
			Thread.sleep(5000);
	}

	@Then("^I validate the title of the home Page and close the Browser$")
	public void i_validate_the_title_of_the_home_Page_and_close_the_Browser() throws Throwable {
	 		String expTitle="Dashboard « Stock Accounting";
			String actTitle=driver.getTitle();
			if(expTitle.equalsIgnoreCase(actTitle)){
			System.out.println("title validation passed");
			}
			else
			{
			System.out.println("title validation failed");
			}
			driver.close();
			}

}
