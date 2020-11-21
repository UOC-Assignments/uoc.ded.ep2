package uoc.ded.practica.util;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.ClauValor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class OrderedVector<E> implements ContenidorAfitat<E> {

	private static final long serialVersionUID = 8799289290083114949L;

	/**
    * Nombre d'elements que hi ha actualment al contenidor. Tamb�
    * representa la posici� on s'ha d'empilar un nou element.
    */
   protected int n;

   /** Taula d'elements del contenidor. Les posicions comencen pel zero.*/
   protected E[] elements;

   /**
    * Constructor sense paràmetres (capacitat màxima, per defecte).
    */

   public OrderedVector() { /*TODO*/ } 
   
   /**
    * Constructor amb paràmetres
    * @param capacitat màxima
    */
   public OrderedVector(int G) { 
	  
		  elements = (E[])new Object[G]; 
		  n = 0;
   }

   /** IMPLEMENTACIÓ DE MÈTODES HEREDATS DE LA INTERFICIE "ContenidorAfitat" **/
	
	@Override
	public Iterador<E> elements() {	return new IteradorVectorImpl<E>(elements,nombreElems(),0); }

	@Override
	public boolean estaBuit() {	return n == 0; }

	@Override
	public int nombreElems() { return n; }

	@Override
	public boolean estaPle() { return n == elements.length; }
	
	/** IMPLEMENTACIÓ DE MÈTODES ESPECÍFICS DE LA INTERFICIE "OrderedVector" **/
	
	// Implementació del Mètode "Afegir". 
	
	@SuppressWarnings("unchecked")
	public void afegir(E elem){ 
			
		/** 
		 * ALGORISME: (adaptar, l'he copiat de DiccionariOrderedVector)
		 *
		 * found := false;
		 * index := 0; 
		 * Si el diccionari és buit, 
		 *    aleshores afegim a la posició n := 0;
		 * si no, 
		 *    mentre hi hagi elements al diccionari i no s'hagi trobat la clau (found)
		 *       Si l'usuari que volem afegir té el mateix Id que l'actual, sobreescribim a "index"
		 *       si no,
		 *         si l'usuari que volem afegir té UserId major, avançem l'iterador (index++)
		 *         Si no, desplaçem tots els elements a partir de "index" una posició i afegim a "index"
		 * Si no trobem cap userId més gran, aleshores afegim al final 
		 * 
		 * */
		
		//FALTA BUSCAR PRIMER SI EL ID DE GRUP EXISTEIX I SI ES AIXÍ ACTUALITZAR 
		//(NO PASSA TEST "TestAddQuestion"). Utilitzar "Comparable_Impl.compareIdTo
		boolean update = false;
		int result = -99;
		int actual = 0;
		if (!this.estaBuit()) {			
			Iterador<E> it1 = this.elements();			
			while(it1.hiHaSeguent() & !update) {
				Comparable_Impl<E> actualQG = new Comparable_Impl<E>(it1.seguent());
				result = actualQG.compareIdTo((E) elem); 
				//Si trobem l'element, aleshores, l'eliminem del vector i el desem en un objecte temporal. 
				//D'aquesta manera després el podrem inserir de manera ordenada utlitzant el mateix algorisme.
				if (result == 1 ) {
					//DESEM "ActualQG" A UN OBJECTE TEMPORAL
					//ELIMINEM ELEMENT DEL VECTOR
					//update = true
				}
				actual++;
			}
			if (update) {
				e=actualQG;
			}else {
				e=elem;
			}
		}				
		
		//Si no... Si el diccionari és buit, aleshores afegim a la posició n = 0;
		 if (this.estaBuit()) {
			int i;
			elements[0]=elem;
			n++;
		} else {
			boolean found = false;
			int index = 0; 	
			Iterador<E> it = this.elements();			
			while(it.hiHaSeguent() & !found) {
				Comparable_Impl<E> actualQG = new Comparable_Impl<E>(it.seguent());
			    result = actualQG.comparePriorityTo((E) e);
			    // Si el grup de preguntes que volem afegir té prioritat superior o igual, desplaçem elements i sobreescribim a "pos"
			    if (result >= 1) {
			    	desplacarElements(index);
			    	elements[index] = e;
			    	n++;
			    	found = true; 
			    // Si el grup de preguntes que volem afegir té prioritat inferior...
				} else {
					//Si hi ha més elements, avançem l'iterador
					if (it.hiHaSeguent()) {
						index++;
					//Si actualQG és el darrer grup de preguntes, afegim al final (index = n)
					} else {
						elements[n] = e;
						n++;
					}
				}
			} 			
		}
	}

	//AQUEST MÈTODE HAURIA D'ESTAR PARAMETRITZAT (RETORNAR TIPUS E)
	public QuestionGroup existeix(String idGroup) {
		QuestionGroup qg;
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0);
		while (it.hiHaSeguent()) {
			qg = (QuestionGroup) it.seguent();
			if ( qg.getIdGroup().equals(idGroup) ) { return qg; }
		}
		return null;
	}
	
	/***************************************************** 
	 * 
	 *                  MÈTODES AUXILIARS 
	 * 
	 * ***************************************************/
    
	private void desplacarElements(int pos) {
		int i;
		for (i=this.nombreElems();i>pos;i--) {
			elements[i]=elements[i-1];
		} 
	}
}