package Test;
import Pages.CountrysPage;
import Pages.HomePage;
import Pages.FashionPage;
import Pages.ArticlesPage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingCartTest extends FatherTest{
    CountrysPage objCountrysPage;
    HomePage objHomePage;
    FashionPage objFashionPage;
    ArticlesPage objArticlesPage;
    ShoppingCartPage objShoppingCartPage;
    public ShoppingCartTest(){
        super();
    }
    @Test(priority = 1,dataProvider = "dpCarrito")
    public void test_Agregar_Carrito(String pais, String campus, String idioma) {
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
        // click en club
        objHomePage.cilickClubButton();
        //click en un club
        objHomePage.clickClubsButtton(campus);
        //click en categorias
        objHomePage.clickCategoriesButton();
        //click en moda y accesorios
        objHomePage.clickFashionButtom();
        //click en el primer articulo
        objFashionPage.clickFirstObjectButton();
        // click en agregar al Carrito
        objArticlesPage.clickShoppingCartButton();
        //Verificar que se agrego al carrito
        Assert.assertTrue(objShoppingCartPage.getArticleShoppingCart().contains("PriceSmart | Carrito de compras"));
    }
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
}