package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C03_DataProvider {

    /*
        dataProvider TestNG'nin test methodu dısından
        test'e data saglamak icin olusuturdugu özel bir yapıdır

        bu yapı iki katlı bir array döndürür
     */

    @DataProvider
    public static Object[][] aranacaklarListesi() {

        String[][] aranacaklarArrayi = {{"Java"}, {"Apple"}, {"Samsung"}, {"Faker"}, {"Cracker"}};

        return aranacaklarArrayi;
    }

    @Test(dataProvider = "aranacaklarListesi")
    public void test01(String aranacakKelime){

        // amazona anasayfaya gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        // bize test methodu dısından  list oalrak verilen urunlerin hepsi icin
        // arama kutusuna yazıp arama yapın

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.searchBox.sendKeys(aranacakKelime + Keys.ENTER);

        // ve sonuc yazisi arattıgınız elemti icerdigini test edin
        String actualAramasonucYazisi = amazonPage.searchResults.getText();
        String expectedIcerik = aranacakKelime;

        Assert.assertTrue(actualAramasonucYazisi.contains(expectedIcerik));

        Driver.quitDriver();
    }
}
