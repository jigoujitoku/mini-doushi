package hr.sarko.hi;

public class Uverb extends Verb {

	public Uverb(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	public String stem() {
		String verbT = trimVerb();
		String verbEndT = Hiragana.hiraganaTransform(lastLetter().charAt(0), 2, 1);
		return verbT + verbEndT;

	}

	public String stemNegative() {
		String verbT;
		if (lastLetter().equals("う"))
			verbT = "わ";
		else
			verbT = Hiragana.hiraganaTransform(lastLetter().charAt(0), 2, 0);
		return trimVerb() + verbT;
	}

	public String stemO() {
		String verbT = trimVerb();
		String verbEndT = Hiragana.hiraganaTransform(lastLetter().charAt(0), 2, 4);
		return verbT + verbEndT;

	}

	public String stemE() {
		String verbT = trimVerb();
		String verbEndT = Hiragana.hiraganaTransform(lastLetter().charAt(0), 2, 3);
		return verbT + verbEndT;

	}

	public String teForm() {
		char verbEnd = lastLetter().charAt(0);
		String verb = trimVerb();
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

		return verb;
	}

	public String potential() {
		String verbT = trimVerb();
		String verbEndT = Hiragana.hiraganaTransform(lastLetter().charAt(0), 2, 3);
		return verbT + verbEndT + "る";
	}

	public String youou() {
		return stemO() + "う";
	}

	public String baKondicional() {
		return stemE() + "ば";
	}

	public static final Verb KAERU = new Uverb("かえる");
	public static final Verb HAIRU = new Uverb("はいる");
	public static final Verb FHAIRU = new Uverb("おふろにはいる");
	public static final Verb SHIRU = new Uverb("しる");
	public static final Verb HASHIRU = new Uverb("はしる");

}
