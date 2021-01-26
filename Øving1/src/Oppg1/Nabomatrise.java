package Oppg1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nabomatrise implements Graf {

	private int n;
	private int m;
	private boolean[][] matrise;

	private HashMap<String, Integer> nodenavn;
	private String[] navn;

	public String[] getNavn() {
		return navn;
	}

	public Nabomatrise(String[] navnPaaNoder) {
		n = navnPaaNoder.length;
		m = 0;
		matrise = new boolean[n][n];
		navn = navnPaaNoder;

		nodenavn = new HashMap<String, Integer>(n);
		for (int i = 0; i < n; i++) {
			nodenavn.put(navn[i], i);
		}
	}

	@Override
	public int getAntallNoder() {

		return n;
	}

	@Override
	public int getAntallKanter() {

		return m;
	}

	@Override
	public List<String> alleNoder() {
		ArrayList<String> liste = new ArrayList<>();
		for (String v : navn) {
			liste.add(v);
		}
		return liste;
	}

	@Override
	public boolean erNaboer(String u, String v) {
		int iu = nodenavn.get(u);
		int iv = nodenavn.get(v);
		return matrise[iu][iv];
	}

	@Override
	public boolean leggTilNode(String w) {

		if (!nodenavn.containsKey(w)) {
			nodenavn.put(w, n);
			n++;

			String[] nyNavn = new String[n];
			for (int i = 0; i < navn.length; i++) {
				nyNavn[i] = navn[i];
			}
			navn = nyNavn;
			navn[n - 1] = w;

			boolean[][] nyMatrise = new boolean[n][n];
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					nyMatrise[i][j] = matrise[i][j];
				}
			}
			matrise = nyMatrise;

			return true;
		}
		return false;

	}

	@Override
	public boolean leggTilKant(String u, String v) {
		List<String> listen = alleNoder();
		if (((listen.contains(u)) && (listen.contains(v))) && !erNaboer(u, v)) {
			int iu = nodenavn.get(u);
			int iv = nodenavn.get(v);
			matrise[iu][iv] = true;
			matrise[iv][iu] = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean leggTilKanter(String w, String[] naboer) {

		for (int i = 0; i < naboer.length; i++) {
			boolean nabo = erNaboer(w, naboer[i]);

			if (nabo) {
				return false;
			}
		}

		for (int i = 0; i < naboer.length; i++) {
			leggTilKant(w, naboer[i]);
		}

		return true;

	}

	@Override
	public boolean fjern(String u, String v) {
		List<String> listen = alleNoder();
		if (((listen.contains(u)) && (listen.contains(v))) && erNaboer(u, v)) {
			int iu = nodenavn.get(u);
			int iv = nodenavn.get(v);
			matrise[iu][iv] = false;
			matrise[iv][iu] = false;
			return true;
		}
		return false;
	}

	@Override
	public List<String> getNaboer(String w) {
		ArrayList<String> listen = new ArrayList<>();
		int iw = nodenavn.get(w);

		for (int i = 0; i < nodenavn.size(); i++) {
			if (matrise[iw][i]) {
				listen.add(navn[i]);
			}
		}
		return listen;
	}

}
