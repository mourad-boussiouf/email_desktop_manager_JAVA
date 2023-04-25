package emailapp;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CryptoSafeRandom {

    public CryptoSafeRandom(int size){
        byte[] values = new byte[size];
        byte test = secureRandom.nextBytes(values);
        System.out.println(test);
    }
    byte byteCharCode = 65;
    char charFromByte = (char)byteCharCode;


    int randomInt = secureRandom.nextInt();
    long randomLong = secureRandom.nextLong();
    float randomFloat = secureRandom.nextFloat();
    double randomDouble = secureRandom.nextDouble();
    boolean randomBoolean = secureRandom.nextBoolean();

    byte[] values = new byte[124];
    byte test = secureRandom.nextBytes(values);


}
