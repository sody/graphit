package com.github.graphit.render;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class SvgRendererSpi implements RendererSpi {
	@Override
	public boolean supports(final String type) {
		return "svg".equals(type);
	}

	@Override
	public Renderer create(final String type, final int width, final int height) {
		return new SvgRenderer(width, height);
	}
}
