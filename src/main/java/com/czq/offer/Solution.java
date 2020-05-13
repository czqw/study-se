package com.czq.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
          if (num == null || num.length == 0){
              return new ArrayList<>();
          }
          if(size == 0){
              return new ArrayList<>();
          }
          int p = 0;
          ArrayList<Integer> list = new ArrayList<>();
          while (p <= num.length - size){
              list.add(getMax(p,p+size-1,num));
              p++;
          }
          return list;
    }
    public int getMax(int start,int end,int [] num){
        int len = end - start + 1;
        int tem [] = new int [len];
        int offset = 0;
        for(int i = start;i <= end ; i++){
            tem[offset++] = num[i];
        }
        Arrays.sort(tem);
        return tem[len - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num[] = {2,3,4,2,6,2,5,1};
        System.out.println(s.maxInWindows(num,3));
    }
}
