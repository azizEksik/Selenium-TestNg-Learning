package tests.day16_POM_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZerowebappsecurityPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class C04_SoftAssertionOrnekTest {

    //1. “http://zero.webappsecurity.com/” Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password” yazin
    //5. Sign in tusuna basin
    //6. Online banking menusu icinde Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
    //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
    //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
    //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
    //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigurationReader.getProperty("webappsecurityUrl"));

        ZerowebappsecurityPage zerowebappsecurityPage = new ZerowebappsecurityPage();

        //2. Sign in butonuna basin
        zerowebappsecurityPage.singinButton.click();

        //3. Login kutusuna “username” yazin
        zerowebappsecurityPage.loginTextBox.sendKeys("username");

        //4. Password kutusuna “password” yazin
        zerowebappsecurityPage.passwordTextBox.sendKeys("password");

        //5. Sign in tusuna basin
        zerowebappsecurityPage.singinButton2.click();

        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        zerowebappsecurityPage.onlineBankingMenuLink.click();
        zerowebappsecurityPage.payBillsLink.click();

        //7. “Purchase Foreign Currency” tusuna basin
        zerowebappsecurityPage.purchaseForeignCurrencyLink.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zerowebappsecurityPage.dropdownMenu);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zerowebappsecurityPage.sellRateText.isDisplayed(),"Eurozone (euro) secili");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> dropdownList = select.getOptions();
        String expectedIcerik = "\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\",\"Switzerland (franc)\",\"China (yuan)\",\"Denmark (krone)\",\"Eurozone (euro)\",\"Great Britain (pound)\",\"Hong Kong (dollar)\",\"Japan (yen)\",\"Mexico (peso)\",\"Norway (krone)\",\"New Zealand (dollar)\",\"Sweden (krona)\",\"Singapore (dollar)\",\"Thailand (baht)\"";
        for (WebElement dropdownEach : dropdownList){
            String message = dropdownEach.getText()+" iceriyor";
            softAssert.assertTrue(expectedIcerik.contains(dropdownEach.getText()),message);
        }
        softAssert.assertAll();

        Driver.closeDriver();
    }

}
