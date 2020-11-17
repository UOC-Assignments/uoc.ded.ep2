package uoc.ded.practica.util;

import uoc.ded.practica.model.User;
import uoc.ei.tads.*;

public class DiccionariOrderedVector_Impl<C,E> implements DiccionariOrderedVector<C,E>{

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
	
	public DiccionariOrderedVector_Impl(int U) {
	 	  elements = (E[])new Object[U]; //BUG DE DISSENY: LA MIDA G HA DE VENIR COM A PARAMETRE AL CRIDAR AL CONSTRUCTOR
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
	public void afegir(C arg0, E arg1) {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public void afegirOrdenat(String c, E elem) {
		//TODO
	}

	

}
