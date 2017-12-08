package javaclasses.encryptor.impl;

import com.google.common.base.CharMatcher;
import javaclasses.encryptor.Encryptor;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class EncryptorImpl implements Encryptor {

    @Override
    public String encrypt(String message) {

        checkArgument(!isNullOrEmpty(message));
        final StringBuilder text = new StringBuilder(prepareInput(message));


        return null;
    }

    private String prepareInput(String message) {
        return CharMatcher.whitespace().removeFrom(message);
    }

}
