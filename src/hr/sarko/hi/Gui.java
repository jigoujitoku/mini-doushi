package hr.sarko.hi;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Gui implements ItemListener, KeyListener {

	// varijable klase
	JFrame frame = new JFrame();
	JMenuBar menubar = new JMenuBar();
	JPanel panel = new JPanel();
	String report;
	double tocnih;
	double ukupno;

	Verb glagolR;
	Adjective pridjevR;
	WrapperGlagoli.Wrapper oblikR;
	WrapperPridjevi.Wrapper oblikPR;
	public static String odgovor;
	public static int glagolLevel = 1;
	public static int pridjevLevel = 1;
	public static int vrijemeLevel = 1;
	public static int vrijemeLevelP = 1;
	public static boolean levelChange = false;
	public static boolean levelChangeP = false;
	public static boolean glagolMode = true;
	String previousInput = "";

	static JLabel glagol;
	static JLabel tense;
	JLabel feedback;
	static JTextField text;

	// definirani fontovi
	Font large = new Font("Serif", Font.BOLD, 26);
	Font midi = new Font("MSGothic", Font.PLAIN, 14);

	{
		frame.setLocation(200, 100);
		frame.setSize(500, 200);
		frame.setTitle("Mini Doushi v1.5 - vježbanje japanskih glagola i pridjeva");
		URL url = Gui.class.getResource("/icon.png");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(url));

		JMenu odabirGlagola = new JMenu("Glagoli");
		menubar.add(odabirGlagola);
		JCheckBoxMenuItem level1 = new JCheckBoxMenuItem("Genki Lesson 3");
		JCheckBoxMenuItem level2 = new JCheckBoxMenuItem("Genki Lesson 4/5");
		JCheckBoxMenuItem level3 = new JCheckBoxMenuItem("Genki Lesson 6");
		JCheckBoxMenuItem level4 = new JCheckBoxMenuItem("Genki Lesson 7/8");
		JCheckBoxMenuItem level5 = new JCheckBoxMenuItem("Genki Lesson 9/10");
		JCheckBoxMenuItem level6 = new JCheckBoxMenuItem("Genki Lesson 11/12");
		JCheckBoxMenuItem level7 = new JCheckBoxMenuItem("Genki Lesson 13/14");
		JCheckBoxMenuItem level8 = new JCheckBoxMenuItem("Genki Lesson 15/16");
		JCheckBoxMenuItem level9 = new JCheckBoxMenuItem("Genki Lesson 17");
		JCheckBoxMenuItem level10 = new JCheckBoxMenuItem("Genki Lesson 18");
		JCheckBoxMenuItem level11 = new JCheckBoxMenuItem("Genki Lesson 19");
		JCheckBoxMenuItem level12 = new JCheckBoxMenuItem("Genki Lesson 20/21");
		JCheckBoxMenuItem level13 = new JCheckBoxMenuItem("Genki Lesson 22/23");
		JCheckBoxMenuItem level14 = new JCheckBoxMenuItem("Iznimke");
		JCheckBoxMenuItem level15 = new JCheckBoxMenuItem("Honorifici - lekcije 19 i 20");
		JCheckBoxMenuItem sve = new JCheckBoxMenuItem("Odaberi sve");
		JCheckBoxMenuItem nista = new JCheckBoxMenuItem("Resetiraj");
		odabirGlagola.add(level1);
		odabirGlagola.add(level2);
		odabirGlagola.add(level3);
		odabirGlagola.add(level4);
		odabirGlagola.add(level5);
		odabirGlagola.add(level6);
		odabirGlagola.add(level7);
		odabirGlagola.add(level8);
		odabirGlagola.add(level9);
		odabirGlagola.add(level10);
		odabirGlagola.add(level11);
		odabirGlagola.add(level12);
		odabirGlagola.add(level13);
		odabirGlagola.add(level14);
		odabirGlagola.add(level15);
		odabirGlagola.add(sve);
		odabirGlagola.add(nista);
		// metoda randomizeGlagol u sebi bira koje glagole ucitava
		dodavanjeMenija(level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11,
				level12, level13, level14, level15, sve, nista);

		JMenu odabirVremena = new JMenu("Gramatika (Genki 1)");
		menubar.add(odabirVremena);
		JMenuItem masu = new JMenuItem("Pristojne forme (masu) - lekcije 3,4 ");
		JMenuItem teform = new JMenuItem("Te-forma - lekcija 6");
		JMenuItem modal = new JMenuItem("Moliti, smjeti, biti zabranjeno - lekcija 6");
		JMenuItem niiku = new JMenuItem("Ići napraviti - lekcija 7");
		JMenuItem teiru = new JMenuItem("Trajanje ili stanje nakon promjene - lekcija 7");
		JMenuItem shorty = new JMenuItem("Kratke forme - lekcije 8,9");
		JMenuItem omouitte = new JMenuItem("Mislim da, reče da - lekcija 8");
		JMenuItem suki = new JMenuItem("Volim-ne volim raditi - lekcija 8");
		JMenuItem tsumori = new JMenuItem("Namjeravati (tsumori) - lekcija 10");
		JMenuItem wish = new JMenuItem("Željeti - lekcija 11");
		JMenuItem kotoaru = new JMenuItem("Iskustvo - lekcija 11");
		JMenuItem tari = new JMenuItem("Tari shimasu - lekcija 11");
		JMenuItem sugiru = new JMenuItem("Pretjerati (sugiru) - lekcija 12");
		JMenuItem naide = new JMenuItem("Nemoj, preporuka - lekcija 8, 12");
		JMenuItem nakucha = new JMenuItem("Morati - lekcija 12");
		odabirVremena.add(masu);
		odabirVremena.add(teform);
		odabirVremena.add(modal);
		odabirVremena.add(niiku);
		odabirVremena.add(teiru);
		odabirVremena.add(shorty);
		odabirVremena.add(omouitte);
		odabirVremena.add(suki);
		odabirVremena.add(tsumori);
		odabirVremena.add(wish);
		odabirVremena.add(kotoaru);
		odabirVremena.add(tari);
		odabirVremena.add(sugiru);
		odabirVremena.add(naide);
		odabirVremena.add(nakucha);
		dodavanjeVremena(masu, teform, modal, niiku, teiru, shorty, omouitte, suki, tsumori, wish, kotoaru, tari,
				sugiru, naide, nakucha);

		JMenu odabirVremena2 = new JMenu("Gramatika (Genki 2)");
		menubar.add(odabirVremena2);
		JMenuItem potent = new JMenuItem("Potencijalni glagoli (moći) - lekcija 13 ");
		JMenuItem temiru = new JMenuItem("Pokušati, unaprijed napraviti, slučajno napraviti - lekcije 13, 15 i 18");
		JMenuItem kamo = new JMenuItem("Možda - lekcija 14");
		JMenuItem tara = new JMenuItem("Kondicional -tara - lekcije 14 i 17");
		JMenuItem ajmo = new JMenuItem("Ajmo, namjeravam - lekcija 15");
		JMenuItem teprimanje = new JMenuItem("Činjenje i primanje usluga (te-ageru, kureru, morau) - lekcija 16");
		JMenuItem nakutemoii = new JMenuItem("Ne moraš - lekcija 17");
		JMenuItem bayokatta = new JMenuItem("Da sam (barem) - lekcija 18");
		JMenuItem nagarakata = new JMenuItem("Dok radim X, Y (nagara), kako ići (kata) - lekcije 18 i 23");
		JMenuItem yasuinikui = new JMenuItem("Lako/teško za napraviti - lekcija 20");
		JMenuItem pasiv = new JMenuItem("Pasiv - lekcija 21");
		JMenuItem kauzativ = new JMenuItem("Kauzativ - lekcija 22");
		JMenuItem paskau = new JMenuItem("Pasiv-kauzativ - lekcija 23");
		odabirVremena2.add(potent);
		odabirVremena2.add(temiru);
		odabirVremena2.add(kamo);
		odabirVremena2.add(tara);
		odabirVremena2.add(ajmo);
		odabirVremena2.add(teprimanje);
		odabirVremena2.add(nakutemoii);
		odabirVremena2.add(bayokatta);
		odabirVremena2.add(nagarakata);
		odabirVremena2.add(yasuinikui);
		odabirVremena2.add(pasiv);
		odabirVremena2.add(kauzativ);
		odabirVremena2.add(paskau);
		dodavanjeVremena2(potent, temiru, kamo, tara, ajmo, teprimanje, nakutemoii, bayokatta, nagarakata, yasuinikui,
				pasiv, kauzativ, paskau);

		JMenu adverbs = new JMenu("Pridjevi");
		JCheckBoxMenuItem lvl1 = new JCheckBoxMenuItem("Genki lekcija 5");
		JCheckBoxMenuItem lvl2 = new JCheckBoxMenuItem("Genki lekcija 6/7/9");
		JCheckBoxMenuItem lvl3 = new JCheckBoxMenuItem("Genki lekcija 10/11/12");
		JCheckBoxMenuItem sveP = new JCheckBoxMenuItem("Odaberi sve");
		JCheckBoxMenuItem nistaP = new JCheckBoxMenuItem("Resetiraj");
		JRadioButtonMenuItem tenseP = new JRadioButtonMenuItem("Testiranje vremena - lekcija 5");
		JRadioButtonMenuItem teP = new JRadioButtonMenuItem("Testiranje te-forme -lekcija 7");
		JRadioButtonMenuItem negTeP = new JRadioButtonMenuItem("Negativna te-forma (-kunakute / -janakute)");
		JRadioButtonMenuItem narusuruP = new JRadioButtonMenuItem("Postati, učiniti kakvim - lekcije 10 i 21,");
		JRadioButtonMenuItem sousouP = new JRadioButtonMenuItem("Čini se / čujem da - lekcije 13 i 17");
		JRadioButtonMenuItem sugiruP = new JRadioButtonMenuItem("Pretjerano - lekcija 12");
		menubar.add(adverbs);
		adverbs.add(lvl1);
		adverbs.add(lvl2);
		adverbs.add(lvl3);
		adverbs.add(sveP);
		adverbs.add(nistaP);
		adverbs.add(tenseP);
		adverbs.add(teP);
		adverbs.add(negTeP);
		adverbs.add(narusuruP);
		adverbs.add(sousouP);
		adverbs.add(sugiruP);
		dodavanjePridjeva(lvl1, lvl2, lvl3, sveP, nistaP, tenseP, teP, negTeP, narusuruP, sousouP, sugiruP);

		JMenu stats = new JMenu("Statistika");
		JMenuItem view = new JMenuItem("Pogledaj");
		JMenuItem send = new JMenuItem("Pošalji");
		menubar.add(stats);
		stats.add(view);
		stats.add(send);
		view.addActionListener(l -> {
			if (ukupno > 1)
				JOptionPane.showMessageDialog(frame,
						"Točnih odgovora: " + Math.round(tocnih) + "/" + Math.round(ukupno) + "\nUspješnost: "
								+ Math.round((tocnih / ukupno) * 100) + "%",
						"Izvještaj", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame, "Prvo riješite nekoliko zadataka.", "Greška",
						JOptionPane.INFORMATION_MESSAGE);
		});
		send.addActionListener(l -> {
			try {
				SendReport.sendReport(report);
				if (SendReport.done)
					JOptionPane.showMessageDialog(frame,
							"Hvala što ste poslali izvještaj. \nPodaci koje skupljamo su anonimni i koristit će se u svrhe istraživanja \nčestih pogrešaka i poboljšavanja materijala za učenje.",
							"Izvještaj uspješno poslan", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(frame,
							"Izvještaj nije poslan.\nRiješite nekoliko zadataka i pošaljite prije izlaska iz programa.",
							"Greška", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Izvještaj nije poslan.", "Greška",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});

		JMenu pomoc = new JMenu("Pomoć");
		JMenuItem uputa = new JMenuItem("Uputa");
		JMenuItem version = new JMenuItem("Povijest verzija");
		JMenuItem about = new JMenuItem("About");
		menubar.add(pomoc);
		pomoc.add(uputa);
		pomoc.add(version);
		pomoc.add(about);
		about.addActionListener(l -> {
			JOptionPane.showMessageDialog(frame,
					"Ovo je mini-aplikacija za vježbanje japanskih glagola.\nTemelji se na glagolima i gramatici iz udžbenika Genki.\nKomentare i pitanja šaljite na memazija@gmail.com.\nMade in 2016.",
					"Mini Doushi by Memazija", JOptionPane.INFORMATION_MESSAGE);

		});
		version.addActionListener(l -> {
			JOptionPane.showMessageDialog(frame,
					"Verzija 1.5.\n" + "Dodani pridjevi iz Genkija 1. Poboljšani izvještaji:\n"
							+ "- dvostruko slanje popravljeno\n" + "- ne broji rezultat unos ako nema promjene\n\n"
							+ "Verzija 1.4.\n"
							+ "Dodano slanje izvještaja. Sva gramatika i glagoli iz Genki 1 i 2 dodani.\n"
							+ "- spremanje i slanje izvještaja neovisno o platformi",
					"Povijest verzija", JOptionPane.INFORMATION_MESSAGE);
		});

		uputa.addActionListener(l -> {
			JOptionPane.showMessageDialog(frame,
					"0. Odaberi glagole i vremena koja se ispituju. Glagola se može odabrati više odjednom.\n1. Upiši glagol u tekstualno polje.\n2. Stisni ENTER ili pristisni dugme. (Prvi enter je za potvrdu hiragane.)\n3. U slučaju pogrešnog odgovora, točan odgovor se ispisuje ispod.\n4. Prepiši ga i zapamti. \n\nAplikacija sprema statistiku na dnevnoj razini. Zahvaljujemo ako pošaljete izvještaj preko izbornika Statistika kad završite s korištenjem.\n\nNapomena: Može se dogoditi da neka kombinacija glagola i oblika nema smisla po značenju, mada je možda gramatički točna.",
					"Uputa za korištenje", JOptionPane.INFORMATION_MESSAGE);
		});

		frame.setJMenuBar(menubar);// dodajemo izbornike
		try {
			addComponentToPane(frame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dodavanjeVremena(JMenuItem masu, JMenuItem teform, JMenuItem modal, JMenuItem niiku, JMenuItem teiru,
			JMenuItem shorty, JMenuItem omouitte, JMenuItem suki, JMenuItem tsumori, JMenuItem wish, JMenuItem kotoaru,
			JMenuItem tari, JMenuItem sugiru, JMenuItem naide, JMenuItem nakucha) {
		masu.addActionListener(l -> {
			vrijemeLevel = 1;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste nastavke -masu, -masen i -mashou.");
		});
		teform.addActionListener(l -> {
			vrijemeLevel = 2;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje te-forme.");
		});
		modal.addActionListener(l -> {
			vrijemeLevel = 3;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za zamoliti, smjeti ili zabraniti.");
		});
		niiku.addActionListener(l -> {
			vrijemeLevel = 4;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika za ići/doći/vratiti se napraviti nešto.");
		});
		teiru.addActionListener(l -> {
			vrijemeLevel = 5;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika te-iru (trajanje radnje i stanje nakon promjene).");
		});
		shorty.addActionListener(l -> {
			vrijemeLevel = 6;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje kratke forme u prošlosti, negaciji i prošlosti u negaciji.");
		});
		omouitte.addActionListener(l -> {
			vrijemeLevel = 28;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika \"misliti da\" i \"reći da\".");
		});
		naide.addActionListener(l -> {
			vrijemeLevel = 7;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika negativnu zamolbu i preporuku.");
		});
		suki.addActionListener(l -> {
			vrijemeLevel = 8;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za što volite ili ne volite raditi.");
		});
		tsumori.addActionListener(l -> {
			vrijemeLevel = 9;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za namjere (tsumori).");
		});
		wish.addActionListener(l -> {
			vrijemeLevel = 10;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za željeti.");
		});
		kotoaru.addActionListener(l -> {
			vrijemeLevel = 11;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika za iskustvo (jednom sam / nikad nisam).");
		});
		tari.addActionListener(l -> {
			vrijemeLevel = 12;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika za raditi više stvari u nekom periodu (-tari shimasu).");
		});
		sugiru.addActionListener(l -> {
			vrijemeLevel = 13;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika za pretjerivanje u nekoj radnji (sugiru).");
		});
		nakucha.addActionListener(l -> {
			vrijemeLevel = 14;
			levelChange = true;
			glagolMode = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za morati.");
		});
	}

	private void dodavanjeVremena2(JMenuItem potent, JMenuItem temiru, JMenuItem kamo, JMenuItem tara, JMenuItem ajmo,
			JMenuItem teprimanje, JMenuItem nakutemoii, JMenuItem bayokatta, JMenuItem nagarakata, JMenuItem yasuinikui,
			JMenuItem pasiv, JMenuItem kauzativ, JMenuItem paskau) {

		potent.addActionListener(l -> {
			vrijemeLevel = 15;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje potencijalnih oblika (mogu).");
		});
		temiru.addActionListener(l -> {
			vrijemeLevel = 16;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje -te miru, -te oku i -te shimau.");
		});
		kamo.addActionListener(l -> {
			vrijemeLevel = 17;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za \"možda\".");
		});
		tara.addActionListener(l -> {
			vrijemeLevel = 18;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje kondicionala -tara, nara i prijedloga s -tara.");
		});
		ajmo.addActionListener(l -> {
			vrijemeLevel = 19;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje voljnih oblika (-you/ou).");
		});
		teprimanje.addActionListener(l -> {
			vrijemeLevel = 20;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje gramatike za dati/primiti uslugu");
		});
		nakutemoii.addActionListener(l -> {
			vrijemeLevel = 21;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje gramatike za ne morati.");
		});
		bayokatta.addActionListener(l -> {
			vrijemeLevel = 22;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje kondicionala na -ba i izraza \"da sam barem\".");
		});
		nagarakata.addActionListener(l -> {
			vrijemeLevel = 23;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje oblika -nagara (dok radiš jednu stvar, radiš i drugu) i -kata (kako raditi).");
		});
		yasuinikui.addActionListener(l -> {
			vrijemeLevel = 24;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje izraza lako je/ teško je za napraviti.");
		});
		pasiv.addActionListener(l -> {
			vrijemeLevel = 25;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje pasiva, trpnog oblika (-areru odnosno -rareru).");
		});
		kauzativ.addActionListener(l -> {
			vrijemeLevel = 26;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje kauzativa, oblika za učiniti/dozvoliti nekom da radi (-aseru odnosno -saseru).");
		});
		paskau.addActionListener(l -> {
			vrijemeLevel = 27;
			levelChange = true;
			randomizeOblik();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje kauzativnog pasiva, natjerati nekog da radi (-aserareru odnosno -saserareru).");
		});

	}

	private void dodavanjeMenija(JCheckBoxMenuItem level1, JCheckBoxMenuItem level2, JCheckBoxMenuItem level3,
			JCheckBoxMenuItem level4, JCheckBoxMenuItem level5, JCheckBoxMenuItem level6, JCheckBoxMenuItem level7,
			JCheckBoxMenuItem level8, JCheckBoxMenuItem level9, JCheckBoxMenuItem level10, JCheckBoxMenuItem level11,
			JCheckBoxMenuItem level12, JCheckBoxMenuItem level13, JCheckBoxMenuItem level14, JCheckBoxMenuItem level15,
			JCheckBoxMenuItem sve, JCheckBoxMenuItem nista) {
		level1.setSelected(true);
		level1.addActionListener(l -> {
			if (level1.isSelected() == true) {
				glagolLevel = 1;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 1. Odgovara Genki 1 Lesson 3 i sadrži 12 glagola.", "Prva razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level1.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g01.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena prva razina (Lesson 3).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}

		});
		level2.addActionListener(l -> {
			if (level2.isSelected() == true) {
				glagolLevel = 2;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 2. Odgovara Genki 1 Lesson 4/5 i sadrži 12 glagola.", "Druga razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level2.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g02.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena druga razina (Lesson 4/5).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level3.addActionListener(l -> {
			if (level3.isSelected() == true) {
				glagolLevel = 3;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 3. Odgovara Genki 1 Lesson 6 i sadrži 25 glagola.", "Treća razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level3.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g03.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena treća razina (Lesson 6).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}

		});
		level4.addActionListener(l -> {
			if (level4.isSelected() == true) {
				glagolLevel = 4;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 4. Odgovara Genki 1 Lesson 7 i 8 te sadrži 21 glagol.", "Četvrta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level4.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g04.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena četvrta razina (Lesson 7/8).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level5.addActionListener(l -> {
			if (level5.isSelected() == true) {
				glagolLevel = 5;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 5. Odgovara Genki 1 Lesson 9 i 10 te sadrži 14 glagola.", "Peta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level4.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g05.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena peta razina (Lesson 9/10).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level6.addActionListener(l -> {
			if (level6.isSelected() == true) {
				glagolLevel = 6;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 6. Odgovara Genki 1 Lesson 11 i 12 te sadrži 18 glagola.", "Šesta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level6.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g06.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena šesta razina (Lesson 11/12).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level7.addActionListener(l -> {
			if (level7.isSelected() == true) {
				glagolLevel = 7;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 7. Odgovara Genki 2 Lesson 13 i 14 te sadrži 11 glagola.", "Sedma razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level7.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g07.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena sedma razina (Lesson 13/14).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level8.addActionListener(l -> {
			if (level8.isSelected() == true) {
				glagolLevel = 8;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 8. Odgovara Genki 2 Lesson 15 i 16 te sadrži 25 glagola.", "Osma razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level8.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g08.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena osma razina (Lesson 15/16).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level9.addActionListener(l -> {
			if (level9.isSelected() == true) {
				glagolLevel = 9;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 9. Odgovara Genki 2 Lesson 17 te sadrži 11 glagola.", "Deveta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level9.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g09.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena deveta razina (Lesson 17).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level10.addActionListener(l -> {
			if (level10.isSelected() == true) {
				glagolLevel = 10;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 10. Odgovara Genki 2 Lesson 18 te sadrži 19 glagola.", "Deseta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level10.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g10.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena deseta razina (Lesson 18).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level11.addActionListener(l -> {
			if (level11.isSelected() == true) {
				glagolLevel = 11;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 11. Odgovara Genki 2 Lesson 19 i 20 te sadrži 16 glagola - bez honorifika.",
						"Jedanaesta razina", JOptionPane.INFORMATION_MESSAGE);
			}
			if (level11.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g11.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena jedanaesta razina (Lesson 19/20).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level12.addActionListener(l -> {
			if (level12.isSelected() == true) {
				glagolLevel = 12;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 12. Odgovara Genki 2 Lesson 21 te sadrži 22 glagola.", "Dvanaesta razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level12.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g12.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena dvanaesta razina (Lesson 21).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level13.addActionListener(l -> {
			if (level13.isSelected() == true) {
				glagolLevel = 13;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 12. Odgovara Genki 2 Lesson 22 i 23 te sadrži 23 glagola.",
						"Trinaesta razina", JOptionPane.INFORMATION_MESSAGE);
			}
			if (level13.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g13.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena trinaesta razina (Lesson 22/23).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level14.addActionListener(l -> {
			if (level14.isSelected() == true) {
				glagolLevel = 14;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 14. Sadrži nepravilne glagole. Svi glagoli oblika imenica + suru spadaju pod ovu skupinu, kao i sve kombinacije koje završavaju na -kuru.",
						"Iznimke", JOptionPane.INFORMATION_MESSAGE);
			}
			if (level14.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g14.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena četrnaesta razina (Iznimke).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		level15.addActionListener(l -> {
			if (level15.isSelected() == true) {
				glagolLevel = 15;
				levelChange = true;
				glagolMode = true;
				randomizeGlagol();
				glagol.setText(glagolR.hiragana);
				tense.setText(oblikR.name);
				text.setText("");
				getOdgovor();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 15. Sadrži honorifike i skromne izraze (lekcije 19 i 20).", "Iznimke",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (level15.isSelected() == false) {
				try {
					Drugi.verbList.removeAll(DiskOperations.readLines("g15.txt"));
					randomizeGlagol();
					glagol.setText(glagolR.hiragana);
					tense.setText(oblikR.name);
					text.setText("");
					getOdgovor();
					JOptionPane.showMessageDialog(feedback, "Isključena petnaesta razina (honorifici i skromni govor).",
							"Info", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					level1.setSelected(true);
				}
			}
		});
		sve.addActionListener(l -> {
			level1.setSelected(true);
			level2.setSelected(true);
			level3.setSelected(true);
			level4.setSelected(true);
			level5.setSelected(true);
			level6.setSelected(true);
			level7.setSelected(true);
			level8.setSelected(true);
			level9.setSelected(true);
			level10.setSelected(true);
			level11.setSelected(true);
			level12.setSelected(true);
			level12.setSelected(true);
			level13.setSelected(true);
			level14.setSelected(true);
			level15.setSelected(true);
			sve.setSelected(false);
			glagolMode = true;
			try {
				for (int i = 1; i < 10; i++) {
					String name = "g0" + i + ".txt";
					Drugi.verbList.addAll(DiskOperations.readLines(name));
				}
				for (int i = 10; i <= 15; i++) {
					String name = "g" + i + ".txt";
					Drugi.verbList.addAll(DiskOperations.readLines(name));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			randomizeGlagol();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
		});
		nista.addActionListener(l -> {
			level1.setSelected(true);
			level2.setSelected(false);
			level3.setSelected(false);
			level4.setSelected(false);
			level5.setSelected(false);
			level6.setSelected(false);
			level7.setSelected(false);
			level8.setSelected(false);
			level9.setSelected(false);
			level10.setSelected(false);
			level11.setSelected(false);
			level12.setSelected(false);
			level12.setSelected(false);
			level13.setSelected(false);
			level14.setSelected(false);
			level15.setSelected(false);
			sve.setSelected(false);
			nista.setSelected(false);
			glagolMode = true;
			try {
				Drugi.verbList.addAll(DiskOperations.readLines("g01.txt"));
				for (int i = 2; i < 10; i++) {
					String name = "g0" + i + ".txt";
					Drugi.verbList.removeAll(DiskOperations.readLines(name));
				}
				for (int i = 10; i <= 15; i++) {
					String name = "g" + i + ".txt";
					Drugi.verbList.removeAll(DiskOperations.readLines(name));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			randomizeGlagol();
			glagol.setText(glagolR.hiragana);
			tense.setText(oblikR.name);
			text.setText("");
			getOdgovor();
		});
	}

	private void dodavanjePridjeva(JCheckBoxMenuItem lvl1, JCheckBoxMenuItem lvl2, JCheckBoxMenuItem lvl3,
			JCheckBoxMenuItem sveP, JCheckBoxMenuItem nistaP, JRadioButtonMenuItem tenseP, JRadioButtonMenuItem teP,
			JRadioButtonMenuItem negTeP, JRadioButtonMenuItem narusuruP, JRadioButtonMenuItem sousouP,
			JRadioButtonMenuItem sugiruP) {

		lvl1.setSelected(false);
		tenseP.setSelected(true);
		lvl1.addActionListener(l -> {
			if (lvl1.isSelected() == true) {
				pridjevLevel = 1;
				levelChangeP = true;
				glagolMode = false;
				randomizeOblikP();
				randomizePridjev();
				glagol.setText(pridjevR.hiragana);
				tense.setText(oblikPR.name);
				text.setText("");
				getOdgovorP();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 1. Odgovara Genki 1 Lesson 5 i sadrži 24 pridjeva.", "Prva razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (lvl1.isSelected() == false) {
				try {
					Drugi.adjectiveList.removeAll(DiskOperations.readLines("p01.txt"));
					randomizePridjev();
					glagol.setText(pridjevR.hiragana);
					tense.setText(oblikPR.name);
					text.setText("");
					getOdgovorP();
					JOptionPane.showMessageDialog(feedback, "Isključena prva razina (Lesson 5).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					lvl1.setSelected(true);
				}
			}
		});

		lvl2.addActionListener(l -> {
			if (lvl2.isSelected() == true) {
				pridjevLevel = 2;
				levelChangeP = true;
				glagolMode = false;
				randomizeOblikP();
				randomizePridjev();
				glagol.setText(pridjevR.hiragana);
				tense.setText(oblikPR.name);
				text.setText("");
				getOdgovorP();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 2. Odgovara Genki 1 Lesson 6/7/8 i sadrži 14 pridjeva.", "Druga razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (lvl2.isSelected() == false) {
				try {
					Drugi.adjectiveList.removeAll(DiskOperations.readLines("p02.txt"));
					randomizePridjev();
					glagol.setText(pridjevR.hiragana);
					tense.setText(oblikPR.name);
					text.setText("");
					getOdgovorP();
					JOptionPane.showMessageDialog(feedback, "Isključena druga razina (Lesson 6/7/8).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					lvl2.setSelected(true);
				}
			}
		});

		lvl3.addActionListener(l -> {
			if (lvl3.isSelected() == true) {
				pridjevLevel = 3;
				levelChangeP = true;
				glagolMode = false;
				randomizeOblikP();
				randomizePridjev();
				glagol.setText(pridjevR.hiragana);
				tense.setText(oblikPR.name);
				text.setText("");
				getOdgovorP();
				JOptionPane.showMessageDialog(feedback,
						"Odabrali ste razinu 3. Odgovara Genki 1 Lesson 10/11/12 i sadrži 20 pridjeva.", "Treća razina",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (lvl3.isSelected() == false) {
				try {
					Drugi.adjectiveList.removeAll(DiskOperations.readLines("p03.txt"));
					randomizePridjev();
					glagol.setText(pridjevR.hiragana);
					tense.setText(oblikPR.name);
					text.setText("");
					getOdgovorP();
					JOptionPane.showMessageDialog(feedback, "Isključena treća razina (Lesson 10/11/12).", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(feedback,
							"Nemoguće isključiti. Mora biti odabrana barem jedna razina.", "Greška",
							JOptionPane.INFORMATION_MESSAGE);
					lvl3.setSelected(true);
				}
			}
		});

		sveP.addActionListener(l -> {
			lvl1.setSelected(true);
			lvl2.setSelected(true);
			lvl3.setSelected(true);
			sveP.setSelected(false);
			glagolMode = false;
			randomizeOblikP();
			randomizePridjev();
			nistaP.setSelected(false);
			try {
				for (int i = 1; i < 4; i++) {
					String name = "p0" + i + ".txt";
					Drugi.adjectiveList.addAll(DiskOperations.readLines(name));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
		});

		nistaP.addActionListener(l -> {
			lvl1.setSelected(true);
			lvl2.setSelected(false);
			lvl3.setSelected(false);
			sveP.setSelected(false);
			glagolMode = false;
			randomizeOblikP();
			randomizePridjev();
			nistaP.setSelected(false);
			try {
				for (int i = 2; i < 4; i++) {
					String name = "p0" + i + ".txt";
					Drugi.adjectiveList.removeAll(DiskOperations.readLines(name));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
		});

		tenseP.addActionListener(l -> {
			vrijemeLevelP = 1;
			levelChange = true;
			glagolMode = false;
			teP.setSelected(false);
			negTeP.setSelected(false);
			sousouP.setSelected(false);
			narusuruP.setSelected(false);
			sugiruP.setSelected(false);
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje prošlosti, negacije i negativne prošlosti kod pridjeva.");
		});

		teP.addActionListener(l -> {
			vrijemeLevelP = 2;
			levelChange = true;
			glagolMode = false;
			tenseP.setSelected(false);
			negTeP.setSelected(false);
			sousouP.setSelected(false);
			narusuruP.setSelected(false);
			sugiruP.setSelected(false);
			randomizePridjev();
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje te-forme kod pridjeva.");
		});
		negTeP.addActionListener(l -> {
			vrijemeLevelP = 3;
			levelChange = true;
			glagolMode = false;
			tenseP.setSelected(false);
			teP.setSelected(false);
			sousouP.setSelected(false);
			narusuruP.setSelected(false);
			sugiruP.setSelected(false);
			randomizePridjev();
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje negativne te-forme kod pridjeva.");
		});
		narusuruP.addActionListener(l -> {
			vrijemeLevelP = 4;
			levelChange = true;
			glagolMode = false;
			tenseP.setSelected(false);
			teP.setSelected(false);
			negTeP.setSelected(false);
			sousouP.setSelected(false);
			sugiruP.setSelected(false);
			randomizePridjev();
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame,
					"Odabrali ste testiranje priloga od pridjeva, postati / učiniti kakvim.");
		});
		sousouP.addActionListener(l -> {
			vrijemeLevelP = 5;
			levelChange = true;
			glagolMode = false;
			tenseP.setSelected(false);
			teP.setSelected(false);
			negTeP.setSelected(false);
			narusuruP.setSelected(false);
			sugiruP.setSelected(false);
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje oblika za: čini mi se/izgleda/čujem da.");
		});
		sugiruP.addActionListener(l -> {
			vrijemeLevelP = 6;
			levelChange = true;
			glagolMode = false;
			tenseP.setSelected(false);
			teP.setSelected(false);
			negTeP.setSelected(false);
			sousouP.setSelected(false);
			narusuruP.setSelected(false);
			randomizePridjev();
			randomizeOblikP();
			glagol.setText(pridjevR.hiragana);
			tense.setText(oblikPR.name);
			text.setText("");
			getOdgovorP();
			JOptionPane.showMessageDialog(frame, "Odabrali ste testiranje nastavka -sugiru (pretjerati).");
		});
	}

	private String randomizeGlagol() {
		glagolR = Drugi.glagolRandom();
		return glagolR.hiragana;
	}

	private void randomizePridjev() {
		pridjevR = Drugi.pridjevRandom();
	}

	private void randomizeOblik() {
		oblikR = Drugi.oblikRandom();
	}

	private void randomizeOblikP() {
		oblikPR = Drugi.oblikRandomP();
	}

	private void getOdgovor() {
		odgovor = oblikR.tense.apply(glagolR);
	}

	private void getOdgovorP() {
		odgovor = oblikPR.tense.apply(pridjevR);
	}

	public void addComponentToPane(Container pane) throws IOException {

		// uzimaju novi glagol i tense iz metode
		glagol = new JLabel();
		glagol.setFont(large);

		tense = new JLabel();
		feedback = new JLabel();
		feedback.setFont(midi);

		randomizeGlagol();
		randomizeOblik();
		getOdgovor();

		feedback.setText("Upiši odgovor.");
		glagol.setText(glagolR.hiragana);
		tense.setText(oblikR.name);

		text = new JTextField(20);
		text.setFont(large);

		JButton button = new JButton("Provjera");
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					button.doClick();
			}
		});

		panel.add(tense);
		panel.add(glagol);
		panel.add(text);
		panel.add(button);
		panel.add(feedback);
		// frame.pack();

		// sad idemo definirati ponasanje
		feedback.setText("Upiši odgovor.");
		button.addActionListener(l -> {
			if (previousInput.equals(text.getText()) || text.getText().equals("")) {
				feedback.setText("Odgovor je: " + odgovor);
			} else {
				ukupno++;
				// OVDJE ĆEMO SPREMATI ODGOVORE
				try {
					report = SendReport.writeReport(SendReport.createFile());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				if (text.getText().equals(odgovor)) {
					feedback.setText("Točno.");
					if (glagolMode == true) {
						randomizeGlagol();
						randomizeOblik();
						getOdgovor();
						glagol.setText(glagolR.hiragana);
						tense.setText(oblikR.name);
					} else {
						randomizePridjev();
						randomizeOblikP();
						getOdgovorP();
						glagol.setText(pridjevR.hiragana);
						tense.setText(oblikPR.name);
					}
					text.setText("");
					tocnih++;

				}
				previousInput = text.getText();
			}

		});

		// Create and set up the content pane.
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) {
		}

		SwingUtilities.invokeLater(() -> new Gui());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}