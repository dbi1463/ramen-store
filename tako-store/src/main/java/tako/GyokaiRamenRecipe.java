package tako;

public record GyokaiRamenRecipe(NoodleHardness hardness, String[] toppings) implements TakoRamenRecipe {

	@Override
	public void cook() {
		prepareSauce("kunbu salt");
		prepareScentedOil();
		prepareSoup();
		cookNoodle(hardness.time());
		addToppings(toppings);
	}
}
