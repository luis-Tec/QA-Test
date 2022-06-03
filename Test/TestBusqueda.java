package Test;

import java.util.concurrent.TimeUnit;

import Pages.CountrysPage;
import Pages.HomePage;
import Pages.ResultadoBusqueda;
import Pages.FashionPage;
import Pages.ArticlesPage;
import Pages.ShoppingCartPage;
import Pages.MembershipPage;
import Pages.MembershipFormPage;
import Pages.ResultMembershipPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBusqueda {
    String driverPath = "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe";

    WebDriver driver;

    ResultadoBusqueda objResultadoBusqueda;

    CountrysPage objCountrysPage;

    HomePage objHomePage;

    FashionPage objFashionPage;

    ArticlesPage objArticlesPage;

    ShoppingCartPage objShoppingCartPage;

    MembershipPage objMembershipPage;

    MembershipFormPage objMembershipFormPage;

    ResultMembershipPage objResultMembershipPage;

    @BeforeTest

    public void setup() {

        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "dpCarrito")
    public void test_Comprar_Membrecia(String pais, String campus, String idioma) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objCountrysPage = new CountrysPage(driver);
        objHomePage = new HomePage(driver);




        //Seleccionar idioma
        objCountrysPage.clickButtonLenguaje(idioma);

        //Click al pais correspondiente
        objCountrysPage.clickButtonCountry(pais);
        //Thread.sleep(500);

        // click en club
        objHomePage.cilickClubButton();
        //Thread.sleep(1000);

        //click en un club
        objHomePage.clickClubsButtton(campus);

        //Buscar click en membresia
        objHomePage.clickMembershipButton();

        // click en comprar nueva membresia
        objHomePage.clickBuyMembershipButton();

        //pagina de membresia dar click en boton unete aquí
        objMembershipPage = new MembershipPage(driver);
        objMembershipPage.clickJoinHereButton();
        System.out.println(  "lklefsdfsdfdfsf " );

        objMembershipFormPage = new MembershipFormPage(driver);
        //pagina de formulario, llenarlo y dar click
        objMembershipFormPage.setNameTextField("Pedro");
        objMembershipFormPage.setLastNameTextField("Alvarado");
        objMembershipFormPage.setEmailTextField("pedro@hotmail.com");
        objMembershipFormPage.setEmailConfirmTextField("pedro@hotmail.com");
        objMembershipFormPage.setPasswordTextField("pedro1234567");
        objMembershipFormPage.setPasswordConfirmTextField("pedro1234567");
        objMembershipFormPage.setIdentificationTextField("123456789");
        objMembershipFormPage.setPhoneTextField("12345678");

        //ingresar el correo de la factura electronica solo para Guatemala y Costa Rica
        if(pais == "Costa Rica" || pais == "Guatemala"){
            objMembershipFormPage.setEmailFETextField("pedro@hotmail.com");
        }

        //click en terminos y condiciones
        objMembershipFormPage.clickTermsConditionsButton();

        //click confirmar pagar
        objMembershipFormPage.clickContinuePayButton();


        objResultMembershipPage = new ResultMembershipPage(driver);
        Assert.assertTrue(objResultMembershipPage.getResultMembership().contains("CVV"));


    }

   @Test(dataProvider = "dpBuscador")
    public void test_Buscar_Producto(String pais, String campus, String idioma, String producto) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objCountrysPage = new CountrysPage(driver);
        objHomePage = new HomePage(driver);

        //Seleccionar idioma
        objCountrysPage.clickButtonLenguaje(idioma);

        //Click al pais correspondiente
        objCountrysPage.clickButtonCountry(pais);
        Thread.sleep(5000);

        // click en club
        objHomePage.cilickClubButton();
        Thread.sleep(3000);

        //click en un club
        objHomePage.clickClubsButtton(campus);

        //Buscar producto
        objHomePage.searchProduct(producto);

        objResultadoBusqueda = new ResultadoBusqueda(driver);

        if (idioma.equals("es")) {
            Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().contains("Resultados para:"));
        } else if (idioma.equals("en")) {
            Assert.assertTrue(objResultadoBusqueda.getProductoBusquueda().contains("Results for:"));
        }
    }


    @Test(dataProvider = "dpCarrito")
    public void test_Agregar_Carrito(String pais, String campus, String idioma) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        //objBusqueda = new Busqueda(driver);
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objCountrysPage = new CountrysPage(driver);
        objHomePage = new HomePage(driver);
        objFashionPage = new FashionPage(driver);
        objArticlesPage = new ArticlesPage(driver);
        objShoppingCartPage = new ShoppingCartPage(driver);

        //Seleccionar idioma
        objCountrysPage.clickButtonLenguaje(idioma);

        //Click al pais correspondiente
        objCountrysPage.clickButtonCountry(pais);
        Thread.sleep(5000);

        // click en club
        objHomePage.cilickClubButton();
        Thread.sleep(3000);

        //click en un club
        objHomePage.clickClubsButtton(campus);

        //click en categorias
        objHomePage.clickCategoriesButton();
        Thread.sleep(3000);

        //click en moda y accesorios
        objHomePage.clickFashionButtom();

        Thread.sleep(5000);
        //click en el primer articulo
        objFashionPage.clickFirstObjectButton();

        // click en agregar al Carrito
        objArticlesPage.clickShoppingCartButton();

        //Verificar que se agrego al carrito
        Assert.assertTrue(objShoppingCartPage.getArticleShoppingCart().contains("PriceSmart | Carrito de compras"));
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
