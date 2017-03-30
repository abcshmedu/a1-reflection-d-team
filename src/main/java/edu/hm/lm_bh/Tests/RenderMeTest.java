package edu.hm.lm_bh.Tests;

import edu.hm.lm_bh.RenderMe;
import edu.hm.lm_bh.Renderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Lab01 Software Architektur
 *
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */


public class RenderMeTest {
    //Classes to be used in later Tests
    private class ClassA {
        @RenderMe
        int myNumber = 4;
    }

    private class ClassB {
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        int[] myArray = new int[]{0, 42, 0};
    }

    private class ClassC {
        @RenderMe
        int myNumber = 4;
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        int[] myArray = new int[]{42, 1, 2};
        @RenderMe
        String myString = "test String, pls ignore";
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        String[] myStrings = new String[]{"StringArray"};
    }

    @Test
    public void simpleIntOutputWorks() throws ClassNotFoundException, IllegalAccessException {
        Renderer sot = new Renderer(new ClassA());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassA:\n" +
                "myNumber (int): 4\n";
        assertEquals(expected, result);
    }

    @Test
    public void arrayOutputWorks() throws ClassNotFoundException, IllegalAccessException {
        Renderer sot = new Renderer(new ClassB());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassB:\n" +
                "myArray (class [I): [0,42,0]\n";
        assertEquals(expected,result);
    }

    @Test
    public void multipleElementsInClass() throws ClassNotFoundException, IllegalAccessException {
        Renderer sot = new Renderer(new ClassC());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassC:\n" +
                "myNumber (int): 4\n" +
                "myArray (class [I): [42,1,2]\n" +
                "myString (class java.lang.String): test String, pls ignore\n" +
                "myStrings (class [Ljava.lang.String;): [StringArray]\n";
        assertEquals(expected,result);

    }
}
