package uoc.ded.practica.model;

import uoc.ei.tads.Cua;
import uoc.ei.tads.CuaVectorImpl;
import uoc.ei.tads.Llista;
import uoc.ei.tads.LlistaEncadenada;

public class User {
	
	private String name;
	private String surname;
	private Llista<Answer> answers;
	private Cua<Question> questions;
	
	public User(String name, String surname) {
		this.setName(surname);
		this.setSurname(surname);
		this.setAnswers(new LlistaEncadenada<>());
		this.setQuestions(new CuaVectorImpl<>());
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
}