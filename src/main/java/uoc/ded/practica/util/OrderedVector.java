package uoc.ded.practica.util;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.ExcepcioParametreIncorrecte;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class OrderedVector<E> implements ContenidorAfitat<E> {

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
   public OrderedVector() {
   	  //this(Trial4C19.G);    // Establim la capacitat màxima, per defecte, del contenidor ( paràmetre E ) 
	  elements = (E[])new Object[Trial4C19.G];
	  n = 0;
   }
	
	public OrderedVector(int custom_size) {
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
		} else {}
		n++;
	}
}
