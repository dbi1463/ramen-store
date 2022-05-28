package tako;

import ramen.RamenStore;

public class TakoRamenStore {

	public static void main(String[] args) {
		var machine = new TakoVendingMachine();
		var store = new RamenStore(machine);
		store.start();
	}
}
