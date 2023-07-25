/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassphraseGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author stefan.popescu
 */
public class WordsGenerator {
    public ArrayList<String> generateWords(File file) throws FileNotFoundException {
        
        Scanner scnr = new Scanner(file);
        ArrayList<String> words = new ArrayList<>();

        while (scnr.hasNextLine()) {
            String data = scnr.nextLine();
            words.add(data);
        }
        scnr.close();

        return words;
    }
}
