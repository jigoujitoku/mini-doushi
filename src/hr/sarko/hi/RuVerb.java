package hr.sarko.hi;

public class RuVerb extends Verb {

	public RuVerb(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	public String stem() {
		return hiragana.substring(0, hiragana.length() - 1);
	}

	public String shortNeg() {
		return stem() + "ない";
	}

	public String shortPastNeg() {
		return stem() + "なかった";
	}

	public String potential() {
		return passive();
	}

	public String causative() {
		return stem() + "させる";
	}

	public String passive() {
		return stem() + "られる";
	}

	public String cauPass() {
		return stem() + "させられる";
	}

	public String youou() {
		return stem() + "よう";
	}

	public String baKondicional() {
		return stem() + "れば";
	}

}
