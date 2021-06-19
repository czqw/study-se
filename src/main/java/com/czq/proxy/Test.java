package com.czq.proxy;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/8/20 10:44 上午
 **/
public class Test {

    public static void main(String[] args) {

        //  1 2 3 4 5
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Test t = new Test();
        t.print(t.reverse(n1));
    }

    public Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node pre = null,cur = head,resH = null;
        while (cur != null){
            Node next = cur.next;
            if(next == null) resH = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return resH;
    }
    private void print(Node head){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
    }
}

class Node{
    Node next;
    int val;
    Node(int val){
        this.val = val;
    }
}