package emailapp;
import java.security.NoSuchProviderException;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CryptoSafeRandom {

    public CryptoSafeRandom() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");

        byte[] values = new byte[300];
        SecureRandom a =  new SecureRandom();
        a.nextBytes(values);

        System.out.println("TEST CRYPTO SAFE RANDOM: ");
        System.out.println(values);
    }
    byte byteCharCode = 65;
    char charFromByte = (char)byteCharCode;
    byte[] values = new byte[124];

}
