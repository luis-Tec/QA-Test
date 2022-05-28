package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Carrito {
    WebDriver driver;

    By listaResultado = By.xpath("//*[@id=\"home\"]/div/div/div[2]/div[1]/div/div/div/div[1]/div/div[1]/div/h3");


    public Carrito(WebDriver driver){

        this.driver = driver;

    }


    public String getArticulosCarrito(){

        return    driver.findElement(listaResultado).getText();

    }
}

