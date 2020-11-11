package uoc.ded.practica.model;

/* Segons la solució de la PAC1, per a emmagatzemar els grup de preguntes 
 * és adient emprar una estrctura estàtica (vector): 
 * 
 * Cita de PAC1, Pàg. 11:
 * 
 * "Per guardar els assajos clínics és millor utilitzar una estructura estàtica ja que el
 * nombre d'assajos clínics és conegut, petit i fitat. (...) Dins de les estructures estàtiques 
 * podrem triar entre (...) i un simple vector on cada assaig clínic ocupa la posició que defineix
 * el seu identificador. Així, la cerca d'un assaig clínic la podrem fer accedint
 * directament a la posició del vector (no tindrem ni que fer cerca dicotòmica) i tindrà
 * cost constant O (1). L'elecció serà doncs un vector on cada assaig clínic ocupa la posició que
 * defineix el seu identificador."
 *
 * Cita de PAC1, Pàg. 17:
 * 
 * "Per guardar els assajos clínics utilitzarem un array de Java ja que
 * només necessitem accés directe per posició. (Trial[] )"
 * 
 */

public class Trial {
	
    // Nombre màxim d'assajos
    public final int MAX_TRIALS = 100;


}
