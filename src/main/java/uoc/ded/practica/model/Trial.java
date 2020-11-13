package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.Contenidor; //NOMES SI IMPLEMENTEM CONTENIDOR
import uoc.ei.tads.Iterador; //NOMES SI IMPLEMENTEM CONTENIDOR

/* Segons la solució de la PAC1, per a emmagatzemar els grup de preguntes 
 * és adient emprar una estructura estàtica (vector): 
 * 
 * Cita de PAC1, Pàg. 11:
 * 
 * "Per guardar els assajos clínics  és millor utilitzar una estructura estàtica ja que el
 * nombre d'assajos clínics és conegut, petit i fitat. (...) Dins de les estructures estàtiques 
 * podrem triar entre (...) i un simple vector on cada assaig clínic ocupa la posició que defineix
 * el seu identificador. Així, la cerca d'un assaig clínic la podrem fer accedint
 * directament a la posició del vector (no tindrem ni que fer cerca dicotòmica) i tindrà
 * cost constant O (1). L'elecció serà doncs un vector on cada assaig clínic ocupa la posició que
 * defineix el seu identificador."
 *
 * Cita de PAC1, Pàg. 17:
 * 
 * "Per guardar els assajos clínics utilitzarem un array de Java ja que
 * només necessitem accés directe per posició. (Trial[] )"
 * 
 */

public class Trial // NO SE SI LA CLASSE HA D'ANAR PARAMETRIRTZADA <E> 

/* implements Contenidor<E> */ //NO SE SI EN AQUEST CAS S'HA DIMPLEMENTAR CAP INTERFICIE; CREC QUE NO. 

/* HIPOTESI 1; En aquest cas, com que Trial es pot implementar amb arrays de java, aleshores no caldrà implementar 
 * cap interficie (en podriem definir una de nova amb el constructor i mètodes a implementar?)*/


{

	/** 
	 * 
	 *  PAS 1ex: Definim un tipus d'objecte ("inner nested class", referencia: Bibliografia [#1]) nou per a emmagaztemar la 
	 *  informació relativa a un sol Trial (trialId + description) amb la finalitat de poder crear una estrcutura de dades 
	 *  basada en un Array d'objectes tipus "TrialsType" (Com que només ha de ser utilitzat dins la classe Trial<E>, 
	 *  aleshores la podem definir com a classe privada.
	 *  
	 *  	static class TrialsType {
		public int idtrial;
		public String description;
	}
	
	 *  
	 *  EDIT: AIXÒ NO CAL PERQUE INDEXEM PER IDTRIAL I ALESHORES PODEM FER UN ARRAY D'STRINGS QUE JA CONTÉ TOTA LA INFORMACIÓ
	 *  REQUERIDA PEL TAD
	 *  
	 **/
	

	/** 
	 * 
	 * PAS 1: Definim el constructor de la estructura de dades "trial" 
	 * 
	 * **/
	
	String[] trials = new String[Trial4C19.T]; // La variable publica "Trial4C19.T" defineix la grandaria del vector (num. de trials)
	
	/**
	 * 
	 * PAS 2: Definim els mètodes modificadors (getters and setters)
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
