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
                };
    }
}