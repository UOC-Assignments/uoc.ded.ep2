package uoc.ded.practica.model;

/* Segons la solució de la PAC1, per a emmagatzemar els  
 * usuaris s'ha d'utilitzar una estrutura de "vector ordenat" per a 
 * representar el  TAD "User":
 * 
 * Pàgs. 11-12:
 * 
 * "(...) l'estructura més adequada seria un vector ordenat pel seu 
 * identificador, ja que ocupa l'espai just i necessari i permet 
 * realitzar cerques dicotòmiques O(log U) per localitzar a l'usuari
 * a partir del seu identificador. (...)"
 * 
 * Pàg. 16:
 * 
 * "(...) Per guardar els usuaris, implementarem una nova classe que implementi
 * un vector ordenat amb operacions per afegir ordenadamente, i fer
 * consultes mitjançant cerca dicotòmica. Per integrar aquesta classe a la
 * biblioteca de classes ha d'implementar les interfícies de
 * ContenedorAcotado i de Diccionari. (...)"
 * 
 * Per tant, importarem les interficies "ContenidorAfitat" i "Diccionari" 
 * (proporcionades a la llibreria de TADS de l'assignatiura) per tal de 
 * poder implementar el vector ordenat on emmagatzemarem els usuaris:
 * 
 */

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Diccionari;

public class User {

	//TO-DO
}
