package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesIlkTest {

    @Test
    public void amazonTest(){

        //------ amazon anasayfaya gidelim------//
        Driver.getDriver().get("https://www.amazon.com");

        //------ Nutella için arma yapalim-----//
        // arama kutusunun locate'i page sayfasında
        // POM'de pages sayfasındaki locatelere erismek icin
        // pages sayfalarindan bir obje olusturulur.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);

        //------- sonuclarin "Nutella" icerdigini test edelim-------//
        String expectedSearchResult = "Nutella";
        String actualSearchResult = amazonPage.searchResults.getText();

        Assert.assertTrue(actualSearchResult.contains(expectedSearchResult));

        //------- Sayfayi kapatalim-------//
        Driver.closeDriver();
    }
}
