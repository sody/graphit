package com.github.graphit.render;

import com.github.graphit.Locker;

import java.io.*;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class SvgRenderer implements Renderer {
	private final StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
	private final Locker locker = new Locker();

	public SvgRenderer(final int width, final int height) {
		builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\"").append('\n')
				.append('\t').append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"").append("\n")
				.append('\t').append("xsi:schemaLocation=\"http://www.w3.org/2000/svg http://www.w3.org/TR/2002/WD-SVG11-20020108/SVG.xsd\">");
	}

	@Override
	public Renderer line(final int x1, final int y1, final int x2, final int y2) {
		locker.check();
		builder.append("<line")
				.append(" x1=\"").append(x1).append("\"")
				.append(" y1=\"").append(y1).append("\"")
				.append(" x2=\"").append(x2).append("\"")
				.append(" y2=\"").append(y2).append("\"")
				.append("/>");
		return this;
	}

	@Override
	public Renderer rectangle(final int x, final int y, final int width, final int height) {
		locker.check();
		builder.append("<rect")
				.append(" x=\"").append(x).append("\"")
				.append(" y=\"").append(y).append("\"")
				.append(" width=\"").append(width).append("\"")
				.append(" height=\"").append(height).append("\"")
				.append("/>");
		return this;
	}

	@Override
	public void render(final OutputStream stream) throws IOException {
		final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
		render(writer);
	}

	private void render(final Writer writer) throws IOException {
		locker.lock();
		writer.append(builder.append("</svg>").toString());
		writer.flush();
	}
}
