package edu.hm.lm_bh;

import edu.hm.lm_bh.RenderMe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Lukas on 29.03.2017.
 */
public class Renderer{
    private final Object target;

    public Renderer(Object target) {
        this.target = target;
    }

    public String render() throws IllegalAccessException, ClassNotFoundException{
        Class targetClass = target.getClass();
        String output = new String("Instance of " + targetClass.getCanonicalName()+ ":\r\n");
        String inneroutput = new String();

        for (Field field: targetClass.getDeclaredFields()) {
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
                                inneroutput = (String)methode.invoke(innerTarget,field.get(target));

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
                String value = !inneroutput.equals("") ? o.toString() : inneroutput;
                output += field.getName()+ " (" + field.getGenericType().toString() + "): " + inneroutput + "\r\n";
            }
        }
        return output;
    }
}
