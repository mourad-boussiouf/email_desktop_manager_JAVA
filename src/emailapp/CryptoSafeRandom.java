package emailapp;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CryptoSafeRandom {

    public CryptoSafeRandom() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom rand = new SecureRandom();
        int rand_int1 = rand.nextInt(20);
        String rdm = "";
        for (int i = 0; i < 10; i++) {
            int rand_int3 = rand.nextInt(20);
            byte[] bytes = new byte[rand_int3]
            Stack<String> s = new Stack<String>();
            rand.nextBytes(bytes);
            System.out.println("Random bytes: "+ bytes);
        }
        try {
            // creating the object of SecureRandom
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            // Declaring the string variable
            String str = "Tajmahal";

            // Declaring the byte Array
            // converting string into byte
            byte[] b = str.getBytes();

            // printing the byte array
            System.out.println("Byte array before operation : " + Arrays.toString(b));

            // generating user-specified number of random bytes
            // using nextBytes() method
            sr.nextBytes(b);

            // printing the new byte array
            System.out.println("Byte array after operation : " + Arrays.toString(b));
        }

        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown : " + e);
        }
        catch (ProviderException e) {
            System.out.println("Exception thrown : " + e);
        }
    }

}
