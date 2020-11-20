package uoc.ded.practica.model;

/* Segons la solució de la PAC1, per a emmagatzemar els grup de preguntes 
 * �s adient emprar un vector ordenat per prioritat: 
 * 
 * Cita de PAC1, P�g. 12:
 * 
 * "Per guardar els grups de preguntes usarem un vector ordenat (per
 * prioritat), ja que es tratar un nombre petit, no variarà molt i està fitat."
 * 
 * Cita de PAC1, P�g. 17:
 * 
 * "Per guardar els grups de preguntes, implementarem una nova classe
 * que implementi un vector ordenat amb operacions per afegir
 * ordenadamente. Com no haurem de fer consultes no cal implementar
 * cerca dicotòmica. Per integrar aquesta classe a la biblioteca de classes ha
 * d'implementar la interfície ContenedorAcotado."
 * 
 */
import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.LlistaEncadenada;
import uoc.ei.tads.Llista;

public class QuestionGroup {
	
	private String idQuestionGroup;
	private Trial4C19.Priority priority;
	private Llista<Question> questions;
	
	public QuestionGroup(String idQuestionGroup,Trial4C19.Priority priority){
		setIdQuestionGroup(idQuestionGroup);
		setPriority(priority);
		setQuestions(new LlistaEncadenada<>());
	}

	public String getIdQuestionGroup() {
		return this.idQuestionGroup;
	}

	public void setIdQuestionGroup(String idQuestionGroup) {
		this.idQuestionGroup = idQuestionGroup;
	}
	
	public Trial4C19.Priority getPriority() {
		return priority;
	}

	public void setPriority(Trial4C19.Priority priority) {
		this.priority = priority;
	}
	
	public Llista<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Llista<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question q) {
		this.questions.afegirAlFinal(q);
	}

	public String getIdGroup() {
		return this.idQuestionGroup;
	}
}	
