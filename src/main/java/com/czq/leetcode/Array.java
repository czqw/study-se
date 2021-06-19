package com.czq.leetcode;

import java.util.*;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/5/21 8:48 上午
 **/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
  }
public class Array {

    public static int binarySearch(int array[],int n, int target){
        int l = 0,r = n -1;  //[l...n]  在循环中保证循环不变量
        while (l <= r){
            int mid = (l + r) / 2;
            if (target == array[mid])
                return mid;
            if (target > array[mid])
                l = mid + 1;
            else
                r = mid - 1;

        }
        return -1;
    }

    public void rotate189(int[] nums, int k) {
        //k == nums.length 时相当于没有移动
        k = k % nums.length;
        reverce(nums,0,nums.length - 1);
        reverce(nums,0,k - 1);
        reverce(nums,k,nums.length - 1);

    }
    public void reverce(int[] nums,int start,int end){
        while (start < end){
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start ++;
            end --;
        }
    }

    public List<List<Integer>> generate118(int numRows) {
        List<List<Integer>> reslist = new ArrayList<>(numRows);
        if (numRows == 0) return reslist;
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        reslist.add(list0);
       for (int i =1; i < numRows; i++){
           List<Integer> list = new ArrayList<>(i);
           List<Integer> listP = reslist.get(i - 1);
           for (int j = 0; j < i + 1; j++){
               if (j == 0 || j == i) {
                   list.add(1);
                   continue;
               }
               list.add(listP.get(j - 1) + listP.get(j));
           }
           reslist.add(list);
       }
       return reslist;
    }

    public int missingNumber268(int[] nums) {
        int sum = 0, sum1 = nums.length;
        for (int i = 0;i < nums.length; i++){
            sum+=nums[i];
            sum1 += i;
        }
        return sum1 - sum;
    }
    public int missingNumber268V2(int[] nums) {

       int[] num = new int[nums.length + 1];
       System.arraycopy(nums,0,num,0,nums.length);
       num[num.length - 1] = 1;
       for (int i = 0; i < num.length - 1; i++){
           num[Math.abs(num[i])] = -num[Math.abs(num[i])];
       }
       int res = -1;boolean flag = false;int tem = -1;
       for (int i= 0 ; i < num.length; i++){
           if (num[i] > 0){
               res = i;
               flag = true;
               break;
           }
           if (num[i] == 0){
               tem = i;
           }
       }
       if (!flag){
           res = tem;
       }
       return res;
    }

    public void merge88(int[] nums1, int m, int[] nums2, int n) {
        int tem[] = new int[m];
        System.arraycopy(nums1,0,tem,0,m);

        int l = 0, r = 0;
        for (int i =0; i < m + n; i++){
            if (l == m) {
                nums1[i] = nums2[r++];
                continue;
            }
            if (r == n){
                nums1[i] = tem[l++];
                continue;
            }
            nums1[i] = tem[l] < nums2[r] ? tem[l++] : nums2[r++];
        }
    }

    public void merge88V2(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = n -1;
        for (int i = m + n -1; i >= 0; i--){
            if (l == -1) {
                nums1[i] = nums2[r--];
                continue;
            }
            if (r == -1){
                nums1[i] = nums1[l--];
                continue;
            }
            nums1[i] = nums1[l] > nums2[r] ? nums1[l--] : nums2[r--];
        }
    }

    public int majorityElement169(int[] nums) {
       Arrays.sort(nums);
       return nums[nums.length/2];
    }

    public int majorityElement169V2(int[] nums) {
       int major = -1,count = 0;
       for (int i = 0; i < nums.length; i++){
           if (count == 0){
               major = nums[i];
               count++;
               continue;
           }
           if (nums[i] == major) count++;
           else count--;
       }
       return major;
    }

    public boolean containsDuplicate217(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                return true;
            map.put(nums[i],0);
        }
        return false;
    }

    public boolean containsDuplicate217V2(int[] nums) {
       Arrays.sort(nums);
       for (int i = 1; i < nums.length; i++){
           if (nums[i] == nums[i - 1])
               return true;
       }
       return false;
    }

    public int strStr28(String haystack, String needle) {
        if ("".equals(needle))return 0;
        if ("".equals(haystack)) return -1;
        char[] charsH = haystack.toCharArray();
        char[] charsN = needle.toCharArray();
        int l = 0, r = 0;
        while (l < charsH.length){
            while (l < charsH.length && charsH[l] != charsN[0]) l++;
            if (l < charsH.length && charsH[l] == charsN[r]){
                int len = 0;
                while (l < charsH.length && r < charsN.length && charsH[l] == charsN[r]){
                    len++;
                    r++;
                    l++;
                }
                if (len == charsN.length)return l - len;
                l = l - len + 1;
                r = 0;
            }
        }
        return -1;
    }

    public int strStr28V2(String haystack, String needle) {
        int lh = haystack.length();
        int ln = needle.length();
        if(ln == 0) return 0;
        int p = 0;
        while (p < lh - ln + 1){
            while (p < lh - ln + 1 && haystack.charAt(p) != needle.charAt(0)) p++;
            int len = 0, pr = 0;
            while (p < lh && pr < ln && haystack.charAt(p) == needle.charAt(pr)){
                len++;
                p++;
                pr++;
            }

            if (len == ln) return p - len;
            p = p - len + 1;
        }
        return -1;
    }

    public boolean isPalindrome125(String s) {
        int i = 0,j = s.length() - 1;
        char[] ch = s.toCharArray();
        while (i < j){
            while (!Character.isLetterOrDigit(ch[i]) && i < j){
                i++;
            }
            while (!Character.isLetterOrDigit(ch[j]) && i < j){
                j--;
            }
            if (Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j]))
                return false;
            i++;j--;
        }
        return true;
    }

    public void reverseString344(char[] s) {
        if (s.length <= 1)return;
        int l = 0, r = s.length - 1;
        char tem = ' ';
        while (l < r){
            tem = s[l];
            s[l] = s[r];
            s[r] = tem;
            l++;r--;
        }
    }

    public boolean hasCycle141(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow != null && fast != null && slow.val == fast.val)return true;
        }
        return false;
    }

    public ListNode getIntersectionNode160(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa.next != null || pb.next != null){
            if (pa == pb) return pa;
            if (pa.next == null) pa = headB;
            else pa = pa.next;
            if (pb.next == null) pb = headA;
            else pb = pb.next;
        }
        return pa == pb ? pa : null;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        Array a = new Array();
        a.rotate189(nums,3);
        System.out.println(Arrays.toString(nums));

        System.out.println(a.generate118(5));

        int[] aa = {9,6,4,2,3,5,7,0,1};
        System.out.println(a.missingNumber268V2(aa));

        int[] tem = {3,2,3};
        System.out.println(a.majorityElement169V2(tem));

        System.out.println(a.strStr28("mississippi","pi"));

    }

}
