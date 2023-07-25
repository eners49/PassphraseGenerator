/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassphraseGenerator;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

/**
 *
 * @author stefan.popescu
 */

public class WordlistFileReader {

    public static final int DEFAULT_BUFFER_SIZE = 1024;
    
    /* This method grabs the word list from the correct directory. */
    public File getWordlist(String file) throws URISyntaxException, FileNotFoundException {
        File wordlist = new File(file);
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        try {
            copyInputStreamToFile(inputStream, wordlist);
        } catch (IOException e) {
            System.out.println("error!");
        }
        return wordlist;
    }

    private void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}