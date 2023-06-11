package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // Page calss'lari sürekli kullandığımız locate islemleri
    // ve varsa login gibi kucuk islevleri içeren method'lar barindirir
    // Selenium ile locate islemi veya herhangi bir islev gerceklestirmek icin istedigimizde
    // WebDriver objesine ihtiyaç vardır

    // Page Object Model(POM)' de Driver classinda olsuturdugumuz
    // WebDriver driver objesini page class'larina tanımlamak için
    // PageFactory class'indan initElements() kullanilir

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        // bu ayari constructor icine koyma sebebimiz :
        // page sayfalarına obje olusturularak ulasıldıgı için
        // kim page sayfasini kullanmak isterse
        // page sayfasından obje olusturmak icin, constructor çalışacak
        // ve bu constructo'un icinde bulunan initElements() methodu gerekli ayarı yapmış olacak
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "(//div[@class='sg-col-inner'])[1]")
    public WebElement searchResults;

}
