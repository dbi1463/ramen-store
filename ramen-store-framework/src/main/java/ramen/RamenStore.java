package ramen;

import static java.lang.System.exit;
import static java.lang.System.out;
import static java.util.Optional.ofNullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RamenStore {

	private VendingMachine machine;

	public RamenStore() {
		this((args) -> null);
	}

	public RamenStore(final VendingMachine vendingMachine) {
		machine = vendingMachine;
	}

	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				machine.prompt();
				var line = reader.readLine();
				var arguments = line.split(" ");
				ofNullable(machine.toOrder(arguments)).ifPresentOrElse(this::cookRamen, this::showPromptMessage);
			}
		} catch (IOException e) {
			out.println("Sorry, there are something wrong. We have to close the store. See you tomorrow!");
			exit(0);
		}
	}

	private void cookRamen(final RamenOrder order) {
		order.toRecipe().cook();
	}

	private void showPromptMessage() {
		out.println("Sorry, unable to make a ramen without an order. Please place an order");
	}

	public static void main(String[] args) {
		var store = new RamenStore();
		store.start();
	}
}
