package Steps;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CheckingDAXStocksValue {
    private BaseUtil base;

    public CheckingDAXStocksValue(BaseUtil base) {
        this.base = base;
    }

    @Given("^I go to ubs.com$")
    public void iGoToUbsCom() {
        System.out.println("Going to www.ubs.com website...");
        base.driver.manage().window().maximize();
        base.driver.navigate().to("https://www.ubs.com/global/en.html");
    }

    @When("^I check DAX stock value$")
    public void iCheckDAXStockValue() {
        System.out.println("Finding DAX..");
        base.driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/article[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div/div/div/div/section/table/tbody/tr[1]/td[1]/a")).click();
    }

    @And("^I checking first value$")
    public String iCheckingFirstValue() {
        String value = base.driver.findElement(By.xpath("//*[@id=\"FQ_SnapBar\"]/tbody/tr/td[1]/span[1]/span")).getText();
        return value;
    }

    @And("^I refresh browser$")
    public String iRefreshBrowser() {
        base.driver.navigate().refresh();
        String value = base.driver.findElement(By.xpath("//*[@id=\"FQ_SnapBar\"]/tbody/tr/td[1]/span[1]/span")).getText();
        return value;
    }

    @Then("^I should see different value of DAX$")
    public void iShouldSeeDifferentValueOfDAX() {
        String value1 = iCheckingFirstValue();
        System.out.println("DAX value before refresh" + value1);
        String value2 = iRefreshBrowser();
        System.out.println("DAX value after refresh" + value2);
        Assert.assertNotEquals(value1, value2);
    }
}
