package tako;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;
import static tako.NoodleHardness.middle;
import static tako.NoodleHardness.valueOf;

import ramen.RamenOrder;
import ramen.VendingMachine;

public class TakoVendingMachine implements VendingMachine {

	@Override
	public RamenOrder toOrder(String[] args) {
		var hardness = ofNullable(args[0]).orElse(middle.name());
		return new TakoRamenOrder(valueOf(hardness));
	}

	public void prompt() {
		out.println("Choose your noodle hardness:");
	}
}
