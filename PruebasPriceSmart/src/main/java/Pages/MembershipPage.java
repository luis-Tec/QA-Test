package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MembershipPage {
    WebDriver driver;

    By joinHereButton = By.xpath("//*[@id=\"lnkJoinNowDiamondTop\"]");


    public MembershipPage(WebDriver driver){

        this.driver = driver;

    }

    public void clickJoinHereButton(){
        driver.findElement(joinHereButton).click();
    }
}
