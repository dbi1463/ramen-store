package tako;

public enum NoodleHardness {

	superHard(45), hard(90), middle(120), soft(270);

	private int time;

	private NoodleHardness(final int value) {
		time = value;
	}

	public int time() {
		return time;
	}
}
