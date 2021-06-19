package com.czq.leetcode.test;


import java.util.*;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/7/20 9:07 上午
 **/
public class Solution {

    static HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public boolean isValid26(String s) {
        if ("".equals(s)) return true;
        if (s == null) return false;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != map.get(ch)) return false;
            } else {
                stack.push(ch);
            }

        }
        return stack.isEmpty();
    }

    public int[] twoSum167(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (target < (numbers[left] + numbers[right])) {
                right--;
            } else if (target == (numbers[left] + numbers[right])) {
                int[] res = new int[2];
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char ch[] = s.toCharArray();
        while (i < j) {
            while (!Character.isLetterOrDigit(ch[i]) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(ch[j]) && i < j) {
                j--;
            }
            while (Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int[] twoSum01(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public int[] twoSum202(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && target / 2 == nums[i]) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tem = nums[i] + nums[j];
            if (tem > target) {
                j--;
            } else if (tem < target) {
                i++;
            } else {
                return new int[]{map.get(nums[i]), map.get(nums[j])};
            }
        }
        return null;
    }


    public int maxProfit121(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            int cur = prices[i] - minPrice;
            maxProfit = Math.max(cur, maxProfit);
        }
        return maxProfit;
    }

    public int maxProfit122(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0, in = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                if (in == -1) {
                    in = prices[i];
                }
                continue;
            }
            if (in != -1) {
                sum += (prices[i] - in);
                in = -1;
            }
        }
        if (in != -1) sum += (prices[prices.length - 1] - in);

        return sum;

    }

    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;

    }

    public int removeElement27(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int flow = 0, fast = 0;
        while (flow <= fast && fast < nums.length) {
            if (nums[fast] != val) {
                nums[flow++] = nums[fast++];
                continue;
            }
            fast++;
        }
        return flow;
    }


    public int reverse7(int x) {
        int res = 0;
        while (x != 0) {
            int tem = x % 10;

            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            if ((res == Integer.MAX_VALUE / 10 && tem > 7) || (res == Integer.MIN_VALUE / 10 && tem > 8)) {
                return 0;
            }
            res = res * 10 + tem;
            x /= 10;
        }
        return res;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        duplication = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                map.put(numbers[i], 1);
            }
        }
        return false;
    }


    public String replaceSpace(String str) {
        int blankNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) blankNum++;
        }
        char[] ch = new char[str.length() + 2 * blankNum];

        int p = str.length() - 1;
        int q = ch.length - 1;
        while (p >= 0 && q >= 0) {
            ch[q] = str.charAt(p);
            if (str.charAt(p) == ' ') {
                ch[--q] = '0';
                ch[--q] = '2';
                ch[--q] = '%';
            }
            p--;
            q--;
        }
        return String.copyValueOf(ch);
    }


    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = listNode;
        while (cur != null) {
            list.add(cur.val);
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int tem = list.get(left);
            list.add(left, list.get(right));
            list.add(right, tem);
        }
        return list;

    }


    int[] rem;

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        rem = new int[n > 1 ? n + 1 : 3];
        rem[1] = 1;
        rem[2] = 1;
        return fib(n);
    }

    public int fib(int n) {
        if (rem[n] != 0) return rem[n];
        int fn = fib(n - 1) + fib(n - 2);
        rem[n] = fn;
        return fn;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if(slow != null && slow.next != null){
                slow = slow.next;
            }else{
                return false;
            }
            if(fast != null && fast.next != null && fast.next.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }

            if(fast == slow)return true;

        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int c = 0;
        while (l1 != null || l2 != null){
            int dl1 = l1 == null ? 0 : l1.val;
            int dl2 = l2 == null ? 0 : l2.val;

            int curen = c + dl1 + dl2;
            ListNode tem = new ListNode(curen % 10);
            c = curen/10;
            cur.next = tem;
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (c > 0){
            cur.next = new ListNode(c);
        }
        return res.next;
    }

    public ListNode addTwoNumbersv2(ListNode l1, ListNode l2) {
         Stack<ListNode> s1 = new Stack<>();
         Stack<ListNode> s2 = new Stack<>();
         while (l1 != null || l2 != null){
             if (l1 != null){
                 s1.push(l1);
                 l1 = l1.next;
             }
             if (l2 != null){
                 s2.push(l2);
                 l2 = l2.next;
             }
         }

         Stack<ListNode> res = new Stack<>();
         int c = 0;
         while (!s1.isEmpty() || !s2.isEmpty()){
             int a1 = s1.isEmpty() ? 0 : s1.pop().val;
             int a2 = s2.isEmpty() ? 0 : s2.pop().val;

             int sum  =  a1 + a2 + c;
             res.push(new ListNode(sum%10));
             c = sum / 10;
         }
         if (c > 0){
             res.push(new ListNode(c));
         }
         ListNode head = new ListNode(0);
         ListNode cur = head;
         while (!res.isEmpty()){
             ListNode tem = res.pop();
             cur.next = tem;
             cur = tem;

         }
         return head.next;
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if(q.size() < k){
                q.add(arr[i]);
            }else if(arr[i] < q.peek()){
                q.poll();
                q.add(arr[i]);
            }
        }
        Arrays.asList(new int[1]);
        int rs[] = new int[k];
        for (int i = 0; i < k; i++){
            rs[i] = q.poll();
        }
        return  rs;
    }






    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isValid26("()"));

        int tese[] = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum167(tese, 9)));

        System.out.println(solution.reverse7(1534236469));

        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);

        int tem[] = {2, 1, 3, 1, 4};
        solution.duplicate(tem, 5, new int[1]);

        solution.replaceSpace("hello world");

        solution.Fibonacci(3);

        HashMap map = new HashMap();
    }
}

class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
