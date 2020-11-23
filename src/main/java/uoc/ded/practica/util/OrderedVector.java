package uoc.ded.practica.util;

import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class OrderedVector<E> implements ContenidorAfitat<E> {

	private static final long serialVersionUID = 8799289290083114949L;

	/**
	 * Nombre d'elements que hi ha actualment al contenidor. Tamb� representa la
	 * posici� on s'ha d'empilar un nou element.
	 */
	protected int n;

	/** Taula d'elements del contenidor. Les posicions comencen pel zero. */
	protected E[] elements;

	/**
	 * Constructor amb paràmetres
	 * 
	 * @param capacitat màxima
	 */
	@SuppressWarnings("unchecked")
	public OrderedVector(int G) {

		elements = (E[]) new Object[G];
		n = 0;
	}

	/**
	 * Constructor sense paràmetres (capacitat màxima, per defecte).
	 */

	public OrderedVector() {
		/* TODO */ }

	/** Implementació de mètodes de la interfície "ContenidorAfitat" **/

	@Override
	public Iterador<E> elements() {
		return new IteradorVectorImpl<E>(elements, nombreElems(), 0);
	}

	@Override
	public boolean estaBuit() {
		return n == 0;
	}

	@Override
	public int nombreElems() {
		return n;
	}

	@Override
	public boolean estaPle() {
		return n == elements.length;
	}

	public void afegir(E elem) {

		// BUSCAR PRIMER SI EL ID DE GRUP JA EXISTEIX I SI ES AIXÍ ACTUALITZAR
		
		// Si trobem l'element, aleshores, l'eliminem del vector.
		// D'aquesta manera després el podrem inserir de manera ordenada utlitzant el
		// mateix algorisme.
		
		boolean found = false;
		int result;
		int actual = 0;
		Comparable_Impl<E> actualQG;
		if (!this.estaBuit()) { 
			Iterador<E> it1 = this.elements();
			while (it1.hiHaSeguent() & !found) {
				actualQG = new Comparable_Impl<E>(it1.seguent());
				result = actualQG.compareIdTo((E) elem);
				if (result == 1) {
					found = true;
					this.eliminar(actual);
					n--;
				}
				actual++;
			}
		}

		// Si el vector és buit, aleshores afegim a la posició n = 0;
		
		if (this.estaBuit()) {
			int i;
			elements[0] = elem;
			n++;
			
		// Si no, busquem a quina posició l'hem d'afegir;
			
		} else {
			found = false;
			int index = 0;
			Iterador<E> it2 = this.elements();
			while (it2.hiHaSeguent() & !found) {
				Comparable_Impl<E> actualQG2 = new Comparable_Impl<E>(it2.seguent());
				result = actualQG2.comparePriorityTo((E) elem);
				
				// Si el grup de preguntes que volem afegir té prioritat superior o igual,
				// desplaçem elements i sobreescribim a "pos"
				
				if (result >= 1) {
					desplacarElementsDreta(index);
					elements[index] = elem;
					n++;
					found = true;
					
					// Si el grup de preguntes que volem afegir té prioritat inferior...
					
				} else {
					
					// Si hi ha més elements, avançem l'iterador
					
					if (it2.hiHaSeguent()) {
						index++;
						
					// Si actualQG2 és el darrer grup de preguntes, afegim al final (index = n)
					
					} else {
						elements[n] = elem;
						n++;
					}
				}
			}
		}
	}

	/**
	 * @todo: AQUEST MÈTODE HAURIA D'ESTAR PARAMETRITZAT (RETORNAR TIPUS E) 
	 */
	
	public QuestionGroup existeix(String idGroup) {
		QuestionGroup qg;
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements, nombreElems(), 0);
		while (it.hiHaSeguent()) {
			qg = (QuestionGroup) it.seguent();
			if (qg.getIdGroup().equals(idGroup)) {
				return qg;
			}
		}
		return null;
	}

	/*****************************************************
	 * 
	 * MÈTODES AUXILIARS
	 * 
	 ***************************************************/

	private void desplacarElementsDreta(int pos) {
		int i;
		for (i = this.nombreElems(); i > pos; i--) {
			elements[i] = elements[i - 1];
		}
	}

	private void eliminar(int pos) {
		int i;
		for (i = pos; i < this.nombreElems(); i++) {
			elements[i] = elements[i + 1];
		}
		elements[n] = null;
	}
}