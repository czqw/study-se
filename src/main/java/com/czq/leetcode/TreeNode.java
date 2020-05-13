package com.czq.leetcode;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/4/27 11:11 下午
 **/

public class TreeNode {
    int val;
    com.czq.leetcode.TreeNode left;
    com.czq.leetcode.TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    TreeNode(int x,TreeNode left,TreeNode right){
        val = x;
        this.left = left;
        this.right = right;
    }
}
