package hr.sarko.hi;

public class NaAdjective extends Adjective {

	public NaAdjective(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	public String stem() {
		return hiragana;
	}

	public String stemNeg() {
		return stem() + "じゃ";
	}

	public String past() {
		return stem() + "でした";
	}

	public String teForm() {
		return stem() + "で";
	}

	public String adverb() {
		return stem() + "に";
	}

	public String souHear() {
		return jishokei() + "だそうです";
	}

	public static final Adjective KIREI = new NaAdjective("きれい");
	public static final Adjective KIRAI = new NaAdjective("きらい");
	public static final Adjective YUUMEI = new NaAdjective("ゆうめい");
	public static final Adjective DAIKIRAI = new NaAdjective("だいきらい");

}
