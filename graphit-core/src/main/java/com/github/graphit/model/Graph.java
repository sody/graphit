package com.github.graphit.model;

import java.util.Collection;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface Graph {

	Collection<Node> getNodes();

	Collection<Edge> getEdges();

	Collection<Edge> getIncomingEdges(Node node);

	Collection<Edge> getOutgoingEdges(Node node);
}
