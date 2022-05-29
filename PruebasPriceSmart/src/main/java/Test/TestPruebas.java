package Test;

import java.util.concurrent.TimeUnit;

import Pages.Paises;
import Pages.Principal;
import Pages.ResultadoBusqueda;
import Pages.Moda;
import Pages.Articulos;
import Pages.Carrito;
import Pages.Membrecia;
import Pages.MembreciaFormulario;
import Pages.MembreciaResultado;

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

public class TestPruebas {
    String driverPath = "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    WebDriver driver;

    ResultadoBusqueda objResultadoBusqueda;

    Paises objPaises;

    Principal objPrincipal;

    Moda objModa;

    Articulos objArticulos;

    Carrito objCarrito;

    Membrecia objMembrecia;

    MembreciaFormulario objMembreciaFormulario;

    MembreciaResultado objMembreciaResultado;

    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "dpMembrecia")
    public void test_Comprar_Membrecia(String pais, String campus, String idioma, String producto) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objPaises = new Paises(driver);
        objPrincipal = new Principal(driver);
        objMembrecia = new Membrecia(driver);
        objMembreciaFormulario = new MembreciaFormulario(driver);
        objMembreciaResultado = new MembreciaResultado(driver);

        //Seleccionar idioma
        objPaises.clickBotonIdioma(idioma);

        //Click al pais correspondiente
        objPaises.clickBotonPais(pais);
        Thread.sleep(1000);

        // click en club
        objPrincipal.clickBotonClub();
        Thread.sleep(3000);

        //click en un club
        objPrincipal.clickBotonClubes(campus);

        //Buscar click en membresia
        objPrincipal.clickBotonMembrecia();

        // click en comprar nueva membresia
        objPrincipal.clickBotonComprarMembrecia();

        //pagina de membresia dar click en boton unete aquí
        objMembrecia.clickBotonUneteAqui();

        //pagina de formulario, llenarlo y dar click
        objMembreciaFormulario.setNombre("Pedro");
        objMembreciaFormulario.setApellido("Alvarado");
        objMembreciaFormulario.setCorreo("pedro@hotmail.com");
        objMembreciaFormulario.setCorreoConfirmar("pedro@hotmail.com");
        objMembreciaFormulario.setContraseña("pedro1234567");
        objMembreciaFormulario.setConttraseñaConfirmar("pedro1234567");
        objMembreciaFormulario.setIdentificacion("123456789");
        objMembreciaFormulario.setTelefono("12345678");

        //ingresar el correo de la factura electronica solo para Guatemala Costa Rica
        if(pais == "Costa Rica" || pais == "Guatemala"){
            objMembreciaFormulario.setCorreoFE("pedro@hotmail.com");
        }

        //click en terminos y condiciones
        objMembreciaFormulario.clickBotonTerminosCondiciones();

        //click confirmar pagar
        objMembreciaFormulario.clickBotonContinuarPagar();


        objResultadoBusqueda = new ResultadoBusqueda(driver);


        Assert.assertTrue(objMembreciaResultado.getMembreciaResultado().contains("CVV"));


    }

   /* @Test(dataProvider = "dpBuscador")
    public void test_Buscar_Producto(String pais, String campus, String idioma, String producto) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objPaises = new Paises(driver);
        objPrincipal = new Principal(driver);
        objResultadoBusqueda = new ResultadoBusqueda(driver);

        //Seleccionar idioma
        objPaises.clickBotonIdioma(idioma);

        //Click al pais correspondiente
        objPaises.clickBotonPais(pais);
        Thread.sleep(5000);

        // click en club
        objPrincipal.clickBotonClub();
        Thread.sleep(3000);

        //click en un club
        objPrincipal.clickBotonClubes(campus);

        //Buscar producto
        objPrincipal.buscarProducto(producto);

        objResultadoBusqueda = new ResultadoBusqueda(driver);

         Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().contains(producto));
    }*/

