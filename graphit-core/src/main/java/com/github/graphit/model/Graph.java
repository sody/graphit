package com.github.graphit.model;

import java.awt.geom.Dimension2D;
import java.util.Collection;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Graph {

	Collection<Node> getNodes();

	Collection<Edge> getEdges();


	Dimension2D getSize();

	void setSize(Dimension2D size);
}
