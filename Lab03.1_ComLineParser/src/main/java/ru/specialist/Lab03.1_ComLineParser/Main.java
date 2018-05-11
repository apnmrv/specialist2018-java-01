package comlineparser;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        ComLineParser cmp = new ComLineParser(new String [] {"?","w","r"});
        cmp.Parse(args);
    }    
}
