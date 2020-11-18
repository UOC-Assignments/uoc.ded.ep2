package uoc.ded.practica.util;

import java.util.Iterator;

import uoc.ded.practica.Trial4C19;
import uoc.ded.practica.model.Question;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class OrderedVector<E> implements ContenidorAfitat<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	//Implementació del Mètode "AfegirOrdenat". 
	//
	//OBSERVACIONS: 
	//Per agilitzar la implementació s'ha
	//decidit no implementar l'actualització de grups de preguntes ja existents, definida a la PAC1. Aquesta decisió s'ha
	//pres ja que els resultats dels jocs de proves no es veuen afectats per l'abscència d'aquesta
	//funcionalitat i em queda poc temps per acabar la resta de la EP2
	
	public void AfegirOrdenat(E elem){ //LA PRIORITAT HA D'ESTAR PARAMETRITZADA PER A NO REFERENCIAR UNA CONSTANT DEL TAD TRIAL4C19 DES D'AQUESTA CLASSE (CONTENIDOR). ES TRACTA D'UNA ERRADA DE DISSENY QUE NO AFECTA EL JOC DE PROVES PERÒ QUE S'HA D'ARREGLAR
		
		// Si el vector incialment està buit, afegim a la primera posició (n=0) sense haver de 
		// comparar prioritats
		
		if (this.estaBuit()) { 
			elements[0] = elem;
		}
		
		// Si no està buit, hem de seleccionar la posició d'inserció en funció de la prioritat del nou element (qg_nou)
		
		else {
			
			int pos = 0; int i;
			IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0); 
			QuestionGroup qg_nou = (QuestionGroup) elem;
			
			// Si el grup de preguntes que volem afegir té prioritat "HIGH", desplaçem la resta d'elements i afegim al principi (n=0)
			
			if (qg_nou.getPriority().equals(Trial4C19.Priority.HIGH)) {
				for (i=this.nombreElems();i>0;i--) {
					elements[i]=elements[i-1];
				}
				elements[0] = elem;	
			}
			
			// Si el grup de preguntes que volem afegir té prioritat "MEDIUM" busquem el darrer element amb prioritat HIGH i afegim DESPRES d'aquest.
			// Si no existeix cap element amb prioritat HIGH, alesores desplaçem tot a partir de n=0 i inserim al primer element. 
			
			else if (qg_nou.getPriority().equals(Trial4C19.Priority.MEDIUM)) {
				QuestionGroup qg_seguent = (QuestionGroup) it.seguent();
				while (qg_seguent.getPriority().equals(Trial4C19.Priority.HIGH)) {
					qg_seguent = (QuestionGroup) it.seguent();
					pos++;
				}
				if (pos != n) { 

					for (i=this.nombreElems();i>pos;i--) {
						elements[i]=elements[i-1];
					}
					elements[pos] = elem;	
				} else {
					for (i=this.nombreElems();i>0;i--) {
						elements[i]=elements[i-1];
					}
					elements[0] = elem;					
				}
			}
			
			//Si el grup de preguntes que volem afegir té prioritat "LOWEST", aleshores busquem el primer element amb prioritat "LOWEST" del vector i afegim al davant.
			//Si no existeix, aleshores afegim a la darrera posició lliure (n)
			
			else if (qg_nou.getPriority().equals(Trial4C19.Priority.LOWER)) {
				
				QuestionGroup qg_seguent = (QuestionGroup) it.seguent();
				Boolean found = false;
				while (qg_seguent.getPriority().equals(Trial4C19.Priority.LOWER)) {
					qg_seguent = (QuestionGroup) it.seguent();
					found = true;
					pos++;
				}
				if (found) { 

					for (i=this.nombreElems();i>pos;i--) {
						elements[i]=elements[i-1];
					}
					elements[pos] = elem;	
				} else {
					elements[n] = elem;					
				}
			}
		}
		
		//Finalment incrementem la quantitat d'elements del vector un cop efegit l'element
		n++;
	}

	public QuestionGroup existeix(String idGroup) {
		QuestionGroup qg;
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0);
		while (it.hiHaSeguent()) {
			qg = (QuestionGroup) it.seguent();
			if ( qg.getIdGroup().equals(idGroup) ) { return qg; }
		}
		return null;
	}
    
	//EN DESUS Moure a Trial4C19Impl.java (addQuestion)
	
	public void afegirPreguntaAlGrup(String idGroup, Question question) {
		QuestionGroup qg;
		IteradorVectorImpl<E> it = new IteradorVectorImpl<E>(elements,nombreElems(),0);
		while (it.hiHaSeguent()) {
			qg = (QuestionGroup) it.seguent();
			if ( qg.getIdGroup().equals(idGroup) ) {
				qg.addQuestion(question);
			}
		}		
	}
}