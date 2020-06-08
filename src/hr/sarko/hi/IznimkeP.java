package hr.sarko.hi;

import java.util.HashMap;
import java.util.Map;

public class IznimkeP extends Adjective {

	public IznimkeP(String hiragana) {
		super(hiragana);
		// TODO Auto-generated constructor stub
	}

	// dodat yokatta,kakkoyokatta, atamagayokatta

	protected final static Map<String, Adjective> mapaPridjeva() {
		Map<String, Adjective> adjectives = new HashMap<>();
		adjectives.put("きれい", NaAdjective.KIREI);
		adjectives.put("きらい", NaAdjective.KIRAI);
		adjectives.put("ゆうめい", NaAdjective.YUUMEI);
		adjectives.put("だいきらい", NaAdjective.DAIKIRAI);
		adjectives.put("いい", IznimkeP.II);
		adjectives.put("かっこいい", IznimkeP.KAKKOII);
		adjectives.put("あたまがいい", IznimkeP.ATAMAGAII);
		return adjectives;
	}

	public static final Adjective II = new IAdjective("いい") {
		public String stem() {
			return "よ";
		}

		public String stemNeg() {
			return "よく";
		}

		public String souSeems() {
			return "よさそうです";
		}
	};

	public static final Adjective KAKKOII = new IAdjective("かっこいい") {
		public String stem() {
			return "かっこよ";
		}

		public String stemNeg() {
			return "かっこよく";
		}

		public String souSeems() {
			return "かっこよさそうです";
		}
	};

	public static final Adjective ATAMAGAII = new IAdjective("あたまがいい") {
		public String stem() {
			return "あたまがよ";
		}

		public String stemNeg() {
			return "あたまがよく";
		}

		public String souSeems() {
			return "あたまがよさそうです";
		}
	};

	@Override
	public String stem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stemNeg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String past() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adverb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String souHear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String teForm() {
		// TODO Auto-generated method stub
		return null;
	}
}
