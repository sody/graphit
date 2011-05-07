package com.github.graphit;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class DummyLayout implements Layout {
	private static final String LAYOUT_ID = "dummy";

	public String getId() {
		return LAYOUT_ID;
	}

	public void renderGraph(final Renderer renderer, final Theme theme, final List<Node> nodes) {
		int nodeWidth = 100;
		int nodeHeight = 100;
		int currentX = 10, currentY = 10;
		for (Node node : nodes) {
			theme.renderNode(renderer, node, currentX, currentY, nodeWidth, nodeHeight);
			currentX += (nodeWidth + 10);
			currentY += (nodeHeight + 10);
		}
	}
}
