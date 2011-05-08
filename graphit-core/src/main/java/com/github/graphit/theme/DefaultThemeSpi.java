package com.github.graphit.theme;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class DefaultThemeSpi implements ThemeSpi {
	private static final Theme THEME = new DummyTheme();

	@Override
	public boolean supports(final String id) {
		return true;
	}

	@Override
	public Theme get(final String id) {
		return THEME;
	}
}
