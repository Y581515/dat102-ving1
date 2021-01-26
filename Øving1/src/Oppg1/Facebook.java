package Oppg1;

import java.util.List;

public class Facebook {
	private String gruppeNavn;
	public Nabomatrise g;
	
	public Facebook(String navnPaaGruppe, String[] navn) {
		this.gruppeNavn=navnPaaGruppe;
		this.g=new Nabomatrise(navn);
	}

	boolean leggTilVenner(String p1, String p2) {
		return g.leggTilKant(p1, p2);		
	}
	
	boolean erVenner(String p1, String p2) {
		return g.erNaboer(p1, p2);
		
	}
	boolean ikkeVenner(String p1, String p2) {
		return g.fjern(p1, p2) ;
		
	}
	int antalFellesVenner(String p1, String p2) {
		int ant=0;
		List<String> listeP1=g.getNaboer(p1);
		List<String> listeP2=g.getNaboer(p2);
		for(int i=0; i< listeP2.size();i++) {
			if (listeP1.contains(listeP2.get(i))) {
				ant++;
			}
		}	
		return ant;
	}
	
	
	void visGraf() {
		System.out.print("Facebookgrafen for Deler av "+gruppeNavn+"\n"+
				"Antal personer i gruppen = "+g.getAntallNoder()+
				", antall vennskap = "+g.getAntallKanter()+"\n");
		for(int i=0;i<g.getNavn().length;i++) {
			
			List<String> liste=g.getNaboer(g.getNavn()[i]);
			
			System.out.print(g.getNavn()[i]+ ": ");
			
			for(String a : liste) {
				System.out.print(a+" ");
			}System.out.println();
		}
		
	
	}
	
	

	
}



