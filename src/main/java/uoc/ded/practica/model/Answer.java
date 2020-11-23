package uoc.ded.practica.model;

import java.util.Date;

/* Segons la solució de la PAC1, per a emmagatzemar els grup de preguntes 
 * més adient emprar una llista encadenada: 
 * 
 * Cita de PAC1, Pàg. 17:
 * 
 * "Per guardar les respostes realitzades per un usuari s'utilitzarà una llista
 * encadenada."
 *  
 */

public class Answer {
	
	private String idUser;
	private Date date;
	private String answer;
	
	public Answer(String idUser, Date date, String answer) {
		setIdUser(idUser);
		setDate(date);
		setAnswer(answer);		
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
