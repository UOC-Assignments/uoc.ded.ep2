package uoc.ded.practica.util;

import java.util.Comparator;
import uoc.ded.practica.model.*;

import uoc.ded.practica.Trial4C19;

/**
 * Classe auxiliar "Comparable_Impl" 
 * que ens permetra parametritzar la classe "OrderedVector" de manera que 
 * aquesta Implementació específica de "Comparable" serà la encarregada de 
 * determinar el tipus dels objectes que volem comparar (groupId o priority)
 * 
 * @todo #1 - Implementar mètode compareIdTo()
 * @todo #2 - unir mètodes compareIdTo() i comparePriorityTo() 
 * utilitzant parametrització i identificació de tipus
 *
 * METHOD: Comparable_Impl.comparePriorityTo(E)
 * 
 * @param <E> generic type element we want compare with another of the same type 
 * */


public class Comparable_Impl<E> implements Comparable<E> {

	private E element;
	
	public Comparable_Impl(E param) {
		this.setElement(param);
	}
	
	/**
	 *
	 * METHOD: Comparable_Impl.comparePriorityTo(E)
	 * 
	 * @param e generic type element we want to compare with
	 * another of the same type (the one defined when calling 
	 * the constructor of the Comparable_Impl object)
	 * 
	 * @return
	 * Retorna 1 si el paràmetre d'entrada "param" (a)
	 * té prioritat superior a "this.element" (b)
	 * 
	 * @return
	 * Retorna 0 si el paràmetre d'entrada "param" (a)
	 * té la mateixa prioritat que "this.element" (b)
	 * 
	 * @return
	 * Retorna -1 si el paràmetre d'entrada "param" (a)
	 * té prioritat inferior que "this.element" (b)
	 * 
	 * @return
	 * Retorna -2 si alguns dels elements comparats
	 * te una prioritat incorrecta
	 * */

	public int comparePriorityTo(E e) {
		Trial4C19.Priority param = ((QuestionGroup) e).getPriority();
		Trial4C19.Priority elem = ((QuestionGroup) this.element).getPriority();
		if (param.ordinal() > elem.ordinal()) { return 1; } 
		else if (param.ordinal() == elem.ordinal()) { return 0; } 
		else if (param.ordinal() < elem.ordinal()) { return -1; }
		return -2;
	}

	public int compareIdTo(E e) {
	//TO-DO
		return -2;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		/**
		 * Es poden unir compareIdTo i comparePriorityTo en aquest si es parametritza correctament 
		 * (e.g. identificar el tipus del paràmetre i prendre acció en funció si és Priority, String, etc)
		 * */
		return 0;
	}
}
