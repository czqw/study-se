package test;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/8/1 1:36 下午
 **/
public class Main {

    public static void main(String[] args) {
        int [] c = new int[1];
    }

    public boolean isSame(Node root){
        if (root == null) return true;
        Node left = root.left;
        Node right = root.rigth;
        boolean lis = left != null && left.left != null && left.rigth != null;
        boolean ris = right != null && right.left != null && right.rigth != null;
        if (lis && ris && left == right){
            return true;
        }

        boolean res = isSame(root.left) && isSame(root.rigth);
        return res && (left.rigth == right.left);

    }

    public boolean isMirror(Node n1,Node n2){
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return  (n1.val == n2.val) && isMirror(n1.left ,n2.rigth) && isMirror(n1.rigth,n2.left);

    }

}

class Node{
    public   Node left;
    public   Node rigth;
    public   int val;
}