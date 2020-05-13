package com.czq.leetcode;

import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/4/27 11:12 下午
 **/
public class TreeSolution {
    public boolean isSameTree100(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree100(p.left, q.left) && isSameTree100(p.right, q.right);
            }
        } else {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isSymmetric101(TreeNode root) {
        if (root == null) return true;
        return comRoot(root.left, root.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val)
            return false;
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }

    public int maxDepth104(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth104(root.left) + 1;
        int right = maxDepth104(root.right) + 1;
        return Math.max(left, right);
    }

    public List<List<Integer>> levelOrderBottom107(TreeNode root) {
        if (root == null)return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode tem = queue.poll();
                if (tem.left != null) queue.add(tem.left);
                if (tem.right != null) queue.add(tem.right);
                list.add(tem.val);
            }
            res.add(0,list);
        }
        return res;

    }

    public int minDepth111(TreeNode root) {
      if (root == null) return 0;
      int left = minDepth111(root.left);
      int right = minDepth111(root.right);
      return (left > 0 && right > 0) ? 1+Math.min(left,right) : 1+Math.max(left,right);
    }

    public List<List<Integer>> levelOrder102(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode tem = queue.poll();
                if(tem.left != null) queue.add(tem.left);
                if(tem.right != null) queue.add(tem.right);
                list.add(tem.val);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder429(Node root) {
        if (root == null) return  new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node tem = queue.poll();
                for (Node n : tem.children){
                    if(n != null) queue.add(n);
                }
                list.add(tem.val);
            }
            res.add(list);
        }
        return res;
    }

    public TreeNode buildTree105(int[] preorder, int[] inorder) {
        return buildTreeByPre(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode buildTreeByPre(int[] preorder, int pstart, int pend, int[] inorder, int istart,int iend) {
        if (preorder.length == 0) return null;
        if(pstart == pend) return new TreeNode(preorder[pstart]);
        int rootIndex = 0;
        int rootVale = preorder[pstart];
        while (rootVale != inorder[rootIndex]){
            rootIndex++;
        }
        TreeNode root = new TreeNode(rootVale);
        int leftLen = rootIndex - istart;
        int leftEnd = pstart + leftLen;
        if (leftLen > 0){
            root.left = buildTreeByPre(preorder,pstart + 1,leftEnd,inorder,istart,rootIndex - 1);
        }
        if(leftLen < pend - pstart){
            root.right = buildTreeByPre(preorder,leftEnd + 1,pend,inorder,rootIndex + 1,iend);
        }
        return root;
    }

    public TreeNode buildTree106(int[] inorder, int[] postorder) {
       return buildTreeByPost(inorder,0,inorder.length - 1,postorder,postorder.length - 1,0);
    }

    private TreeNode buildTreeByPost(int[] inorder,int istart,int iend,int[] postorder,int pright,int pleft){
        if (postorder.length == 0 )return null;
        if (istart == iend || pright == pleft)return new TreeNode(postorder[pright]);
        int rootIndex = 0;
        int rootValue = postorder[pright];
        while (inorder[rootIndex] != rootValue){
            rootIndex++;
        }
        TreeNode root = new TreeNode(rootValue);
        int rightLen = iend - rootIndex;
        int rightLow = pright - rightLen;
        if (rightLen < iend - istart){
            root.left = buildTreeByPost(inorder,istart ,rootIndex - 1,postorder,rightLow - 1,pleft);
        }
        if (rightLen > 0){
            root.right = buildTreeByPost(inorder,rootIndex + 1,iend,postorder,pright -1,rightLow);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();
        int pre[] = {3,9,20,15,7};
        int in[] = {9,3,15,20,7};
        TreeNode root = solution.buildTree105(pre,in);
        System.out.println(solution.levelOrder102(root));

        int ino[] = {9,3,15,20,7};
        int post[] = {9,15,7,20,3};
        TreeNode root1 = solution.buildTree106(ino,post);
        System.out.println(solution.levelOrder102(root1));
    }
}
