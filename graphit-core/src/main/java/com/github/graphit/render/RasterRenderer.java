package com.github.graphit.render;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class RasterRenderer implements Renderer {
	private final BufferedImage image;
	private final String format;

	public RasterRenderer(final String format, final int width, final int height) {
		this.format = format;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public Renderer line(final int x1, final int y1, final int x2, final int y2) {
		image.getGraphics().drawLine(x1, y1, x2, y2);
		return this;
	}

	@Override
	public Renderer rectangle(final int x, final int y, final int width, final int height) {
		image.getGraphics().drawRect(x, y, width, height);
		return this;
	}

	@Override
	public void render(final OutputStream stream) throws IOException {
		ImageIO.write(image, format, stream);
		stream.flush();
	}
}
