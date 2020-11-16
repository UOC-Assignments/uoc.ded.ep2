package uoc.ded.practica.util;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.Trial;

public class JavaArray_Impl implements JavaArray 
{

	private Trial[] trials;
	//private n;
	/** 
	 * 
	 * Implementem el constructor de la estructura de dades "trial" 
	 * 
	 * **/
	
	public JavaArray_Impl() {
		this.trials = new Trial[Trial4C19.T];  // La variable publica "Trial4C19.T" defineix la grandaria del vector (num. de trials)
	}
	
	/**
	 * 
	 * Implementem els mètodes modificadors (getters and setters)
	 * 
	 */
	
	public void add(Trial trial) {		
		this.trials[trial.getIdTrial()] = trial;
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
