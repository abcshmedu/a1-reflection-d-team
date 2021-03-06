package edu.hm.lm_bh;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Renderer class to wrap Object in.
 * Wraps a Object and give the ability to render it
 * into a user readable string.
 *
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 29.03.2017
 */
public class Renderer {
    private final Object target;

    /**
     * Constructor to assign target.
     *
     * @param target target to be rendered later
     */
    public Renderer(Object target) {
        this.target = target;
    }

    /**
     * Render method to display target.
     * Uses the target and creates a readable string output.
     *
     * @return readable string
     * @throws IllegalAccessException Access denied
     * @throws ClassNotFoundException non valid class
     */
    @SuppressWarnings("unchecked")
    public String render() {
        String output;
        try {
            Class targetClass = target.getClass();
            output = "Instance of " + targetClass.getCanonicalName() + ":\n"; //First line
            output += renderFields();
            output += renderMethods();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }

        return output;
    }

    /**
     * Renders all annotated fields of the target into a String.
     *
     * @return rendered readable String.
     * @throws Exception When custom rendereer is not found
     */
    private String renderFields() throws Exception {
        String result = "";
        for (Field field : target.getClass().getDeclaredFields()) {
            String innerOutput = ""; //Reset innerOutput
            if (field.getAnnotation(RenderMe.class) != null) {
                field.setAccessible(true); //disable private
                String withParam = field.getAnnotation(RenderMe.class).with();
                if (!withParam.equals("")) {
                    //Custom Rendering
                    Class varRenderer = Class.forName(withParam);
                    Class implementedClass = varRenderer.getInterfaces()[0];
                    if (implementedClass == CustomRenderTemplate.class) {

                        Object innerTarget = varRenderer.getConstructor().newInstance();
                        Method methode = varRenderer.getMethod("render", Object.class);
                        innerOutput = (String) methode.invoke(innerTarget, field.get(target));
                    }
                }
                Object o = field.get(target);
                innerOutput = innerOutput.equals("") ? o.toString() : innerOutput;
                result += field.getName() + " (" + field.getGenericType().toString() + "): " + innerOutput + "\n";
            }
        }
        return result;
    }

    /**
     * Renders all annotated methods of the target into a String.
     *
     * @return rendered readable String.
     * @throws Exception When custom rendereer is not found
     */
    private String renderMethods() throws Exception {
        String resultString = "";
        for (Method method : target.getClass().getDeclaredMethods()) {
            String innerOutput = "";
            if (method.getAnnotation(RenderMe.class) != null && !method.getReturnType().equals(Void.TYPE) && method.getGenericParameterTypes().length == 0) {
                method.setAccessible(true);
                String withParam = method.getAnnotation(RenderMe.class).with();
                Object result = method.invoke(target);
                if (!withParam.equals("")) {
                    //Custom Rendering
                    Class varRenderer = Class.forName(withParam);
                    Class implementedClass = varRenderer.getInterfaces()[0];
                    if (implementedClass == CustomRenderTemplate.class) {

                        Object innerTarget = varRenderer.getConstructor().newInstance();
                        Method methode = varRenderer.getMethod("render", Object.class);
                        innerOutput = (String) methode.invoke(innerTarget, result);
                    }
                }
                innerOutput = innerOutput.equals("") ? result.toString() : innerOutput;
                resultString += method.getName() + " (" + method.getReturnType().toString() + "): " + innerOutput + "\n";
            }
        }
        return resultString;
    }
}
