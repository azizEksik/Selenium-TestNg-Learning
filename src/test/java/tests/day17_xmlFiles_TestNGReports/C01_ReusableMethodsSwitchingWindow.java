package tests.day17_xmlFiles_TestNGReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsSwitchingWindow {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String firstWindowHandle = Driver.getDriver().getWindowHandle();
        SoftAssert softAssert = new SoftAssert();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = Driver.getDriver().findElement(By.tagName("h3"));
        String expectedText = "Opening a new window";
        String actualText = text.getText();
        softAssert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actulaTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedTitle,actulaTitle);

        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
        // 42. satir itibariyle yeni window acildi
        // artik 2 window'umuz var. eger driver.getWindowHandle() dersek ikisini de getirir.
        // o yüzden Set<> olusturacagiz

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        // artik  2. sayfanin windowHandle degerine sahibiz

        ReusableMethods.switchToWindow("New Window");

        expectedTitle = "New Window";
        actulaTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedTitle,actulaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = Driver.getDriver().findElement(By.tagName("h3")).getText();
        softAssert.assertEquals(expectedText,actualText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        Driver.getDriver().switchTo().window(firstWindowHandle);
        expectedTitle = "The Internet";
        actulaTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(expectedTitle,actulaTitle);

        softAssert.assertAll();
    }



}
