package edu.hm.lm_bh.Tests;

import edu.hm.lm_bh.RenderMe;
import edu.hm.lm_bh.Renderer;
import org.junit.Test;

/**
 * Tests throwing expections for the Renderer class.
 * @author Lukas
 * @author Heunke Sebastian, heunke@hm.edu
 * @version 05.04.2017
 */
public class RendererExceptionTest {
    /**
     * Test checking for a exception thrown.
     */
    @Test(expected = RuntimeException.class, timeout = 300)
    public void nonExistingRenderer() {
        Renderer r = new Renderer(new ClassEx());
        r.render();
    }

    /**
     * Class used in test.
     */
    private static class ClassEx {
        @RenderMe(with = "no.renderer.here")
        private int a = 0;
    }
}