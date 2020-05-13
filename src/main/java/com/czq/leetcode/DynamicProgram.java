package com.czq.leetcode;

/**
 * @Description 动态规划
 * @Author zhiqiang.cheng
 * @Date2020/5/11 11:11 下午
 **/

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;

/**
 * 动态规划：原问题拆解为若干子问题，同时保存子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案
 *                                  记忆化搜索  自顶向下   思考
 *                 重叠子问题
 * 本质：递归问题 ——>              ——>
 *                 最优子结构  要符合「最优子结构」，子问题间必须互相独立
 *                                  动态规划    自底向上   实现
 */

public class DynamicProgram {
    int[] memo;

    public void setMemo(int n) {
        memo = new int[n + 1];
    }

    int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        //记忆化搜索 - 自上而下
        if (memo[n] == 0) memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    int fib1(int n) {
        memo[0] = 0;
        memo[1] = 1;
        //o(n)
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];
        //记忆化搜索 - 自下而上
        return memo[n];
    }

    public int climbStairs70(int n) {
        int[] m = new int[n + 2];
        m[1] = 1;
        m[2] = 2;
        for (int i = 3; i <= n; i++)
            m[i] = m[i - 1] + m[i - 2];
        return m[n];
    }

    //分割整数递归
    public int integerBreak343(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // 将 n 进行分割（至少两部分），可以获得最大乘积
    private int breakInteger(int n) {
        if (n == 1)
            return 1;
        if (memo[n] != 0)
            return memo[n];
        int res = -1;
        for (int i = 1; i <= n - 1; i++)
            // i + (n - i)
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        memo[n] = res;
        return res;
    }

    //分割整数 动态规划  O(n 2)
    public int integerBreakV343(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
        return memo[n];
    }

    public int rob198(int[] nums) {
        memo = new int[nums.length];
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index....nums.length）范围中的所有房子
     */
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (memo[index] != 0)
            return memo[index];
        int res = 0;
        for (int i = index; i < nums.length; i++)
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        memo[index] = res;
        return res;

    }

    /**
     * 动态规划  O(n 2)
     */
    public int robV198(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[nums.length];
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--)
            for (int j = i; j < n; j++)
                //状态转移方程
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
        return memo[0];
    }


    /**
     * 0 - 1 背包问题  v w
     * f(n,c) n个物品放入容量为c的背包，使价值最大
     * f(i,c) = f(i-1.c)   不放
     *        = v(i) + f(i-1,c - w(i))  放
     * 状态转移方程
     * f(i,c) = max {f(i-1,c),v(i) + f(i-1,c-w(i))}
     *
     * 时间复杂度：O(n*c)   空间复杂度: O(n*c)
     * */
    public int knapsack01(int []w,int[]v,int c){
        Assert.check(w.length == v.length);
        int n = w.length;
        if ( n == 0)
            return 0;
        //放入row个物品，容量是col时的最大值
        int [][] memo = new int[n][c+1];

        //第一行
        for (int i = 0;i <= c; i++)
            memo[0][i] = (i >= w[0] ? v[0] : 0);

        for (int i=1 ; i < n; i++)
            for (int j = 0; j <=c ; j++){
                //不放入第i个物品
                memo[i][j] = memo[i-1][j];
                //考虑放入第i个物品
                if ( j >= w[i])
                    memo[i][j] = Math.max(memo[i][j],v[i] + memo[i-1][j - w[i]]);
            }
        return memo[n-1][c];
    }
    /**
     * O(2*C) = O(C)
     * */
    public int knapsack01V2(int []w,int []v,int c){
        Assert.check(w.length == v.length);
        int n = w.length;
        if ( n == 0)
            return 0;
        //放入row个物品，容量是col时的最大值
        int [][] memo = new int[2][c+1];

        //第一行
        for (int i = 0;i <= c; i++)
            memo[0][i] = (i >= w[0] ? v[0] : 0);

        for (int i=1 ; i < n; i++)
            for (int j = 0; j <=c ; j++){
                //不放入第i个物品
                memo[i%2][j] = memo[(i-1)%2][j];
                //考虑放入第i个物品
                if ( j >= w[i])
                    memo[i%2][j] = Math.max(memo[i%2][j],v[i] + memo[(i-1)%2][j - w[i]]);
            }
        return memo[(n-1)%2][c];
    }

    /**
     * F(n,c)考虑将n个物品填满容量为c的背包
     * 状态转移方程：f(i,c) = f(i-1,c) || f(i-1,c-w(i))     O(n*sum)
     * */
    public boolean canPartition416(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if(sum % 2 != 0)
            return false;

        int n  = nums.length;
        int c = sum/2;
        //初始化
        boolean memo[] = new boolean[c+1];
        for (int i = 0; i <= c; i++)
            memo[i] = nums[0] == i;

        for (int i = 1; i < n; i++)
            for (int j = c; j >= nums[i]; j--)
                memo[j] = memo[j] || memo[j - nums[i]];
        return memo[c];
    }

    /**
     * f(n,c) n个硬币，组成c的最少个数
     * f(i,c) = min{f(i-1,c),f(i,c)}
     * */
    public int coinChange322(int[] coins, int amount) {
       if (amount == 0)
           return 0;
       if (coins.length == 0)
           return -1;
       //memo[i] = 组成i的最少硬币数
       int memo[] = new int[amount+1];
       memo[0] = 0;
       for (int i = 0; i <= amount; i++){
           for (int j = 0; j < coins.length; j++){
               if ( i - coins[j] < 0)
                   continue;
               memo[i] = Math.min(memo[i],1 + memo[i - coins[j]]);
           }
       }
       return memo[amount] == amount + 1  ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        DynamicProgram dynamicProgram = new DynamicProgram();
        dynamicProgram.setMemo(10);
        System.out.println(dynamicProgram.fib(10));
        System.out.println(dynamicProgram.fib1(10));

        System.out.println(dynamicProgram.climbStairs70(1));
    }
}
