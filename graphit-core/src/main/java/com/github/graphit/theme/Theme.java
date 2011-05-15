package com.github.graphit.theme;

import com.github.graphit.model.Graph;
import com.github.graphit.render.Renderer;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Theme {

	void renderGraph(Graph graph, Renderer renderer);

}
