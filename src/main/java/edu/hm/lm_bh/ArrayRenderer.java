package edu.hm.lm_bh;

import java.lang.reflect.Array;

/**
 * Custom Array Rendere Class.
 * Class to render Arrays with.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public class ArrayRenderer implements CustomRenderTemplate {

    /**
     * Default Constructor.
     */
    public ArrayRenderer() {
    }

    /**
     * Rendering method to create a String.
     * Goes through all values of primitive / non primitive arrays,
     * and displays them together in a single readable string.
     * @param value Object to be rendered
     * @return Object rendered to a string
     */
    public String render(Object value){
        int length = Array.getLength(value);
        String output = "[";
        for (int i = 0; i < length; i++) {
            output += Array.get(value, i);
            if (i + 1 < length) {
                output += ',';
            }
        }
        output += ']';
        return output;
    }
}
