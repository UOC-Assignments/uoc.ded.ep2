package uoc.ded.practica.exceptions;

public class UserIsAlreadyInTrialException extends DEDException {
	
	private static final long serialVersionUID = -794646687407930632L;

	public UserIsAlreadyInTrialException(String idUser, int idTrial) {
		super("L'usuari "+idUser+" ja està assignat al assaig "+idTrial);
		//TO-DO
	}	
}