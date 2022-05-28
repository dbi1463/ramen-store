package ramen;

import static java.lang.System.out;

@FunctionalInterface
public interface VendingMachine {

	RamenOrder toOrder(String[] args);

	default void prompt() {
		out.println("Choose your flavor ramen:");
	}
}
