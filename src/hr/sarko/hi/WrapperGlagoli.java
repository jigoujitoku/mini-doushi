package hr.sarko.hi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class WrapperGlagoli {

	static class Wrapper {
		String name;
		Function<Verb, String> tense;

		public Wrapper(String name, Function<Verb, String> tense) {
			this.name = name;
			this.tense = tense;
		}

	}

	public static List<Wrapper> tenses = new ArrayList<>();

	private static void register(String name, Function<Verb, String> tense) {
		tenses.add(new Wrapper(name, tense));
	}

	static void init() {
		switch (Gui.vrijemeLevel) {
		case 1: {
			tenses.clear();
			register("masu forma", Verb::masu);
			register("negacija, pristojni oblik", Verb::masen);
			register("ajmo - pristojno", Verb::mashou);
			register("hoćemo li?", Verb::masenka);
			break;
		}
		case 2: {
			tenses.clear();
			register("te forma", Verb::teForm);
			break;
		}
		case 3: {
			tenses.clear();
			register("molim te", Verb::teKudasai);
			register("smjeti", Verb::teMoIi);
			register("zabranjeno je", Verb::teWaIkenai);
			break;
		}
		case 4: {
			tenses.clear();
			register("idem napraviti", Verb::niIku);
			register("došao napraviti", Verb::niKita);
			register("vraćam se napraviti", Verb::niKaeru);
			break;
		}
		case 5: {
			tenses.clear();
			register("te-iru masu", Verb::teImasu);
			register("te-ru te forma", Verb::teIte);
			register("te-iru negacija", Verb::teImasen);
			register("te-iru prošlost", Verb::teImashita);
			register("te-iru neg.prošlost", Verb::teImasenDeshita);
			break;
		}
		case 6: {
			tenses.clear();
			register("negacija", Verb::shortNegative);
			register("prošlost", Verb::shortPast);
			register("prošlost negacija", Verb::shortNegPast);
			break;
		}
		case 7: {
			tenses.clear();
			register("nemoj", Verb::pleaseDont);
			register("trebao bi", Verb::taHougaIi);
			register("ne bi trebao", Verb::naiHougaIi);
			break;
		}
		case 8: {
			tenses.clear();
			register("volim", Verb::suki);
			register("ne volim baš", Verb::sukijanai);
			register("ne volim", Verb::kirai);
			register("ni volim ni ne volim", Verb::sukidemo);
			break;
		}
		case 9: {
			tenses.clear();
			register("namjeravam", Verb::tsumori);
			register("namjeravam ne raditi", Verb::naitsumori);
			register("namjeravah", Verb::tsumoriDeshita);
			register("namjeravah ne raditi", Verb::naiTsumoriDeshita);
			break;
		}
		case 10: {
			tenses.clear();
			register("želim", Verb::tai);
			register("ne želim", Verb::takunai);
			register("željah", Verb::takatta);
			register("ne željah", Verb::takunakatta);
			break;
		}
		case 11: {
			tenses.clear();
			register("imam iskustvo", Verb::kotoAru);
			register("nikad nisam", Verb::kotoNai);
			break;
		}
		case 12: {
			tenses.clear();
			register("radim X i drugo", Verb::tari);
			register("radio sam X i drugo", Verb::tariPast);
			break;
		}
		case 13: {
			tenses.clear();
			register("previše sam radio", Verb::sugiru);
			break;
		}
		case 14: {
			tenses.clear();
			register("moram - masu", Verb::nakerebaIkemasen);
			register("moram - short", Verb::nakerebaIkenai);
			register("moram - casual", Verb::nakyaIkenai);
			break;
		}
		case 15: {
			tenses.clear();
			register("mogu", Verb::potential);
			register("mogu - masu", Verb::potentialMasu);
			break;
		}
		case 16: {
			tenses.clear();
			register("pokušavam/pokušat ću - kratko", Verb::teMiru);
			register("pokušavam/pokušat ću - masu", Verb::teMimasu);
			register("pokušah - masu", Verb::teMimashita);
			register("pokušah - kratko", Verb::teMita);
			register("unaprijed radim - kratko", Verb::teOku);
			register("unaprijed radim - masu", Verb::teOkimasu);
			register("unaprijed radih - masu", Verb::teOkimashita);
			register("unaprijed radih - kratko", Verb::teOita);
			register("slučajno napravih - masu", Verb::teShimaimashita);
			register("slučajno napravih - kratko", Verb::teShimatta);
			break;
		}
		case 17: {
			tenses.clear();
			register("možda - kratko", Verb::kamoShirenai);
			register("možda - masu", Verb::kamoShiremasen);
			break;
		}
		case 18: {
			tenses.clear();
			register("ako, kada", Verb::tara);
			register("kako bi bilo da..", Verb::taraDou);
			register("ako je riječ o.., ukoliko", Verb::nara);
			break;
		}
		case 19: {
			tenses.clear();
			register("ajmo, mogao  bih (kratko)", Verb::youou);
			register("mislim da bih mogao", Verb::yououToOmou);
			break;
		}
		case 20: {
			tenses.clear();
			register("učiniti nekome - kratko", Verb::teAgeru);
			register("učinit će nekome  - masu", Verb::teAgemasu);
			register("učinio je nekome - masu", Verb::teAgemashita);
			register("učinio je nekome - kratko", Verb::teAgeta);
			register("čini meni - kratko", Verb::teKureru);
			register("čini meni - masu", Verb::teKuremasu);
			register("učinio je za mene - masu", Verb::teKuremashita);
			register("učinio je za mene - kratko", Verb::teKureta);
			register("dobiti uslugu - masu", Verb::teMoraimasu);
			register("dobiti uslugu - kratko", Verb::teMorau);
			register("dobio uslugu - masu", Verb::teMoraimashita);
			register("dobio uslugu - kratko", Verb::teMoratta);
			break;
		}
		case 21: {
			tenses.clear();
			register("ne moraš", Verb::nakuteMoIi);
			register("smiješ", Verb::teMoIi);
			break;
		}
		case 22: {
			tenses.clear();
			register("ako, kad bi samo", Verb::baKondicional);
			register("ako ne bi", Verb::nakereba);
			register("da sam barem..", Verb::baYokatta);
			register("da barem nisam..", Verb::nakerebaYokatta);
			break;
		}
		case 23: {
			tenses.clear();
			register("dok radim .. (radim i Y)", Verb::nagara);
			register("kako (raditi), način za..", Verb::kata);
			break;
		}
		case 24: {
			tenses.clear();
			register("lako za napraviti", Verb::yasui);
			register("teško za napraviti", Verb::nikui);
			break;
		}
		case 25: {
			tenses.clear();
			register("pasiv - kratko", Verb::passive);
			register("pasiv - masu", Verb::passiveMasu);
			break;
		}
		case 26: {
			tenses.clear();
			register("učiniti/dozvoliti da radi - kratko", Verb::causative);
			register("učiniti/dozvoliti da radi - masu", Verb::causativeMasu);
			break;
		}
		case 27: {
			tenses.clear();
			register("natjerati da radi - kratko", Verb::cauPass);
			register("natjerati da radi - masu", Verb::taraDou);
			break;
		}
		case 28: {
			tenses.clear();
			register("mislim da..", Verb::toOmou);
			register("mislim da je (prošlost)", Verb::taToOmou);
			register("mislim da ne..", Verb::naiToOmou);
			register("mislim da nije (prošlost)", Verb::nakattaToOmou);
			register("reče da..", Verb::toItteImashita);
			register("reče da je (prošlost)", Verb::taToItteImashita);
			register("reče da ne..", Verb::naiToItteImashita);
			register("reče da nije (prošlost)", Verb::nakattaToItteImashita);
		}
		}
	}

}
