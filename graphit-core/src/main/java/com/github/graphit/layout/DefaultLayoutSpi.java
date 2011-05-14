package com.github.graphit.layout;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class DefaultLayoutSpi implements LayoutSpi {
	private static final Layout LAYOUT = new CircleLayout();

	@Override
	public boolean supports(final String id) {
		return true;
	}

	@Override
	public Layout get(final String id) {
		return LAYOUT;
	}
}
