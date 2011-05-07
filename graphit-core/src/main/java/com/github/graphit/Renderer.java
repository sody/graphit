package com.github.graphit;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface Renderer {

	Renderer line(int x1, int y1, int x2, int y2);

	Renderer rectangle(int x, int y, int width, int height);

	void write(OutputStream stream) throws IOException;
}
