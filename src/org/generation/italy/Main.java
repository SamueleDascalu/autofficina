package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String stringaInserita, risposta;
		int interoInserito, totale=0;
		boolean esiste=false;
		
		String[] interventi = 
		{
			"sostituzione pastiglie freni", "cambio olio", "sostituzione filtro d'aria",
			"cambio cinghia di distribuzione", "regolazione minimo"
		};
		int[] costoOrario = {50, 30, 20, 150, 25};
		String[] ricambi = 
		{
			"pastiglie freno Bosch", "pastiglie freno Brembo", "filtro aria Opel",
			"filtro aria Mercedes", "olio diesel GW312"
		};
		int[] costoUnitario = {200, 500, 65, 90, 18};
		
		ArrayList<String> interventiInseriti = new ArrayList<String>();
		ArrayList<Integer> durataInterventi = new ArrayList<Integer>();
		ArrayList<Integer> costoInterventi = new ArrayList<Integer>();
		
		ArrayList<String> ricambiInseriti = new ArrayList<String>();
		ArrayList<Integer> quantitaRicambi = new ArrayList<Integer>();
		ArrayList<Integer> costoRicambi = new ArrayList<Integer>();
		
		do {
			System.out.println("Gli interventi disponibili sono:\n");
			
			for(int i=0; i<interventi.length; i++) {
				System.out.print("-"+interventi[i]+"\n");
			}
			
			System.out.println();
			System.out.print("Inserisci il nome dell'intervento: ");
			stringaInserita = scanner.nextLine();
			
			for(int i=0; i<interventi.length; i++) {
				
				if(interventi[i].equals(stringaInserita)) {
					esiste=true;
					
					interventiInseriti.add(stringaInserita);
					
					System.out.print("Inserisci la durata dell'intervento: ");
					interoInserito = Integer.parseInt(scanner.nextLine());
					
					durataInterventi.add(interoInserito);
					
					costoInterventi.add(interoInserito*costoOrario[i]);
					
					totale+=interoInserito*costoOrario[i];
				} else {
					esiste=false;
				}
			}
			
			if(esiste==false) {
				System.out.print("Intervento non disponibile.");
				System.out.println();
			}
			
			System.out.println();
			System.out.print("Vuoi inserire un altro intervento? (si/no) ");
			risposta = scanner.nextLine();
		}while(risposta.equals("si"));
		
		do {
			System.out.println();
			System.out.println("I pezzi di ricambio disponibili sono:\n");
			
			for(int i=0; i<ricambi.length; i++) {
				System.out.print("-"+ricambi[i]+"\n");
			}
			
			System.out.println();
			System.out.print("Inserisci il pezzo di ricambio: ");
			stringaInserita = scanner.nextLine();
			
			for(int i=0; i<ricambi.length; i++) {
				
				if(ricambi[i].equals(stringaInserita)) {
					esiste=true;
					
					ricambiInseriti.add(stringaInserita);
					
					System.out.print("Inserisci la quantità: ");
					interoInserito = Integer.parseInt(scanner.nextLine());
					
					quantitaRicambi.add(interoInserito);
					
					costoRicambi.add(interoInserito*costoUnitario[i]);
					
					totale+=interoInserito*costoUnitario[i];
				} else {
					esiste=false;
				}
			}
			
			if(esiste==false) {
				System.out.println("Pezzo non disponibile.");
				System.out.println();
			}
			
			System.out.println();
			System.out.print("Vuoi inserire un altro pezzo? (si/no) ");
			risposta = scanner.nextLine();
		}while(risposta.equals("si"));
		
		System.out.println("FATTURA GENERATA:");
		System.out.println("DESCRIZIONE\t\tQUANTITA'\tCOSTO");
		
		for(int i=0; i<interventiInseriti.size(); i++) {
			System.out.println(interventiInseriti.get(i)+"\t\t"+durataInterventi.get(i)+"\t"+costoInterventi.get(i));
		}
		
		for(int i=0; i<interventiInseriti.size(); i++) {
			System.out.println(ricambiInseriti.get(i)+"\t\t"+quantitaRicambi.get(i)+"\t"+costoRicambi.get(i));
		}
		
		System.out.println();
		System.out.println("TOTALE FATTURA: "+totale);
		
		scanner.close();
	}

}
