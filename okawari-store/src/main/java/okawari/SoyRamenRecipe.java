package okawari;

import ramen.RamenRecipe;
import ramen.ScentedOilMaker;
import ramen.SoupMaker;

public record SoyRamenRecipe(
	NoodleHardness hardness,
	SoupMaker soupMaker,
	ScentedOilMaker scentedOilMaker,
	String[] toppings) implements RamenRecipe {

	public void cook() {
		heatBowl();
		prepareSauce(Sauces.soy.toString());
		prepareSoup();
		cookNoodle(hardness.time());
		addToppings(toppings());
		prepareScentedOil();
	}
}
