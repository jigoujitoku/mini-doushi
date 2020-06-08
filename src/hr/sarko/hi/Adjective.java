package hr.sarko.hi;

public abstract class Adjective {

	protected final String hiragana;

	public Adjective(String hiragana) {
		this.hiragana = hiragana;
	}

	public String jishokei() {
		return hiragana;
	}

	@Override
	public String toString() {
		return hiragana;
	}

	public abstract String stem();

	public abstract String stemNeg();

	public abstract String past();

	public String negative() {
		return stemNeg() + "ないです";
	};

	public String negativePast() {
		return stemNeg() + "なかったです";
	};

	public abstract String teForm();

	public String negativeTeForm() {
		return stemNeg() + "なくて";
	}

	public abstract String adverb();

	public String become() {
		return adverb() + "なりました";
	}

	public String suru() {
		return adverb() + "します";
	}

	public String souSeems() {
		return stem() + "そうです";
	}

	public abstract String souHear();

	public String mitai() {
		return jishokei() + "みたいです";
	}

	public String sugiru() {
		return stem() + "すぎる";
	}

}