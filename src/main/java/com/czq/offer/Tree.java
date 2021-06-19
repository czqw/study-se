package com.czq.offer;


import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Tree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return create(pre, 0, pre.length - 1, in, 0, in.length);
    }

    private TreeNode create(int[] pre, int pstart, int pend, int[] mid, int mstart, int mend) {
        TreeNode rooot = new TreeNode(pre[pstart]);
        if (pend == pstart || mstart == mend) {
            return rooot;
        }
        int rootIndex = mstart;
        while (pre[pstart] != mid[rootIndex]) {
            rootIndex++;
        }
        int leftLen = rootIndex - mstart;
        int leftEnd = pstart + leftLen;
        if (leftLen > 0) {
            rooot.left = create(pre, pstart + 1, leftEnd, mid, mstart, rootIndex - 1);
        }
        if (leftLen < pend - pstart) {
            rooot.right = create(pre, leftEnd + 1, pend, mid, rootIndex + 1, mend);
        }
        return rooot;
    }


    public static void main(String[] args) {
//        Tree t = new Tree();
//        int pre [] = {1,2,4,5,3,6,7};
//        int in[] = {4,2,5,1,6,3,7};
//        preOrder(t.reConstructBinaryTree(pre,in));


        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode rigth = new TreeNode(3);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(7);
        left.left = a;
        left.right = b;
        rigth.left = c;
        rigth.right = d;
        root.left = left;
        root.right = rigth;
        preOrder(root);
        System.out.println();
        floorPrder(root);
        Queue<TreeNode> q = new ArrayDeque();
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void floorPrder(TreeNode root) {
        if (root == null) {
            return;
        }
        java.util.Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size;i++){
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            System.out.println();
        }
    }
}