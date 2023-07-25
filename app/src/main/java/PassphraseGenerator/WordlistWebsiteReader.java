/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassphraseGenerator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author stefan.popescu
 */
public class WordlistWebsiteReader {
    public ArrayList<String> generateWords(String website) throws IOException {
        // Get the input stream through URL Connection
        URL url = new URL(website);
        URLConnection con = url.openConnection(); InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.          

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        
        ArrayList<String> words = new ArrayList<>();

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
        
        return words;
    }    
    
    
}
