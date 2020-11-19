package uoc.ded.practica.exceptions;

public class UserNotFoundException extends DEDException {
	
	private static final long serialVersionUID = -8982073697983712396L;

	public UserNotFoundException(String idUser) {
		super("No s'ha trobat l'usuari"+idUser);
	}	
}
