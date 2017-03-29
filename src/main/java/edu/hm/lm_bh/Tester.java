package edu.hm.lm_bh;

import edu.hm.SomeClass;
import edu.hm.lm_bh.Renderer;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lukas on 29.03.2017.
 */
public class Tester {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass(3);
        Renderer r = new Renderer(someClass);
        try {
            System.out.println(r.render());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
