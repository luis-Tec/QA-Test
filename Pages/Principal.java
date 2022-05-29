package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Principal {
    WebDriver driver;

    //Buscador
    By barraBusqueda = By.name("_sq");


    //boton  clubes
    By botonClub = By.xpath("//*[@id=\"clubLocationHeader\"]");
    By botonCerrarMenuClubes = By.xpath("/html/body/form/div/div/div/div/div/div/div[1]/button");
    By dialogMensajeClub = By.xpath("//*[@id=\"selectClubAlert\"]");
    By botonDialogMensajeClub = By.xpath("/html/body/form/div/div/div/div/div[1]/div/div[2]/div/div/a[1]");



    //Texto del campus
    By textCampus = By.xpath("//*[@id=\"club-location-picker-cont\"]");

    //Extraer elementos hijos
    By elements = By.xpath("./child::*");

    //Boton categorias
    By botonCategorias = By.xpath("//*[@id=\"categories-dropdown\"]/div/div");

    //boton moda y accesorios
    By botonModa = By.xpath("//*[@id=\"Modayaccesorios\"]");

    By botonMembrecia = By.xpath("//*[@id=\"dropdownMenuButton\"]");

    By botonComprarMembrecia = By.xpath("//*[@id=\"signup-button\"]");

    public Principal(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBotonClub() {
        driver.findElement(botonClub).click();
        if (driver.findElements(dialogMensajeClub).size() != 0) {
            driver.findElement(botonDialogMensajeClub).click();
        }
    }

    public void clickBotonClubes(String campus) {
        List<WebElement> hijosTextCampus = driver.findElement(textCampus).findElements(elements);
        for (WebElement i : hijosTextCampus) {
            String x = i.findElement(By.id("club-description")).getText();
            System.out.println(x + " " + campus);
            if (campus.equals(x)) {
                if (i.findElements(By.id("club-select")).size() != 0) {
                    driver.findElement(botonCerrarMenuClubes).click();
                } else {
                    i.findElement(By.id("select-club")).click();
                }
                break;
            }
        }
    }

    public void clickBotonCategorias() {

        driver.findElement(botonCategorias).click();
    }

    public void clickBotonModa() {
        driver.findElement(botonCategorias);
        driver.findElement(botonModa).click();
    }

    public void clickBotonMembrecia() {

        driver.findElement(botonMembrecia).click();
    }

    public void clickBotonComprarMembrecia() {
        driver.findElement(botonMembrecia);
        driver.findElement(botonComprarMembrecia).click();
    }

    public void setProducto(String strProducto) {
        driver.findElement(barraBusqueda).sendKeys(strProducto);
    }

    public void enterBarraBusqueda() {
        driver.findElement(barraBusqueda).sendKeys(Keys.RETURN);
    }

    public void buscarProducto(String strProducto) {
        //Ingresa el producto
        this.setProducto(strProducto);

        //Busca el producto al presionar "ENTER"
        this.enterBarraBusqueda();
    }

}
