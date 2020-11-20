package uoc.ded.practica.util;

import java.util.Comparator;

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
	 * Retorna 1 si el paràmetre d'entrada "param"
	 * és de major prioritat que "this.element"
	 * 
	 * Retorna 0 si el paràmetre d'entrada "param"
	 * té la mateixa prioritat que "this.element"
	 * 
	 * 	 * Retorna -1 si el paràmetre d'entrada "param"
	 * té prioritat inferior que "this.element"
	 * */
	@Override
	public int compareTo(E param) {
		int paramPriority;
		//Establim prioritat numèrica de param
		if (param.toString().equals(Trial4C19.Priority.HIGH.toString())) { paramPriority = 1; } 
		else if (param.toString().equals(Trial4C19.Priority.MEDIUM.toString())) { paramPriority = 2; }
		else if (param.toString().equals(Trial4C19.Priority.LOWER.toString())) { paramPriority = 3; }
		//Establim prioritat numèrica de element
		if (this.element.toString().equals(Trial4C19.Priority.HIGH.toString())) { paramPriority = 1; } 
		else if (this.element.toString().equals(Trial4C19.Priority.MEDIUM.toString())) { paramPriority = 2; }
		else if (this.element.toString().equals(Trial4C19.Priority.LOWER.toString())) { paramPriority = 3; }
		//Ara ja podem utilitzar la classe "Comparator" genèrica per a decidir quin dels dos elements 
		//és major (param > element ? )
		Comparable a = (Comparable) param;
		Comparable b = (Comparable) param;
		return a.compareTo(b);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

}
