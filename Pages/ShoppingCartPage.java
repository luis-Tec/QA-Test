package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ShoppingCartPage {
    WebDriver driver;

    By resultList = By.xpath("//*[@id=\"home\"]/div/div/div[2]/div[1]/div/div/div/div[1]/div/div[1]/div/h3");


    public ShoppingCartPage(WebDriver driver){

        this.driver = driver;

    }
    public String getArticleShoppingCart(){

        return    driver.findElement(resultList).getText();

    }
}

