package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
import uoc.ei.tads.Iterador;

public class User_Impl<C, E> implements Diccionari<C,E>, ContenidorAfitat<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User<C, E> users; //DRAFT

	/** 
	 * 
	 * Implementem el constructor de la estructura de dades "Users" 
	 * 
	 * **/
	
	public User_Impl() {
		this.setUsers(new User_Impl<C,E>());  
	}

	@Override
	public void afegir(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterador claus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object esborrar(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hiEs(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterador elements() {
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return null;
	}

	public User<C, E> getUsers() {
		//Aquest mètode (getter) crec que no és necessari
		return users;
	}

	private void setUsers(User<C, E> users) {
		//Aquest mètode (setter) només és utilitzat pel constructor, aixi que el fem privat
		this.users = users;
	}
}
