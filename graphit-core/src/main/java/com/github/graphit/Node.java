package com.github.graphit;

import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Node {

	String getId();

	String getName();

	String getType();

	List<Edge> getEdges();
}
