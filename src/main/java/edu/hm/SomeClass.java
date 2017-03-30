package edu.hm;

import edu.hm.lm_bh.RenderMe;

import java.util.Date;

/**
 * Dummy class for quick Testing.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */

public class SomeClass {

    @RenderMe
    private int foo;
    @RenderMe
    private Date date = new Date(123456789);
    @RenderMe(with = "edu.hm.lm_bh.ArrayRenderer")
    int[] array = {1, 2, 3};


    public SomeClass(int foo) {
        this.foo = foo;
    }
}
