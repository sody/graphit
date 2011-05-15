package com.github.graphit.model;

import java.awt.geom.Dimension2D;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class GraphImpl implements Graph {
	private final Collection<Node> nodes;
	private final Collection<Edge> edges;

	private Dimension2D size;

	public GraphImpl(final Collection<Node> nodes) {
		this.nodes = nodes;

		edges = new HashSet<Edge>();
		for (Node node : nodes) {
			edges.addAll(node.getOutgoingEdges());
		}
	}

	@Override
	public Collection<Node> getNodes() {
		return nodes;
	}

	@Override
	public Collection<Edge> getEdges() {
		return edges;
	}

	@Override
	public Dimension2D getSize() {
		return size;
	}

	@Override
	public void setSize(final Dimension2D size) {
		this.size = size;
	}
}
