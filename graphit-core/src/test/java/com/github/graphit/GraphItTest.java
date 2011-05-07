package com.github.graphit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphItTest extends Assert {

	@Test
	public void test() {
		final List<Node> nodes = new ArrayList<Node>();
		nodes.add(new NodeImpl("A"));
		nodes.add(new NodeImpl("B"));
		nodes.add(new NodeImpl("C"));

		GraphIt.createGraph("dummy", "dummy", "svg", nodes);
	}

	public static class NodeImpl implements Node {
		private final String id;
		private final String name;

		public NodeImpl(final String id) {
			this(id, id);
		}

		public NodeImpl(final String id, final String name) {
			this.id = id;
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
			return null;
		}

		@Override
		public List<Edge> getEdges() {
			return null;
		}
	}
}
