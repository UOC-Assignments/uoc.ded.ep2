package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.Trial4C19.Type;

/* Segons la solució de la PAC1, per a emmagatzemar les preguntes dins  
 * d'un grup de preguntes s'ha d'utilitzar una estructura de "llista 
 * encadenada" per a representar el  TAD "Question":
 * 
 * Cita de PAC1, Pàg. 12:
 * 
 * "Per guardar les preguntes (dins d'un grup) d'un assaig clínic usarem una
 * llista encadenada, ja que el nombre de preguntes és petit, però en
 * constant augment, no es poden fitar, i necessitem ordenació.
 * 
 * Cita de PAC1, Pàg. 17:
 * 
 * "Per guardar les preguntes dins d'un grup de preguntes utilitzarem una
 * ListaEncadenada."
 * 
 */

public class Question {
	
	private String idQuestion;
	private String wording;
	private Trial4C19.Type type;
	private String[] choices;
	
	public Question(String idQuestion, String wording, Type type, String[] choices) {
		this.setIdQuestion(idQuestion);
		this.setWording(wording);
		this.setType(type);
		this.setChoices(choices);
	}

	public String getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(String idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public Trial4C19.Type getType() {
		return type;
	}

	public void setType(Trial4C19.Type type) {
		this.type = type;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	
	//TO-DO

}
