package uoc.ded.practica.model;

import uoc.ei.tads.Cua;
import uoc.ei.tads.CuaVectorImpl;
import uoc.ei.tads.Llista;
import uoc.ei.tads.LlistaEncadenada;

public class User {
	
	private String idUser;
	private String name;
	private String surname;
	private Llista<Answer> answers;
	private Cua<Question> questions;
	
	public User(String idUser, String name, String surname) {
		this.setIduser(idUser);
		this.setName(surname);
		this.setSurname(surname);
		this.setAnswers(new LlistaEncadenada<>());
		this.setQuestions(new CuaVectorImpl<>());
	}

	private void setIduser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return this.name;
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

	public Llista<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(LlistaEncadenada<Answer> answers) {
		this.answers = answers;
	}

	public Cua<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Cua<Question> questions) {
		this.questions = questions;
	}

	public String getUserId() {
		return this.idUser;
	}
}