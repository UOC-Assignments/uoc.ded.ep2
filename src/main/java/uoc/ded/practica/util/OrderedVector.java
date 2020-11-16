package uoc.ded.practica.util;

import java.util.Iterator;

import uoc.ded.practica.model.Question;
import uoc.ded.practica.model.QuestionGroup;
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
	
    /**
     * Mètode que retorna true si un element existeix al vector
     *
     * @param 
     * 
     * @pre cert
     * @post
     */	
	public QuestionGroup existeix(String idGrup);

    /**
     * Mètode que retorna true si un element existeix al vector
     *
     * @param 
     * 
     * @pre cert
     * @post
     */	
	public void afegirPreguntaAlGrup(String idGroup, Question question);
}
