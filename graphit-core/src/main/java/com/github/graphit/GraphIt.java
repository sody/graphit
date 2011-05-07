package com.github.graphit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphIt {
	private static final ServiceLoader<Theme> themes = ServiceLoader.load(Theme.class);
	private static final ServiceLoader<Layout> layouts = ServiceLoader.load(Layout.class);

	private static final Map<String, Renderer> renderers = new HashMap<String, Renderer>();

	static {
		renderers.put("svg", new SvgRenderer());
	}

	public static void createGraph(final String layout, final String theme, final String renderer,
								   final List<Node> nodes) {
		final Layout layoutInstance = getLayout(layout);
		final Theme themeInstance = getTheme(theme);
		final Renderer rendererInstance = createRenderer(renderer);

		layoutInstance.renderGraph(rendererInstance, themeInstance, nodes);

		try {
			rendererInstance.write(new FileOutputStream("some.svg"));
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	private static Renderer createRenderer(final String id) {
		if (!renderers.containsKey(id)) {
			throw new IllegalArgumentException("There are no such layout configured: " + id);
		}
		return renderers.get(id);
	}

	private static Layout getLayout(final String id) {
		for (Layout layout : layouts) {
			if (layout.getId().equals(id)) {
				return layout;
			}
		}
		throw new IllegalArgumentException("There are no such layout configured: " + id);
	}

	private static Theme getTheme(final String id) {
		for (Theme theme : themes) {
			if (theme.getId().equals(id)) {
				return theme;
			}
		}
		throw new IllegalArgumentException("There are no such theme configured: " + id);
	}
}
