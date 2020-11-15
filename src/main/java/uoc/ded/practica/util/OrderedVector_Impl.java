package uoc.ded.practica.util;

import java.util.Comparator;
import java.util.function.Function;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class OrderedVector_Impl<E> implements OrderedVector<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
   /**
    * Nombre d'elements que hi ha actualment al contenidor. Tamb�
    * representa la posici� on s'ha d'empilar un nou element.
    */
   protected int n;

   /** Taula d'elements del contenidor. Les posicions comencen pel zero.*/
   protected E[] elements;

   /**
    * Constructor sense par�metres (capacitat màxima, per defecte).
    * @post n == 0 && this.max == MAXIM_ELEMENTS_PER_DEFECTE && elements.length==max
    */
   public OrderedVector_Impl() {
   	  //this(Trial4C19.G);    // Establim la capacitat màxima, per defecte, del contenidor ( paràmetre E ) 
	  elements = (E[])new Object[Trial4C19.G];
	  n = 0;
   }
	
	public OrderedVector_Impl(int custom_size) {
	// NOT USED IN THIS IMPLEMENTATION (ELS GRUPS DE PREGUNTES SON DE Tiral4C19.G = 20 elements sempre) 
	}

	/** MÈTODES HEREDATS A IMPLEMENTAR (Referències: "PilaVectorImpl.java") **/
	
	@Override
	public Iterador<E> elements() {	return new IteradorVectorImpl<E>(elements,nombreElems(),0); }

	@Override
	public boolean estaBuit() {	return n==0; }

	@Override
	public int nombreElems() { return n; }

	@Override
	public boolean estaPle() { return n == elements.length; }
	
	/** Custom methods **/
	
	public void AfegirOrdenat(E elem){
		
		if (this.estaBuit()) { 
			elements[0] = elem;
		} else {
			int pos = 0; int i;
			IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0); 
			QuestionGroup qg_existent = (QuestionGroup) it.seguent();
			QuestionGroup qg_nou = (QuestionGroup) elem;
			if (qg_nou.getPriority().equals(Trial4C19.Priority.HIGH)) {
				//desplaçem tots els elements una posició i inserim a la posició n=0
				for (i=Trial4C19.G;i>0;i++) {
					elements[i]=elements[i-1];
				}
				elements[0] = elem;				
			} else {
				//mentre no final i existent > nou --> existent = it.seguent, pos++ i tornem a comparar. Un cop trobat tornem a desplaçar i inserim			
			}			
		}
		n++;
	}
}
