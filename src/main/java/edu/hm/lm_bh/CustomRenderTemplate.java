package edu.hm.lm_bh;

/**
 * Lab01 Software Architektur
 *
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public interface CustomRenderTemplate {
    String render(Object value) throws IllegalAccessException;
}
