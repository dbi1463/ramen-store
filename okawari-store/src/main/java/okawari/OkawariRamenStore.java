package okawari;

import ramen.RamenStore;

public class OkawariRamenStore {

	public static void main(String[] args) {
		var machine = new OkawariVendingMachine();
		var store = new RamenStore(machine);
		store.start();
	}
}
