package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
public class HomePage {
    WebDriver driver;
    //Buscador
    By searchTextField = By.name("_sq");
    //boton  clubes
    By clubButton = By.xpath("//*[@id=\"clubLocationHeader\"]");
    By closeMenuClubButton = By.xpath("/html/body/form/div/div/div/div/div/div/div[1]/button");
    By mensajeClubDialog = By.xpath("//*[@id=\"selectClubAlert\"]");
    By mensajeClubDialogButton = By.xpath("/html/body/form/div/div/div/div/div[1]/div/div[2]/div/div/a[1]");
    //Texto del campus
    By textCampus = By.xpath("//*[@id=\"club-location-picker-cont\"]");
    //Extraer elementos hijos
    By elements = By.xpath("./child::*");
    //Boton categorias
    By categoriesButton = By.xpath("//*[@id=\"categories-dropdown\"]/div/div");
    //boton moda y accesorios
    By fashionButton = By.xpath("//*[@id=\"Modayaccesorios\"]");
    By membeershipButton = By.xpath("/html/body/section/section/nav/section/div/div/div[2]/mega-menu/ul[2]/div/li[3]");
    By buyMembershipButton = By.xpath("//*[@id=\"lnkJoinNowDiamondTop\"]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void cilickClubButton() {
        driver.findElement(clubButton).click();
        if (driver.findElements(mensajeClubDialog).size() != 0) {
            driver.findElement(mensajeClubDialogButton).click();
        }
    }
    public void clickClubsButtton(String campus) {
        List<WebElement> childrenTextCampus = driver.findElement(textCampus).findElements(elements);
        for (WebElement i : childrenTextCampus) {
            String x = i.findElement(By.id("club-description")).getText();
            System.out.println(x + " " + campus);
            if (campus.equals(x)) {
                if (i.findElements(By.id("club-select")).size() != 0) {
                    driver.findElement(closeMenuClubButton).click();
                } else {
                    i.findElement(By.id("select-club")).click();
                }
                break;
            }
        }
    }
    public void clickCategoriesButton() {
        driver.findElement(categoriesButton).click();
    }
    public void clickFashionButtom() {
        driver.findElement(categoriesButton);
        driver.findElement(fashionButton).click();
    }
    public void clickMembershipButton() {
        driver.findElement(membeershipButton).click();
    }
    public void clickBuyMembershipButton() {
        driver.findElement(buyMembershipButton).click();
    }
    public void setProduct(String strProduct) {
        driver.findElement(searchTextField).sendKeys(strProduct);
    }
    public void enterSearchTextField() {
        driver.findElement(searchTextField).sendKeys(Keys.RETURN);
    }
    public void searchProduct(String strProduct) {
        //Ingresa el producto
        this.setProduct(strProduct);
        //Busca el producto al presionar "ENTER"
        this.enterSearchTextField();
    }
}