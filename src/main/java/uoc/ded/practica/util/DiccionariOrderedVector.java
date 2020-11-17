package uoc.ded.practica.util;

import uoc.ded.practica.model.User;
import uoc.ei.tads.*;

public interface DiccionariOrderedVector<C,E> extends Diccionari<C,E>, ContenidorAfitat<E>{

	void afegirOrdenat(String c, E elem);

	/**
	 * SEGUIR PER AQUI 
	 */

}
