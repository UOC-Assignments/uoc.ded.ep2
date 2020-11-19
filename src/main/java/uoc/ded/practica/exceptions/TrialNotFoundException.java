package uoc.ded.practica.exceptions;

public class TrialNotFoundException extends DEDException {

	private static final long serialVersionUID = 1480510310713154378L;

	public TrialNotFoundException(int idTrial) {
		super("No existeix cap assaig amb identificador: "+idTrial);
	}	
}