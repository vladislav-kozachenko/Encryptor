package javaclasses.encryptor.impl;

import com.google.common.base.CharMatcher;
import javaclasses.encryptor.Encryptor;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Implementation of Encryptor.
 * Represents encrypting machine based on simple algorithm of symbols transposition.
 */
public class EncryptorImpl implements Encryptor {

    /**
     * Receives an string message and encrypt it.
     *
     * @param message is the String text that may be encrypted.
     * @return encrypted string.
     */
    @Override
    public String encrypt(String message) {

        checkArgument(!isNullOrEmpty(message));
        final StringBuilder text = new StringBuilder(prepareInput(message));
        final int itemNumber = (int) Math.sqrt(text.length()) + 1;
        List<String> grid = createGrid(text, itemNumber);

        return getEncryptedMessage(grid);
    }

    private String getEncryptedMessage(List<String> grid) {
        final StringBuilder encryptedMessage = new StringBuilder();
        final int wordSize = grid.get(0).length();
        for (int item = 0; item < wordSize; item++) {
            for (String word : grid) {
                if (item < word.length()) {
                    encryptedMessage.append(word.charAt(item));
                }
            }
            encryptedMessage.append(' ');
        }
        return encryptedMessage.toString().trim();
    }

    private List<String> createGrid(StringBuilder text, int itemsNumber) {
        final List<String> grid = new ArrayList<>();
        while (itemsNumber < text.length()) {
            grid.add(text.substring(0, itemsNumber));
            text.delete(0, itemsNumber);
        }
        grid.add(text.toString());
        text.delete(0, text.length());
        return grid;
    }

    private String prepareInput(String message) {
        return CharMatcher.whitespace().removeFrom(message);
    }

}
