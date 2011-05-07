package com.github.graphit;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface Theme {

	String getId();

	void renderNode(Renderer renderer, Node node, int x, int y, int width, int height);

	void renderEdge(Renderer renderer, Edge edge, int x1, int y1, int x2, int y2);
}
