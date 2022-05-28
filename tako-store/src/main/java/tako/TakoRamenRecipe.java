package tako;

import static java.lang.System.out;

import ramen.RamenRecipe;
import ramen.ScentedOilMaker;
import ramen.SoupMaker;

public interface TakoRamenRecipe extends RamenRecipe {

	default SoupMaker soupMaker() {
		return () -> {
			out.println("put the gyokai soup into the bowl");
		};
	}

	default ScentedOilMaker scentedOilMaker() {
		return () -> {
			out.println("put the boiled shrimp oil into the bowl");
		};
	}
}
