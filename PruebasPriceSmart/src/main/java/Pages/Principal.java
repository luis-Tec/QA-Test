package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Principal {
    WebDriver driver;

    //boton  clubes
    By botonClub = By.xpath("//*[@id=\"clubLocationHeader\"]");

    By dialogMensajeClub = By.xpath("//*[@id=\"selectClubAlert\"]");
    By botonDialogMensajeClub = By.xpath("/html/body/form/div/div/div/div/div[1]/div/div[2]/div/div/a[1]");

    //Boton categorias
    By botonCategorias = By.xpath("//*[@id=\"categories-dropdown\"]/div/div");

    //Texto del campus
    By textCampus = By.xpath("//*[@id=\"club-location-picker-cont\"]");

    //Extraer elementos hijos
    By elements = By.xpath("./child::*");

    //boton moda y accesorios
    By botonModa = By.xpath("//*[@id=\"Modayaccesorios\"]");


    public Principal(WebDriver driver){
        this.driver = driver;
    }

    public void clickBotonClub(){
        driver.findElement(botonClub).click();
        if(driver.findElements(dialogMensajeClub).size() != 0){
            driver.findElement(botonDialogMensajeClub).click();
        }
    }

    public void clickBotonClubes(String campus){
        List<WebElement> hijosTextCampus = driver.findElement(textCampus).findElements(elements);
        for ( WebElement i : hijosTextCampus ) {
            String x = i.findElement(By.id("club-description")).getText();
            System.out.println(x+" "+campus);
            if(campus.equals(x)){
                i.findElement(By.id("select-club")).click();
                break;
            }
        }
    }

    public void clickBotonCategorias(){
        driver.findElement(botonCategorias).click();
    }

    public void clickBotonModa(){
        driver.findElement(botonCategorias);
        driver.findElement(botonModa).click();
    }
}
