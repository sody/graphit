package com.github.graphit.theme;

import com.github.graphit.model.Graph;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class DummyTheme implements Theme {

	@Override
	public void renderGraph(final Graph graph, final Renderer renderer) {
		for (Node node : graph.getNodes()) {
			final Point2D position = node.getPosition();
			final Dimension2D size = node.getSize();
			renderer.rectangle((int) position.getX(), (int) position.getY(), (int) size.getWidth(), (int) size.getHeight());
		}
	}
}
