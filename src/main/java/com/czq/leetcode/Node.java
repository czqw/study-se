package com.czq.leetcode;

import java.util.List;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/4/30 8:09 上午
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}