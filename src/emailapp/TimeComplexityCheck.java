package emailapp;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class TimeComplexityCheck {
    public TimeComplexityCheck() throws NoSuchAlgorithmException, NoSuchProviderException {
        double now = System.currentTimeMillis();
        CryptoSafeRandom CSR = new CryptoSafeRandom();
        String rdm = CSR.CryptoSafeRandom(1);
        System.out.println("Temps pris par la classe testée : " + (System.currentTimeMillis() - now) + "milisecondes, " + "Return de la classe testée : " + rdm);
    }



}
