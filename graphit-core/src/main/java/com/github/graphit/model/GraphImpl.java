package com.github.graphit.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphImpl implements Graph {
	private final Collection<Node> nodes;
	private final Collection<Edge> edges;
	private final Map<Node, Collection<Edge>> incomingEdges;
	private final Map<Node, Collection<Edge>> outgoingEdges;


	protected GraphImpl(final Map<Node, Collection<Edge>> incomingEdges,
						final Map<Node, Collection<Edge>> outgoingEdges) {
		this.incomingEdges = incomingEdges;
		this.outgoingEdges = outgoingEdges;

		this.nodes = new ArrayList<Node>(incomingEdges.keySet());
		this.edges = new ArrayList<Edge>();
		for (Collection<Edge> nodeEdges : incomingEdges.values()) {
			edges.addAll(nodeEdges);
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
	public Collection<Edge> getIncomingEdges(final Node node) {
		return incomingEdges.get(node);
	}

	@Override
	public Collection<Edge> getOutgoingEdges(final Node node) {
		return outgoingEdges.get(node);
	}
}
