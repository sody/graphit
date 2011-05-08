package com.github.graphit.render;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Renderer {

	Renderer line(int x1, int y1, int x2, int y2);

	Renderer rectangle(int x, int y, int width, int height);

	void render(OutputStream stream) throws IOException;
}
