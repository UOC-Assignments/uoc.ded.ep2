package uoc.ded.practica.util;

import uoc.ei.tads.ContenidorAfitat;

public interface OrderedVector<E> extends ContenidorAfitat<E> {

	
    /**
     * Mètode que afegeix un element al vector de manera ordenada en funció de la 
     * prioritat establerta (HIGH, MED, LOW). 
     *
     * @param 
     * 
     * @pre cert
     * @post
     */	
	public void AfegirOrdenat(E elem);
}
