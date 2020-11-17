package uoc.ded.practica.util;

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
	public int nombreElems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaPle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afegir(C userId, E user) {	
		String str = (String) userId;
		String userId_digitsOnly= str.replaceAll("[^0-9]", "");
		elements[Integer.parseInt(userId_digitsOnly)]=user;
		n++;
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
	
	//Custom methods


	

}
