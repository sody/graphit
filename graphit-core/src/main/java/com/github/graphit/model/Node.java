package com.github.graphit.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Collection;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Node {

	String getId();

	String getType();

	String getName();

	Collection<Edge> getIncomingEdges();

	Collection<Edge> getOutgoingEdges();


	Point2D getPosition();

	void setPosition(Point2D position);

	Dimension2D getSize();

	void setSize(Dimension2D size);
}
