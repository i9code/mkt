package com.code.base.oop.generics

// 泛型定义
class D01Generics<T> (var value :T){
}

fun main(args: Array<String>) {
    var i = D01Generics<Int>(10)
    var str = D01Generics<String>("string")

    println(i.value)
    println(str.value)
}


// 协变（covariant）与逆变（controvariant）

/**
 * 关于协变与逆变的概念及来源

    List<Object>
    List<String>

    List<String> list = new ArrayList();
    List<Object> list2 = list; // 编译失败

    list2.add(new Date())

    String str = list.get(0);

    List<? extends Object> list ...


    interface Collection<E> {
    void addAll(Collection<E> items);
    }

    void copyAll(Collection<Object> to, Collection<String> from) {
    to.addAll(from);
    }

    interface Collection<E> {
    void addAll(Collection<? extends E> items);
    }

    Collection<String>就是Collection<? extends Object>的子类型。

    List<? super String>

    我们如果只从中读取数据，而不往里面写入内容，那么这样的对象叫做生产者；如果只向里面写入数据，而不从中读取数据，那么这样的数据叫做消费者。

    生产者使用? extends E； 消费者使用? super E

 */

class MyClass<out T, in M>(t: T, m: M) {

    private var t: T

    private var m: M

    init {
        this.t = t
        this.m = m
    }

    fun get(): T = this.t

    fun set(m: M) {
        this.m = m
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    var myObject: MyClass<Any, Int> = myClass

    println(myObject.get())
}