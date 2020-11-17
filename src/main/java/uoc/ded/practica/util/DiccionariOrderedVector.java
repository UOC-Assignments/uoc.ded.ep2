package uoc.ded.practica.util;

import java.util.Comparator;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ded.practica.model.User;
import uoc.ei.tads.*;

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
	public E consultar(C arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E esborrar(C arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hiEs(C arg0) {
		// TODO Auto-generated method stub
		return false;
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
		} else {
			//utilitzar un comparator per a cercar la posició a la que ha d'anar l'element
			//Comparator.comparing(keyExtractor)

			int pos = 0; int i;
			boolean found = false;
			IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0); 
			User actualUser = (User) elem;
			
			// Si l'usuari que volem afegir té UserId igual o menor, desplaçem la resta d'elements i afegim al davant 
			actualUser = (User) it.seguent();
			int NouUserId = this.extraureEnter((String) userId);
			int ActualUserId = this.extraureEnter(actualUser.getUserId());
			while (it.hiHaSeguent() & !found) {
				if (NouUserId <= ActualUserId) {
					for (i=this.nombreElems();i>0;i--) {
						elements[i]=elements[i-1];
					}
					elements[pos] = elem;
					found = true;
				} else {	
					actualUser = (User) it.seguent();
					pos++;
				}
			}
			//Si no trobem cap userId superior o igual, aleshores afegim al final
			elements[n] = elem;
		}
		n++;
	}
	
	//Auxiliar methods
	private int extraureEnter(String userIdStr) {
		return Integer.parseInt( ((String) userIdStr).replaceAll("[^0-9]", "") );
	}
}
