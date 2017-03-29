package edu.hm.lm_bh;

/**
 * Created by Lukas on 29.03.2017.
 */
public interface CustomRenderTemplate<T> {
    String render(T value) throws IllegalAccessException;
}
