package emailapp;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class TimeComplexityCheck {
    public TimeComplexityCheck() throws NoSuchAlgorithmException, NoSuchProviderException {
        double now = System.currentTimeMillis();
        CryptoSafeRandom CSR = new CryptoSafeRandom();
        System.out.println(CSR.CryptoSafeRandom(10));
        //avec tous les println 98 mili
        System.out.println("Temps pris par la classe testée : " + (System.currentTimeMillis() - now) + "milisecondes");
    }



}
