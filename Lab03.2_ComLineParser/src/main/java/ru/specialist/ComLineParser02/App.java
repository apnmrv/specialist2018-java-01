
package ru.specialist.ComLineParser02;

public class App {

    public static void main(String[] args) {
        
        SimpleParser sp = new SimpleParser(new String[] {"?", "r", "w"});
        
        if (sp.Parse(args)) {
            System.out.println("Input file name: " + sp.getInFile());
            System.out.println("Output file name: " + sp.getOutFile());
        }        
        
    }
    
}
