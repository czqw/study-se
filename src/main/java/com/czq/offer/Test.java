package com.czq.offer;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  input = sc.nextLine();
        String strs[] = input.split(" ");
        Integer year = Integer.valueOf(strs[0]);
        Integer month = Integer.valueOf(strs[1]);
        Integer week = Integer.valueOf(strs[2]);
        Integer day = Integer.valueOf(strs[3]);
        if(week < 1 || week > 4 || day < 1 || day > 7){
            System.out.println(0);
            System.exit(0);
        }

        Integer days = 0;
        for (int y = 2000;y < year; y++){
            if (isRunNian(y)){
                days = days + 366;
            }else {
                days = days + 365;
            }
        }

        for (int m = 1; m < month; m++){
            if(m % 2 != 0){
                days = days + 31;
            }else if (m == 2){
                days = isRunNian(year) ? (days + 29) : (days + 28);
            }else {
                days += 30;
            }
        }

        //month月1日是周几
        Integer w =days % 7 - 1;


     //   System.out.println(days + ":"+w);
        int tem = 8 - w;
      //  System.out.println(tem + "  "+ week+" "+day );
        int d = tem + (week - 2)*7 + day;
        System.out.println(year+"-"+strs[1]+"-"+d);

    }

    public static boolean isRunNian(Integer year){
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }
}
