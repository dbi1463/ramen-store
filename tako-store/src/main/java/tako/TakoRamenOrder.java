package tako;

import ramen.RamenOrder;
import ramen.RamenRecipe;

public record TakoRamenOrder(NoodleHardness hardness) implements RamenOrder {

	static final String[] defaultToppings = { "ravioli", "cooked dried bamboo shoots", "chopped scallion", "braised egg", "nori" };

	@Override
	public RamenRecipe toRecipe() {
		return TakoRamenFlavors.oyokai.toRecipe(this);
	}

	public String[] toppings() {
		return defaultToppings;
	}
}
