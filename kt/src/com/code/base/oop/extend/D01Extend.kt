package com.code.base.oop.extend

fun main(args: Array<String>) {
    var b = D01Extend("abc")
    b.print()

    // 成员方法优先于扩展方法调用
    b.doPrint()

    EE().test()
}

class D01Extend {
    var name : String = ""

    constructor(name: String) {
        this.name = name
    }

    fun doPrint(){
        println("inner")
    }
}

fun D01Extend.print(){
    println("$name")
}

fun D01Extend.doPrint(){
    println("extend")
}

// 扩展的作用域
/*
    1. 扩展函数所定义在的类实例叫做分发接收者（dispatch receiver）
    2. 扩展函数所扩展的那个类的实例叫做扩展接收者（extension receiver）
    3. 当以上两个名字出现冲突时，扩展接收者的优先级最高
 */

class DD {
    fun method() {
        println("DD method")
    }
}

class EE {
    fun method2() {

    }

    fun DD.hello() {
        method()
        method2()
    }

    fun world(dd: DD) {
        dd.hello()
    }

    fun DD.output() {
        println(toString())
        println(this@EE.toString())
    }

    fun test() {
        var dd = DD()
        dd.output()
    }
}


// 扩展可以很好地解决Java中充斥的各种辅助类问题。
// Collections.swap(list, 4, 10)
// list.swap(4, 10)
// Collection.binarySearch()
// list.binarySearch(...)
