package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class LoginStep {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to website ubs.com$")
    public void iNavigateToWebsiteUbsCom() {
        System.out.println("Going to www.ubs.com website...");
        base.driver.manage().window().maximize();
        base.driver.navigate().to("https://www.ubs.com/global/en.html");
    }

    @And("^Go to Login Page$")
    public void goToLoginPage() {
        System.out.println("Going to Login page...");
        base.driver.findElement(By.xpath("//*[@id=\"loginLabel\"]/span")).click();
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.driver.findElement(By.partialLinkText("US")).click();
    }

    @When("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin() {
        System.out.println("Entering incorrect login and password");
        System.out.println("Login: admin");
        System.out.println("Password: admin");
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        base.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        base.driver.findElement(By.id("password")).sendKeys("admin");
        base.driver.findElement(By.id("submit")).click();
    }

    @Then("^Should appear error message$")
    public void shouldAppearErrorMessage() {
        System.out.println("Checking error message...");
        boolean errorMessage = base.driver.findElement(By.xpath("/html/body/div[1]/section/main/div[1]")).isEnabled();
        System.out.println("Is enable: " + errorMessage);
        Assert.assertTrue(errorMessage);
    }
}
