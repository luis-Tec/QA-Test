package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ResultMembershipPage {
    WebDriver driver;
    By resultsList = By.xpath("/html/body/section/section/form/section/div/div[1]/div/div/div/section/div/div/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div[3]/label");
    public ResultMembershipPage(WebDriver driver){
        this.driver = driver;
    }
    //Get the User name from Home Page
    public String getResultMembership(){
        return    driver.findElement(resultsList).getText();
    }
}