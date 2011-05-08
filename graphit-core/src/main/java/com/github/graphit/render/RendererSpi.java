package com.github.graphit.render;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface RendererSpi {

	boolean supports(String type);

	Renderer create(String type, int width, int height);
}
