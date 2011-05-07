package com.github.graphit;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface Layout {

	String getId();

	void renderGraph(Renderer renderer, Theme theme, List<Node> nodes);
}
