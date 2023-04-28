package emailapp;
import java.security.NoSuchProviderException;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CryptoSafeRandom {

    public CryptoSafeRandom() throws NoSuchAlgorithmException, NoSuchProviderException {

        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
        SecureRandom rand = new SecureRandom();
        SecureRandom random = new SecureRandom();
        SecureRandom random1 = new SecureRandom();

        int rand_int1 = rand.nextInt(20);
        int rand_int2 = rand.nextInt(20);
        System.out.println("Random Integer1" + rand_int1);
        System.out.println("Random Integer2" + rand_int2);

        random1.setSeed(random1.generateSeed(rand_int1));
        random1.nextBytes(new byte[20]);

        System.out.println("random1.setSeed(random1.generateSeed(rand_int1));\n" +
                "        random1.nextBytes(new byte[20]): " + new byte[20]);


        byte bytes[] = new byte[20];
        byte bytes2[] = new byte[20];


        String rdm = "";
        for (int i = 0; i < 10; i++) {
            //s.push(rand.nextBytes(bytes));
            int rand_int3 = rand.nextInt(20);
            Stack<String> s = new Stack<String>();
            random.nextBytes(bytes);
            System.out.println("Random bytes: "+ bytes);
        }



    }
    byte byteCharCode = 65;
    char charFromByte = (char)byteCharCode;
    byte[] values = new byte[124];

}
