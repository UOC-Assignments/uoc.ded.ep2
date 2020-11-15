package uoc.ded.practica.util;

import uoc.ei.tads.*;
/*
 * C i E corresponen amb "clau (key)" i "element" respectivament. Com que la classe està 
 * parametritzada, podem especificar els tipus que desitjem a l'hora de crear l'objecte 
 * (En e l cas que ens ocupa, String (idUser) per al paràmetre "C" o clau i User 
 * (objecte que representa un sol usuari) per al paràmetre "E" o element.
 */
	
public class DiccionariContenidorAfitat_Impl<C,E> implements Diccionari<C,E>, ContenidorAfitat<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DiccionariContenidorAfitat_Impl() {
		// TODO Auto-generated constructor stub
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

}
