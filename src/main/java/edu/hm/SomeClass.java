package edu.hm;

import edu.hm.lm_bh.RenderMe;

import java.util.Date;

/**
 * Created by Lukas on 29.03.2017.
 */
public class SomeClass {

    @RenderMe
    private int foo;
    @RenderMe
    private Date date = new Date(123456789);
    @RenderMe(with="edu.hm.lm_bh.ArrayRenderer")
    int[] array = {1, 2, 3};


    public SomeClass(int foo) {
        this.foo = foo;
    }
}
