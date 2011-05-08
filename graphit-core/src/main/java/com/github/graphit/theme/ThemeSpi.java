package com.github.graphit.theme;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public interface ThemeSpi {

	boolean supports(String id);

	Theme get(String id);
}
