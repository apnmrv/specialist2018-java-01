package ru.specialist.ComLineParser01;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        ComLineParser cmp = new ComLineParser(new String [] {"?","w","r"});
        cmp.Parse(args);
    }    
}
