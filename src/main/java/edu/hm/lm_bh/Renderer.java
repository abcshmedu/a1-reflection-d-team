package edu.hm.lm_bh;

import edu.hm.lm_bh.RenderMe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lukas on 29.03.2017.
 */
public class Renderer{
    private final Object target;

    public Renderer(Object target) {
        this.target = target;
    }

    public String render() throws IllegalAccessException {
        Class targetClass = target.getClass();
        String output = new String("Instance of " + targetClass.getCanonicalName()+ ":\r\n");
        for (Field field: targetClass.getDeclaredFields()) {
            if (field.getAnnotation(RenderMe.class) != null)
            {
                String withParam = field.getAnnotation(RenderMe.class).with();
                if (withParam != "")

                field.setAccessible(true);
                Object o = field.get(target);
                output += field.getName()+ " (" + field.getType().toString() + "): " + o.toString() + "\r\n";
            }
        }
        return output;
    }
}
