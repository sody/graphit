package com.github.graphit.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class NodeImpl implements Node {
	private final String id;
	private final String type;
	private final String name;

	private final Collection<Edge> incomingEdges = new HashSet<Edge>();
	private final Collection<Edge> outgoingEdges = new HashSet<Edge>();

	private Point2D position;
	private Dimension2D size;

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
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<Edge> getIncomingEdges() {
		return incomingEdges;
	}

	@Override
	public Collection<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public void setPosition(final Point2D position) {
		this.position = position;
	}

	@Override
	public Dimension2D getSize() {
		return size;
	}

	@Override
	public void setSize(final Dimension2D size) {
		this.size = size;
	}

	protected void addIncomingEdge(final Edge edge) {
		incomingEdges.add(edge);
	}

	protected void removeIncomingEdge(final Edge edge) {
		incomingEdges.remove(edge);
	}

	protected void addOutgoingEdge(final Edge edge) {
		outgoingEdges.add(edge);
	}

	protected void removeOutgoingEdge(final Edge edge) {
		outgoingEdges.remove(edge);
	}
}
