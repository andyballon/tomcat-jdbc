package org.openshift.quickstarts.tomcat.test;

import org.junit.Test;
import org.openshift.quickstarts.tomcat.model.MyUnit;

import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }
}