package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
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
	private Diccionari<String,User> usersOnThisTrial;
	private ContenidorAfitat<QuestionGroup> questionGroupsOnThisTrial;
	private User mostActiveUser;
	
	//TODO -> Constructor + getters & setters
	
	public Trial(int idTrial, String description) {
		this.setIdTrial(idTrial);
		this.setDescription(description);
		this.setUsersOnThisTrial(new DiccionariOrderedVector<>(Trial4C19.U));
		this.setQuestionGroupsOnThisTrial(new OrderedVector<>(Trial4C19.G));
		this.setMostActiveUser(new User(null, null, null));
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

	public ContenidorAfitat<QuestionGroup> getQuestionGroupsOnThisTrial() {
		return questionGroupsOnThisTrial;
	}

	public void setQuestionGroupsOnThisTrial(ContenidorAfitat<QuestionGroup> questionGroupsOnThisTrial) {
		this.questionGroupsOnThisTrial = questionGroupsOnThisTrial;
	}

	public Diccionari<String,User> getUsersOnThisTrial() {
		return usersOnThisTrial;
	}

	public void setUsersOnThisTrial(Diccionari<String,User> usersOnThisTrial) {
		this.usersOnThisTrial = usersOnThisTrial;
	}

	public User getMostActiveUser() {
		return mostActiveUser;
	}

	public void setMostActiveUser(User mostActiveUser) {
		this.mostActiveUser = mostActiveUser;
	}
	
	public void assignQuestionGroup(QuestionGroup qg) {
		((OrderedVector<QuestionGroup>) this.questionGroupsOnThisTrial).AfegirOrdenat(qg);
	}

	public void assignUser(User u) {
		((DiccionariOrderedVector<String,User>) this.usersOnThisTrial).afegir(u.getUserId(), u);
	}
	
}

