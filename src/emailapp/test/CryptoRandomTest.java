package emailapp.test;
import emailapp.CryptoSafeRandom;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class CryptoRandomTest {

        CryptoSafeRandom CSR = new CryptoSafeRandom();

        @Test
        public void testLengthOfRdmScenarii () throws NoSuchAlgorithmException, NoSuchProviderException {
            assertEquals(1, CSR.CryptoSafeRandom(1).length());
            assertEquals(2, CSR.CryptoSafeRandom(2).length());
            assertEquals(3, CSR.CryptoSafeRandom(3).length());
            assertEquals(4, CSR.CryptoSafeRandom(4).length());
            assertEquals(5, CSR.CryptoSafeRandom(5).length());
            assertEquals(6, CSR.CryptoSafeRandom(6).length());
            assertEquals(7, CSR.CryptoSafeRandom(7).length());
            assertEquals(8, CSR.CryptoSafeRandom(8).length());
            assertEquals(9, CSR.CryptoSafeRandom(9).length());
            assertEquals(10, CSR.CryptoSafeRandom(10).length());
        }

    }

