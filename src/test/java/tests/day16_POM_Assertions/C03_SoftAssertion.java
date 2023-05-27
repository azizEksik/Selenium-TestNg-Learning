package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void hardAsertion(){

        /*
            Assert islemi ilk failed oldugunda
            Selenium calismayi durdurur
            ve java.lang.AssertionError verir

            Eger bir test methodu icinde birden fazla assertion varsa
            ilk failed olanda calisma durur
            sonraki assertion'lar calismamis olur

            TestNG bu konuda da bize daha fazla kontrol yetkisi vermistir
            istersek TestNG assertion failed olsa bile
            bizim istedigimiz satira kadar
            kodalrin calismaya devam etmesini saglar

            "artik rapor ver" dedigimizde
            failed olan tüm assertionları raporlar
            ve failed olan varsa calismayi durdurur
         */

        int sayi = 23;

        Assert.assertTrue(sayi%2==0); // sayi cift mi

        Assert.assertTrue(sayi > 100); // sayi 100 den büyük mü

        Assert.assertTrue(sayi < 1000); // sayi 1000 den kücük mü

        Assert.assertFalse(sayi  % 3 == 0 ); // sayinin 3 ile bölünemedigini test edin
    }

    @Test
    public void softAssertionTesti(){

        /*
            SoftAssert calss'i sayasinde
            assertAll()'nun calisacagi satira kadar
            failedn olan olsa bile, tüm assertion'lar calismaya devam eder

            assertAll() calistiginda
            failed olan assertion'lara ait raporu verir
            ANCAK hangi satirda olduklarini vermez

            Selenium hata mesajı da assertAll()'un bulundugu satiri isaret eder.

            Failed olan assertion'lari kolaylıkla bulabilmemiz icin
            assertionun yanına virgül atıp string bir mesaj vermeliyiz
            SoftAssertion.assertTrue(kosul , String mesaj)
            Assert.assertTrue(kosul , String mesaj)
         */

        int sayi = 36;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(sayi%2==0,"sayi cift olmali"); // sayi cift mi

        softAssert.assertTrue(sayi > 100,"sayi 100 den büyük olmali"); // sayi 100 den büyük mü

        softAssert.assertTrue(sayi < 1000,"sayi 1000 den kucuk olmali"); // sayi 1000 den kücük mü

        softAssert.assertFalse(sayi  % 3 == 0 ,"sayi 3 e bolunememeli"); // sayinin 3 ile bölünemedigini test edin

        softAssert.assertAll(); // bütün assert'leri raporlayan method

        // softAssert objesi ile assertion'lari yaptıktan sonra
        // assertAll() kullanmazsak, test direkt passed olur
        // failed olan assrtion'lar raporlanmaz

    }
}
