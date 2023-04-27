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
        SecureRandom random = new SecureRandom();
        byte seed[] = random.generateSeed(20);
        byte seed2[] = random.generateSeed(40);

        byte bytes[] = new byte[20];
        byte bytes2[] = new byte[20];

        SecureRandom rand = new SecureRandom();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
        int rand_int2 = rand.nextInt(1000);

        // Print random integers
        System.out.println("Random Integers: " + rand_int1);
        System.out.println("Random Integers: " + rand_int2);
    }
    byte byteCharCode = 65;
    char charFromByte = (char)byteCharCode;
    byte[] values = new byte[124];

}
