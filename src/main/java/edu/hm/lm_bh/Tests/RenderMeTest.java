package edu.hm.lm_bh.Tests;

import edu.hm.lm_bh.RenderMe;
import edu.hm.lm_bh.Renderer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

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

    /**
     * Test class with one int.
     */
    private class ClassA {
        @RenderMe
        private final int myNumber = 4;
    }

    /**
     * Test class with one array.
     */
    private class ClassB {
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private final int[] myArray = new int[]{0, 42, 0};
    }

    /**
     * Test class with multiple Elements.
     */
    private class ClassC {
        @RenderMe
        private final int myNumber = 4;
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private final int[] myArray = new int[]{42, 1, 2};
        @RenderMe
        private final String myString = "test String, pls ignore";
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private final String[] myStrings = new String[]{"StringArray"};
    }

    /**
     * Test class with a single method.
     */
    private class ClassD {
        @RenderMe
        public int aMethod(){return 42;}
    }

    /**
     * Test class with a multiple methods.
     */
    private class ClassE {
        @RenderMe
        private String aMethod(){return "Hello there!";}
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private int[] arrayMethod(){return new int[]{42,42,42,42};}
    }
    /**
     * Simple int output.
     * @throws ClassNotFoundException fails test
     * @throws IllegalAccessException fails test
     */
    @Test
    public void simpleIntOutputWorks() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        Renderer sot = new Renderer(new ClassA());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassA:\n"
                + "myNumber (int): 4\n";
        assertEquals(expected, result);
    }

    /**
     * Tests displaying of a int array.
     * @throws ClassNotFoundException fails test
     * @throws IllegalAccessException fails test
     */
    @Test
    public void arrayOutputWorks() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        Renderer sot = new Renderer(new ClassB());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassB:\n"
                + "myArray (class [I): [0,42,0]\n";
        assertEquals(expected, result);
    }

    /**
     * Tests displaying of multiple elements from one class.
     * @throws ClassNotFoundException fails test
     * @throws IllegalAccessException fails test
     */
    @Test
    public void multipleElementsInClass() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        Renderer sot = new Renderer(new ClassC());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassC:\n"
                + "myNumber (int): 4\n"
                + "myArray (class [I): [42,1,2]\n"
                + "myString (class java.lang.String): test String, pls ignore\n"
                + "myStrings (class [Ljava.lang.String;): [StringArray]\n";
        assertEquals(expected, result);

    }

    /**
     * Tests rendering of methods.
     * @throws IllegalAccessException fails test
     * @throws InvocationTargetException fails test
     * @throws ClassNotFoundException fails test
     */
    @Test
    public void methodGetsRendered() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Renderer sot = new Renderer(new ClassD());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassD:\n"
                + "aMethod (int): 42\n";

        assertEquals(expected,result);
    }

    /**
     * Tests rendering of multiple methods.
     * @throws IllegalAccessException fails test
     * @throws InvocationTargetException fails test
     * @throws ClassNotFoundException fails test
     */
    @Test
    public void multipleMethodGetsRendered() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Renderer sot = new Renderer(new ClassE());
        String result = sot.render();
        String expected = "Instance of edu.hm.lm_bh.Tests.RenderMeTest.ClassE:\n"
                + "aMethod (class java.lang.String): Hello there!\n"
                + "arrayMethod (class [I): [42,42,42,42]\n";

        assertEquals(expected,result);
    }
}
