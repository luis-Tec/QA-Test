package Test;

import java.util.concurrent.TimeUnit;

import Pages.Busqueda;
import Pages.Paises;
import Pages.Principal;
import Pages.ResultadoBusqueda;
import Pages.Moda;
import Pages.Articulos;
import Pages.Carrito;

import Pages.ResultadoBusqueda;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestBusqueda {
    String driverPath = "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    WebDriver driver;

    Busqueda objBusqueda;

    ResultadoBusqueda objResultadoBusqueda;

    Paises objPaises;

    Principal objPrincipal;

    Moda objModa;

    Articulos objArticulos;

    Carrito objCarrito;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

    }
    /*@Test(priority=0)

    public void test_Home_Page_Appear_Correct() {

        //Create Login Page object

        objBusqueda = new Busqueda(driver);

        //login to application

        objBusqueda.buscarProducto("frijol");

        // go the next page

        objResultadoBusqueda = new ResultadoBusqueda(driver);

        //Verify home page

        Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().contains("Resultados para:"));
    }*/

    @Test(priority=1)

    public void test_Agregar_Carrito() {

        //Crear objetos
        objPaises = new Paises(driver);
        objPrincipal = new Principal(driver);
        objModa = new Moda(driver);
        objArticulos = new Articulos(driver);
        objCarrito = new Carrito(driver);

        //darle enter en el boton de pais correspndiente
        objPaises.clickBotonCostaRica();

        // click en club
        objPrincipal.clickBotonClub();

        //click en un club
        objPrincipal.clickBotonClubes();

        //click en categorias
        objPrincipal.clickBotonCategorias();

        //click en moda y accesorios
        objPrincipal.clickBotonModa();

        //click en el primer articulo
        objModa.clickBotonPrimerObjeto();

        // click en agregar al Carrito
        objArticulos.clickBotonAgregarCarrito();

        //Verificar que se agrego al carrito
        Assert.assertTrue(objCarrito.getArticulosCarrito().contains("PriceSmart | Carrito de compras"));
    }
}
