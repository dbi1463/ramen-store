package okawari;

import ramen.RamenRecipe;
import ramen.ScentedOilMaker;
import ramen.SoupMaker;

public record TonkotsuRamenRecipe(
	Sauces sauce,
	NoodleHardness hardness,
	SoupMaker soupMaker,
	ScentedOilMaker scentedOilMaker,
	String[] toppings) implements RamenRecipe {

	public void cook() {
		heatBowl();
		prepareSauce(sauce().toString());
		prepareScentedOil();
		prepareSoup();
		cookNoodle(hardness().time());
		addToppings(toppings());
	}
}
