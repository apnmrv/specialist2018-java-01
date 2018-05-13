package ru.specialist.Lab01_CalConverter;

public class CalendarConverter {

    public static void main(String[] args) {
        int year = 1999;
        int dayNum = 165;
        int [] daysInMonths={
            31,
            28,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31};
        String []months={
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
        
        int monthNum=0;
        boolean isLeapYear=(year%4==0)&& (year%100!=0 || year%400==0);
        
        StringBuilder sb = new StringBuilder();
        sb = sb.append("For year ").append(year).append(" day ").append(dayNum).append(" is ");
        
            for(int d : daysInMonths){
                if (isLeapYear && d==28) ++d;
                if (dayNum <= d) break;
                
                dayNum -= d;
                monthNum++;
            }        
        sb = sb.append(months[monthNum]).append(", ").append(dayNum).append(".");
        
        System.out.println(sb);
    }    
}
