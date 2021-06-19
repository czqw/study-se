package com.czq.thread;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/8/18 8:51 下午
 **/
public class Test {

    public static void main(String[] args) {
       Test test = new Test();
        System.out.println(test.maxString("babad"));
    }
    //  babad
    public String maxString(String str){
        if(str == null || "".equals(str)) return "";
        int l = 0,r = 1;
        String  res = "";
        while (l < r && l < str.length() && r < str.length()){
            if(isH(str,l,r) ){
                if(l - r + 1 > res.length()){
                    res = str.substring(l,r);
                }
               r++;
               l++;
            }else {
                r++;
            }
        }
        return res;
    }
    private boolean isH(String str,int l,int r){
        if(l >= r) return false;
        while (l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
            if(l == r) return true;
        }
        return true;
    }

}
