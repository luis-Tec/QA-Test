package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class HomePage {
    WebDriver driver;

    //Buscador
    By searchTextField = By.xpath("//*[@id=\"_sq\"]");
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
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(clubButton) );
        driver.findElement(clubButton).click();
        if (driver.findElements(mensajeClubDialog).size() != 0) {
            waiter.until( ExpectedConditions.presenceOfElementLocated(mensajeClubDialogButton) );
            driver.findElement(mensajeClubDialogButton).click();
        }
    }
    public void clickClubsButtton(String campus) {
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(textCampus) );
        waiter.until( ExpectedConditions.presenceOfElementLocated(elements) );
        List<WebElement> childrenTextCampus = driver.findElement(textCampus).findElements(elements);
        for (WebElement i : childrenTextCampus) {
            String x = i.findElement(By.id("club-description")).getText();
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
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(categoriesButton) );
        driver.findElement(categoriesButton).click();
    }
    public void clickFashionButtom() {
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(categoriesButton) );
        driver.findElement(categoriesButton);
        waiter.until( ExpectedConditions.presenceOfElementLocated(fashionButton) );
        driver.findElement(fashionButton).click();
    }
    public void clickMembershipButton() {
        driver.findElement(membeershipButton).click();
    }
    public void clickBuyMembershipButton() {
        driver.findElement(buyMembershipButton).click();
    }
    public void setProduct(String strProduct) {
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(searchTextField) );
        driver.findElement(searchTextField).sendKeys(strProduct);
    }
    public void enterSearchTextField() {

        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.presenceOfElementLocated(searchTextField) );
        driver.findElement(searchTextField).sendKeys(Keys.RETURN);
    }
    public void searchProduct(String strProduct) {
        //Ingresa el producto
        this.setProduct(strProduct);
        //Busca el producto al presionar "ENTER"
        this.enterSearchTextField();
    }
}