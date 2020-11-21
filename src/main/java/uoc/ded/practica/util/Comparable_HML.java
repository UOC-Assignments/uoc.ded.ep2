package uoc.ded.practica.util;

import java.util.Comparator;
import uoc.ded.practica.model.*;

import uoc.ded.practica.Trial4C19;

/**
 * 
 * Classe auxiliar "Comparable_HML" (High, Medium, Low)
 * que ens permetra parametritzar la classe "OrderedVector
 * 
 * */

public class Comparable_HML<E> implements Comparable<E> {

	private E element;
	
	public Comparable_HML(E param) {
		this.setElement(param);
	}
	
	/**
	 * compareTo(): 
	 * 
	 * Retorna 1 si el paràmetre d'entrada "param" (a)
	 * té prioritat superior a "this.element" (b)
	 * 
	 * Retorna 0 si el paràmetre d'entrada "param" (a)
	 * té la mateixa prioritat que "this.element" (b)
	 * 
	 * 	 * Retorna -1 si el paràmetre d'entrada "param" (a)
	 * té prioritat inferior que "this.element" (b)
	 * */
	@Override
	public int compareTo(E e) {
		Trial4C19.Priority param = ((QuestionGroup) e).getPriority();
		Trial4C19.Priority elem = ((QuestionGroup) this.element).getPriority();
		if (param.ordinal() > elem.ordinal()) { return 1; } 
		else if (param.ordinal() == elem.ordinal()) { return 0; } 
		else if (param.ordinal() < elem.ordinal()) { return -1; }
		return -2;
	}


	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}
}
