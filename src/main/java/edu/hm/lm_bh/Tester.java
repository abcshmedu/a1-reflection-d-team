package edu.hm.lm_bh;

import edu.hm.SomeClass;

/**
 * Small Testable main method.
 * Used for quick debugging.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public class Tester {
    /**
     * Private Constructor for Checkstyle.
     */
    private Tester(){}

    /**
     * Useless main method for quick testing.
     * @param args unused
     */
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(1);
        Renderer r = new Renderer(someClass);
        try {
            System.out.println(r.render());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
