package uoc.ded.practica.model;

/* Segons la soluci� de la PAC1, per a emmagatzemar els grup de preguntes 
 * �s adient emprar una estrctura est�tica (vector): 
 * 
 * Cita de PAC1, P�g. 11:
 * 
 * "Per guardar els assajos cl�nics �s millor utilitzar una estructura est�tica ja que el
 * nombre d'assajos cl�nics �s conegut, petit i fitat. (...) Dins de les estructures est�tiques 
 * podrem triar entre (...) i un simple vector on cada assaig cl�nic ocupa la posici� que defineix
 * el seu identificador. Aix�, la cerca d'un assaig cl�nic la podrem fer accedint
 * directament a la posici� del vector (no tindrem ni que fer cerca dicot�mica) i tindr�
 * cost constant O (1). L'elecci� ser� doncs un vector on cada assaig cl�nic ocupa la posici� que
 * defineix el seu identificador."
 *
 * Cita de PAC1, P�g. 17:
 * 
 * "Per guardar els assajos cl�nics utilitzarem un array de Java ja que
 * nom�s necessitem acc�s directe per posici�. (Trial[] )"
 * 
 */

public class Trial {
	
    // Nombre m�xim d'assajos
    public final int MAX_TRIALS = 100;


}
