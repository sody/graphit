package com.github.graphit.theme;

import com.github.graphit.model.BoundedGraph;
import com.github.graphit.model.Edge;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Theme {

	void renderGraph(BoundedGraph graph, Renderer renderer);

}
