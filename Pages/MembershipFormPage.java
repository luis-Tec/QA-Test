package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MembershipFormPage {
    WebDriver driver;

    By continuePayButton = By.xpath("//*[@id=\"sendInfoNotAero\"]");

    By nameTextField = By.xpath("//*[@id=\"firstName\"]");

    By lastNameTextField = By.xpath("//*[@id=\"lastName\"]");

    By emailTextField = By.xpath("//*[@id=\"email\"]");

    By emailConfirmTextField = By.xpath("//*[@id=\"emailConfirm\"]");

    By passwordTextField = By.xpath("//*[@id=\"txtpassword\"]");

    By passwordConfirmTextField = By.xpath("//*[@id=\"passwordConfirm\"]");

    By identificationTextField = By.xpath("//*[@id=\"identification\"]");

    By phoneTextField = By.xpath("//*[@id=\"phone\"]");

    //By barraIdentificacionFE = By.name("numberElectronicInvoice");

    By emailFeTextField = By.xpath("//*[@id=\"emailElectronicInvoice\"]");

    By termsConditionsButton = By.xpath("//*[@id=\"terms-label\"]");


    public MembershipFormPage(WebDriver driver){

        this.driver = driver;

    }

    public void clickContinuePayButton(){
        driver.findElement(continuePayButton).click();
    }

    public void clickTermsConditionsButton(){
        driver.findElement(termsConditionsButton).click();
    }

    public void setNameTextField(String strProducto){
        driver.findElement(nameTextField).sendKeys(strProducto);
    }

    public void setLastNameTextField(String strProducto){
        driver.findElement(lastNameTextField).sendKeys(strProducto);
    }

    public void setEmailTextField(String strProducto){
        driver.findElement(emailTextField).sendKeys(strProducto);
    }

    public void setEmailConfirmTextField(String strProducto){
        driver.findElement(emailConfirmTextField).sendKeys(strProducto);
    }

    public void setPasswordTextField(String strProducto){
        driver.findElement(passwordTextField).sendKeys(strProducto);
    }

    public void setPasswordConfirmTextField(String strProducto){
        driver.findElement(passwordConfirmTextField).sendKeys(strProducto);
    }

    public void setIdentificationTextField(String strProducto){
        driver.findElement(identificationTextField).sendKeys(strProducto);
    }

    public void setPhoneTextField(String strProducto){
        driver.findElement(phoneTextField).sendKeys(strProducto);
    }

    public void setEmailFETextField(String strProducto){
        driver.findElement(emailFeTextField).sendKeys(strProducto);
    }


}
