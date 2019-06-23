package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

public class ChangeDomicile extends BaseUtil {

    private BaseUtil base;

    public ChangeDomicile(BaseUtil base) {
        this.base = base;
    }

    @Given("^I go to website ubs.com$")
    public void iGoToWebsiteUbsCom() {
        System.out.println("Going to www.ubs.com website...");
        base.driver.manage().window().maximize();
        base.driver.navigate().to("https://www.ubs.com/global/en.html");
    }

    @When("^I push the button to change domicile$")
    public void iPushTheButtonToChangeDomicile() {
        System.out.println("Selecting domicile... ");
        base.driver.findElement(By.xpath("//*[@id=\"countryLabel\"]")).click();
        base.driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]/div/div[2]/div/ul/li[1]/a")).click();
    }

    @Then("^Language should be changed$")
    public void languageShouldBeChanged() {
        String title = base.driver.getTitle();
        System.out.println("Title is: " + title.toUpperCase());
        Assert.assertTrue(title.contains("Our financial services in your country | UBS Italy"));
    }
}
