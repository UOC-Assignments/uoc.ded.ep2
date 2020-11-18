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
	private static final long serialVersionUID = 499829181997824422L;
	
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
			super(U);
	 	  	elements = (E[])new Object[U]; 
	 	  	n = 0;
	}

	public void afegir(C userId, E elem) {	
		
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
			    // Si l'usuari que volem afegir té UserId major, avançem l'iterador
				} else if (nouUserId > actualUserId) {
					pos++;
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

	@Override
	public boolean estaPle() {
		// TODO Auto-generated method stub
		return false;
	}


}
