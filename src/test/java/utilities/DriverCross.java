package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {


    private DriverCross(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(String browser){

        browser = browser==null ? ConfigurationReader.getProperty("browser") : browser;
        // Bu star bizim emniyet sübabımız
        // Eger parmetre olarak null gönderilirse
        // configuration.properties'deki browser degerini alacak

        if (driver == null){

            switch (browser){
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
