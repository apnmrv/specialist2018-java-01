
package comlineparser;

public class SimpleParser extends ComLineParserBase {
    
    private String inFile;
    private String outFile;

    public String getOutFile() {
        return this.outFile != null ? outFile : "not set";
    }

    public String getInFile() {
        return this.inFile != null ? inFile : "not set";
    }    
    
    public SimpleParser(String[] keys) {
        super(keys);
    }

    private void setInFile(String inFile) {
        this.inFile = inFile;
    }

    private void setOutFile(String outFile) {
        this.outFile = outFile;
    }
    
    @Override
    protected void OnUsage(String errorKey){
        if (errorKey != null) 
            System.out.println("Command-line switch error:" + errorKey);
        
        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
	System.out.println("   -?  показать Help файл");
	System.out.println("   -r  задать имя входного файла");
	System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        
        SwitchStatus status = SwitchStatus.NoError;       
        
        switch (key) {
            
            case "?": 
                status = SwitchStatus.ShowUsage; break;
                
            case "r":
                if (keyValue.isEmpty()) {
                
                    System.out.println("Имя входного файла не задано.");
                } 
               
                this.setInFile(keyValue);
                break;
                
            case "w":
                if (keyValue.isEmpty()) {
                 
                    System.out.println("Имя выходного файла не задано.");
                }
                
                setOutFile(keyValue);                
                break;
                
            default : status = SwitchStatus.Error; break;
        }   
        return status;
    }       
}