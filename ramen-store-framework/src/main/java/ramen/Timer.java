package ramen;

import static java.lang.System.out;

public interface Timer {

	static void waitFor(int time, String unit) {
		out.println("wait for %d %s".formatted(time, unit));
	}
}
