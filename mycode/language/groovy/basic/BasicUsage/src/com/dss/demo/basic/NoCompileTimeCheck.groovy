package com.dss.demo.basic
import groovy.transform.

/**
 * Created by lili on 15-10-17.
 */
class NoCompileTimeCheck {

    @groovy.transform.TypeChecked
    def shout(String str) {
        println("Printing in uppercase");
        println(str.toUppercase());
    }

    public static void main(String[] args) {
        try {
            shout("hello");
        } catch (ex) {
            println("Failed...")
        }
    }
}
