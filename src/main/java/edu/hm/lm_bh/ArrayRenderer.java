package edu.hm.lm_bh;
import java.util.Arrays;

/**
 * Created by Lukas on 29.03.2017.
 */
public class ArrayRenderer implements CustomRenderTemplate<int[]>{
    public ArrayRenderer() {
    }

    public String render(int[] value) throws IllegalAccessException {
        return Arrays.toString(value);
    }
}
