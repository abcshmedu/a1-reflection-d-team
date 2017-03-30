package edu.hm.lm_bh;

/**
 * Custom rendering Template.
 * Allows to customize rendering, if not used default
 * toString is used.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public interface CustomRenderTemplate {
    /**
     * Custom rendering method.
     * @param value Object to be rendered
     * @return rendered String
     * @throws IllegalAccessException when field access failed
     */
    String render(Object value) throws IllegalAccessException;
}
