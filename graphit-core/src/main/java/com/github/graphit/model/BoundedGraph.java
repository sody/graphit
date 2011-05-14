package com.github.graphit.model;

import java.awt.geom.Rectangle2D;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface BoundedGraph extends Graph {

	Rectangle2D getBounds();

	void setBounds(Rectangle2D bounds);

	Rectangle2D getNodeBounds(Node node);

	void setNodeBounds(Node node, Rectangle2D bounds);
}
