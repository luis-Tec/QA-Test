package Test;

import java.util.concurrent.TimeUnit;

import Pages.Busqueda;
import Pages.ResultadoBusqueda;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestBusqueda {
    String driverPath = "C:\\Users\\Luis\\Documents\\Selenium\\chromedriver\\chromedriver.exe";

    WebDriver driver;

    Busqueda objBusqueda;

    ResultadoBusqueda objResultadoBusqueda;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.pricesmart.com/site/cr/es");

    }
    @Test(priority=0)

    public void test_Home_Page_Appear_Correct() {

        //Create Login Page object

        objBusqueda = new Busqueda(driver);

        //login to application

        objBusqueda.buscarProducto("frijol");

        // go the next page

        objResultadoBusqueda = new ResultadoBusqueda(driver);

        //Verify home page

        Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().toLowerCase().contains("Resultados para:"));
    }
}
