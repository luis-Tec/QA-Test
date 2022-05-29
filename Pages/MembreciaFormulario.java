package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MembreciaFormulario {
    WebDriver driver;

    By botonContinuarPagar = By.xpath("//*[@id=\"sendInfoNotAero\"]");

    By barraNombre = By.xpath("//*[@id=\"firstName\"]");

    By barraApellido = By.xpath("//*[@id=\"lastName\"]");

    By barraCorreo = By.xpath("//*[@id=\"email\"]");

    By barraCorreoConfirmar = By.xpath("//*[@id=\"emailConfirm\"]");

    By barraContraseña = By.xpath("//*[@id=\"txtpassword\"]");

    By barraContraseñaConfirmar = By.xpath("//*[@id=\"passwordConfirm\"]");

    By barraIdentificacion = By.xpath("//*[@id=\"identification\"]");

    By barraTelefono = By.xpath("//*[@id=\"phone\"]");

    //By barraIdentificacionFE = By.name("numberElectronicInvoice");

    By barraCorreoFE = By.xpath("//*[@id=\"emailElectronicInvoice\"]");

    By botonTerminosCondiciones = By.xpath("//*[@id=\"terms-label\"]");


    public MembreciaFormulario(WebDriver driver){

        this.driver = driver;

    }

    public void clickBotonContinuarPagar(){
        driver.findElement(botonContinuarPagar).click();
    }

    public void clickBotonTerminosCondiciones(){
        driver.findElement(botonTerminosCondiciones).click();
    }

    public void setNombre(String strProducto){
        driver.findElement(barraNombre).sendKeys(strProducto);
    }

    public void setApellido(String strProducto){
        driver.findElement(barraApellido).sendKeys(strProducto);
    }

    public void setCorreo(String strProducto){
        driver.findElement(barraCorreo).sendKeys(strProducto);
    }

    public void setCorreoConfirmar(String strProducto){
        driver.findElement(barraCorreoConfirmar).sendKeys(strProducto);
    }

    public void setContraseña(String strProducto){
        driver.findElement(barraContraseña).sendKeys(strProducto);
    }

    public void setConttraseñaConfirmar(String strProducto){
        driver.findElement(barraContraseñaConfirmar).sendKeys(strProducto);
    }

    public void setIdentificacion(String strProducto){
        driver.findElement(barraIdentificacion).sendKeys(strProducto);
    }

    public void setTelefono(String strProducto){
        driver.findElement(barraTelefono).sendKeys(strProducto);
    }

    public void setCorreoFE(String strProducto){
        driver.findElement(barraCorreoFE).sendKeys(strProducto);
    }


}
