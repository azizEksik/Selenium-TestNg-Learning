package tests.day14_TestNGFrameworkOlusturma;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOnMethod {

    /*
        DependsOnMethod oncelik sirasina karışmaz

        dependsOnMethod bir test methodunun calismasını
        baska bir methodun calisip passed olmasına bağlar

        baglanilan method calismaz veya calisir ama failed olursa
        baglanan method hic calismaz

        @Test notasyonu sayesinde her test bagımsız olarak calistirilabilir

        Ancak bir test dependsOnMethod ile baska bir method'a baglanmis ise
        tek basina calismasi istendiginde, once bagli oldugu test methodunu calistirir
        o method calisip passed olursa asil calistirmak istedigimiz method'da calisir

        bu baglanti 3 veya daha fazla method arasinda olursa
        yani calistirmak istedigimiz method baska bir methoda,
        o da baska bir methoda bagli ise
        3'ü birden calismaz
        "No tests were found" yazar ve hiçbir  test methodu calismaz
     */

    @Test(dependsOnMethods = "wiseTesti") // wiseTesti failed olursa youtubeTesti calismaz
    public void youtubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = 3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");

    }

    @Test(dependsOnMethods = "youtubeTesti") // amazon testini youtube testine bagladik
    public void amazonTesti(){                // eger youtube testi failed olurse amazon testi calismaz
        System.out.println("Amazon");
    }



}
