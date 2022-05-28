package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Moda {
    WebDriver driver;

    By botonPrimerObjeto = By.xpath("/html/body/section/section[1]/section[3]/div/div[2]/div/div/div/div/section/div/div/div/div/div[2]/div/div/section/div/section/div/div/div/div/div/div/div[1]/div/a/div[2]");


    public Moda(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonPrimerObjeto(){
        driver.findElement(botonPrimerObjeto).click();
    }
}
