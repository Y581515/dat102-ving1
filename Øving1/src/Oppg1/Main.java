package Oppg1;

public class Main {
	public static void main(String[] args) {
		String[] g1 = {"Anne","Bj�rn","Edvard","Fiona"};
		Facebook gr1= new Facebook("DAT102",g1);
		System.out.println(gr1.leggTilVenner("Anne","Bj�rn" ));
		
		System.out.println(gr1.g.getNavn()[0]);
		
		gr1.leggTilVenner("Anne","Edvard" );
		gr1.leggTilVenner("Bj�rn","Edvard" );
		gr1.leggTilVenner("Bj�rn","Fiona" );
		
		gr1.visGraf();
		
		
		
		
	}

}
