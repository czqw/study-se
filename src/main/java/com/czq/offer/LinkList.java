package com.czq.offer;

import java.util.*;

public class LinkList {
    public List<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return Collections.emptyList();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;

    }

    public static void main(String[] args) {
        LinkList l = new LinkList();
        ListNode head = createLink(new int[] {1,2,3,4,5,6});
        System.out.println(l.printListFromTailToHead(head));
    }

    public static ListNode createLink(int a[]){
        if (a == null || a.length ==0){
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i = 1;i<a.length;i++){
            ListNode node = new ListNode(a[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }
}
