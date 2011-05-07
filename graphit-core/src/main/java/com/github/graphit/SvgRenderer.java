package com.github.graphit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class SvgRenderer implements Renderer {
	private final StringBuilder builder = new StringBuilder();

	public SvgRenderer() {
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\"").append('\n')
				.append('\t').append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"").append("\n")
				.append('\t').append("xsi:schemaLocation=\"http://www.w3.org/2000/svg http://www.w3.org/TR/2002/WD-SVG11-20020108/SVG.xsd\">");
	}

	public Renderer line(final int x1, final int y1, final int x2, final int y2) {
		builder.append("<line")
				.append(" x1=\"").append(x1).append("\"")
				.append(" y1=\"").append(y1).append("\"")
				.append(" x2=\"").append(x2).append("\"")
				.append(" y2=\"").append(y2).append("\"")
				.append("/>");
		return this;
	}

	public Renderer rectangle(final int x, final int y, final int width, final int height) {
		builder.append("<rect")
				.append(" x=\"").append(x).append("\"")
				.append(" y=\"").append(y).append("\"")
				.append(" width=\"").append(width).append("\"")
				.append(" height=\"").append(height).append("\"")
				.append("/>");
		return this;
	}

	@Override
	public void write(final OutputStream stream) throws IOException {
		builder.append("</svg>");
		final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
		writer.append(builder.toString());
		writer.flush();
	}
}
