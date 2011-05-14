package com.github.graphit.layout;

import com.github.graphit.model.BoundedGraph;
import com.github.graphit.model.BoundedGraphImpl;
import com.github.graphit.model.Graph;
import com.github.graphit.model.Node;

import java.awt.geom.Rectangle2D;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class CircleLayout implements Layout {

	@Override
	public BoundedGraph apply(final Graph graph) {
		final BoundedGraph result = new BoundedGraphImpl(graph);

		final int count = graph.getNodes().size();
		final double max = 100;
		final double r = count * max / Math.PI;
		final double phi = 2 * Math.PI / count;

		int i = 0;
		for (Node node : graph.getNodes()) {
			final int x = (int) (r + r * Math.sin(i * phi));
			final int y = (int) (r + r * Math.cos(i * phi));
			result.setNodeBounds(node, new Rectangle2D.Double(x, y, max, max));
			i++;
		}
		return result;
	}
}
