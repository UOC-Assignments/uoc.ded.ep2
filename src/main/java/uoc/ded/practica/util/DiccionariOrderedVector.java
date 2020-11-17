package uoc.ded.practica.util;

import java.util.Comparator;

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

	public void afegirOrdenat(C userId, E user) {	
		//int userId_int = Integer.parseInt( ((String) userId).replaceAll("[^0-9]", "") );
		//USE COMPARATOR INSTEAD
		Comparator.comparing(keyExtractor)

		
		n++;
	}

	

}
