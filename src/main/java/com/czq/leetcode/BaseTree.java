package com.czq.leetcode;


import com.czq.offer.Tree;

import java.util.*;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/4/27 11:53 下午
 **/
public class BaseTree {
    
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void inOrder(TreeNode root){
        if (root != null){
            inOrder(root.left);
            System.out.print(root.val+ " ");
            inOrder(root.right);
        }
    }
    
    public static void postOrder(TreeNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }

    public static void levelOrder(TreeNode root){
        TreeNode tem ;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            tem = queue.poll();
            System.out.print(tem.val+" ");
            if (tem.left != null) queue.add(tem.left);
            if (tem.right != null) queue.add(tem.right);
        }
    }

    public static List<List<Integer>> levelOrderL(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null)queue.add(treeNode.left);
                if (treeNode.right != null)queue.add(treeNode.right);
            }
            res.add(0,list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node10=new TreeNode(10,null,null);
        TreeNode node8=new TreeNode(8,null,null);
        TreeNode node9=new TreeNode(9,null,node10);
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node5=new TreeNode(5,node8,node9);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(2,node4,node5);
        TreeNode node3=new TreeNode(3,node6,node7);
        TreeNode node1=new TreeNode(1,node2,node3);
        /**
         *
         *                        1
         *                    2       3
         *                  4   5   6    7
         *                    8   9
         *                          10
         *
         * */
        System.out.println("=====先序====");
        preOrder(node1);
        System.out.println();

        System.out.println("=====中序====");
        inOrder(node1);
        System.out.println();

        System.out.println("=====后序====");
        postOrder(node1);
        System.out.println();

        System.out.println("=====层序====");
        levelOrder(node1);
        System.out.println();

        System.out.println("=====层序====");
        List list = levelOrderL(node1);
        System.out.println(list);

        TreeSolution solution = new TreeSolution();
        System.out.println(solution.levelOrder102(node1));
    }
}
