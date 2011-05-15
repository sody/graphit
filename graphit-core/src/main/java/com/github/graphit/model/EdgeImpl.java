package com.github.graphit.model;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class EdgeImpl implements Edge {
	private final Node source;
	private final Node target;
	private final String name;
	private final String type;

	protected EdgeImpl(final Node source, final Node target, final String type, final String name) {
		this.source = source;
		this.target = target;
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

	@Override
	public Node getSource() {
		return source;
	}

	@Override
	public Node getTarget() {
		return target;
	}
}
