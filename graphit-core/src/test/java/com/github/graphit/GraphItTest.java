package com.github.graphit;

import com.github.graphit.model.Graph;
import com.github.graphit.model.GraphBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphItTest extends Assert {

	@Test
	public void test() {
		final GraphBuilder builder = new GraphBuilder();

		builder.addNode("A")
				.addNode("B")
				.addNode("C")
				.addNode("D")
				.addNode("E");

		final Graph graph = builder.build();
		GraphIt.createGraph("dummy", "dummy", "svg", graph);
		GraphIt.createGraph("dummy", "dummy", "png", graph);
	}

}
