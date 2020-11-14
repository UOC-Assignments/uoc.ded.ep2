package uoc.ded.practica.model;

import uoc.ded.practica.Trial4C19;
import uoc.ei.tads.ClauValor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;
import uoc.ei.tads.Iterador;

public class User<C,E> implements Diccionari<C,E>, ContenidorAfitat<E> {
	
	/**
 * 
 */
private static final long serialVersionUID = 1L;

/* codi de "DiccionariVectorImpl" */

protected ClauValor<C,E>[] diccionari;
protected int idUser;

/* codi de "CuaVectorImpl" */
  
   public static final int MAXIM_ELEMENTS_PER_DEFECTE = 256;

   /** Taula d'elements del contenidor. */
   protected E[] elements;

   /** Nombre d'elements que hi ha actualment al contenidor. */
   protected int n;

   /** Primer element de la cua. */
   private int  primer;

   /** Constructor:
    * 
    *  Creem dues estructures de dades per a emmagatzemar els usuaris; 
    *  
    *  La primera "Elements" consisteix en la implementació d'un vector mitjançant la interfície 
    *  "contenidor afitat", el qual ens servirà per emmagatzemar sense ordre (sempre desem al d 
    *  
    *  */

   public User(int idUser) { 
	   elements = (E[])new Object[Trial4C19.U]; // Capacitat m�xima per defecte del contenidor -> Trial4C19.U = 560 usuaris
	   n = 0;
	   primer = 0;
	   diccionari = (ClauValor<C,E>[])new ClauValor[idUser]; 
	}

   /**
* Constructor sense par�metres (capacitat m�xima, per defecte).
* @post n == 0 && this.max == MAXIM_ELEMENTS_PER_DEFECTE
*/
   public CuaVectorImpl()
   {

   }


//GETTER & SETTER: NOMÉS SÓN ACCESSIBLES DES DE L'SCOPE DEL TAD COM A OPERACIONS INTERNES

private User<C,E> getUsers() {
	return users;
}

private void setUsers(User<C,E> users) {
	this.users = users;
}

//OVERRIDES & CUSTOM METHODS

@Override
public Iterador<E> elements() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean estaBuit() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int nombreElems() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean estaPle() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void afegir(C idUser, E user) {
	// TODO Auto-generated method stub
	
}

@Override
public Iterador<C> claus() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public E consultar(C arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public E esborrar(C arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean hiEs(C arg0) {
	// TODO Auto-generated method stub
	return false;
}

public String getName() {
	// TODO Auto-generated method stub
	return null;
}

public String getSurname() {
	// TODO Auto-generated method stub
		return null;
	}
}
