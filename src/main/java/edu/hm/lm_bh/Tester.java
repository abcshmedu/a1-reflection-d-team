package edu.hm.lm_bh;

import edu.hm.SomeClass;

/**
 * Lab01 Software Architektur
 *
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public class Tester {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(3);
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
