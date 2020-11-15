package uoc.ded.practica.util;

import uoc.ded.practica.model.Trial;

/**
 * Definició del CONTENIDOR per a l'emmagatzematge d'assajos (Trials)
 * 
 */

public interface JavaArray {
    /**
     * Mètode que insereix un nou element a un vector de java de manera indexada 
     * (en funció del paràmetre idTrial). 
     *
     * @param idTrial -> identificador de l'assaig
     * @param description -> descripció textual de l'assaig
     * 
     * @pre l'element amb índex idTrial no existeix al vector
     * @post els elements del vector de java seran els mateixos,
     * més un nou element amb la descricpió indicada al paràmetre 
     * "description". 
     */
	public void add(Trial trial);
	
    /**
     * Mètode que retorna el nombre d'assajos
     *
     * @return nombre d'elements al vector de trials.
     * 
     * @pre cert (POTSER S'HA D'AFEGIR QUE LA RESPONSABILITAT DE COMPROVAR QUE NO EXISTEIXI EL TRIAL ÉS DE L'USUARI DEL TAD)
     * @post els nombre d'elements que conté el vector de trials
     */
	public int getNumTrials();
	
    /**
     * Mètode que retorna "cert" si un assaig existeix 
     *
     * @param idTrial -> identificador de l'assaig
     * 
     * @pre cert
     * @post retorna un booleà que indica si un assaig existeix
     */
	public boolean exists(int idTrial);
}

/*************************************************************************************************
 * 
 *                            REFERÈNCIES BIBLIOGRÀFIQUES I DOCUMENTACIÓ
 * 
 *************************************************************************************************
 * 
 * Segons la solució de la PAC1, per a emmagatzemar els grup de preguntes 
 * és adient emprar una estructura estàtica (vector): 
 * 
 * Cita de PAC1, Pàg. 11:
 * 
 * "Per guardar els assajos clínics  és millor utilitzar una estructura estàtica ja que el
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
 
