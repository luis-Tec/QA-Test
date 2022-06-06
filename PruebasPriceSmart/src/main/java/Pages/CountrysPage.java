package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class CountrysPage {
    WebDriver driver;
    //Botones Paises
    //America Central
    //Boton Costa Rica
    By buttonCR = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[1]");
    //Boton El Salvador
    By buttonSL = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[2]");
    //Boton Guatemala
    By buttonGT = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[3]");
    //Boton Honduras
    By buttonHN = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[4]");
    //Boton Nicaragua
    By buttonNC = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[5]");
    //Boton Panama
    By buttonPN = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[1]/div/ul/li[6]");
    //Caribe
    //Boton Aruba
    By buttonAR = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[1]");
    //Boton Barbados
    By buttonBA = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[2]");
    //Boton Republica Dominicana
    By buttonRP = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[3]");
    //Boton Jamaica
    By buttonJA = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[4]");
    //Boton Trinidad y Tobago
    By buttonTB = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[5]");
    //Boton Islas Virgenes, US
    By buttonIV = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[3]/div/ul/li[6]");
    //Sur America
    //Boton Colombia
    By buttonCL = By.xpath("/html/body/section/section/section[1]/div/div[5]/div/div/div[5]/div/ul/li");
    //Boton Idiomas
    By buttonLenguaje = By.xpath("//*[@id=\"dropdownMenu1\"]");
    //Boton Ingles
    By buttonLenguajeEN = By.xpath("/html/body/section/section/section[1]/div/div[1]/div/li/div/ul/li[1]/a");
    //Boton Español
    By buttonLenguajeES = By.xpath("/html/body/section/section/section[1]/div/div[1]/div/li/div/ul/li[2]/a");
    public CountrysPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonCountry(String country) {
        if (country.equals("Costa Rica")) {
            driver.findElement(buttonCR).click();
        } else if (country.equals("El Salvador")) {
            driver.findElement(buttonSL).click();
        } else if (country.equals("Guatemala")) {
            driver.findElement(buttonGT).click();
        } else if (country.equals("Honduras")) {
            driver.findElement(buttonHN).click();
        } else if (country.equals("Nicaragua")) {
            driver.findElement(buttonNC).click();
        } else if (country.equals("Panamá")) {
            driver.findElement(buttonPN).click();
        } else if (country.equals("Aruba")) {
            driver.findElement(buttonAR).click();
        } else if (country.equals("Barbados")) {
            driver.findElement(buttonBA).click();
        } else if (country.equals("República Dominicana")) {
            driver.findElement(buttonRP).click();
        } else if (country.equals("Jamaica")) {
            driver.findElement(buttonJA).click();
        } else if (country.equals("Trinidad y Tobago")) {
            driver.findElement(buttonTB).click();
        } else if (country.equals("Islas Vírgenes, US")) {
            driver.findElement(buttonIV).click();
        } else if (country.equals("Colombia")) {
            driver.findElement(buttonCL).click();
        }
    }
    public void clickButtonLenguaje(String idioma) {
        driver.findElement(buttonLenguaje).click();
        if (idioma.equals("es")) {
            driver.findElement(buttonLenguajeES).click();
        } else if (idioma.equals("en")) {
            driver.findElement(buttonLenguajeEN).click();
        }
    }
}