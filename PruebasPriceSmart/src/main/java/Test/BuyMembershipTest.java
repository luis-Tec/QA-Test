package Test;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyMembershipTest extends FatherTest{
    //CountrysPage objCountrysPage;
    //HomePage objHomePage;
    //MembershipPage objMembershipPage;
    MembershipFormPage objMembershipFormPage;
    ResultMembershipPage objResultMembershipPage;
    @Test(dataProvider = "dpMembership")
    public void test_Buy_Membership(String country, String name, String lastName, String email,String emailConfirm,String password, String passwordConfirm, String ID, String phone, String emailFE, String url) throws InterruptedException {
        //Cargar la pagina de seleccion de paises
        driver.get(url);

        //Crear objetos
        objMembershipFormPage = new MembershipFormPage(driver);
        objResultMembershipPage = new ResultMembershipPage(driver);

        //pagina de formulario, llenarlo y dar click
        objMembershipFormPage.setNameTextField(name);
        objMembershipFormPage.setLastNameTextField(lastName);
        objMembershipFormPage.setEmailTextField(email);
        objMembershipFormPage.setEmailConfirmTextField(emailConfirm);
        objMembershipFormPage.setPasswordTextField(password);
        objMembershipFormPage.setPasswordConfirmTextField(passwordConfirm);
        objMembershipFormPage.setIdentificationTextField(ID);
        objMembershipFormPage.setPhoneTextField(phone);
        if(country == "Costa Rica" || country == "Guatemala"){
            objMembershipFormPage.setEmailFETextField(emailFE);
        }
        //click en terminos y condiciones
        objMembershipFormPage.clickTermsConditionsButton();
        //click confirmar pagar
        objMembershipFormPage.clickContinuePayButton();
        Assert.assertTrue(objResultMembershipPage.getResultMembership().contains("CVV"));
    }
    @DataProvider(name = "dpMembership")
    public static Object[][] dataProviderMemberShip() {
        return new Object[][]
                {
                        {"Costa Rica", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6401"},
                        {"Costa Rica", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6402"},
                        {"Costa Rica", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6403"},
                        {"Costa Rica", "Luis","Lopez","luis@hotmail.com","luis@hotmail.com","luis1234567","luis1234567","123456789","12345678","luis@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6404"},
                        {"Costa Rica", "Andres","Figueres","andres@hotmail.com","andres@hotmail.com","andres1234567","andres1234567","123456789","12345678","andres@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6405"},
                        {"Costa Rica", "Jose","Ramos","jose@hotmail.com","jose@hotmail.com","jose1234567","jose1234567","123456789","12345678","jose@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6406"},
                        {"Costa Rica", "Rafael","Flores","rafael@hotmail.com","rafael@hotmail.com","rafael1234567","rafael1234567","123456789","12345678","rafael@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6407"},
                        {"Costa Rica", "Maria","Ramirez","maria@hotmail.com","maria@hotmail.com","maria1234567","maria1234567","123456789","12345678","maria@hotmail.com", "https://www.pricesmart.com/site/cr/es/registro?item_number=989998&club_code=6408"},
                        {"El Salvador", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/sv/es/registro?item_number=989998&club_code=6701"},
                        {"El Salvador", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/sv/es/registro?item_number=989998&club_code=6702"},
                        {"Guatemala", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/gt/es/registro?item_number=989998&club_code=6301"},
                        {"Guatemala", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/gt/es/registro?item_number=989998&club_code=6303"},
                        {"Guatemala", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/gt/es/registro?item_number=989998&club_code=6304"},
                        {"Guatemala", "Luis","Lopez","luis@hotmail.com","luis@hotmail.com","luis1234567","luis1234567","123456789","12345678","luis@hotmail.com", "https://www.pricesmart.com/site/gt/es/registro?item_number=989998&club_code=6305"},
                        {"Guatemala", "Andres","Figueres","andres@hotmail.com","andres@hotmail.com","andres1234567","andres1234567","123456789","12345678","andres@hotmail.com", "https://www.pricesmart.com/site/gt/es/registro?item_number=989998&club_code=6306"},
                        {"Honduras", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/hn/es/registro?item_number=989998&club_code=6602"},
                        {"Honduras", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/hn/es/registro?item_number=989998&club_code=6603"},
                        {"Honduras", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/hn/es/registro?item_number=989998&club_code=6604"},
                        {"Panamá", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6202"},
                        {"Panamá", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6203"},
                        {"Panamá", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6204"},
                        {"Panamá", "Luis","Lopez","luis@hotmail.com","luis@hotmail.com","luis1234567","luis1234567","123456789","12345678","luis@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6205"},
                        {"Panamá", "Andres","Figueres","andres@hotmail.com","andres@hotmail.com","andres1234567","andres1234567","123456789","12345678","andres@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6206"},
                        {"Panamá", "Jose","Ramos","jose@hotmail.com","jose@hotmail.com","jose1234567","jose1234567","123456789","12345678","jose@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6207"},
                        {"Panamá", "Rafael","Flores","rafael@hotmail.com","rafael@hotmail.com","rafael1234567","rafael1234567","123456789","12345678","rafael@hotmail.com", "https://www.pricesmart.com/site/pa/es/registro?item_number=989998&club_code=6208"},
                        {"Nicaragua", "Jose","Ramos","jose@hotmail.com","jose@hotmail.com","jose1234567","jose1234567","123456789","12345678","jose@hotmail.com", "https://www.pricesmart.com/site/ni/es/registro?item_number=989998&club_code=8901"},
                        {"Nicaragua", "Rafael","Flores","rafael@hotmail.com","rafael@hotmail.com","rafael1234567","rafael1234567","123456789","12345678","rafael@hotmail.com", "https://www.pricesmart.com/site/ni/es/registro?item_number=989998&club_code=8902"},
                        {"Aruba", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/aw/es/registro?item_number=989998&club_code=8201"},
                        {"Barbados", "Rafael","Flores","rafael@hotmail.com","rafael@hotmail.com","rafael1234567","rafael1234567","123456789","12345678","rafael@hotmail.com", "https://www.pricesmart.com/site/bb/es/registro?item_number=989998&club_code=8501"},
                        {"República Dominicana", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/do/es/registro?item_number=989998&club_code=6801"},
                        {"República Dominicana", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/do/es/registro?item_number=989998&club_code=6802"},
                        {"República Dominicana", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/do/es/registro?item_number=989998&club_code=6804"},
                        {"República Dominicana", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/do/es/registro?item_number=989998&club_code=6805"},
                        {"República Dominicana", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/do/es/registro?item_number=989998&club_code=6806"},
                        {"Islas Vírgenes, US", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/vi/es/registro?item_number=989998&club_code=8101"},
                        {"Trinidad y Tobago", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/tt/es/registro?item_number=989998&club_code=8001"},
                        {"Trinidad y Tobago", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/tt/es/registro?item_number=989998&club_code=8002"},
                        {"Trinidad y Tobago", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/tt/es/registro?item_number=989998&club_code=8003"},
                        {"Trinidad y Tobago", "Luis","Lopez","luis@hotmail.com","luis@hotmail.com","luis1234567","luis1234567","123456789","12345678","luis@hotmail.com", "https://www.pricesmart.com/site/tt/es/registro?item_number=989998&club_code=8004"},
                        {"Jamaica", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/jm/es/registro?item_number=989998&club_code=8701"},
                        {"Jamaica", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/jm/es/registro?item_number=989998&club_code=8702"},
                        /*
                        {"Colombia", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6101"},
                        {"Colombia", "Juan","Gomez","juan@hotmail.com","juan@hotmail.com","juan1234567","juan1234567","123456789","12345678","juan@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6102"},
                        {"Colombia", "Carlos","Castillo","carlos@hotmail.com","carlos@hotmail.com","carlos1234567","carlos1234567","123456789","12345678","carlos@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6103"},
                        {"Colombia", "Luis","Lopez","luis@hotmail.com","luis@hotmail.com","luis1234567","luis1234567","123456789","12345678","luis@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6104"},
                        {"Colombia", "Andres","Figueres","andres@hotmail.com","andres@hotmail.com","andres1234567","andres1234567","123456789","12345678","andres@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6105"},
                        {"Colombia", "Jose","Ramos","jose@hotmail.com","jose@hotmail.com","jose1234567","jose1234567","123456789","12345678","jose@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6106"},
                        {"Colombia", "Rafael","Flores","rafael@hotmail.com","rafael@hotmail.com","rafael1234567","rafael1234567","123456789","12345678","rafael@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6107"},
                        {"Colombia", "Maria","Ramirez","maria@hotmail.com","maria@hotmail.com","maria1234567","maria1234567","123456789","12345678","maria@hotmail.com", "https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6108"},
                        {"Colombia", "Pedro","Alvarado","pedro@hotmail.com","pedro@hotmail.com","pedro1234567","pedro1234567","123456789","12345678","pedro@hotmail.com","https://www.pricesmart.com/site/co/es/registro?item_number=989998&club_code=6109"},
                        */



                };
    }
}