package com.czq.offer;

import java.util.Arrays;

public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int a[] = new int[length];
        for (int i = 0; i < length; i++){
            a[numbers[i]]++;
        }
        for(int i = 0; i < a.length;i++){
            if(a[i] > 1){
                return true;
            }
        }
        return false;
    }
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        int len = numbers.length;
        if(len == 0) return false;

        Arrays.sort(numbers);
        int tem = 0,i = 1;
        for(;i < len; i++){
            if((tem = numbers[i - 1]) == numbers[i]){
                break;
            }
        }
        if(i == len){
            return false;
        }
        duplication[0] = numbers[i];
        return true;
    }
    public static String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return str.toString();
        }
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }

        int p = len - 1;
        int q = str.length() - 1;
        while(p >= 0){
            char ch = str.charAt(p--);
            if(ch == ' '){
                str.setCharAt(q--,'0');
                str.setCharAt(q--,'2');
                str.setCharAt(q--,'%');
            }else{
                str.setCharAt(q--,ch);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
