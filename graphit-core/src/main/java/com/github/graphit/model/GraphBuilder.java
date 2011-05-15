package com.github.graphit.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class GraphBuilder {
	private final Map<String, Node> nodes = new HashMap<String, Node>();

	public GraphBuilder addNode(final String id) {
		return addNode(new NodeImpl(id, null, id));
	}

	public GraphBuilder addNode(final String id, final String type) {
		return addNode(new NodeImpl(id, type, id));
	}

	public GraphBuilder addNode(final Node node) {
		validateNode(node);

		nodes.put(node.getName(), node);
		return this;
	}

	public GraphBuilder addNode(final String id, final Node node) {
		assert id != null;
		validateNode(node);

		nodes.put(id, node);
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
		return addEdge(new EdgeImpl(source, target, type, null));
	}

	public GraphBuilder addEdge(final String type, final Node source, final Node target) {
		return addEdge(new EdgeImpl(source, target, type, null));
	}

	public GraphBuilder addEdge(final Edge edge) {
		validateEdge(edge);

		if (!edge.getSource().getOutgoingEdges().contains(edge)) {
			((NodeImpl) edge.getSource()).addOutgoingEdge(edge); //todo: class cast exception
		}
		if (!edge.getTarget().getIncomingEdges().contains(edge)) {
			((NodeImpl) edge.getTarget()).addIncomingEdge(edge); //todo: class cast exception
		}
		return this;
	}

	public GraphBuilder addGraph(final Graph graph) {
		validateGraph(graph);

		for (Node node : graph.getNodes()) {
			addNode(node);
		}

		for (Edge edge : graph.getEdges()) {
			addEdge(edge);
		}
		return this;
	}

	public Graph build() {
		return new GraphImpl(nodes.values());
	}

	private void validateGraph(final Graph graph) {
		assert graph != null;
		assert graph.getNodes() != null;
		assert graph.getEdges() != null;
	}

	private void validateNode(final Node node) {
		assert node != null;
		assert node.getName() != null;
		assert node.getIncomingEdges() != null;
		assert node.getOutgoingEdges() != null;
		assert !nodes.containsKey(node.getName());
		assert !nodes.containsValue(node);
	}

	private void validateEdge(final Edge edge) {
		assert edge != null;
		assert edge.getSource() != null;
		assert edge.getTarget() != null;
		assert nodes.containsValue(edge.getSource());
		assert nodes.containsValue(edge.getTarget());
	}
}
