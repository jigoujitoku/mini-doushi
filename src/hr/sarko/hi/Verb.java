package hr.sarko.hi;

public abstract class Verb {

	protected final String hiragana;

	public Verb(String hiragana) {
		this.hiragana = hiragana;
	}

	public String jishokei() {
		return hiragana;
	}

	// jer ta metoda vec postoji u objektu (nadklasi objekt)
	@Override
	public String toString() {
		return hiragana;
	}

	// ne moze postojat kao konkretna klasa, ru i u imaju stem, sad ce svaka
	// nova klasa glagola trazit da imamo stem
	public abstract String stem();

	public String stemNegative() {
		return stem();
	}

	public String trimVerb() {
		return hiragana.substring(0, hiragana.length() - 1);
	}

	public String lastLetter() {
		return String.valueOf(hiragana.charAt(hiragana.length() - 1));
	}

	public String masu() {
		return stem() + "ます";
	}

	public String masen() {
		return stem() + "ません";
	}

	public String masenka() {
		return masen() + "か";
	}

	public String mashou() {
		return stem() + "ましょう";
	}

	public String niIku() {
		return stem() + "にいきます";
	}

	public String niKita() {
		return stem() + "にきました";
	}

	public String niKaeru() {
		return stem() + "にかえります";
	}

	public String teForm() {
		return stem() + "て";
	}

	public String teKudasai() {
		return teForm() + "ください";
	}

	public String teMoIi() {
		return teForm() + "もいい";
	}

	public String nakuteMoIi() {
		String verb = shortNegative();
		return verb.substring(0, verb.length() - 1) + "くてもいい";
	}

	public String teWaIkenai() {
		return teForm() + "はいけません";
	}

	public String shortPast() {
		String verb = teForm();
		char verbEnd = verb.charAt(verb.length() - 1);
		String verbT = verb.substring(0, verb.length() - 1);
		if (verbEnd == 'て')
			verb = verbT.concat("た");
		else if (verbEnd == 'で')
			verb = verbT.concat("だ");
		return verb;

	}

	public String taHougaIi() {
		return shortPast() + "ほうがいい";
	}

	public String naiHougaIi() {
		return shortNegative() + "ほうがいい";
	}

	public String shortNegative() {
		return stemNegative() + "ない";
	}

	public String pleaseDont() {
		return shortNegative() + "でください";
	}

	public String shortNegPast() {
		return stemNegative() + "なかった";
	}

	public String potential() {
		return null;
	}

	public String potentialMasu() {
		String verb = potential();
		return verb.substring(0, verb.length() - 1) + "ます";
	}

	public String passive() {
		return stemNegative() + "れる";
	}

	public String passiveMasu() {
		String verb = passive();
		return verb.substring(0, verb.length() - 1) + "ます";
	}

	public String causative() {
		return stemNegative() + "せる";
	}

	public String causativeMasu() {
		String verb = causative();
		return verb.substring(0, verb.length() - 1) + "ます";
	}

	public String cauPass() {
		String verb = causative();
		return verb.substring(0, verb.length() - 1) + "られる";
	}

	public String cauPassMasu() {
		String verb = cauPass();
		return verb.substring(0, verb.length() - 1) + "ます";
	}

	public String tai() {
		return stem() + "たい";
	}

	public String takunai() {
		return tai().substring(0, tai().length() - 1) + "くない";
	}

	public String takatta() {
		return tai().substring(0, tai().length() - 1) + "かった";
	}

	public String takunakatta() {
		return tai().substring(0, tai().length() - 1) + "くなかった";
	}

	public String toOmou() {
		return jishokei() + "とおもいます";
	}

	public String naiToOmou() {
		return shortNegative() + "とおもいます";
	}

	public String taToOmou() {
		return shortPast() + "とおもいます";
	}

	public String nakattaToOmou() {
		return shortNegPast() + "とおもいます";
	}

	public String toItteImashita() {
		return jishokei() + "といっていました";
	}

	public String naiToItteImashita() {
		return shortNegative() + "といっていました";
	}

	public String taToItteImashita() {
		return shortPast() + "といっていました";
	}

	public String nakattaToItteImashita() {
		return shortNegPast() + "といっていました";
	}

	public String teIru() {
		return teForm() + "いる";
	}

	public String teImasu() {
		return teForm() + "います";
	}

	public String teIte() {
		return teForm() + "いて";
	}

	public String teIta() {
		return teForm() + "いた";
	}

