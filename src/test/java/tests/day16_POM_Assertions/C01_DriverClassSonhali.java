package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_DriverClassSonhali {

    // tane test methodu olusturalim
    // 1. method'da amazona gidip, url'in amazon icerdigini test edin
    @Test(priority = 1)
    public void amazonTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        String expectedUrl = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        Driver.closeDriver();
    }

    // 2. method'da Wisequarter anasayfaya gidip, title'ın size Wise Quarter icerdigini test edin
    @Test(priority = 2)
    public void wiseTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("wiseUrl"));
        String expectedTitle = "Wise Quarter";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();
    }

    // 3. method'da Facebook anasayfaya gidip, tittle'in facebook içerdigini test edin
    @Test(priority = 3)
    public void facebookTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("facebookUrl"));
        String expectedTitle = "Facebook";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();
    }

    // her method'da yin driver olusturup, method sonunda yeni driver'ı kapatın
}
