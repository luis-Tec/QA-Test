package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Paises {
    WebDriver driver;

    By botonCostaRica = By.xpath("//*[@id=\"country-picker-home\"]/div/div[5]/div/div/div[1]/div/ul/li[1]/a/div[1]/img");


    public Paises(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonCostaRica(){driver.findElement(botonCostaRica).click();
    }
}
