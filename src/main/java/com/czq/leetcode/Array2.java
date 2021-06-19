package com.czq.leetcode;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/5/26 11:20 下午
 **/
public class Array2 {
    public int findDuplicate287(int[] nums) {
       int left = 0, rigth = nums.length - 1;
       while (left < rigth){
           int mid = (left + rigth + 1)/2;
           int count = 0;
           for (int tem : nums){
               if (tem < mid)count++;
           }
           if (count >= mid){
               rigth = mid - 1;
           }
           if (count < mid){
               left = mid;
           }
       }
       return left;
    }

    public static void main(String[] args) {
        Array2 array2 = new Array2();
        int a[] = {1,2,3,3};
        System.out.println(array2.findDuplicate287(a));
    }
}
