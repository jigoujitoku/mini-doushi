package hr.sarko.hi;

public class Prvi {

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
	}

	// public static void main(String[] args) throws IOException {
	// Prvi prvi = new Prvi();
	// Scanner scanner = new Scanner(System.in);
	// String line = scanner.nextLine();
	// if (prvi.isVerb(line) && !prvi.isException(line)) {
	// System.out.println("Masu oblik: " + prvi.masuForm(line));
	// System.out.println("Te forma: " + prvi.teForm(line));
	// System.out.println("Kratka negacija: " + prvi.shortNegative(line));
	// System.out.println("Kratka prošlost: " + prvi.shortPast(line));
	// System.out.println("Kratka prošlost u negaciji: " +
	// prvi.shortNegPast(line));
	// System.out.println("Potencijal: " + prvi.potential(line));
	// System.out.println("Kauzativ: " + prvi.causative(line));
	// System.out.println("Pasiv: " + prvi.passive(line));
	// System.out.println("Kauzativ-pasiv: " + prvi.cauPass(line));
	// } else if (prvi.isException(line))
	// System.out.println("Iznimka.");
	// else if (!prvi.isVerb(line))
	// System.out.println("Nije glagol.");
	// }

	private static final String hiraganaU = "うくぐすつぬむるぶ";
	private static final String hiraganaE = "えけげせぜてでねめへべぺれ";
	private static final String hiraganaI = "いきぎしじりちぴびひぢみに";

	private String trimVerb(String verb) {
		return verb.substring(0, verb.length() - 1);
	}

	private String lastLetter(String verb) {
		return String.valueOf(verb.charAt(verb.length() - 1));
	}

	private boolean isVerb(String verb) {
		if (verb == null || verb.length() < 2) {
			return false;
		}
		return hiraganaU.contains(lastLetter(verb));
	}

	private boolean isRuVerb(String verb) {
		if (verb == null || verb.length() < 2)
			return false;
		if (!lastLetter(verb).equals("る"))
			return false;
		char scndLastLetter = verb.charAt(verb.length() - 2);
		return (hiraganaE.contains(String.valueOf(scndLastLetter))
				|| hiraganaI.contains(String.valueOf(scndLastLetter)));
	}

	private boolean isException(String verb) {
		if (verb.equals("する") || verb.equals("くる"))
			return true;
		else
			return false;
	}

	private String makeStem(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				return trimVerb(verb);

			} else {
				String verbT = trimVerb(verb);
				String verbEndT = Hiragana.hiraganaTransform(lastLetter(verb).charAt(0), 2, 1);
				return verbT + verbEndT;
			}
		}
		return verb;
	}

	private String masuForm(String verb) {
		return makeStem(verb).concat("ます");
	}

	private String masenForm(String verb) {
		return makeStem(verb).concat("ませす");
	}

	private String mashouForm(String verb) {
		return makeStem(verb).concat("ましょう");
	}

	private String shortNegative(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				verb = trimVerb(verb).concat("ない");

			} else {
				String verbT = Hiragana.hiraganaTransform(lastLetter(verb).charAt(0), 2, 0);
				return trimVerb(verb) + verbT + "ない";
			}
		}
		return verb;

	}

	private String shortNegPast(String verb) {
		return shortNegative(verb).substring(0, shortNegative(verb).length() - 1).concat("かった");

	}

	private String teForm(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				verb = trimVerb(verb);
				verb = verb.concat("て");
			} else {
				char verbEnd = verb.charAt(verb.length() - 1);
				verb = trimVerb(verb);
				switch (verbEnd) {
				case 'う':
				case 'つ':
				case 'る':
					verb = verb.concat("って");
					return verb;
				case 'む':
				case 'ぶ':
				case 'ぬ':
					verb = verb.concat("んで");
					return verb;
				case 'く':
					verb = verb.concat("いて");
					return verb;
				case 'ぐ':
					verb = verb.concat("いで");
					return verb;
				case 'す':
					verb = verb.concat("して");
					return verb;
				}

			}
		}
		return verb;
	}

	private String shortPast(String verb) {
		verb = teForm(verb);
		char verbEnd = verb.charAt(verb.length() - 1);
		verb = trimVerb(verb);
		if (verbEnd == 'て')
			verb = verb.concat("た");
		else if (verbEnd == 'で')
			verb = verb.concat("だ");
		return verb;

	}

	private String potential(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				return makeStem(verb).concat("られる");

			} else {
				String verbT = trimVerb(verb);
				String verbEndT = Hiragana.hiraganaTransform(lastLetter(verb).charAt(0), 2, 3);
				return verbT + verbEndT + "る";
			}
		}
		return verb;

	}

	private String passive(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				return makeStem(verb).concat("られる");

			} else {
				String verbT = trimVerb(verb);
				String verbEndT = Hiragana.hiraganaTransform(lastLetter(verb).charAt(0), 2, 0);
				return verbT + verbEndT + "れる";
			}
		}
		return verb;

	}

	private String causative(String verb) {
		if (isVerb(verb)) {
			if (isRuVerb(verb)) {
				return makeStem(verb).concat("させる");

			} else {
				String verbT = trimVerb(verb);
				String verbEndT = Hiragana.hiraganaTransform(lastLetter(verb).charAt(0), 2, 0);
				return verbT + verbEndT + "せる";
			}
		}
		return verb;

	}

	private String cauPass(String verb) {
		return passive(causative(verb));
	}
}
