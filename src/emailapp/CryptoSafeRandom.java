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

    public CryptoSafeRandom(int length) throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom rand = new SecureRandom();
        int rand_int1 = rand.nextInt(20);


        String seedSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]-=";
        char[] seedWord = new char[length];
        for(int i=0; i<length; i++){
            int rand_int = rand.nextInt(seedSet.length());
            seedWord[i] = seedSet.charAt(rand_int);
        }

        String rdm = "";
        for (int i = 0; i < 10; i++) {
            int rand_int3 = rand.nextInt(20);
            byte[] bytes = new byte[rand_int3]
            Stack<String> s = new Stack<String>();
            rand.nextBytes(bytes);
            System.out.println("Random bytes: "+ bytes);
        }
        try {
            // initialisation objet secure random
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            // declarer la seed
            String str = new String(seedWord);
            System.out.println("SEED WORD" + str);
            return;
            // déclarer le tableau de byte
            // remplir le tableau de byte par le seedword aleatoire converti en byte
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
