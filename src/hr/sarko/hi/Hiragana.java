package hr.sarko.hi;

public class Hiragana {

	static final String hiraganaU = "うくぐすつぬむるぶ";
	static final String hiraganaE = "えけげせぜてでねめへべぺれ";
	static final String hiraganaI = "いきぎしじりちぴびひぢみに";

	private static final char[][] hiraganaTable = { { 'あ', 'い', 'う', 'え', 'お' }, { 'か', 'き', 'く', 'け', 'こ' },
			{ 'が', 'ぎ', 'ぐ', 'げ', 'ご' }, { 'さ', 'し', 'す', 'せ', 'そ' }, { 'ざ', 'じ', 'ず', 'ぜ', 'ぞ' },
			{ 'た', 'ち', 'つ', 'て', 'と' }, { 'だ', 'ぢ', 'づ', 'で', 'ど' }, { 'は', 'ひ', 'ふ', 'へ', 'ほ' },
			{ 'ば', 'び', 'ぶ', 'べ', 'ぼ' }, { 'ぱ', 'ぴ', 'ぷ', 'ぺ', 'ぽ' }, { 'ま', 'み', 'む', 'め', 'も' },
			{ 'な', 'に', 'ぬ', 'ね', 'の' }, { 'ら', 'り', 'る', 'れ', 'ろ' }, };

	// mijenja zadnje slovo u odgovarajuce iz istog reda katakane, vraća string
	public static String hiraganaTransform(char verbEnd, int s1, int s2) {
		for (int red = 0; red < hiraganaTable.length; red++)
			if (verbEnd == hiraganaTable[red][s1]) {
				verbEnd = hiraganaTable[red][s2];
			}
		return String.valueOf(verbEnd);

	}

}

// ne s brojkama