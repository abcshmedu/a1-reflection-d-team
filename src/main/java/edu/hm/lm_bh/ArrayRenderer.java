package edu.hm.lm_bh;

import java.lang.reflect.Field;

/**
 * Created by Lukas on 29.03.2017.
 */
public class ArrayRenderer{
    public ArrayRenderer() {
    }

    String render(Object target) throws IllegalAccessException {
        Class targetClass = target.getClass();
        String output = new String("Instance of " + targetClass.getCanonicalName()+ ":\r\n");

        return output;
    }
}
