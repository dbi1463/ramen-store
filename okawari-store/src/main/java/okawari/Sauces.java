package okawari;

enum Sauces {

	salt("salt sauce"), soy("soy sauce");

	private String fullname;

	private Sauces(final String value) {
		fullname = value;
	}

	@Override
	public String toString() {
		return fullname;
	}
}