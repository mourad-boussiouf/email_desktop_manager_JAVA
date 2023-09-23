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

    public String CryptoSafeRandom(int length) throws NoSuchAlgorithmException, NoSuchProviderException {

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
        char[] rdm = new char[length];
        char[] seedWord = new char[length];
        byte[] bytes = new byte[1];
        SecureRandom SingleByte = SecureRandom.getInstance("SHA1PRNG");


        for(int i=0; i<length; i++){
            SingleByte.nextBytes(bytes);
            String stringSingleByte = Arrays.toString(bytes).substring(1, Arrays.toString(bytes).length() - 1);
            int OccurentShuffleNumber = Math.abs(Integer.parseInt(stringSingleByte));
            if (OccurentShuffleNumber == 128){
                //gestion edge case 128 pile
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

            // declare et instancie la seed en tant que String
            String str = new String(seedWord);

            // declarer le tableau de byte
            // remplir le tableau de byte par le seedword aleatoire converti en byte
            byte[] b = str.getBytes();

            String[] simpleArrayFromByteArray = Arrays.toString(b).substring(1, Arrays.toString(b).length() - 1).split(",");
            //renouvellement random bytes
            sr.nextBytes(b);

            for (int i = 0; i < length; i++) {
                //renouvellement génération de bytes à chaque loop
                sr.nextBytes(b);

                //array to string
                String table = Arrays.toString(b);

                // remove the square brackets of the string array representation
                String Tableau = table.substring(1, table.length() - 1);


                String[] strArray = Tableau.split(", ");

                System.out.println("strArray:"+ strArray.length);

                byte[] numberToArraySelect = new byte[1];
                sr.nextBytes(numberToArraySelect);
                int numberToShuffleInOccurrentArray = Integer.parseInt(Arrays.toString(numberToArraySelect).substring(1, Arrays.toString(numberToArraySelect).length() - 1))+128;
                System.out.println("Valeur brute byte +128 : "+numberToShuffleInOccurrentArray);

                while(numberToShuffleInOccurrentArray >= 250){
                    System.out.println("Edge case NumberOfShuffleInArray > 250 old :"+numberToShuffleInOccurrentArray);
                    sr.nextBytes(numberToArraySelect);
                    numberToShuffleInOccurrentArray = Integer.parseInt(Arrays.toString(numberToArraySelect).substring(1, Arrays.toString(numberToArraySelect).length() - 1))+128;
                    System.out.println("Edge case NumberOfShuffleInArray > 250 new :"+numberToShuffleInOccurrentArray);
                }


                int pickInArray = numberToShuffleInOccurrentArray % 10;
                while(pickInArray >= rdm.length){
                    pickInArray--;
                }

                if (strArray.length > 10 && numberToShuffleInOccurrentArray <= 66 && numberToShuffleInOccurrentArray > 20) {
                    pickInArray = pickInArray + (strArray.length - 10);
                }
                System.out.println("UnicodeCharsList < ? que : " + UnicodeCharsList.length());
                System.out.println("pickInArray > UnicodeCharsList ? : " + Math.abs(b[pickInArray]));
                int pickAtThisPosition = Math.abs(b[pickInArray]);
                if (Math.abs(b[pickInArray]) == 128){  pickAtThisPosition--; }
                rdm[i] = UnicodeCharsList.charAt(pickAtThisPosition);
            }
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown : " + e);
        }
        catch (ProviderException e) {
            System.out.println("Exception thrown : " + e);
        }
        return new String(rdm);
    }

}
