package tests.day18_TestNGReports_ParalelCalistirma;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C04_DataProviderNegatifLoginTest {

    // veilen 10 kullanıcı bilgisi ile istemem giris yapılamadıgını test edin

    @DataProvider
    public static Object[][] yanlisKulaniciAdlariListesi() {

        String[][] kullaniciBilgileriArrayi = {{"Mememre","12345"},{"Mustafa","23456"},
                                                {"Burcu","32456"},{"Cigdem","87896"},
                                                {"Ahmet","6541321"},{"Kemal","65313"},
                                                {"Melike","35132165"},{"Cinar","6543121"},
                                                {"Muleyke","32131"},{"Kadir","544444"}};

        return kullaniciBilgileriArrayi;
    }


    @Test(dataProvider = "yanlisKulaniciAdlariListesi")
    public void gecersizIsisimTesti(String kullaniciAdi, String password){

        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // ilk login linkine tıklayın
        QualityDemyPage qualityDemyPage = new QualityDemyPage();
        qualityDemyPage.loginLink.click();

        // kullanıcı adı olarak selenium
        qualityDemyPage.emailTextBox.sendKeys(kullaniciAdi);

        // password olarak heyecandir yazin
        qualityDemyPage.passwordTextBox.sendKeys(password);

        // login buttonuna tıklayın
        qualityDemyPage.loginButton.click();

        // giris yapılamadıgını test edin

        Assert.assertTrue(qualityDemyPage.emailTextBox.isEnabled());

        Driver.closeDriver();
    }

}
