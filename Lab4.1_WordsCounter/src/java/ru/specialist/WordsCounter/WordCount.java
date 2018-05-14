
package ru.specialist.WordsCounter;

import java.io.*;
import java.util.*;

public class WordCount {
    
    private String inFile;
    private String outFile;
    private static String testString = "Hello world";
    private Hashtable<String, Integer> words = new Hashtable<>();

    public Hashtable<String, Integer> getWords() {
        return words;
    }

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }
    
    public void countWords() throws FileNotFoundException, IOException{
        int num = 0;
        
        Reader reader;
        
        if (this.inFile.isEmpty()){
            reader = new StringReader(WordCount.testString);
        } else {
            reader = new FileReader(this.inFile);
        }
        
        BufferedReader br = new BufferedReader(reader);
        
        for (String line = br.readLine(); 
                line != null; line = br.readLine()){
            StringTokenizer st = new StringTokenizer(line, " , . ; : \" \\()[]{}/");
            while (st.hasMoreTokens()){
                String token = st.nextToken().toLowerCase();
                if(!words.containsKey(token)){
                    words.put(token, 1);
                } else {
                    Object val = words.get(token);
                    int n = (int) val;
                    n++;
                    words.put(token, n);
                }
            }
        }
        
        br.close();
        System.out.println("num="+num);
    }
}
