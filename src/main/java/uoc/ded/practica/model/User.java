package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
import uoc.ei.tads.Iterador;

public class User<C,E> implements Diccionari<C,E>, ContenidorAfitat<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User<C,E> users; //DRAFT

	/** 
	 * 
	 * Implementem el constructor de la estructura de dades "Users" 
	 * 
	 * **/
	
	public User() {
 		this.setUsers(new User<C,E>());  
	}
	
	//GETTER & SETTER: NOMÉS SÓN ACCESSIBLES DES DE L'SCOPE DEL TAD COM A OPERACIONS INTERNES
	
	private User<C,E> getUsers() {
		return users;
	}

	private void setUsers(User<C,E> users) {
		this.users = users;
	}

	//OVERRIDES & CUSTOM METHODS

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
	public void afegir(C idUser, E user) {
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

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSurname() {
		// TODO Auto-generated method stub
		return null;
	}
}
