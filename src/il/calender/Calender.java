package il.calender;

import java.sql.Date;
import java.util.*;

public class Calender {

    private HashMap <Date, String> planMap;

    public Calender(){
        planMap = new HashMap<Date, String>();
    }

    public static final int [] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int [] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public void calPlan(String strDate, String plan){
        java.sql.Date date = java.sql.Date.valueOf(strDate);
        System.out.println(date);
        planMap.put(date, plan);
    }

    public String searchPlan(String strDate){
        java.sql.Date date = java.sql.Date.valueOf(strDate);
        String plan = planMap.get(date);
        return plan;
    }

    //leap year
    public boolean isLeapYear(int year){
        if (year % 4 ==  0 && (year % 100 != 0 || year % 400 != 0)){
            return true;
        }else{
            return false;
        }
    }

    //Check the leap year
    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month - 1];
        } else {
            return MAX_DAYS[month - 1];
        }
    }
    //How to find the first day
    public int getFirstDayIndexOfWeek(int year,int month){
        int a_year = year-1;
        int days = a_year * 365 + a_year / 4 - a_year / 100 + a_year / 400;

        if (isLeapYear(year)) {
            for(int i=1; i <month; i++){
                days += LEAP_MAX_DAYS[i - 1];
            }
        } else {
            for(int i=1; i <month; i++){
                days += MAX_DAYS[i - 1];
            }
        }
        return days % 7;
    }



    public void printCalender(int year, int month){

        System.out.printf("   <<%4d년%3d월>>    \n",year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        int weekday = getFirstDayIndexOfWeek(year, month) + 1;

        //first line
        for(int i=1; i <= weekday; i++){
            if(weekday==7){
                break;
            }
            System.out.printf("   ");
        }

        for(int i = 1; i <=maxDay; i++){
            System.out.printf("%3d", i);
            if ((i + weekday) % 7 == 0){
                System.out.println();
            }

        }
        System.out.println("\n");
    }

    /*public static void main(String[] args) {
        Calender cal = new Calender();
        cal.calPlan("2022-01-22", "백신맞는날");
        System.out.println(cal.searchPlan("2022-01-22"));
    }*/
}
