package com.czq.collection;

import java.util.*;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/21
 */
public class ListTest {

    public static void main(String[] args) {
       /* List<Long> list = new ArrayList<>();
        list.add(1L);
        Vector v = new Vector();
        Set set = new HashSet();
        Collections c;
        Collection coll = set;
        List ll = Collections.synchronizedList(list);
        Hashtable ht = new Hashtable();
        ht.put("qq",1);

        arrayCopytest();

        testArrayList();
        testArrayListEn();*/

       arrayListDemo();

    }

    public static void arrayCopytest(){
        int[] a = new int[11];
        for (int i = 0;i<9;i++)
            a[i]=i;
        System.arraycopy(a,3,a,4,a.length-4);
        a[3]=99;
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
        System.out.println();

        int b[] = Arrays.copyOf(a,15);
        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+"\t");
            if (i == b.length-1)
                System.out.println(b.length);
        }
    }

    public static void testArrayList(){
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));
    }
    public static void testArrayListEn(){
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));
    }

    public static void arrayListDemo(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        System.out.printf("Before add:arrayList.size() = %d\n",arrayList.size());

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        System.out.printf("After add:arrayList.size() = %d\n",arrayList.size());

        System.out.println("Printing elements of arrayList");
        // 三种遍历方式打印元素
        // 第一种：通过迭代器遍历
        System.out.print("通过迭代器遍历:");
        Iterator<Integer> it = arrayList.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 第二种：通过索引值遍历
        System.out.print("通过索引值遍历:");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        // 第三种：for循环遍历
        System.out.print("for循环遍历:");
        for(Integer number : arrayList){
            System.out.print(number + " ");
        }

        // toArray用法
        // 第一种方式(最常用)
        Integer[] integer = arrayList.toArray(new Integer[0]);

        // 第二种方式(容易理解)
        Integer[] integer1 = new Integer[arrayList.size()];
        arrayList.toArray(integer1);

        // 抛出异常，java不支持向下转型
        //Integer[] integer2 = new Integer[arrayList.size()];
        //integer2 = arrayList.toArray();
        System.out.println();

        // 在指定位置添加元素
        arrayList.add(2,2);
        // 删除指定位置上的元素
        arrayList.remove(2);
        // 删除指定元素
        arrayList.remove((Object)3);
        // 判断arrayList是否包含5
        System.out.println(arrayList);
        System.out.println("ArrayList contains 5 is: " + arrayList.contains(5));

        // 清空ArrayList
        arrayList.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + arrayList.isEmpty());
    }
}
