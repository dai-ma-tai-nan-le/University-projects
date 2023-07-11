package com.ljp.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class Md5UtilsTest {

    @Test
    public void md5() {
        String s=Md5Utils.md5("1234566");
        System.out.println(s);
    }
}