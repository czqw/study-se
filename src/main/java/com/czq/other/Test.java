package com.czq.other;

import java.util.*;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/8/20 8:23 下午
 **/
public class Test {
    static Map<Character,Character> map = new HashMap<>();
    static{
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
    }
    public static void main(String[] args) {
/*        String s = "abcddd";
        System.out.println(reverse(s));
    }*/
        System.out.println(getDivision(6));
        String [] s= {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(s,2));
    }
    public static  List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String s : words) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        List<String> res = new ArrayList();
        for (Map.Entry<String,Integer> m : map.entrySet()){
            if(m.getValue().equals( k)) res.add(m.getKey());
        }
        return res;
    }
    public static  String  reverse(String str){
        if(str == null || "".equals(str)) return str;
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    public boolean isSym(String str){
        if(str == null || "".equals(str)) return true;
        int n = str.length();
        if(n % 2 == 1)return false;//奇数直接不满足
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)) stack.add(c);//不存在时，add
            else{
                if(stack.isEmpty() )return false;
                if(stack.pop() != map.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }


    public static int getDivision(int n) {
        try {
            n += 1;
            if (n / 0 > 0) {
                n += 5;
            } else {
                n -= 5;
            }
            return n;
        } catch (Exception e) {
            n++;
        }
        n++;
        return n++;
    }

    class Main{

        public boolean isSym(String str){
            if(str == null || "".equals(str)) return true;
            int n = str.length();
            if(n % 2 == 1)return false;//奇数直接不满足
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                char c = str.charAt(i);
                if(!map.containsKey(c)) stack.add(c);//不存在时，add
                else{
                    if(stack.isEmpty() )return false;
                    if(stack.pop() != map.get(c)) return false;
                }
            }
            return stack.isEmpty();
        }
    }



}
