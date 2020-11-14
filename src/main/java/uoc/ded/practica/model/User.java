package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.ClauValor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
import uoc.ei.tads.Iterador;

public class User {
	
	private String name;
	private String surname;
	
	public User(String name, String surname) {
		setName(surname);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}