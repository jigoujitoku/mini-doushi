package hr.sarko.hi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class WrapperPridjevi {
	static class Wrapper {
		String name;
		Function<Adjective, String> tense;

		public Wrapper(String name, Function<Adjective, String> tense) {
			this.name = name;
			this.tense = tense;
		}
	}

	public static List<Wrapper> tenses = new ArrayList<>();

	private static void register(String name, Function<Adjective, String> tense) {
		tenses.add(new Wrapper(name, tense));
	}

	static void init() {
		switch (Gui.vrijemeLevelP) {
		case 1: {
			tenses.clear();
			register("negacija", Adjective::negative);
			register("prošlost", Adjective::past);
			register("negacija u prošlosti", Adjective::negativePast);
			break;
		}
		case 2: {
			tenses.clear();
			register("te-forma", Adjective::teForm);
			break;
		}
		case 3: {
			tenses.clear();
			register("negativna te-forma", Adjective::negativeTeForm);
			break;
		}
		case 4: {
			tenses.clear();
			register("prilog", Adjective::adverb);
			register("postalo je ..", Adjective::become);
			register("činim (takvim)", Adjective::suru);
			break;
		}
		case 5: {
			tenses.clear();
			register("čini mi se", Adjective::souSeems);
			register("čujem da", Adjective::souHear);
			// register("izgleda mi", Adjective::mitai);
			break;
		}
		case 6: {
			tenses.clear();
			register("previše, pretjerano", Adjective::sugiru);
			break;
		}

		}
	}

}
