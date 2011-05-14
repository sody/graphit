package com.github.graphit.layout;

import com.github.graphit.model.BoundedGraph;
import com.github.graphit.model.Graph;
import com.github.graphit.model.Node;
import com.github.graphit.theme.Theme;
import com.github.graphit.render.Renderer;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Layout {

	BoundedGraph apply(Graph graph);
}
