package com.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static xfnt.LoggerFactory.debug;
import static xfnt.LoggerFactory.step;

public class MathClassTest extends TestBase {
    private MathClass mathClass;
    private int a = 20;
    private int b = 10;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        mathClass = new MathClass();
    }

    @Test
    public void testAdd() {
        step("Testing add");
        int result = mathClass.add(a, b);
        assertEquals(30, result);
        debug("Something went wrong");
    }
}
