package login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginTest {

    WebDriver driver;

    @Given("the user is on the login page")
    public void loginPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid {string} and {string}")
    public void enterDetails(String usernameIn, String passwordIn) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for username field to be present
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys(usernameIn);

        // Wait for password field to be present
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys(passwordIn);
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

           // driver.quit();

           // driver.quit();
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

    		Assert.assertNotEquals(msgStr, expectedText);		
    	}catch (Exception e) {
			e.printStackTrace();
		}
	
    }



    @And("clicks on the PLM button and Add employee button")
    public void clicksOnThePLMButton() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();



    }

    @When("the user fills out the form with the following details")
    public void theUserFillsOutTheFormWithTheFollowingDetails(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> row : data) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(row.get("first_name"));
            driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys(row.get("middle_name"));
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(row.get("last_name"));
//            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(row.get("first_name"));

            driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@id='app']/div[1]//form[@class='oxd-form']//div[@class='orangehrm-employee-form']/div[3]/div/div[1]/div//input")).sendKeys(row.get("username"));
            driver.findElement(By.xpath("//div[@id='app']/div[1]//form[@class='oxd-form']//div[@class='oxd-form-row user-password-row']/div/div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/div//input[@type='password']")).sendKeys(row.get("password"));
            driver.findElement(By.xpath("//div[@id='app']/div[1]//form[@class='oxd-form']//div[@class='oxd-form-row user-password-row']/div/div[@class='oxd-grid-item oxd-grid-item--gutters']/div//input[@type='password']")).sendKeys(row.get("confirm_password"));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
        }


    }
}
