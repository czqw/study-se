package com.czq.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {


        int a[]  = {4,5,7,3,6,9};
       // quickSort(a);
        quick(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int a[]){
        if (a == null || a.length == 0){
            return;
        }
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int start, int end) {

        if (start >= end){
            return;
        }
        int i = start , j = end,index = a[i];
        while (i < j){
            while (i < j && a[j]>= index){
                j--;
            }

            if (i < j){
                a[i++] = a[j];
            }

            while (i < j && a[i] < index){
                i++;
            }

            if (i < j){
                a[j--] = a[i];
            }
        }
        a[i] = index;
        quickSort(a,start,i-1);
        quickSort(a,i+1,end);
    }


    public static void quick(int a[],int start,int end){
        if (start >= end){
            return;
        }
        int i = start,j=end,index = a[i];

        while (i < j){
            while ( i < j && a[j] >= index){
                j--;
            }
            if (i < j){
                a[i++] = a[j];
            }

            while (i < j && a[i] < index){
                i++;
            }
            if (i<j){
                a[j--] = a[i];
            }
            a[i] = index;
            quick(a,start,i - 1);
            quick(a,i+ 1,end);
        }
    }
}
