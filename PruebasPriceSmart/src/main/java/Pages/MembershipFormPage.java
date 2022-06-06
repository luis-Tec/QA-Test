package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MembershipFormPage {
    WebDriver driver;
    By nameTextField = By.name("firstName");
    By lastNameTextField = By.name("lastName");
    By emailTextField = By.xpath("//*[@id=\"email\"]");
    By emailConfirmTextField = By.xpath("//*[@id=\"emailConfirm\"]");
    By passwordTextField = By.xpath("//*[@id=\"txtpassword\"]");
    By passwordConfirmTextField = By.xpath("//*[@id=\"passwordConfirm\"]");
    By identificationTextField = By.xpath("//*[@id=\"identification\"]");
    By phoneTextField = By.xpath("//*[@id=\"phone\"]");
    By emailFeTextField = By.xpath("//*[@id=\"emailElectronicInvoice\"]");
    By termsConditionsButton = By.xpath("//*[@id=\"terms-label\"]");
    By continuePayButton = By.xpath("//*[@id=\"sendInfoNotAero\"]");
    public MembershipFormPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickContinuePayButton(){
        driver.findElement(continuePayButton).click();
    }
    public void clickTermsConditionsButton(){
        driver.findElement(termsConditionsButton).click();
    }
    public void setNameTextField(String strName){
        driver.findElement(nameTextField).sendKeys(strName);
    }
    public void setLastNameTextField(String strLastName){
        driver.findElement(lastNameTextField).sendKeys(strLastName);
    }
    public void setEmailTextField(String strEmail){
        driver.findElement(emailTextField).sendKeys(strEmail);
    }
    public void setEmailConfirmTextField(String strEmailConfirm){
        driver.findElement(emailConfirmTextField).sendKeys(strEmailConfirm);
    }
    public void setPasswordTextField(String strPassword){
        driver.findElement(passwordTextField).sendKeys(strPassword);
    }
    public void setPasswordConfirmTextField(String strPasswordConfirm){
        driver.findElement(passwordConfirmTextField).sendKeys(strPasswordConfirm);
    }
    public void setIdentificationTextField(String strID){
        driver.findElement(identificationTextField).sendKeys(strID);
    }
    public void setPhoneTextField(String strPhone){
        driver.findElement(phoneTextField).sendKeys(strPhone);
    }
    public void setEmailFETextField(String strEmailFE){
        driver.findElement(emailFeTextField).sendKeys(strEmailFE);
    }
}