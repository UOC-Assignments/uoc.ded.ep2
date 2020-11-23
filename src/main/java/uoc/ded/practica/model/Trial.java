package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
import uoc.ei.tads.Iterador;

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
		((OrderedVector<QuestionGroup>) this.questionGroupsOnThisTrial).afegir(qg);
	}

	public void assignUser(User u) {
		/** 
		 * Quan s'assigna un usuari a un assaig, abans s'ha d'omplir la cua de preguntes "u.questions" de l'usuari
		 * amb les preguntes que hi ha assignades al trial, començant per la 1ª pregunta del grup amb més 
		 * prioritat (com que els grups de preguntes estan ordenats, aleshores només cal que en fem un 
		 * recorregut lineal -> complexitat O(n). Per assolir aquest objectiu implementem el mètode 
		 * "u.addQuestions(Question q)" on el paràmetre d'entrada serà un iterador amb totes les preguntes
		 * de cada grup de preguntes assignats al trial.
		 *  **/
		 
		Iterador<QuestionGroup> qg_it = this.questionGroupsOnThisTrial.elements(); 
		while (qg_it.hiHaSeguent()) {
			QuestionGroup qg_actual = qg_it.seguent();
			Iterador<Question> q_it = (Iterador<Question>) qg_actual.getQuestions().elements(); //Aqui estic fent un cast de Llista a Iterador, no se si funcionara
			while(q_it.hiHaSeguent()) {
				Question q_actual = q_it.seguent();
				u.addQuestion(q_actual);
			}
		}
		
		/**
		 * Un cop tenim les preguntes assigades a la cua de l'objecte "User u", ja podem assignar l'usuari
		 * al trial.
		 * **/
		((DiccionariOrderedVector<String,User>) this.usersOnThisTrial).afegir(u.getUserId(), u);
	}
	
}

