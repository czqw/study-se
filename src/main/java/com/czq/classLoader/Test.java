package com.czq.classLoader;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/9/4 7:23 下午
 **/
public class Test {

    public static void main(String[] args) {

    }
    //[1,4,2,2,2]
    public int find(int nums[]){
        if(nums == null || nums.length == 0) return -1;
       // for (int i = 0; i < nums.length; i++){
            int i = 0;
            int tem = nums[i];
            while (tem != i){
                if(nums[tem] == tem) return tem;
                int swap = nums[tem];
                nums[tem] = tem;
                nums[i] = swap;
                tem = swap;
            }
     //   }
        return -1;
    }
}
