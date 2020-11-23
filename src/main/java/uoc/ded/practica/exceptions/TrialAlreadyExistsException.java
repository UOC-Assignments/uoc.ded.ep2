package uoc.ded.practica.exceptions;

public class TrialAlreadyExistsException extends DEDException {

	private static final long serialVersionUID = -5648514238610085525L;

	public TrialAlreadyExistsException(int idTrial) {
		super("Ja existeix un assaig amb identificador: "+idTrial);
	}	
}