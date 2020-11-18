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

public class DiccionariOrderedVector<C,E> implements Diccionari<C,E>, ContenidorAfitat<E>{

	private static final long serialVersionUID = 1L;
	
   /**
    * Nombre d'elements que hi ha actualment al contenidor. Tamb�
    * representa la posici� on s'ha d'empilar un nou element.
    */
   protected int n;

   /** Taula d'elements del contenidor. Les posicions comencen pel zero.*/
   protected E[] elements;

   /**
    * Constructor sense paràmetres (capacitat màxima, per defecte).
    */
	
	public DiccionariOrderedVector(int U) {
	 	  elements = (E[])new Object[U]; 
		  n = 0;
	}

	@Override
	public Iterador<E> elements() {	return new IteradorVectorImpl<E>(elements,nombreElems(),0); }

	@Override
	public boolean estaBuit() { return n == 0; }

	@Override
	public int nombreElems() { return n; }

	@Override
	public boolean estaPle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterador<C> claus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E consultar(C userId) {
		Boolean found = false;
		int userId_int = this.extraureEnter((String) userId);
		//Fer recorregut 
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0); 
		while (it.hiHaSeguent() & !found) {
			User actualUser = (User) it.seguent();
			if (userId_int == extraureEnter(actualUser.getUserId())) {
				return (E) actualUser;
			}
		}
		return null;
	}

	@Override
	public E esborrar(C arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hiEs(C userId) {
		Boolean found = false;
		int userId_int = this.extraureEnter((String) userId);
		//Fer recorregut 
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0); 
		while (it.hiHaSeguent() & !found) {
			User actualUser = (User) it.seguent();
			if (userId_int == extraureEnter(actualUser.getUserId())) {
				found = true;
			}
		}
		return found;
	}

	@Override
	public void afegir(C arg0, E arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//Custom methods

	public void afegirOrdenat(C userId, E elem) {	
		
		//Si el vector és buit, aleshores afegim a la posició n = 0;
		if (this.estaBuit()) {
			this.elements[0] = elem;
			n++;
		} else {
			//utilitzar un comparator per a cercar la posició a la que ha d'anar l'element
			//Comparator.comparing(keyExtractor)

			int pos = 0; int i, actualUserId, nouUserId;
			boolean found = false;
			User actualUser;
			int numElements = nombreElems();
			IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(this.elements,numElements,0); 

			while (it.hiHaSeguent() & !found) {
				actualUser = (User) it.seguent();
				nouUserId = this.extraureEnter((String) userId);
			    actualUserId = this.extraureEnter(actualUser.getUserId());
			    // Si l'usuari que volem afegir té el mateix Id que l'actual, sobreescribim a "pos"
			    if (nouUserId == actualUserId) {
			    	elements[pos] = elem;
			    	found = true;
			    // Si l'usuari que volem afegir té UserId major, aavançem l'iterador
				} else if (nouUserId > actualUserId) {
					pos++;
					//actualUser = (User) it.seguent();
				} else {
					//Si no, desplaçem tots els elements a partir de "pos" una posició i afegim a "pos"
					for (i=this.nombreElems();i>pos;i--) {
						elements[i]=elements[i-1];
					}
					found = true;
					elements[pos] = elem;
					n++;
				}																	
			}
			//Si no trobem cap userId més gran, aleshores afegim al final
			if (!found) {
				elements[n] = elem;
				n++;
			}		
		}
	}
	
	//Auxiliar methods
	private int extraureEnter(String userIdStr) {
		return Integer.parseInt( ((String) userIdStr).replaceAll("[^0-9]", "") );
	}
}
