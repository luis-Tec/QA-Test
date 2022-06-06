package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class ArticlesPage {
    WebDriver driver;
    By addShoppingCartButton = By.xpath("//*[@id=\"btn-add-to-cart\"]");
    public ArticlesPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickShoppingCartButton(){
        driver.findElement(addShoppingCartButton).click();
    }
}
