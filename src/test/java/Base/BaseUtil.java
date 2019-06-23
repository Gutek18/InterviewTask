package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseUtil {
    public WebDriver driver;

    public void AcceptingCookie(){
        driver.navigate().to("https://www.ubs.com/global/en/homepage/cookies/cookie-pop-up.lightbox.logo.footer_links.disclaimer_text.html");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/button/span/span/span/span")).click();
    }
 }
