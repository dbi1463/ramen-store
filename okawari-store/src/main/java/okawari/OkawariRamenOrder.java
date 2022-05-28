package okawari;

import ramen.RamenOrder;
import ramen.RamenRecipe;

public record OkawariRamenOrder(
	OkawariRamenFlavors flavor,
	Sauces sauce,
	SoupConcentration concentration,
	NoodleHardness hardness) implements RamenOrder {

	static final String[] defaultToppings = { "char siew", "cooked dried bamboo shoots", "chopped scallion", "braised egg", "nori" };

	@Override
	public RamenRecipe toRecipe() {
		return flavor().toRecipe(this);
	}

	public String[] toppings() {
		return defaultToppings;
	}
}
