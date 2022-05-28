package ramen;

import static java.lang.System.out;
import static java.util.stream.Stream.of;
import static ramen.Timer.waitFor;

public interface RamenRecipe {

	void cook();

	SoupMaker soupMaker();

	ScentedOilMaker scentedOilMaker();

	default void addToppings(String[] toppings) {
		of(toppings).forEach((topping) -> {
			out.println("put the %s into the bowl".formatted(topping));
		});
	}

	default void cookNoodle(int time) {
		out.println("cook the noodle");
		waitFor(time, "seconds");
		out.println("put the cooked noodle into the bowl");
	}

	default void heatBowl() {
		out.println("put the hot water into the bowl");
		waitFor(30, "seconds");
		out.println("pour out the hot water");
	}

	default void prepareSauce(String sauce) {
		out.println("put a spoon of %s into the bowl".formatted(sauce));
	}

	default void prepareSoup() {
		soupMaker().makeSoup();
	}

	default void prepareScentedOil() {
		scentedOilMaker().makeScentedOil();
	}
}
