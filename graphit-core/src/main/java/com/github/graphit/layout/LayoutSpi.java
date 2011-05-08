package com.github.graphit.layout;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface LayoutSpi {

	boolean supports(String id);

	Layout get(String id);
}
