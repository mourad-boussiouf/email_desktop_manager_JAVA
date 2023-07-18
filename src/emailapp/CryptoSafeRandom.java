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

        SecureRandom rand = new SecureRandom();
        int rand_int1 = rand.nextInt(20);

        //collection de caractères dans StringBuilder
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
        sb.append((char) 233);
        sb.append((char) 232);
        sb.replace(122, 125, "");
        sb.replace(118, 120, "");
        sb.replace(112, 114, "");
        sb.replace(116, 117, "");
        sb.replace(99, 100, "");

        String UnicodeCharsList = sb.toString();
        System.out.println(UnicodeCharsList);
        System.out.println(UnicodeCharsList.length());

        char[] seedWord = new char[length];
        byte[] bytes = new byte[1];
        SecureRandom SingleByte = SecureRandom.getInstance("SHA1PRNG");
        //cette fonction regenère

        for(int i=0; i<length; i++){
            SingleByte.nextBytes(bytes);
            String stringSingleByte = Arrays.toString(bytes).substring(1, Arrays.toString(bytes).length() - 1);
            System.out.println("Byte to array to string à partir de SingleByte ICI: " + Math.abs(Integer.parseInt(stringSingleByte)));
            int OccurentShuffleNumber = Math.abs(Integer.parseInt(stringSingleByte));
            if (OccurentShuffleNumber == 128){
                System.out.println("Edge case 128");
                while (OccurentShuffleNumber == 128){
                    SingleByte.nextBytes(bytes);
                    stringSingleByte = Arrays.toString(bytes).substring(1, Arrays.toString(bytes).length() - 1);
                    OccurentShuffleNumber = Math.abs(Integer.parseInt(stringSingleByte));
                }
            }
            seedWord[i] = UnicodeCharsList.charAt(OccurentShuffleNumber);
        }
        try {
            // initialisation objet secure random
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            // declarer la seed
            String str = new String(seedWord);
            System.out.println("SEED WORD 1: " + str);

            // declarer le tableau de byte
            // remplir le tableau de byte par le seedword aleatoire converti en byte
            String str2 = new String(seedWord);
            byte[] b = str.getBytes();

            String[] simpleArrayFromByteArray = Arrays.toString(b).substring(1, Arrays.toString(b).length() - 1).split(",");

            // printing the byte array

            System.out.println("Byte array a partir de seed word avant nextBytes WWWW1: " + Arrays.toString(simpleArrayFromByteArray));
            sr.nextBytes(b);

            simpleArrayFromByteArray = Arrays.toString(b).substring(1, Arrays.toString(b).length() - 1).split(",");

            System.out.println("Byte array a partir de seed word aprés nextBytes WWWW2: " + Arrays.toString(simpleArrayFromByteArray));


            char[] rdm = new char[length];
            for (int i = 0; i < length; i++) {

                System.out.println("count"+i);

                sr.nextBytes(b);

                String table = Arrays.toString(b);
                String table2 = Arrays.toString(bytes);
                //string to array

                String Tableau = table.substring(1, table.length() - 1); // remove the square brackets

                String[] strArray = Tableau.split(", ");

                System.out.println("strArray:"+ strArray.length);

                byte[] numberToArraySelect = new byte[1];
                sr.nextBytes(numberToArraySelect);
                String FloatTest = Arrays.toString(numberToArraySelect);
                int numberToShuffleInOccurrentArray = Integer.parseInt(Arrays.toString(numberToArraySelect).substring(1, Arrays.toString(numberToArraySelect).length() - 1))+128;
                System.out.println("Valeur brute byte +128 : "+numberToShuffleInOccurrentArray);

                while(numberToShuffleInOccurrentArray >= 250){
                    System.out.println("Edge case NumberOfShuffleInArray > 250 old :"+numberToShuffleInOccurrentArray);
                    sr.nextBytes(numberToArraySelect);
                    numberToShuffleInOccurrentArray = Integer.parseInt(Arrays.toString(numberToArraySelect).substring(1, Arrays.toString(numberToArraySelect).length() - 1))+128;
                    System.out.println("Edge case NumberOfShuffleInArray > 250 new :"+numberToShuffleInOccurrentArray);
                }
                int pickInArray = numberToShuffleInOccurrentArray % 10;
                if (strArray.length > 10 && numberToShuffleInOccurrentArray <= 88) {
                    System.out.println("Edge gros array old :"+pickInArray);
                    pickInArray = pickInArray + (strArray.length - 10);
                    System.out.println("Edge gros array new :"+pickInArray);
                }


                System.out.println("PICK IN ARRAY"+pickInArray);
                System.out.println("longueur array occurrent" + strArray.length +"objectif random int max 10 via nextByte" + "numberToShuffleInOccurrentArray:" + pickInArray);
                //fill array with indexed shuffle contain index in dictionary now
                System.out.println("Random bytes Arrays.toString.(b): "+Arrays.toString(b));
                System.out.println("Random bytes table : "+ table);
                System.out.println("Random index in b: "+ Math.abs(b[pickInArray]));

            }
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
