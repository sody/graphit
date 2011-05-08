package com.github.graphit.theme;

import com.github.graphit.model.Edge;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class DummyTheme implements Theme {

	public void renderNode(final Renderer renderer, final Node node, final int x, final int y, final int width, final int height) {
		renderer.rectangle(x, y, width, height);
	}

	public void renderEdge(final Renderer renderer, final Edge edge, final int x1, final int y1, final int x2, final int y2) {
		renderer.line(x1, y1, x2, y2);
	}
}
