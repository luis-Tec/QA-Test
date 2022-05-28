package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Articulos {
    WebDriver driver;

    By botonAgregarCarrito = By.name("btn-add-to-cart");

    public Articulos(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonAgregarCarrito(){
        driver.findElement(botonAgregarCarrito).click();
    }
}
