package com.github.graphit.model;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class NodeImpl implements Node {
	private final String id;
	private final String type;
	private final String name;

	protected NodeImpl(final String id, final String type, final String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}
}
