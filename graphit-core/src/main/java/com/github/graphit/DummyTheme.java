package com.github.graphit;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class DummyTheme implements Theme {
	private static final String THEME_ID = "dummy";

	public String getId() {
		return THEME_ID;
	}

	public void renderNode(final Renderer renderer, final Node node, final int x, final int y, final int width, final int height) {
		renderer.rectangle(x, y, width, height);
	}

	public void renderEdge(final Renderer renderer, final Edge edge, final int x1, final int y1, final int x2, final int y2) {
		renderer.line(x1, y1, x2, y2);
	}
}
