package edu.hm.lm_bh;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Lukas on 29.03.2017.
 */
public class ArrayRenderer implements CustomRenderTemplate{

    public ArrayRenderer() {
    }

    public String render(Object value) throws IllegalAccessException {
        String output = "";
        for(int i= 0; i < Array.getLength(value); i++){
            System.out.println(Array.get(value,i));
            output += Array.get(value,i);
        }
        return output;
    }
}
