package javaclasses.encryptor;

import javaclasses.encryptor.impl.EncryptorImpl;
import org.junit.Assert;
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
    public void testEncrypt(){
        final String input = "have a nice day";
        final String expected = "hae and via ecy";
        final String result = encryptor.encrypt(input);
        assertEquals(expected, result);
    }

}
