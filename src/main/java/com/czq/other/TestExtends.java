package com.czq.other;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/22
 */
public class TestExtends {

    public static void main(String[] args) {
        Father f = new Father("aaa",1);
        Father ff = new Father("aaa",1);

        HashSet<Father> set = new HashSet<>();
        set.add(f);
        set.add(ff);
        System.out.println(f.hashCode());
        System.out.printf("set:%s\n", set);

        String s = "11";
        String s1 = s.intern();
        Integer i = new Integer(1);

        Factory factory= Father::new;
    }
}

interface Factory<P extends Father>{
    P create(int a);
}

class Father{
    private String name;
    private Integer age;

    public Father(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public Father(int a){

    }

    public String toString(){
        return name+"--"+age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Father)) return false;
        Father father = (Father) o;
        return name.equals(father.name) &&
                age.equals(father.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
class Son extends Father{
    public Son(){
       super(1);
    }
}