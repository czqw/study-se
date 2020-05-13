package com.czq.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/2
 */
public class Lamble {
    public static void main(String[] args) throws Exception{
       // tranf();
        test();

        String s = "是的";
        System.out.println(s.getBytes("GBK").length);
    }

    public static void test() {
        // Function<T, R> -T作为输入，返回的R作为输出
        Function<String, String> function = (x) -> {
            System.out.print(x + ": ");
            return "Function";
        };
        System.out.println(function.apply("hello world"));

//Predicate<T> -T作为输入，返回的boolean值作为输出
        Predicate<String> pre = (x) -> {
            System.out.print(x);
            return false;
        };
        System.out.println(": " + pre.test("hello World"));

//Consumer<T> - T作为输入，执行某种动作但没有返回值
        Consumer<String> con = (x) -> {
            System.out.println(x);
        };
        con.accept("hello world");

//Supplier<T> - 没有任何输入，返回T
        Supplier<String> supp = () -> {
            return "Supplier";
        };
        System.out.println(supp.get());

//BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
        BinaryOperator<String> bina = (x, y) -> {
            System.out.print(x + " " + y);
            return "BinaryOperator";
        };
        System.out.println(" " + bina.apply("hello ", "world"));
    }

    public static void tranf() {
        List<Response> list = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            list.add(new Response("aa" + i, "AA" + i));
        }
        System.out.println(list);

        Function<List<Response>, List<ResponseVo>> fun = (reList -> {
            List<ResponseVo> vos = new ArrayList<>(reList.size());
            reList.forEach(r -> vos.add(new ResponseVo(r)));
            return vos;
        });
        System.out.println(fun.apply(list));


        Function<Response, ResponseVo> function = (re) -> {
            ResponseVo reVo = new ResponseVo();
            reVo.setKey(re.getKey());
            reVo.setValue(re.getValue());
            return reVo;
        };
        ResponseVo vo = function.apply(new Response("aaa", "AAA"));
        System.out.println(vo);
    }
}


class Response {

    private String key;
    private String value;

    public Response(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return this.getKey() + ":" + this.getValue();
    }
}

class ResponseVo {

    private String key;
    private String value;

    public ResponseVo(Response r) {
        setValue(r.getValue() + "vo");
        setKey(r.getKey() + "vo");
    }

    public ResponseVo() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return this.getKey() + ":" + this.getValue();
    }
}