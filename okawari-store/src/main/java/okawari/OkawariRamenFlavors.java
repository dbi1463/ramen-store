package okawari;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;
import static okawari.NoodleHardness.middle;
import static okawari.Sauces.salt;
import static okawari.SoupConcentration.normal;
import static okawari.Soups.chicken;

import java.util.function.Function;

import ramen.RamenRecipe;
import ramen.ScentedOilMaker;

enum OkawariRamenFlavors {

	tonkotsu((order) -> {
		var sauce = ofNullable(order.sauce()).orElse(salt);
		var concentration = ofNullable(order.concentration()).orElse(normal);
		var hardness = ofNullable(order.hardness()).orElse(middle);
		var soupMaker = concentration.soupMaker(Soups.tonkotsu);
		ScentedOilMaker scentedOilMaker = () -> {
			out.println("put the lard into the bowl");
			out.println("put the pork back fat into the bowl");
		};
		return new TonkotsuRamenRecipe(sauce, hardness, soupMaker, scentedOilMaker, order.toppings());
	}),

	soy((order) -> {
		var hardness = ofNullable(order.hardness()).orElse(middle);
		var soupMaker = normal.soupMaker(chicken);
		ScentedOilMaker scentedOilMaker = () -> {
			out.println("put the boiled scallion oil into the bowl");
		};
		return new SoyRamenRecipe(hardness, soupMaker, scentedOilMaker, order.toppings());
	});

	private Function<OkawariRamenOrder, RamenRecipe> recipeMaker;

	private OkawariRamenFlavors(final Function<OkawariRamenOrder, RamenRecipe> maker) {
		recipeMaker = maker;
	}

	RamenRecipe toRecipe(final OkawariRamenOrder order) {
		return recipeMaker.apply(order);
	}
}
