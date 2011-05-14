package com.github.graphit.theme;

import com.github.graphit.model.BoundedGraph;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;

import java.awt.geom.Rectangle2D;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class DummyTheme implements Theme {

	@Override
	public void renderGraph(final BoundedGraph graph, final Renderer renderer) {
		for (Node node : graph.getNodes()) {
			final Rectangle2D bounds = graph.getNodeBounds(node);
			renderer.rectangle((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
		}
	}
}
