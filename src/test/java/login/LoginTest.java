package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @Given("the user is on the login page")
    public void loginPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid username and password")
    public void enterDetails() throws Exception
    {

            Thread.sleep(2000);
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("Admin");

            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("admin123");

    }

    @When("clicks on the login button")
    public void clickLoginButton() throws Exception {

            Thread.sleep(2000);

            WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));
            loginButton.click();

    }

    @Then("the user should be navigated to the dashboard")
    public void validateLogin() throws Exception
    {

            Thread.sleep(3000);
            String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
            Assert.assertEquals(driver.getCurrentUrl(),expectedUrl );
<<<<<<< HEAD
           // driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
=======
            driver.quit();

>>>>>>> b7290d0c7b63648dc94869b37ee89de0482d833f
    }
    //Validate if the newly added employee name present in the Employee list or not.
    @Then("check the employee")
    public void validateEmployee() throws Exception
    {
    	try {
    		Thread.sleep(2000);
    		WebElement pim = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
    		pim.click();
    		Thread.sleep(2000);
    		WebElement employeeListNavbar = driver.findElement(By.xpath("//div[@id='app']//header[@class='oxd-topbar']//nav[@role='navigation']/ul/li[2]/a[@href='#']"));
    		Thread.sleep(2000);
    		WebElement employeeIdInput = driver.findElement(By.xpath("//div[@id='app']//div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div/div[2]//input"));
    		employeeIdInput.sendKeys("0367");
    		Thread.sleep(2000);
    		WebElement searchButton = driver.findElement(By.xpath("//div[@id='app']//div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-actions']/button[@type='submit']"));
    		Thread.sleep(2000);
    		searchButton.click();
    		Thread.sleep(2000);
    		WebElement msg = driver.findElement(By.xpath("//div[@id='app']/div[1]/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']//span[@class='oxd-text oxd-text--span']"));
    		String msgStr = msg.getText();
    		String expectedText = "No Records Found";
//    		if(!msgStr.equals(expectedText))
//    		{
//    			System.out.println("employee found");
//    		}
    		Assert.assertNotEquals(msgStr, expectedText);		
    	}catch (Exception e) {
			e.printStackTrace();
		}
	
    }

}
