package secretSanta;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class SecretSanta {

	private static Scanner sc;
	private static List<String> noms;
	private static List<String> dejaVu;
	private static Random random;
	private static String str;

	public static void genererChoix(List<String> liste1, List<String> liste2) {
		int i;
		for (String string : liste1) {
			i = random.nextInt(liste2.size());
			while ((string.equals(liste2.get(i))))
				i = random.nextInt(liste2.size());
			System.out.println(string + " doit trouver un cadeau pour " + liste2.get(i));
			liste2.remove(i);
		}
	}

	public static void demanderNoms(String str, Scanner sc, List<String> liste) {
		System.out.println("Entrer le nom d'une persone ou laisser vide pour valider : ");
		str = sc.nextLine();
		liste.add(str);
		while (!(str.isEmpty())) {
			System.out.println("Entrer le nom d'une persone ou laisser vide pour valider : ");
			str = sc.nextLine();
			if (!(str.isEmpty()))
				liste.add(str);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		noms = new ArrayList<>();
		dejaVu = new ArrayList<>();
		random = new Random();
		demanderNoms(str, sc, noms);
		sc.close();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		dejaVu.addAll(noms);
		genererChoix(noms, dejaVu);
	}
}