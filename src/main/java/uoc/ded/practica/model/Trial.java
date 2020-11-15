package uoc.ded.practica.model;

import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.Llista;
import uoc.ei.tads.LlistaEncadenada;

/**
 * Definició del CONTENIDOR per a l'emmagatzematge d'assajos (Trials)
 * @param <E>
 * 
 */

public class Trial {
	
	private int idTrial; //No estic segur si cal, ja que al diccionari ja indexem per idTrial
	private String description;
	private Llista<User> usersOnThisTrial;
	private OrderedVector questionsOnThisTrial;
	private User mostActiveUser;
	
	//TODO -> Constructor + getters & setters
	
	public Trial(int idTrial, String description) {
		this.setIdTrial(idTrial);
		this.setDescription(description);
		this.setUsersOnThisTrial(new LlistaEncadenada<>());
		this.setQuestionsOnThisTrial(new OrderedVector());
		this.setMostActiveUser(new User(null, null));
	}

	public int getIdTrial() {
		return this.idTrial;
	}

	public void setIdTrial(int idTrial) {
		this.idTrial = idTrial;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderedVector getQuestionsOnThisTrial() {
		return questionsOnThisTrial;
	}

	public void setQuestionsOnThisTrial(OrderedVector questionsOnThisTrial) {
		this.questionsOnThisTrial = questionsOnThisTrial;
	}

	public Llista<User> getUsersOnThisTrial() {
		return usersOnThisTrial;
	}

	public void setUsersOnThisTrial(Llista<User> usersOnThisTrial) {
		this.usersOnThisTrial = usersOnThisTrial;
	}

	public User getMostActiveUser() {
		return mostActiveUser;
	}

	public void setMostActiveUser(User mostActiveUser) {
		this.mostActiveUser = mostActiveUser;
	}
	
}

