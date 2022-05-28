package okawari;

enum NoodleHardness {

	hard(120), middle(180), soft(240);

	private int time;

	private NoodleHardness(final int value) {
		time = value;
	}

	public int time() {
		return time;
	}
}
