package com.github.graphit.layout;

import com.github.graphit.model.Node;
import com.github.graphit.theme.Theme;
import com.github.graphit.render.Renderer;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class DummyLayout implements Layout {

	public void apply(final Renderer renderer, final Theme theme, final List<Node> nodes) {
		int nodeWidth = 100;
		int nodeHeight = 100;
		int currentX = 10, currentY = 10;
		for (Node node : nodes) {
			theme.renderNode(renderer, node, currentX, currentY, nodeWidth, nodeHeight);
			currentX += (nodeWidth + 10);
//			currentY += (nodeHeight + 10);
		}
	}
}
