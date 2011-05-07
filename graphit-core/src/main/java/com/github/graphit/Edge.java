package com.github.graphit;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface Edge {

	String getName();

	String getType();

	Node getSource();

	Node getTarget();
}
