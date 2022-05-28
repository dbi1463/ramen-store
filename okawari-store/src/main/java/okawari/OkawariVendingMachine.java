package okawari;

import static okawari.NoodleHardness.middle;
import static okawari.OkawariRamenFlavors.tonkotsu;
import static okawari.Sauces.salt;
import static okawari.SoupConcentration.normal;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import ramen.RamenOrder;
import ramen.VendingMachine;

public class OkawariVendingMachine implements VendingMachine {

	static class FlavorConverter implements IStringConverter<OkawariRamenFlavors> {

		@Override
		public OkawariRamenFlavors convert(String value) {
			return OkawariRamenFlavors.valueOf(value);
		}
	}

	static class SaucesConverter implements IStringConverter<Sauces> {

		@Override
		public Sauces convert(String value) {
			return Sauces.valueOf(value);
		}
	}

	static class ConcentrationConverter implements IStringConverter<SoupConcentration> {

		@Override
		public SoupConcentration convert(String value) {
			return SoupConcentration.valueOf(value);
		}
	}

	static class HardnessConverter implements IStringConverter<NoodleHardness> {

		@Override
		public NoodleHardness convert(String value) {
			return NoodleHardness.valueOf(value);
		}
	}

	static class Options {

		@Parameter(required = true, converter = FlavorConverter.class)
		OkawariRamenFlavors flavor = tonkotsu;

		@Parameter(names = "-sauce", converter = SaucesConverter.class)
		Sauces sauce = salt;

		@Parameter(names = { "-concentration", "-c" }, converter = ConcentrationConverter.class)
		SoupConcentration concentration = normal;

		@Parameter(names = "-hardness", converter = HardnessConverter.class)
		NoodleHardness hardness = middle;

		RamenOrder toOrder() {
			return new OkawariRamenOrder(flavor, sauce, concentration, hardness);
		}
	}

	@Override
	public RamenOrder toOrder(String[] args) {
		var options = new Options();
		JCommander.newBuilder()
			.addObject(options)
			.build()
			.parse(args);
		return options.toOrder();
	}
}
