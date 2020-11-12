package uoc.ded.practica.model;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.Iterador;

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

public class Trial<E> /* implements Contenidor<E> */ //NO SE SI EN AQUEST CAS S'HA DIMPLEMENTAR CAP INTERFICIE; CREC QUE NO 

{

	/** 
	 *  PAS 1: Definim un tipus d'objecte nou per a emmagaztemar la informació relativa a un sol Trial (trialId + description) 
	 *  amb la finalitat de poder crear una estrcutura de dades basada en un Array d'objectes tipus "TrialsType" (Com que només
	 *  ha de ser utilitzat dins la classe Trial<E>, aleshores la podem definir com a classe privada.
	 **/
	
	private class TrialsType {
		public int idtrial;
		public String description;
	}
	
	/** PAS 2: Definim el constructor de la estructura de dades "trial<E>" **/
	TrialsType[] trials = new TrialsType[Trial4c19.T];

	/* AQUEST MÈTODES CORRESPONEN A LA INTERFICIE, SI AQUESTA NO S'IMPLEMENTA, ALESHORES ESBORRAR ELS METODES. 
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
