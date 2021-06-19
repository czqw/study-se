package com.czq.leetcode;

/**
 * @Description  面试集合
 * @Author zhiqiang.cheng
 * @Date2020/5/27 7:16 上午
 **/
public class offer {
    public TreeNode buildTree07(int[] preorder, int[] inorder) {
       return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (preorder.length == 0)return null;
        if (pend == pstart) return new TreeNode(preorder[pstart]);
        int rootIndex = 0;
        int rootValue = preorder[pstart];
        while (rootValue != inorder[rootIndex]){
            rootIndex++;
        }
        int leftLen = rootIndex - istart;
        TreeNode root = new TreeNode(rootValue);
        if (leftLen > 0){
            root.left = buildTree(preorder,pstart + 1,pstart + leftLen,inorder,istart,rootIndex - 1);
        }
        if (pend - pstart > leftLen){
            root.right = buildTree(preorder,pstart + leftLen + 1,pend,inorder,rootIndex + 1,iend);
        }
        return root;
    }
}
