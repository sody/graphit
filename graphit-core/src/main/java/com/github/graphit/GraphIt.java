package com.github.graphit;

import com.github.graphit.layout.Layout;
import com.github.graphit.layout.LayoutSpi;
import com.github.graphit.model.Node;
import com.github.graphit.render.Renderer;
import com.github.graphit.render.RendererSpi;
import com.github.graphit.theme.Theme;
import com.github.graphit.theme.ThemeSpi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Ivan Khalopik
 * @since 1.1
 */
public class GraphIt {
	private static final ServiceLoader<RendererSpi> renderers = ServiceLoader.load(RendererSpi.class);
	private static final ServiceLoader<ThemeSpi> themes = ServiceLoader.load(ThemeSpi.class);
	private static final ServiceLoader<LayoutSpi> layouts = ServiceLoader.load(LayoutSpi.class);

	public static void createGraph(final String layoutId, final String themeId, final String rendererType,
								   final List<Node> nodes) {
		final Layout layout = getLayout(layoutId);
		final Theme theme = getTheme(themeId);
		final Renderer renderer = createRenderer(rendererType, 1000, 1000);

		layout.apply(renderer, theme, nodes);

		try {
			renderer.render(new FileOutputStream("some." + rendererType));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Renderer createRenderer(final String type, final int width, final int height) {
		for (RendererSpi rendererSpi : renderers) {
			if (rendererSpi.supports(type)) {
				return rendererSpi.create(type, width, height);
			}
		}
		throw new IllegalArgumentException("There are no such layout configured: " + type);
	}

	private static Layout getLayout(final String id) {
		for (LayoutSpi layoutSpi : layouts) {
			if (layoutSpi.supports(id)) {
				return layoutSpi.get(id);
			}
		}
		throw new IllegalArgumentException("There are no such layout configured: " + id);
	}

	private static Theme getTheme(final String id) {
		for (ThemeSpi themeSpi : themes) {
			if (themeSpi.supports(id)) {
				return themeSpi.get(id);
			}
		}
		throw new IllegalArgumentException("There are no such theme configured: " + id);
	}
}
