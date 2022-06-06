package Test;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyMembershipTest extends FatherTest{
    CountrysPage objCountrysPage;
    HomePage objHomePage;
    MembershipPage objMembershipPage;
    MembershipFormPage objMembershipFormPage;
    ResultMembershipPage objResultMembershipPage;
    @Test(dataProvider = "dpMembership")
    public void test_Buy_Membership(String country, String campus, String lenguaje) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get("https://www.pricesmart.com/site/es/seleccionar-pais");

        //Crear objetos
        objCountrysPage = new CountrysPage(driver);
        objHomePage = new HomePage(driver);
        objMembershipPage = new MembershipPage(driver);
        objMembershipFormPage = new MembershipFormPage(driver);
        objResultMembershipPage = new ResultMembershipPage(driver);

        //Seleccionar idioma
        objCountrysPage.clickButtonLenguaje(lenguaje);

        //Click al pais correspondiente
        objCountrysPage.clickButtonCountry(country);
        Thread.sleep(1000);

        // click en club
        objHomePage.cilickClubButton();
        Thread.sleep(3000);

        //click en un club
        objHomePage.clickClubsButtton(campus);
        //Buscar click en membresia
        objHomePage.clickMembershipButton();
        // click en comprar nueva membresia
        objHomePage.clickBuyMembershipButton();
        //pagina de membresia dar click en boton unete aquí
        objMembershipPage.clickJoinHereButton();
        //pagina de formulario, llenarlo y dar click
        objMembershipFormPage.setNameTextField("Pedro");
        objMembershipFormPage.setLastNameTextField("Alvarado");
        objMembershipFormPage.setEmailTextField("pedro@hotmail.com");
        objMembershipFormPage.setEmailConfirmTextField("pedro@hotmail.com");
        objMembershipFormPage.setPasswordTextField("pedro1234567");
        objMembershipFormPage.setPasswordConfirmTextField("pedro1234567");
        objMembershipFormPage.setIdentificationTextField("123456789");
        objMembershipFormPage.setPhoneTextField("12345678");
        //ingresar el correo de la factura electronica solo para Guatemala Costa Rica
        if(country == "Costa Rica" || country == "Guatemala"){
            objMembershipFormPage.setEmailFETextField("pedro@hotmail.com");
        }
        //click en terminos y condiciones
        objMembershipFormPage.clickTermsConditionsButton();
        //click confirmar pagar
        objMembershipFormPage.clickContinuePayButton();
        Assert.assertTrue(objResultMembershipPage.getResultMembership().contains("CVV"));
    }
    @DataProvider(name = "dpMembership")
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