package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Principal {
    WebDriver driver;
    //boton  clubes
    By botonClub = By.xpath("//*[@id=\"clubLocationHeader\"]/img");
    //boton para seleccionar algun club
    By botonClubes = By.xpath("/html/body/form/div/div/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[3]/div[1]/button");

    //Boton categorias
    By botonCategorias = By.xpath("//*[@id=\"categories-dropdown\"]/div/div");

    //boton moda y accesorios
    By botonModa = By.name("Modayaccesorios");

    public Principal(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonClub(){
        driver.findElement(botonClub).click();
    }

    public void clickBotonClubes(){
        driver.findElement(botonClubes).click();
    }

    public void clickBotonCategorias(){
        driver.findElement(botonCategorias).click();
    }

    public void clickBotonModa(){
        driver.findElement(botonModa).click();
    }
}
