package emailapp;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.sql.Array;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CryptoSafeRandom {

    public CryptoSafeRandom(int length) throws NoSuchAlgorithmException, NoSuchProviderException {
        String strWithSingleQuote = "Other \\people's money";
        System.out.println(strWithSingleQuote);
        SecureRandom rand = new SecureRandom();
        int rand_int1 = rand.nextInt(20);

        System.out.println("SHOULD BE TRUE");
        System.out.println(126<0X007F);
        System.out.println("SHOULD BE FALSE");
        System.out.println(127<0X007F);

        StringBuilder sb = new StringBuilder();
        for (int y = 0X0021; y <= 0X007E; y++) {
            if (Character.isDefined(y) && !Character.isSurrogate((char) y)) {
                sb.append((char) y);
            }
        }
        for (int y = 0X0080; y <= 0X0080; y++) {
            if (Character.isDefined(y) && !Character.isSurrogate((char) y)) {
                sb.append((char) y);
            }
        }
        for (int y = 0X00A1; y <= 0X00C8; y++) {
            if (Character.isDefined(y) && !Character.isSurrogate((char) y)) {
                sb.append((char) y);
            }
        }

        sb.replace(122, 125, "");
        sb.replace(118, 120, "");


        String UnicodeCharsList = sb.toString();
        System.out.println(UnicodeCharsList);
        System.out.println(UnicodeCharsList.length());

        String seedSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+{}[]-=";
        char[] seedWord = new char[length];
        for(int i=0; i<length; i++){
            int rand_int = rand.nextInt(UnicodeCharsList.length());
            seedWord[i] = UnicodeCharsList.charAt(rand_int);
        }

        new Vector<>();

        try {
            // initialisation objet secure random
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            // declarer la seed
            String str = new String(seedWord);
            System.out.println("SEED WORD: " + str);

            // declarer le tableau de byte
            // remplir le tableau de byte par le seedword aleatoire converti en byte
            byte[] b = str.getBytes();

            // printing the byte array
            System.out.println("Byte array a partir de seed word avant nextBytes: " + Arrays.toString(b));

            // generating user-specified number of random bytes
            // using nextBytes() method
            for (int i = 0; i <= length; i++) {
                
            }
            String rdm = "";
            for (int i = 0; i < length; i++) {
                int rand_int3 = rand.nextInt(20);
                byte[] bytes = new byte[length];
                Stack<String> s = new Stack<String>();
                sr.nextBytes(b);
                rand.nextBytes(bytes);
                String table = Arrays.toString(b);
                //string to array

                String Tableau = table.substring(1, table.length() - 1); // remove the square brackets
                System.out.println("test hexa dans java");
                System.out.println(1>0xFFFF);
                String[] strArray = Tableau.split(", ");
                String firstNum = strArray[0];
                System.out.println("strArray:"+ strArray.length);

                int[] intArray = new int[strArray.length];

                for (int u = 0; u < strArray.length; u++) {
                    int intOfChar = Integer.parseInt(strArray[5]);
                    //System.out.println("Random bytes To String real int array:"+intOfChar);
                }

                System.out.println("Random bytes To String real int array:"+intArray[0]);
                System.out.println("Random bytes To String: "+ Arrays.toString(b));
                System.out.println("Random bytes: "+ table);

            }

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