/*
    @Test(dataProvider = "dpCarrito")
    public void test_Agregar_Carrito(String pais, String campus, String idioma) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        objBusqueda = new Busqueda(driver);
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objPaises = new Paises(driver);
        objPrincipal = new Principal(driver);
        objModa = new Moda(driver);
        objArticulos = new Articulos(driver);
        objCarrito = new Carrito(driver);

        //Seleccionar idioma
        objPaises.clickBotonIdioma(idioma);

        //Click al pais correspondiente
        objPaises.clickBotonPais(pais);
        Thread.sleep(5000);

        // click en club
        objPrincipal.clickBotonClub();
        Thread.sleep(3000);

        //click en un club
        objPrincipal.clickBotonClubes(campus);

        //click en categorias
        objPrincipal.clickBotonCategorias();
        Thread.sleep(3000);

        //click en moda y accesorios
        objPrincipal.clickBotonModa();

        Thread.sleep(5000);
        //click en el primer articulo
        objModa.clickBotonPrimerObjeto();

        // click en agregar al Carrito
        objArticulos.clickBotonAgregarCarrito();

        //Verificar que se agrego al carrito
        Assert.assertTrue(objCarrito.getArticulosCarrito().contains("PriceSmart | Carrito de compras"));
    }
/*
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





    @DataProvider(name = "dpCarrito")
    public static Object[][] dataProviderCarrito() {
        return new Object[][]
                {
                        {"Costa Rica", "Zapote", "es"},
                        {"Costa Rica", "Escazú", "es"},
                        {"Costa Rica", "Heredia", "es"},
                        {"Costa Rica", "Llorente", "es"},
                        {"Costa Rica", "Alajuela", "es"},
                        {"Costa Rica", "Tres Ríos", "es"},
                        {"Costa Rica", "Santa Ana", "es"},
                        {"El Salvador", "Santa Elena", "en"},
                        {"El Salvador", "Los Héroes", "es"},
                        {"Guatemala", "Aranda", "es"},
                        {"Guatemala", "Miraflores", "es"},
                        {"Guatemala", "Pradera", "es"},
                        {"Guatemala", "Fraijanes", "es"},
                        {"Guatemala", "San Cristóbal", "es"},
                        {"Honduras", "Florencia", "es"},
                        {"Honduras", "San Pedro Sula", "es"},
                        {"Honduras", "El Sauce", "es"},
                        {"Nicaragua", "Managua", "es"},
                        {"Nicaragua", "Masaya", "es"},
                        {"Panamá", "Vía Brasil", "es"},
                        {"Panamá", "El Dorado", "es"},
                        {"Panamá", "David", "es"},
                        {"Panamá", "Brisas", "es"},
                        {"Panamá", "Costa Verde", "es"},
                        {"Panamá", "Santiago de Veraguas", "es"},
                        {"Panamá", "Metro Park", "es"},
                        {"Aruba", "Oranjestad", "es"},
                        {"Barbados", "St. Michaels", "es"},
                        {"República Dominicana", "Los Prados", "es"},
                        {"República Dominicana", "Santiago", "es"},
                        {"República Dominicana", "Arroyo Hondo", "es"},
                        {"República Dominicana", "San Isidro", "es"},
                        {"República Dominicana", "Bolívar", "es"},
                        {"Jamaica", "Portmore", "es"},
                        {"Jamaica", "Kingston", "es"},
                        {"Trinidad y Tobago", "Chaguanas", "es"},
                        {"Trinidad y Tobago", "Port of Spain", "es"},
                        {"Trinidad y Tobago", "Mausica", "es"},
                        {"Trinidad y Tobago", "San Fernando", "es"},
                        {"Islas Vírgenes, US", "St. Thomas", "es"},
                        {"Colombia", "Bucaramanga - Floridablanca", "es"},
                        {"Colombia", "Barranquilla", "es"},
                        {"Colombia", "Cali Cañasgordas", "es"},
                        {"Colombia", "Cali Menga", "es"},
                        {"Colombia", "Pereira", "es"},
                        {"Colombia", "Bogotá Salitre", "es"},
                        {"Colombia", "Medellín", "es"},
                        {"Colombia", "Chía", "es"},
                        {"Colombia", "Bogotá Usaquén", "es"}

                };
    }

    @DataProvider(name = "dpBuscador")
    public static Object[][] dataProviderBuscador() {
        return new Object[][]
                {
                        {"Costa Rica", "Zapote", "es", "frijol"},
                        {"Costa Rica", "Escazú", "en", "beans"},
                        {"Costa Rica", "Heredia", "es", "banano"},
                        {"Costa Rica", "Llorente", "es", "carne"},
                        {"Costa Rica", "Alajuela", "es", "pollo"},
                        {"Costa Rica", "Tres Ríos", "es", "tv"},
                        {"Costa Rica", "Santa Ana", "es", "foco"},
                        {"El Salvador", "Santa Elena", "en", "atun"},
                        {"El Salvador", "Los Héroes", "es", "tomate"},
                        {"Guatemala", "Aranda", "es", "aceite"},
                        {"Guatemala", "Miraflores", "es", "filete"},
                        {"Guatemala", "Pradera", "es", "pollo"},
                        {"Guatemala", "Fraijanes", "es", "carne"},
                        {"Guatemala", "San Cristóbal", "es", "atún"},
                        {"Honduras", "Florencia", "es", "lomo"},
                        {"Honduras", "San Pedro Sula", "es", "arroz"},
                        {"Honduras", "El Sauce", "es", "queso"},
                        {"Nicaragua", "Managua", "es", "tortilla"},
                        {"Nicaragua", "Masaya", "es", "salmón"},
                        {"Panamá", "Vía Brasil", "es", "frijoles"},
                        {"Panamá", "El Dorado", "es", "cloro"},
                        {"Panamá", "David", "es", "jabon"},
                        {"Panamá", "Brisas", "es", "neumatico"},
                        {"Panamá", "Costa Verde", "es", "vidrio"},
                        {"Panamá", "Santiago de Veraguas", "es", "espejo"},
                        {"Panamá", "Metro Park", "es", "pintura"},
                        {"Aruba", "Oranjestad", "es", "maquillaje"},
                        {"Barbados", "St. Michaels", "es", "labial"},
                        {"República Dominicana", "Los Prados", "es", "agua"},
                        {"República Dominicana", "Santiago", "es", "espuma"},
                        {"República Dominicana", "Arroyo Hondo", "es", "queso"},
                        {"República Dominicana", "San Isidro", "es", "pescado"},
                        {"República Dominicana", "Bolívar", "es", "perro"},
                        {"Jamaica", "Portmore", "es", "gato"},
                        {"Jamaica", "Kingston", "es", "pajaro"},
                        {"Trinidad y Tobago", "Chaguanas", "es", "pasto"},
                        {"Trinidad y Tobago", "Port of Spain", "es", "tierra"},
                        {"Trinidad y Tobago", "Mausica", "es", "aire"},
                        {"Trinidad y Tobago", "San Fernando", "es", "fuego"},
                        {"Islas Vírgenes, US", "St. Thomas", "es", "sillón"},
                        {"Colombia", "Bucaramanga - Floridablanca", "es", "bola"},
                        {"Colombia", "Barranquilla", "es", "guantes"},
                        {"Colombia", "Cali Cañasgordas", "es", "alfombra"},
                        {"Colombia", "Cali Menga", "es", "libro"},
                        {"Colombia", "Pereira", "es", "anteojos"},
                        {"Colombia", "Bogotá Salitre", "es", "cocina"},
                        {"Colombia", "Medellín", "es", "baño"},
                        {"Colombia", "Chía", "es", "escoba"},
                        {"Colombia", "Bogotá Usaquén", "es", "maletas"}
                };
    }

    @DataProvider(name = "dpMembrecia")
    public static Object[][] dataProviderMembrecia() {
        return new Object[][]
                {
                        {"Costa Rica", "Escazú", "en", "beans"},
                        {"El Salvador", "Santa Elena", "en", "atun"},
                        {"El Salvador", "Los Héroes", "es", "tomate"},
                        {"Costa Rica", "Zapote", "es", "frijol"},
                        {"Costa Rica", "Heredia", "es", "banano"},
                        {"Costa Rica", "Llorente", "es", "carne"},
                        {"Costa Rica", "Alajuela", "es", "pollo"},
                        {"Costa Rica", "Tres Ríos", "es", "tv"},
                        {"Costa Rica", "Santa Ana", "es", "foco"},

                };
    }

}
