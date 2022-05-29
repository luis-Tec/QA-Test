package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ResultadoBusqueda {
    WebDriver driver;

    By listaResultados = By.xpath("//*[@id=\"product-search\"]");



    public ResultadoBusqueda(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public String getProductoBusquueda(){

        return    driver.findElement(listaResultados).getText();

    }

}
