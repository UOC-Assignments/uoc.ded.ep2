package uoc.ded.practica.exceptions;

public class NoQuestionsException extends DEDException {
	
	private static final long serialVersionUID = -2592621763962669366L;

	public NoQuestionsException() {
		super("L'usuari no té preguntes assignades");
	}
}