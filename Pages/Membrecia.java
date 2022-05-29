package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Membrecia {
    WebDriver driver;

    By botonUneteAqui = By.xpath("//*[@id=\"lnkJoinNowDiamondTop\"]");


    public Membrecia(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonUneteAqui(){
        driver.findElement(botonUneteAqui).click();
    }
}
