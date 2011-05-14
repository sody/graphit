package com.github.graphit.model;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class EdgeImpl implements Edge {
	private final String name;
	private final String type;

	protected EdgeImpl(final String type, final String name) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}
}
