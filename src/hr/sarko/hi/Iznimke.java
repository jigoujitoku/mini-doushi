package hr.sarko.hi;

import java.util.HashMap;
import java.util.Map;

public class Iznimke extends Verb {

	protected final static Map<String, Verb> mapaGlagola() {
		Map<String, Verb> verbs = new HashMap<>();
		verbs.put("くる", Iznimke.KURU);
		verbs.put("する", Iznimke.SURU);
		verbs.put("いく", Iznimke.IKU);
		verbs.put("もっていく", Iznimke.MOTTEIKU);
		verbs.put("もってくる", Iznimke.MOTTEKURU);
		verbs.put("つれていく", Iznimke.TSURETEIKU);
		verbs.put("むかえにいく", Iznimke.MUKAENIIKU);
		verbs.put("つれてくる", Iznimke.TSURETEKURU);
		verbs.put("かえる", Uverb.KAERU);
		verbs.put("しる", Uverb.SHIRU);
		verbs.put("はしる", Uverb.HASHIRU);
		verbs.put("はいる", Uverb.HAIRU);
		verbs.put("おふろにはいる", Uverb.FHAIRU);
		verbs.put("ある", Iznimke.ARU);
		verbs.put("きょうみがある", Iznimke.KYOMIARU);
		verbs.put("ねつがある", Iznimke.NETSUARU);
		verbs.put("にんきがある", Iznimke.NINKIARU);
		verbs.put("いらっしゃる", Iznimke.IRASSHARU);
		verbs.put("おっしゃる", Iznimke.OSSHARU);
		verbs.put("なさる", Iznimke.NASARU);
		verbs.put("くださる", Iznimke.KUDASARU);
		verbs.put("ござる", Iznimke.GOZARU);
		return verbs;
	}

	public Iznimke(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	public static final Verb ARU = new Uverb("ある") {
		public String shortNegative() {
			return "ない";
		}

		public String shortNegPast() {
			return "なかった";
		}

	};
	public static final Verb KYOMIARU = new Uverb("きょうみがある") {
		public String shortNegative() {
			return "きょうみがない";
		}

		public String shortNegPast() {
			return "きょうみがなかった";
		}
	};

	public static final Verb NETSUARU = new Uverb("ねつがある") {
		public String shortNegative() {
			return "ねつがない";
		}

		public String shortNegPast() {
			return "ねつがなかった";
		}
	};

	public static final Verb NINKIARU = new Uverb("にんきがある") {
		public String shortNegative() {
			return "にんきがない";
		}

		public String shortNegPast() {
			return "にんきがなかった";
		}

	};

	public static final Verb IKU = new Uverb("いく") {
		public String teForm() {
			return "いって";
		}

	};
	public static final Verb MOTTEIKU = new Uverb("もっていく") {
		public String teForm() {
			return "もっていって";
		}

	};
	public static final Verb TSURETEIKU = new Uverb("つれていく") {
		public String teForm() {
			return "つれていって";
		}

	};
	public static final Verb MUKAENIIKU = new Uverb("むかえにいく") {
		public String teForm() {
			return "むかえにいって";
		}

	};

	public static final Verb KURU = new Verb("くる") {

		public String stem() {
			return "き";
		}

		public String stemNegative() {
			return "こ";
		}

		public String potential() {
			return "こられる";
		}

		public String causative() {
			return "こらせる";
		}

		public String passive() {
			return "こられる";
		}

		public String cauPass() {
			return "こさせられる";
		}

	};
	public static final Verb MOTTEKURU = new Verb("もってくる") {
		public String stem() {
			return "もってき";
		}

		public String stemNegative() {
			return "もってこ";
		}

		public String potential() {
			return "もってこられる";
		}

		public String causative() {
			return "もってこらせる";
		}

		public String passive() {
			return "もってこられる";
		}

		public String cauPass() {
			return "もってこさせられる";
		}
	};
	public static final Verb TSURETEKURU = new Verb("つれてくる") {
		public String stem() {
			return "つれてき";
		}

		public String stemNegative() {
			return "つれてこ";
		}

		public String potential() {
			return "つれてこられる";
		}

		public String causative() {
			return "つれてこらせる";
		}

		public String passive() {
			return "つれてこられる";
		}

		public String cauPass() {
			return "つれてこさせられる";
		}
	};

	public static final Verb SURU = new Verb("する") {

		public String stem() {
			return "し";
		}

		public String potential() {
			return "できる";
		}

		public String causative() {
			return "させる";
		}

		public String passive() {
			return "される";
		}

		public String cauPass() {
			return "させられる";
		}

	};

	public static final Verb IRASSHARU = new Uverb("いらっしゃる") {
		public String stem() {
			return "いらっしゃい";
		}

		public String teForm() {
			return "いらっしゃって";
		}
	};
	public static final Verb OSSHARU = new Uverb("おっしゃる") {
		public String stem() {
			return "おっしゃい";
		}

		public String teForm() {
			return "おしゃって";
		}
	};
	public static final Verb NASARU = new Uverb("なさる") {
		public String stem() {
			return "なさい";
		}

		public String teForm() {
			return "なさって";
		}
	};
	public static final Verb KUDASARU = new Uverb("くださる") {
		public String stem() {
			return "ください";
		}

		public String teForm() {
			return "くださって";
		}
	};
	public static final Verb GOZARU = new Uverb("ござる") {
		public String stem() {
			return "ござい";
		}

		public String teForm() {
			return "ござって";
		}
	};

	@Override
	public String stem() {
		// TODO Auto-generated method stub
		return null;
	}

}
