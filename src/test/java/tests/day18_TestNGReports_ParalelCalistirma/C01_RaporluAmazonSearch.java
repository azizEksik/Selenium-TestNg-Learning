package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ConcurrentModificationException;

public class C01_RaporluAmazonSearch extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("Amazon Arama Testi","Kullanici istedigi kelimeyi aratabilmeli");

        // amazon'a gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        extentTest.info("Kullanıcı amazon anasayfaya gider");

        // Nutella icin arama yapın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys(ConfigurationReader.getProperty("amazonAranacakKelime")+Keys.ENTER);
        extentTest.info("arama kutusuna belirlenen aranacak kelimeyi yazar ve aratır");

        // arama sonuclarinin Nutella icerdigini test edin
        String expectedResult = ConfigurationReader.getProperty("amazonExpectedIcerik");
        String actualResult = amazonPage.searchResults.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("Belirlenen aranacak kelime aratıldığında, arama sonucunda expected icerik olduğu test edildi");

        Driver.quitDriver();
    }

}
