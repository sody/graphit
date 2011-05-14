package com.github.graphit.model;

import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class BoundedGraphImpl implements BoundedGraph {
	private final Graph graph;

	private Rectangle2D bounds;
	private Map<Node, Rectangle2D> nodeBounds = new HashMap<Node, Rectangle2D>();

	public BoundedGraphImpl(final Graph graph) {
		this.graph = graph;
	}

	@Override
	public Rectangle2D getBounds() {
		return bounds;
	}

	@Override
	public void setBounds(final Rectangle2D bounds) {
		this.bounds = bounds;
	}

	@Override
	public Rectangle2D getNodeBounds(final Node node) {
		return nodeBounds.get(node);
	}

	@Override
	public void setNodeBounds(final Node node, final Rectangle2D bounds) {
		nodeBounds.put(node, bounds);
	}

	@Override
	public Collection<Node> getNodes() {
		return graph.getNodes();
	}

	@Override
	public Collection<Edge> getEdges() {
		return graph.getEdges();
	}

	@Override
	public Collection<Edge> getIncomingEdges(final Node node) {
		return graph.getIncomingEdges(node);
	}

	@Override
	public Collection<Edge> getOutgoingEdges(final Node node) {
		return graph.getOutgoingEdges(node);
	}
}
