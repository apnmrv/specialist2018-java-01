/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.specialist.IntConverter01;

/**
 *
 * @author pandrey
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(getBinaryByString(65004300));
        
        System.out.println(getBinaryByStringBuilderInsert(65004300));
        
        System.out.println(getBinaryByStringBuilderAppend(65004300));
    }
    
    public static String getBinaryByString (int num){         // Для упражнения. Не эффективен
        String str = new String();
        for (int i = 0; i < 32; i++){
            if ( num%2 != 0 ) str = "1" + str; else str = "0" + str;
            if (i == 7 || i == 15 || i == 23) str = " " + str;
            num = num>>1;
        }
        return str;
    }
    
    public static StringBuilder getBinaryByStringBuilderInsert (int num){       // ?? Чем отличается от append? В исходниках выглядит также, но не требует реверса итоговой строки.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++){
            if ( num%2 != 0 ) sb.insert(0, "1"); else sb.insert (0, "0");
            if (i == 7 || i == 15 || i == 23) sb.insert(0," ");
            num = num>>1;
        }
        
        return sb;
    }
    
    public static StringBuilder getBinaryByStringBuilderAppend (int num){       
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++){
            if ( num%2 != 0 ) sb.append("1"); else sb.append ("0");
            if (i == 7 || i == 15 || i == 23) sb.append(" ");
            num = num>>1;
        }
        
        sb = sb.reverse();
        
        return sb;
    }
}