package javaclasses.encryptor;

import javaclasses.encryptor.impl.EncryptorImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptorTest {

    private Encryptor encryptor;

    @Before
    public void setEncryptor(){
        encryptor = new EncryptorImpl();
    }

    @Test
    public void testEncryptOneWord(){
        final String input = "chillout";
        final String expected = "clu hlt io";
        final String result = encryptor.encrypt(input);
        assertEquals(expected, result);
    }

    @Test
    public void testEncryptPhrase(){
        final String input = "feed the dog";
        final String expected = "fto ehg ee dd";
        final String result = encryptor.encrypt(input);
        assertEquals(expected, result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNullInput(){
        encryptor.encrypt(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEmptyString(){
        encryptor.encrypt("");
    }

}
