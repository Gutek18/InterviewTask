package Steps;


import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void inializeTest() {
        System.out.println("Opening the browser...");
        base.driver = new ChromeDriver();
        base.AcceptingCookie();
    }

    @After
    public void TearDownTest() {
        System.out.println("Closing the browser...");
        base.driver.quit();
    }
}
