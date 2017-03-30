package edu.hm.lm_bh;

import java.lang.reflect.Array;

/**
 * Lab01 Software Architektur
 *
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public class ArrayRenderer implements CustomRenderTemplate {

    public ArrayRenderer() {
    }

    public String render(Object value) throws IllegalAccessException {
        int length = Array.getLength(value);
        String output = "[";
        for (int i = 0; i < length; i++) {
            output += Array.get(value, i);
            if (i + 1 < length)
                output += ',';
        }
        output += ']';
        return output;
    }
}
