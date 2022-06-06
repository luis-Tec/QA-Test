package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
public class FatherTest {
    protected static WebDriver driver;

    public WebDriver FatherTest(){
        return driver;
    }
    @BeforeTest
    public void setup() {
        String driverPath = "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}