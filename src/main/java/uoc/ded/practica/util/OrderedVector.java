package uoc.ded.practica.util;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.ExcepcioParametreIncorrecte;
import uoc.ei.tads.Iterador;

public class OrderedVector<E> implements ContenidorAfitat<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public (){
		
	}
	

   public static final int MAXIM_ELEMENTS_PER_DEFECTE = 256;

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
   	  this(Trial4C19.G);    /** Establim la capacitat màxima, per defecte, del contenidor ( paràmetre E és un Int sempre al tractar-se d'un vector ) */
   }
	
	public OrderedVector(int custom_size) {
	// NOT USED IN THIS IMPLEMENTATION (ELS GRUPS DE PREGUNTES SON DE Tiral4C19.G = 20 elements sempre) 
}

	/** MÈTODES HEREDATS A IMPLEMENTAR **/
	
	@Override
	public Iterador<E> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int nombreElems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaPle() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/** Custom methods **/
	
	public void AfegirOrdenat(E element){
		
		//TO-DO
	}
	

}
