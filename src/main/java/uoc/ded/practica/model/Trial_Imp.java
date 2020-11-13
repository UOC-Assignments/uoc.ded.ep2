package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;

public class Trial_Imp implements Trial // NO SE SI LA CLASSE HA D'ANAR PARAMETRIRTZADA <E> `
{

	/** 
	 * 
	 * PAS 1: implementem el constructor de la estructura de dades "trial" 
	 * 
	 * **/
	
	String[] trials = new String[Trial4C19.T]; // La variable publica "Trial4C19.T" defineix la grandaria del vector (num. de trials)
	
	/**
	 * 
	 * PAS 2: implementem els mètodes modificadors (getters and setters)
	 * 
	 */
	
	public void trialIndexedInsert(int idTrial, String description) {		
		trials[idTrial] = description;
	}
	
	public int getNumTrials() {
		int i;
		int count = 0;
		for (i=0;i<Trial4C19.T;i++) {
			if (trials[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	/** draft code **/
	
	/* AQUEST MÈTODES CORRESPONEN A LA INTERFICIE CONTENIDOR<E>, SI AQUESTA NO S'IMPLEMENTA, ALESHORES ESBORRAR ELS METODES. 
	 * 
	public Iterador<E> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estaBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	public int nombreElems() {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
}
