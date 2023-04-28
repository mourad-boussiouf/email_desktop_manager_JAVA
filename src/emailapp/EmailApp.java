package emailapp;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EmailApp {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {

        Email em1 = new Email("Moi","lastname");
        CryptoSafeRandom em2 = new CryptoSafeRandom(5);
    }

}