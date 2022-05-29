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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
    }
    /*
    @Test(dataProvider = "dp")
    public void test_Home_Page_Appear_Correct(String pais, String url) {
        objBusqueda = new Busqueda(driver);
        driver.get(url);
        objBusqueda.buscarProducto("frijol");
        objResultadoBusqueda = new ResultadoBusqueda(driver);
        Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().contains("Resultados para:"));
    }

     */

    @Test(dataProvider = "dp")
    public void test_Agregar_Carrito(String pais, String campus) throws InterruptedException {
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objPaises = new Paises(driver);
        objPrincipal = new Principal(driver);
        objModa = new Moda(driver);
        objArticulos = new Articulos(driver);
        objCarrito = new Carrito(driver);

        //darle enter en el boton de pais correspndiente
        objPaises.clickBotonCostaRica();
        Thread.sleep(10000);
        // click en club
        objPrincipal.clickBotonClub();

        //click en un club
        objPrincipal.clickBotonClubes(campus);

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

    /*
    @DataProvider(name="dp")
    public static Object[][] readJson() throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("C:\\Users\\Luis\\Documents\\GitHub\\QA-Test\\PruebasPriceSmart\\src\\main\\java\\json\\DataProvider.json");
        Object obj = jsonParser.parse(fileReader);

        Object[][] jsonObj = null;

        JSONArray lista = (JSONArray) obj;
        for(int i=0;i<lista.size();i++)
        {
            JSONObject datos = (JSONObject) lista.get(0);
            JSONObject pais = (JSONObject) datos.get("pais");
            String  nombre = (String) pais.get("nombre");
            String  url = (String) pais.get("url");
            JSONArray campuslist =  (JSONArray) pais.get("campus");
            System.out.println(nombre);
            System.out.println(url);
            System.out.println(campuslist);
        }
        return null;
    }*/


    @DataProvider(name = "dp")
    public static Object[][] dataProviderMethod() {
        return new Object[][]
                {
                        {"Costa Rica", "Zapote"},
                        {"Costa Rica", "Escazú"},
                        {"Costa Rica", "Heredia"},
                        {"Costa Rica", "Llorente"},
                        {"Costa Rica", "Alajuela"},
                        {"Costa Rica", "Tres Ríos"},
                        {"Costa Rica", "Santa Ana"},
                        {"Costa Rica", "Liberia"}
                };
    }

}
