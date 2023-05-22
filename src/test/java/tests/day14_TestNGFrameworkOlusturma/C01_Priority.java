package tests.day14_TestNGFrameworkOlusturma;

import org.testng.annotations.Test;

public class C01_Priority {

    /*
        JUnit framework'te testlerin calisma sirasi
        ONGORULEMEZ ve DUZENLENEMEZ

        TestNG testleri harf sirasina göre çalıştırır (ONGORULEBİLİR)

        Ayrıca priority degeri girerek testleri istediğimiz sıra  ile de calistirabiliriz
        (KONTROL EDİLEBİLİR SIRALAMA)

        Priority sayisal olarak kucukten buyuge dogru testleri calistirir
        eger priority degeri aynı olan birden fazla test varsa, yine harf sirasina bakar
     */

    @Test(priority = 57)
    public void youtubeTesti(){
        System.out.println("Youtube");
    }

    @Test(priority = -3)
    public void wiseTesti(){
        System.out.println("Wise Quarter");
    }

    @Test (priority = 57)
    public void amazonTest(){ // priority yazılmazsa default deger olan 0 kabul edilir
        System.out.println("Amazon");
    }
}
