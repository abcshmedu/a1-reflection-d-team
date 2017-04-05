package edu.hm.lm_bh.Tests;

import edu.hm.lm_bh.RenderMe;
import edu.hm.lm_bh.Renderer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


/**
 * Tests for the Renderer class.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 05.04.2017
 */
@RunWith(Parameterized.class)
public class RendererTest {

    /**
     * Collection of test inputs and results.
     * Arrays containing the input parameters and the result expected.
     * @return collection filled with arrays usable for tests
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{new ClassA(), "Instance of edu.hm.lm_bh.Tests.RendererTest.ClassA:\n"
                + "myNumber (int): 4\n"}, {new ClassB(), "Instance of edu.hm.lm_bh.Tests.RendererTest.ClassB:\n"
                + "myArray (class [I): [0,42,0]\n"}, {new ClassC(), "Instance of edu.hm.lm_bh.Tests.RendererTest.ClassC:\n"
                + "myNumber (int): 4\n"
                + "myArray (class [I): [42,1,2]\n"
                + "myString (class java.lang.String): test String, pls ignore\n"
                + "myStrings (class [Ljava.lang.String;): [StringArray]\n"}, {new ClassD(), "Instance of edu.hm.lm_bh.Tests.RendererTest.ClassD:\n"
                + "aMethod (int): 42\n"}, {new ClassE(), "Instance of edu.hm.lm_bh.Tests.RendererTest.ClassE:\n"
                + "arrayMethod (class [I): [42,42,42,42]\n"
                + "aMethod (class java.lang.String): Hello there!\n"}});

    }

    private Renderer input;
    private String output;

    /**
     * Constructor used to intialize the variables.
     * @param input Object used in the test
     * @param output expected result
     */
    public RendererTest(Object input, String output) {
        this.input = new Renderer(input);
        this.output = output;
    }

    /**
     * Renderer testing method.
     * Takes the input and expected arrays and compares them.
     */
    @Test
    public void test() {
        assertEquals(input.render(), output);
    }

    //Classes to be used in later Tests

    /**
     * Test class with one int.
     */
    private static class ClassA {
        @RenderMe
        private final int myNumber = 4;
    }

    /**
     * Test class with one array.
     */
    private static class ClassB {
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private final int[] myArray = new int[]{0, 42, 0};
    }

    /**
     * Test class with multiple Elements.
     */
    private static class ClassC {
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
    private static class ClassD {
        private static final int NUM = 42;

        /**
         * Test method.
         * @return a int
         */
        @RenderMe
        public int aMethod() {
            return NUM;
        }
    }

    /**
     * Test class with a multiple methods.
     */
    private static class ClassE {
        private static final int NUM = 42;

        /**
         * Test method.
         * @return a String
         */
        @RenderMe
        private String aMethod() {
            return "Hello there!";
        }

        /**
         * Method used for testing.
         * @return some Array
         */
        @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
        private int[] arrayMethod() {
            return new int[]{NUM, NUM, NUM, NUM};
        }
    }
}