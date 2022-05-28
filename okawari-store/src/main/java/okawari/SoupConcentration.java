package okawari;

import static java.lang.System.out;

import java.util.function.Consumer;

import ramen.SoupMaker;
import ramen.Timer;

enum SoupConcentration {

	lighter((type) -> {
		out.println("put the %s soup into the bowl".formatted(type.name()));
		out.println("put some boiled water into the bowl");
	}),

	normal((type) -> {
		out.println("put the %s soup into the bowl".formatted(type.name()));
	}),

	stronger((type) -> {
		out.println("put one and helf %s soup into the boiler".formatted(type.name()));
		out.println("open the fire to large and boil the soup");
		Timer.waitFor(3, "minutes");
		out.println("put the boiled soup into the bowl");
	});

	private Consumer<Soups> soupMaker;

	private SoupConcentration(final Consumer<Soups> maker) {
		soupMaker = maker;
	}

	public SoupMaker soupMaker(Soups type) {
		return () -> soupMaker.accept(type);
	}
}