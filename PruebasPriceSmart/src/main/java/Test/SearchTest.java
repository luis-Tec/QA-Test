package Test;
import Pages.CountrysPage;
import Pages.HomePage;
import Pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends FatherTest{
    SearchResultPage objResultadoBusqueda;
    CountrysPage objCountrysPage;
    HomePage objHomePage;
    @Test(dataProvider = "dpBuscador")
    public void test_SearchProduct(String country, String campus, String lenguaje, String producto) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");
        //Crear objetos
        objCountrysPage = new CountrysPage(driver);
        objHomePage = new HomePage(driver);
        objResultadoBusqueda = new SearchResultPage(driver);
        //Seleccionar idioma
        objCountrysPage.clickButtonLenguaje(lenguaje);
        //Click al pais correspondiente
        objCountrysPage.clickButtonCountry(country);
        Thread.sleep(5000);
        // click en club
        objHomePage.cilickClubButton();
        //click en un club
        objHomePage.clickClubsButtton(campus);
        //Buscar producto
        objHomePage.searchProduct(producto);
        Assert.assertTrue(objResultadoBusqueda.getSearchProduct().contains(producto));
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
}