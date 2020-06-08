package hr.sarko.hi;

public class IAdjective extends Adjective {

	public IAdjective(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	public String stem() {
		return hiragana.substring(0, hiragana.length() - 1);
	}

	public String stemNeg() {
		return stem() + "く";
	}

	public String past() {
		return stem() + "かったです";
	}

	public String teForm() {
		return stemNeg() + "て";
	}

	public String adverb() {
		return stemNeg();
	}

	public String souHear() {
		return jishokei() + "そうです";
	}

}
