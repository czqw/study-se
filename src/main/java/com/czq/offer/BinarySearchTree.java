package com.czq.offer;

public class BinarySearchTree {

    private int k;
    private int order = 1;
    TreeNode node = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if(k == 0) return null;
        this.k = k;
        inOrder(pRoot);
        return node;
    }
    private void inOrder(TreeNode node){
        if (node == null) return;

        if (node.left != null){
            inOrder(node.left);
        }
        if (order++ == k){
            this.node = node;
        }
        if (node.right != null) inOrder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

    }
}
