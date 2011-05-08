package com.github.graphit.layout;

import com.github.graphit.model.Node;
import com.github.graphit.theme.Theme;
import com.github.graphit.render.Renderer;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface Layout {

	void apply(Renderer renderer, Theme theme, List<Node> nodes);
}
