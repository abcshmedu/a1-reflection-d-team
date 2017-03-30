package edu.hm.lm_bh;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RenderMe Annotation.
 * Indicates that a field or method is intended to be displayed.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {

    /**
     * Holds a value for custom renders.
     * @return custom renderer used
     */
    String with() default "";
}