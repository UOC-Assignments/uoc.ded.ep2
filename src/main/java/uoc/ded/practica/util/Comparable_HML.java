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
	public int compareTo(E param) {
		int paramPriority = 0;
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
		Comparable<E> a = (Comparable<E>) param;
		Comparable<E> b = (Comparable<E>) this.getElement();
		return a.compareTo((E) b);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

}
