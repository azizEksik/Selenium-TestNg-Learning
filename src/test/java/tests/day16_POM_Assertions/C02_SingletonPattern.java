package tests.day16_POM_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Collection;

public class C02_SingletonPattern {

    @Test
    public void test01(){
        /*
            Otomasyon için elimiz ve kolumuz olarak
            Driver calss'ındaki WebDriver driver objesini kullanıyoruz
            ANCAK driver'ın bizim istedigimiz işlemleri yapabilmesi için
            önceclikle getDriver() icinde yaptıgımız atama islemlerine ihtiyacı var

            Bir framework'de calisan kisilerin
            getDriver() kullanmadan direkt driver objesine erişimini engellemek icin
            Singleton Pattern kullanımı TERCİH EDİLMİŞTİR

            singleton pattern bir class'tan
            obje olusturulmasını ve o obje ile calss'daki calss üyelerine erisimi engellemek için kullanılır

            OOP Konsept cercevesinde
            Driver calss'ini farkli farkli yöntemlerle kullanabilirsiniz
            Ekip calismasinin tek düzen üzerinden gitmesi önemli oldugundan
            farkli yöntemlerle WebDriver driver' in kullanımını engellemek istiyoruz

         */

        // Driver.driver.get(ConfigurationReader.getProperty("amazonUrl"));
        // getDriver() calismadıgından driver null olarak isaretlendiginden
        // NullPointerException verir

        // Driver class'indaki constructor'ı private yapınca kimse driver class'indan obje olusturamaz



    }
}
