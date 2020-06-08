package hr.sarko.hi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Drugi {

	public static List<String> verbList;
	public static List<String> adjectiveList;

	static {
		try {
			switch (Gui.glagolLevel) {
			case 1:
				verbList = DiskOperations.readLines("g01.txt");
				adjectiveList = DiskOperations.readLines("p01.txt");
				break;
			}
			switch (Gui.pridjevLevel) {
			case 1:
				verbList = DiskOperations.readLines("g01.txt");
				adjectiveList = DiskOperations.readLines("p01.txt");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void promjenaLevela() {
		if (Gui.levelChange == true)
			try {
				switch (Gui.glagolLevel) {
				case 1:
					verbList.addAll(DiskOperations.readLines("g01.txt"));
					break;
				case 2:
					verbList.addAll(DiskOperations.readLines("g02.txt"));
					break;
				case 3:
					verbList.addAll(DiskOperations.readLines("g03.txt"));
					break;
				case 4:
					verbList.addAll(DiskOperations.readLines("g04.txt"));
					break;
				case 5:
					verbList.addAll(DiskOperations.readLines("g05.txt"));
					break;
				case 6:
					verbList.addAll(DiskOperations.readLines("g06.txt"));
					break;
				case 7:
					verbList.addAll(DiskOperations.readLines("g07.txt"));
					break;
				case 8:
					verbList.addAll(DiskOperations.readLines("g08.txt"));
					break;
				case 9:
					verbList.addAll(DiskOperations.readLines("g09.txt"));
					break;
				case 10:
					verbList.addAll(DiskOperations.readLines("g10.txt"));
					break;
				case 11:
					verbList.addAll(DiskOperations.readLines("g11.txt"));
					break;
				case 12:
					verbList.addAll(DiskOperations.readLines("g12.txt"));
					break;
				case 13:
					verbList.addAll(DiskOperations.readLines("g13.txt"));
					break;
				case 14:
					verbList.addAll(DiskOperations.readLines("g14.txt"));
					break;
				case 15:
					verbList.addAll(DiskOperations.readLines("g15.txt"));
					break;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Gui.levelChange = false;
	}

	public static void promjenaLevelaP() throws IOException {
		if (Gui.levelChangeP == true)
			switch (Gui.pridjevLevel) {
			case 1:
				adjectiveList.addAll(DiskOperations.readLines("p01.txt"));
				try {
					for (int i = 2; i < 10; i++) {
						String name = "g0" + i + ".txt";
						verbList.removeAll(DiskOperations.readLines(name));
					}
					for (int i = 10; i <= 15; i++) {
						String name = "g" + i + ".txt";
						verbList.removeAll(DiskOperations.readLines(name));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				adjectiveList.addAll(DiskOperations.readLines("p02.txt"));
			case 3:
				adjectiveList.addAll(DiskOperations.readLines("p03.txt"));
				break;

			}
		Gui.levelChangeP = false;

	}

	public static List<Verb> listaGlagola() {
		List<Verb> list = new ArrayList<Verb>();
		promjenaLevela();
		for (String element : verbList) {
			Verb verb = Iznimke.mapaGlagola().get(element);
			if (verb == null) {
				char scndLastLetter = element.charAt(element.length() - 2);
				if (String.valueOf(element.charAt(element.length() - 1)).equals("る")
						&& (Hiragana.hiraganaE.contains(String.valueOf(scndLastLetter))
								|| Hiragana.hiraganaI.contains(String.valueOf(scndLastLetter)))) {
					Verb verbo = new RuVerb(element);
					list.add(verbo);
				} else {
					Verb verbo = new Uverb(element);
					list.add(verbo);
				}
			} else
				list.add(verb);
		}
		return list;
	}

	// ovdje određujemo je li I ili NA pridjev
	// iznimke su unesene posebno
	public static List<Adjective> listaPridjeva() {
		List<Adjective> list = new ArrayList<Adjective>();
		try {
			promjenaLevelaP();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String element : adjectiveList) {
			Adjective adj = IznimkeP.mapaPridjeva().get(element);
			if (adj == null) {
				if (String.valueOf(element.charAt(element.length() - 1)).equals("い")) {
					Adjective ajd = new IAdjective(element);
					list.add(ajd);
				} else {
					Adjective ajd = new NaAdjective(element);
					list.add(ajd);
				}
			} else
				list.add(adj);
		}
		return list;

	}

	// daje randomoblik GLAGOLA
	public static WrapperGlagoli.Wrapper oblikRandom() {
		ArrayList<WrapperGlagoli.Wrapper> temp = new ArrayList<WrapperGlagoli.Wrapper>();
		Random random = new Random();
		WrapperGlagoli.init();
		int indeksO = random.nextInt(WrapperGlagoli.tenses.size());
		WrapperGlagoli.Wrapper randomOblik = WrapperGlagoli.tenses.get(indeksO);
		return randomOblik;
	}

	// daje random oblik PRIDJEVA
	public static WrapperPridjevi.Wrapper oblikRandomP() {
		Random random = new Random();
		WrapperPridjevi.init();
		int indeksO = random.nextInt(WrapperPridjevi.tenses.size());
		WrapperPridjevi.Wrapper randomOblik = WrapperPridjevi.tenses.get(indeksO);
		return randomOblik;
	}

	// vuče random glagol od učitanih
	public static Verb glagolRandom() {
		Random randy = new Random();
		int indeksV = randy.nextInt(listaGlagola().size());
		Verb randomGlagol = listaGlagola().get(indeksV);
		return randomGlagol;
	}

	public static Adjective pridjevRandom() {
		Random randy = new Random();
		int indeksV = randy.nextInt(listaPridjeva().size());
		Adjective randomP = listaPridjeva().get(indeksV);
		return randomP;
	}

	private static void ocjenaUnosa() {
		Verb glagolR = glagolRandom();
		WrapperGlagoli.Wrapper oblikR = oblikRandom();
		String line = "";
		System.out.println("Glagol: " + glagolR + "\t Oblik: " + oblikR.name);
		while (!line.equals(oblikR.tense.apply(glagolR))) {
			Scanner scanner = new Scanner(System.in);
			line = scanner.nextLine();
			if (!line.equals(oblikR.tense.apply(glagolR)))
				System.out.println("Netočno.");
		}
		System.out.println("Odlično.");
	}

}