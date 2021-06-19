package com.czq.offer;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/8/20 6:54 下午
 **/
public class Test1 {

    public static void main(String[] args) {
        Test1 t = new Test1();
        int a[] = {-1,2,3,5,1};
        int  res =t.minNumberdisappered(a);
        System.out.println(res);
    }

    public int minNumberdisappered (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0)return 0;
        int ans = 0;
        for(int i =0; i < arr.length; i++){
            if(arr[i] > arr.length) continue;
            while(i != arr[i] && arr[i] < arr.length - 1){
                if(arr[i] > 0){
                    int tem = arr[i];
                    arr[i] = arr[tem];
                    arr[tem] = tem;
                }else{
                    break;
                }
            }
        }
        for(int i = 1 ; i < arr.length; i++){
            if(arr[i] <= 0 || arr[i] != i ) return i;
        }
        return ans;
    }
}
