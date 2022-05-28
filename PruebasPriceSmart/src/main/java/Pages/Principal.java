package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Principal {
    WebDriver driver;
    //boton  clubes
    By botonClub = By.xpath("//*[@id=\"clubLocationHeader\"]");

    //boton para seleccionar algun club
    By botonClubes = By.xpath("//*[@id=\"club-location-picker-cont\"]/div[1]");

    //click nuevo club
    By boton = By.xpath("//*[@id=\"select-club\"]");

    //Boton categorias
    By botonCategorias = By.xpath("//*[@id=\"categories-dropdown\"]/div/div");

    //boton moda y accesorios
    By botonModa = By.name("Modayaccesorios");


    public void setCampus(String strCampus){
        //river.findElement().getText();
    }

    public Principal(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonClub(){
        driver.findElement(botonClub).click();
    }

    public void clickBotonClubes(){
        driver.findElement(botonClubes);
        driver.findElement(boton).click();
    }

    public void clickBotonCategorias(){
        driver.findElement(botonCategorias).click();
    }

    public void clickBotonModa(){
        driver.findElement(botonModa).click();
    }
}
