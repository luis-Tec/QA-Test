package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MembershipPage {
    WebDriver driver;
    By joinHereButton = By.xpath("//*[@id=\"lnkJoinNowDiamondTop\"]");
    public MembershipPage(WebDriver driver){

        this.driver = driver;

    }
    public void clickJoinHereButton(){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(joinHereButton) );
        driver.findElement(joinHereButton).click();
    }
}