package com.github.graphit.render;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class RasterRendererSpi implements RendererSpi {
	private final Set<String> supportedTypes = new HashSet<String>();

	public RasterRendererSpi() {
		supportedTypes.add("png");
		supportedTypes.add("gif");
		supportedTypes.add("jpg");
		supportedTypes.add("bmp");
	}

	@Override
	public boolean supports(final String type) {
		return supportedTypes.contains(type);
	}

	@Override
	public Renderer create(final String type, final int width, final int height) {
		return new RasterRenderer(type, width, height);
	}
}
