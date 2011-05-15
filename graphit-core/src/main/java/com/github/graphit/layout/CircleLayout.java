package com.github.graphit.layout;

import com.github.graphit.model.Graph;
import com.github.graphit.model.Node;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class CircleLayout implements Layout {

	@Override
	public void apply(final Graph graph) {
		final int count = graph.getNodes().size();
		final double max = 100;
		final double r = count * max / Math.PI;
		final double phi = 2 * Math.PI / count;

		if (graph.getSize() == null) {
			final int graphMax = (int) (3 * r);
			graph.setSize(new Dimension(graphMax, graphMax));
		}
		int i = 0;
		for (Node node : graph.getNodes()) {
			if (node.getSize() == null) {
				node.setSize(new Dimension(100, 100));
			}
			final double x = (r + r * Math.sin(i * phi));
			final double y = (r + r * Math.cos(i * phi));
			node.setPosition(new Point2D.Double(x, y));
			i++;
		}
	}
}
