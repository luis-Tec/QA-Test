package Pages;
import java.util.concurrent.TimeUnit;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Busqueda {
    WebDriver driver;

    By barraBusqueda = By.name("_sq");

    By login = By.name("btnLogin");

    public Busqueda(WebDriver driver){

        this.driver = driver;

    }

    //Set user name in textbox

    public void setProducto(String strProducto){

        driver.findElement(barraBusqueda).sendKeys(strProducto);
    }


    //Click on login button

    public void enterBarraBusqueda(){
        driver.findElement(barraBusqueda).sendKeys(Keys.RETURN);
    }


    public void buscarProducto(String strProducto){

        //Ingresa el producto

        this.setProducto(strProducto);


        //Busca el producto al presionar "ENTER"

        this.enterBarraBusqueda();
    }
}
