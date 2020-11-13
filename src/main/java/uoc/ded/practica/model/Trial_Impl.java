package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;

public class Trial_Impl implements Trial // NO SE SI LA CLASSE HA D'ANAR PARAMETRIRTZADA <E> `
{

	private String[] trials;

	/** 
	 * 
	 * Implementem el constructor de la estructura de dades "trial" 
	 * 
	 * **/
	
	public Trial_Impl() {
		this.trials = new String[Trial4C19.T];  // La variable publica "Trial4C19.T" defineix la grandaria del vector (num. de trials)
	}
	
	/**
	 * 
	 * Implementem els mètodes modificadors (getters and setters)
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
	
	public boolean exists(int idTrial) {
		if (trials[idTrial] != null) {
			return true;
		}
		return false;
	}
}