	public String teImashita() {
		return teForm() + "いました";
	}

	public String teInai() {
		return teForm() + "いない";
	}

	public String teImasen() {
		return teForm() + "いません";
	}

	public String teInakatta() {
		return teForm() + "いなかった";
	}

	public String teImasenDeshita() {
		return teForm() + "いませんでした";
	}

	public String suki() {
		return jishokei() + "のがすきです";
	}

	public String sukijanai() {
		return jishokei() + "のがすきじゃないです";
	}

	public String kirai() {
		return jishokei() + "のがきらいです";
	}

	public String sukidemo() {
		return jishokei() + "のがすきでもきらいでもないです";
	}

	public String tsumori() {
		return jishokei() + "つもりです";
	}

	public String naitsumori() {
		return shortNegative() + "つもりです";
	}

	public String tsumoriDeshita() {
		return jishokei() + "つもりでした";
	}

	public String naiTsumoriDeshita() {
		return shortNegative() + "つもりでした";
	}

	public String kotoAru() {
		return shortPast() + "ことがあります";
	}

	public String kotoNai() {
		return shortPast() + "ことがありません";
	}

	public String tari() {
		return shortPast() + "りします";
	}

	public String tariPast() {
		return shortPast() + "りしました";
	}

	public String sugiru() {
		return stem() + "すぎました";
	}

	public String nakereba() {
		String verb = shortNegative();
		return verb.substring(0, verb.length() - 1) + "ければ";
	}

	public String nakerebaIkemasen() {
		return nakereba() + "いけません";
	}

	public String nakerebaIkenai() {
		return nakereba() + "いけない";
	}

	public String nakuchaIkenai() {
		String verb = shortNegative();
		return verb.substring(0, verb.length() - 1) + "くちゃいけない";
	}

	public String nakyaIkenai() {
		String verb = shortNegative();
		return verb.substring(0, verb.length() - 1) + "きゃいけない";
	}

	public String teMiru() {
		return teForm() + "みる";
	}

	public String teOku() {
		return teForm() + "おく";
	}

	public String teShimau() {
		return teForm() + "しまう";
	}

	public String teMimasu() {
		return teForm() + "みます";
	}

	public String teOkimasu() {
		return teForm() + "おきます";
	}

	public String teShimaimasu() {
		return teForm() + "しまいます";
	}

	public String teMita() {
		return teForm() + "みた";
	}

	public String teOita() {
		return teForm() + "おいた";
	}

	public String teShimatta() {
		return teForm() + "しまった";
	}

	public String teMimashita() {
		return teForm() + "みました";
	}

	public String teOkimashita() {
		return teForm() + "おきました";
	}

	public String teShimaimashita() {
		return teForm() + "しまいました";
	}

	public String kamoShirenai() {
		return jishokei() + "かもしれない";
	}

	public String kamoShiremasen() {
		return jishokei() + "かもしれません";
	}

	public String nara() {
		return jishokei() + "なら";
	}

	public String tara() {
		return shortPast() + "ら";
	}

	public String taraDou() {
		return tara() + "どうですか";
	}

	public String youou() {
		return null;
	}

	public String yououToOmou() {
		return youou() + "とおもいます";
	}

	public String teAgeru() {
		return teForm() + "あげる";
	}

	public String teMorau() {
		return teForm() + "もらう";
	}

	public String teKureru() {
		return teForm() + "くれる";
	}

	public String teAgemasu() {
		return teForm() + "あげます";
	}

	public String teMoraimasu() {
		return teForm() + "もらいます";
	}

	public String teKuremasu() {
		return teForm() + "くれます";
	}

	public String teAgeta() {
		return teForm() + "あげた";
	}

	public String teMoratta() {
		return teForm() + "もらった";
	}

	public String teKureta() {
		return teForm() + "くれた";
	}

	public String teAgemashita() {
		return teForm() + "あげました";
	}

	public String teMoraimashita() {
		return teForm() + "もらいました";
	}

	public String teKuremashita() {
		return teForm() + "くれました";
	}

	public String baKondicional() {
		return null;
	}

	public String baYokatta() {
		return baKondicional() + "よかった";
	}

	public String nakerebaYokatta() {
		return nakereba() + "よかった";
	}

	public String nagara() {
		return stem() + "ながら";
	}

	public String kata() {
		return stem() + "かた";
	}

	public String yasui() {

		return stem() + "やすい";
	}

	public String nikui() {
		return stem() + "にくい";
	}

}
