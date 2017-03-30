package edu.hm.lm_bh;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Lab01 Software Architektur
 * @version 29.03.2017
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 */

public class Renderer{
    private final Object target;

    public Renderer(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public String render() throws IllegalAccessException, ClassNotFoundException{
        Class targetClass = target.getClass();
        String output = "Instance of " + targetClass.getCanonicalName()+ ":\n"; //First line

        for (Field field: targetClass.getDeclaredFields()) {
            String innerOutput = "";

            if (field.getAnnotation(RenderMe.class) != null)
            {
                field.setAccessible(true);
                String withParam = field.getAnnotation(RenderMe.class).with();
                if (!withParam.equals("")) {
                    Class varRenderer = Class.forName(withParam);
                    Class implementedClass = varRenderer.getInterfaces()[0];
                    if (implementedClass == CustomRenderTemplate.class)
                    {
                        try {
                               Object innerTarget = varRenderer.getConstructor().newInstance();
                               Object o = field.get(target);
                               Method methode = varRenderer.getMethod("render",Object.class);
                                innerOutput = (String)methode.invoke(innerTarget,field.get(target));

                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Object o = field.get(target);
                innerOutput = innerOutput.equals("") ? o.toString() : innerOutput;
                output += field.getName()+ " (" + field.getGenericType().toString() + "): " + innerOutput + "\n";
            }
        }
        return output;
    }
}
