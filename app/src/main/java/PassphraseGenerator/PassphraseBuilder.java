/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassphraseGenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 *
 * @author stefan.popescu
 */
public class PassphraseBuilder {
    
    public String generatePassphrase(ArrayList<String> words, int maxLength) {
        /* Generate our list of "chosen words". We stop once we reach a word that overflows what we need. */
                int numWords = words.size();
                
                ArrayList<String> chosenWords = new ArrayList<>();
                int currentLength = 0;
                SecureRandom rng = new SecureRandom();
                
		while (true) {
                    int randomNum = rng.nextInt(numWords);
                    String randomWord = words.get(randomNum);
                    if (currentLength + randomWord.length() > maxLength - 2) {
                        break;
                    }
                    chosenWords.add(randomWord + "_");
                    currentLength += randomWord.length() + 1;
                }
                /* Find another word that matches the length we need and insert it in a random spot in the ArrayList. */
                int lengthNeeded = maxLength - currentLength;
                while (true) {
                    int randomNum = rng.nextInt(numWords);
                    String randomWord = words.get(randomNum);
                    if (randomWord.length() == lengthNeeded) {
                        int randomIndex = rng.nextInt(chosenWords.size());
                        chosenWords.add(randomIndex, randomWord + "_");
                        break;
                    }
                    else {
                        words.remove(randomNum);
                        numWords--;
                    }
                }
                
                /* Convert our ArrayList of words into a passphrase string, and display it! */
                StringBuilder passphrase = new StringBuilder();
                for (int i = 0; i < chosenWords.size(); ++i) {
                    passphrase.append(chosenWords.get(i));
                }
                String passphraseString = passphrase.toString();
                passphraseString = passphraseString.substring(0, passphraseString.length() - 1);
                
                return passphraseString;
    }
    
}
