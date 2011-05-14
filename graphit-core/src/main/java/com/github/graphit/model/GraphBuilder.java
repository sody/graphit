package com.github.graphit.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphBuilder {
	private final Map<String, Node> nodes = new HashMap<String, Node>();
	private final Map<Node, Collection<Edge>> incomingEdges = new HashMap<Node, Collection<Edge>>();
	private final Map<Node, Collection<Edge>> outgoingEdges = new HashMap<Node, Collection<Edge>>();

	public GraphBuilder addNode(final String id) {
		return addNode(id, null);
	}

	public GraphBuilder addNode(final String id, final String type) {
		assert id != null;

		return addNode(new NodeImpl(id, type, null));
	}

	public GraphBuilder addNode(final Node node) {
		assert node != null;

		nodes.put(node.getId(), node);
		incomingEdges.put(node, new HashSet<Edge>());
		outgoingEdges.put(node, new HashSet<Edge>());
		return this;
	}

	public GraphBuilder addEdge(final String sourceId, final String targetId) {
		return addEdge(null, sourceId, targetId);
	}

	public GraphBuilder addEdge(final String type, final String sourceId, final String targetId) {
		assert sourceId != null;
		assert targetId != null;

		final Node source = nodes.get(sourceId);
		final Node target = nodes.get(targetId);
		return addEdge(new EdgeImpl(type, null), source, target);
	}

	public GraphBuilder addEdge(final Edge edge, final Node source, final Node target) {
		assert edge != null;
		assert source != null && outgoingEdges.containsKey(source);
		assert target != null && incomingEdges.containsKey(target);

		incomingEdges.get(target).add(edge);
		outgoingEdges.get(source).add(edge);
		return this;
	}

	public GraphBuilder addGraph(final Graph graph) {
		assert graph != null;

		for (Node node : graph.getNodes()) {
			final Collection<Edge> incoming = new HashSet<Edge>();
			final Collection<Edge> outgoing = new HashSet<Edge>();
			incoming.addAll(graph.getIncomingEdges(node));
			outgoing.addAll(graph.getOutgoingEdges(node));

			nodes.put(node.getId(), node);
			incomingEdges.put(node, incoming);
			outgoingEdges.put(node, outgoing);
		}
		return this;
	}


	public Graph build() {
		return new GraphImpl(incomingEdges, outgoingEdges);
	}
}
