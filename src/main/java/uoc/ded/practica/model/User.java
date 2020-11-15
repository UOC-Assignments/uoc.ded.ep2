package uoc.ded.practica.model;

import uoc.ei.tads.Cua;
import uoc.ei.tads.CuaVectorImpl;
import uoc.ei.tads.LlistaEncadenada;

public class User {
	
	private String name;
	private String surname;
	private LlistaEncadenada<Answer> answers;
	private Cua<Question> questions;
	
	public User(String name, String surname) {
		setName(surname);
		setSurname(surname);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	private void setSurname(String surname) {
		this.surname = surname;
	}
}