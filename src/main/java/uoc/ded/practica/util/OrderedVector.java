package uoc.ded.practica.util;

import uoc.ei.tads.ContenidorAfitat;

public interface OrderedVector<E> extends ContenidorAfitat<E> {

	
    /**
     * Mètode que afegeix un element al vector de manera ordenada
     *
     * @param 
     * 
     * @pre cert
     * @post
     */	
	public void AfegirOrdenat(E elem);
}
