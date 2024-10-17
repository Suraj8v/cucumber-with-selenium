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
            driver.quit();

    }

}
