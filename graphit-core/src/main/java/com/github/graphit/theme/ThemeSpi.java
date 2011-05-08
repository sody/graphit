package com.github.graphit.theme;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public interface ThemeSpi {

	boolean supports(String id);

	Theme get(String id);
}
