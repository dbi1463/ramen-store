package tako;

import static java.util.Optional.ofNullable;

import java.util.function.Function;

import ramen.RamenRecipe;

public enum TakoRamenFlavors {

	oyokai((order) -> {
		var hardness = ofNullable(order.hardness()).orElse(NoodleHardness.middle);
		return new GyokaiRamenRecipe(hardness, order.toppings());
	});

	private Function<TakoRamenOrder, RamenRecipe> recipeMaker;

	private TakoRamenFlavors(final Function<TakoRamenOrder, RamenRecipe> maker) {
		recipeMaker = maker;
	}

	RamenRecipe toRecipe(final TakoRamenOrder order) {
		return recipeMaker.apply(order);
	}
}
