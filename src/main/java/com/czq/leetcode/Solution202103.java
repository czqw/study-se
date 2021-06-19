package com.czq.leetcode;

import com.czq.offer.Tree;

import java.util.Stack;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2021/3/28 8:56 下午
 **/
public class Solution202103 {

    // 783
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            if(pre != null){
                res = Math.min(res,root.val - pre.val);
            }
            pre = root;
            root = root.right;
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        //33
        if(x == 0) return true;

        if(x < 0 || x % 10 == 0 )return false;
        int res = 0;
        while(x > res){
            int tem = x % 10;
            res = res * 10 + tem;
            x /= 10;
        }
        return res == x || x == res/10;
    }

    public static void main(String[] args) {
        Solution202103 s = new Solution202103();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;

        System.out.println(s.minDiffInBST(n4));
        isPalindrome(121);
    }
}
