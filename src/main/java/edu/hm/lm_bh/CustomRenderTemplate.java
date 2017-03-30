package edu.hm.lm_bh;

/**
 * Lab01 Software Architektur
 * @version 29.03.2017
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 */
public interface CustomRenderTemplate{
    String render(Object value) throws IllegalAccessException;
}
