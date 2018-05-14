package ru.specialist.ComLineParser01;
/**
 *
 * @author Admin
 */
public class ComLineParser {
    
    private String[] keys;
    
    private String[] delimeters;
    
    public enum SwitchStatus { NoError, Error, ShowUsage };

    public ComLineParser(String[] keys) {
        this(keys, new String[]{"/","-"});
    }
    
    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }

    public void OnUsage(String errorKey){
        if (errorKey != null) System.out.println(errorKey);
        System.out.println(
                "формат ком.строки: имяПрограммы [-r<input-fileName>] "
                        + "[-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
	System.out.println("   -w  выполнить вывод в указанный файл");
    }
    
    public Enum OnSwitch(String key, String keyValue) {
        System.out.println("Ключ: "+key);
        System.out.println("Значение: "+keyValue);
        
        return SwitchStatus.NoError;
    }
    
    public boolean Parse(String[] args){
        
        SwitchStatus ss = SwitchStatus.NoError;
        int argNum;
        for (argNum = 0; (ss == SwitchStatus.NoError) && 
                (argNum < args.length); argNum++) {                             // Цикл по элементам массива args
            // провера наличия правильного разделителя
            System.out.println("Строка: "+ args[argNum]);
            
            boolean isDelimeter = false;
            for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {               
               isDelimeter = args[argNum].regionMatches(0,delimeters[n], 0, 1);
               
               System.out.println("Ищем разделитель \""+delimeters[n]+"\"");
               System.out.println("Найден? "
                       + new StringBuilder().append(isDelimeter).toString());
               }
               if (isDelimeter) {                                               // Если найден разделитель
                   System.out.println(
                           "Найден разделитель. Начинаем поиск ключа в строке "
                                   +args[argNum].substring(1));
                    // проверка наличия правильного ключа
                    boolean isKey = false;                    
                    for (int i = 0; !isKey && (i < keys.length); i++) {
                        String s1 = args[argNum].toUpperCase();
                        String s2 = keys[i].toUpperCase();
                        isKey = s1.regionMatches(1, s2, 0, 1);
                        if(isKey) {
                            System.out.println("Найден ключ");
                            this.OnSwitch(keys[i], args[argNum].substring(2));
                            break;
                        }
                    }
                    if (isKey == false) ss = SwitchStatus.Error;                       
                } else {
                    ss = SwitchStatus.Error;
                    break;
                }                         
        }
        // завершение разбора командной строки
        if (ss == SwitchStatus.ShowUsage) OnUsage(null);
        if (ss == SwitchStatus.Error) OnUsage((argNum == args.length) 
                ? null : args[argNum]);        
        return ss == SwitchStatus.NoError;
    }
}