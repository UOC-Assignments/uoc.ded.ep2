package uoc.ded.practica.util;

import uoc.ded.practica.model.User;
import uoc.ei.tads.*;

/**
 * 
 * @author jordi
 * 
 * Adaptació del TAD de la biblioteca: "DiccionariVectorImpl.java"
 *
 */

public class DiccionariOrderedVector<C,E> extends DiccionariVectorImpl<C, E> implements ContenidorAfitat<E> {

	/**
	 * 
	 */
	
	private int max; //Mida màxima del contenidor afitat. Obtenim la dada com a argument del constructor
	
	private static final long serialVersionUID = 499829181997824422L;
	
   /**
    * Constructor 
    */
	
	public DiccionariOrderedVector(int arg) {
			super(arg);
	 	  	this.max = arg;
	}

	public void afegir(C clau, E elem) {	
		
		/** 
		 * ALGORISME: 
		 *
		 * found := false;
		 * index := 0; 
		 * Si el diccionari és buit, 
		 *    aleshores afegim a la posició n := 0;
		 * si no, 
		 *    mentre hi hagi elements al diccionari i no s'hagi trobat la clau (found)
		 *       Si l'usuari que volem afegir té el mateix Id que l'actual, sobreescribim a "index"
		 *       si no,
		 *         si l'usuari que volem afegir té UserId major, avançem l'iterador (index++)
		 *         Si no, desplaçem tots els elements a partir de "index" una posició i afegim a "index"
		 * Si no trobem cap userId més gran, aleshores afegim al final 
		 * 
		 * */
			
		//Si el diccionari és buit, aleshores afegim a la posició n = 0;
		if (this.estaBuit()) {
			int i;
			diccionari[0]=new ClauValor<C,E>(clau,elem);
			n++;
		} 
		
		else {
			int i; 
			int index = 0; 
			int result;		
			boolean found = false;
			Comparable<C> actualUser;
			IteradorClaus<C,E> it = (IteradorClaus<C, E>) this.claus();			
			while(it.hiHaSeguent() & !found) {
				    actualUser = (Comparable<C>) it.seguent();
				    result = actualUser.compareTo((C) clau);
				    /** AIXÒ QUE VE MILLOR FER-HO AMB SWITCH-CASE EN FUNCIO DE RESULT!! **/
				    // Si l'usuari que volem afegir té el mateix Id que l'actual, sobreescribim a "pos"
				    if (result == 0) {
				    	diccionari[index] = new ClauValor<C, E>(clau,elem);
				    	found = true; 
				    // Si l'usuari que volem afegir té UserId major, avançem l'iterador
					} else if (result < 0) {
						index++;
					} else {
						//Si no, desplaçem tots els elements a partir de "pos" una posició i afegim a "pos"
						for (i=this.nombreElems();i>index;i--) {
							diccionari[i]=diccionari[i-1];
						}
						diccionari[index] = new ClauValor<C, E>(clau,elem);
						n++;
						found = true;
					}																	
				}
				//Si no trobem cap userId més gran, aleshores afegim al final
				if (!found) {
					diccionari[n] = new ClauValor<C, E>(clau,elem);
					n++;
				}		
		} 
			
	}
	

	@Override
	public boolean estaPle() { return this.n == this.max; }


}
