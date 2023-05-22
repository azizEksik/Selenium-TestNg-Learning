package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C02_Ignore {

    /*
        @Ignore notasyonu
        basina yazdıgı destin ignore edilmesini saglar
     */


    @Test(priority = 57)
    public void youtubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = -3) @Ignore
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test (priority = 57)
    public void amazonTest(){
        System.out.println("Amazon");
    }
}
