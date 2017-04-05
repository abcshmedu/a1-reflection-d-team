package edu.hm.lm_bh.Tests;

import edu.hm.lm_bh.RenderMe;
import edu.hm.lm_bh.Renderer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 05.04.2017.
 */
public class RendererExceptionTest {
    @Test(expected = RuntimeException.class, timeout = 300)
    public void testName() {
        Renderer r = new Renderer(new ClassEx(3));
        r.render();
    }

    private static class ClassEx
    {
        @RenderMe
        private int a;

        public ClassEx(int a) {
            this.a = a;
        }
    }
}