package uoc.ded.practica.exceptions;

public class QuestionGroupNotFoundException extends DEDException {

	private static final long serialVersionUID = 5776901602334304556L;

	public QuestionGroupNotFoundException(String idGroup) {
		super("No existeix cap grup amb identificador: "+idGroup);
	}	
}