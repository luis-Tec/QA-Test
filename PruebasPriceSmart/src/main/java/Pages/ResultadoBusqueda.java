package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ResultadoBusqueda {
    WebDriver driver;

    By listaResultados = By.xpath("/html/body/section/section/section[2]/div/div[2]/div/div/div/section/div/div/div/span/h3/span[2]");



    public ResultadoBusqueda(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

    public String getProductoBusquueda(){

        return    driver.findElement(listaResultados).getText();

    }

}
