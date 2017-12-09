package com.demo.dss;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest{

    @Test
    public void testSayHello() {
	HelloWorld impl = new HelloWorld();
	Assert.assertEquals(impl.sayHello(), "Hello Maven");
    }
}
    
