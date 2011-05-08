package com.github.graphit.theme;

import com.github.graphit.model.Edge;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Theme {

	void renderNode(Renderer renderer, Node node, int x, int y, int width, int height);

	void renderEdge(Renderer renderer, Edge edge, int x1, int y1, int x2, int y2);
}
