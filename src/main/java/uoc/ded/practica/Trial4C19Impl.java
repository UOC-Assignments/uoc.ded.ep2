package uoc.ded.practica;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.JavaArray;
import uoc.ded.practica.util.JavaArray_Impl;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.*;

import java.util.Date;

public class Trial4C19Impl implements Trial4C19 {
		
	private JavaArray trials; //A
	private LlistaEncadenada<QuestionGroup> QuestionGroups; //B
	private Diccionari<String, User> users; //C
	private Trial mostActiveTrial;//D
	
	/*
	 * C i E corresponen amb "clau (key)" i "element" respectivament. Com que la classe està 
	 * parametritzada, podem especificar els tipus que desitjem a l'hora de crear l'objecte 
	 * (En e l cas que ens ocupa, String (idUser) per al paràmetre "C" o clau i MyUser 
	 * (objecte que representa un sol usuari) per al paràmetre "E" o element.
	 */
		
	public Trial4C19Impl() {
		/** Creem els objectes TAD que defineixen cadascuna de les estructures de dades 
		 * del TAD Trial4C19 
		 */
		trials = new JavaArray_Impl();
		users = new DiccionariOrderedVector<String, User>();

		//questions = new ...
		//.....
	}

    public void addUser(String idUser, String name, String surname) {
		User user = new User(name, surname);
    	users.afegir(idUser,user);
    }

    public void addTrial(int idTrial, String description) throws Exceptions {
    	
    	/** La comprovació d'errors la fem aquí, abans de treballar sobre el TAD Trial 
    	 * on s'emmagatzemen els assajos [ A més, el "test..." no passa si no es compleix 
    	 * la condició -> (expected = Exceptions.class) ]
    	 */
    	if ( trials.exists(idTrial) ) {
    		throw new Exceptions("Ja existeix un assaig amb identificador: "+idTrial);
    	}
    	trials.trialIndexedInsert(idTrial,description); 
    }

    public void addQuestionGroup(String idQuestionGroup, Priority priority) {

    }

    public void addQuestion(String idQuestion, String wording, Type type, String[] choices, String idGroup) throws QuestionGroupNotFoundException {

    }

    public Iterador<Question> getQuestions(String idGroup) throws QuestionGroupNotFoundException {
        return null;
    }

    public void assignQuestionGroup2Trial(String idGroup, int idTrial) throws QuestionGroupNotFoundException, TrialNotFoundException {

    }

    public void assignUser2Trial(int idTrial, String idUser) throws UserIsAlreadyInTrialException {

    }

    public Question getCurrentQuestion(String idUser) throws UserNotFoundException {
        return null;
    }

    public void addAnswer(String idUser, Date date, String answer) throws UserNotFoundException, NoQuestionsException {

    }

    public Iterador<Answer> getAnswers(String idUser) throws UserNotFoundException, NoQuestionsException {
        return null;
    }

    public User mostActiveUser(int idTrial) {
        return null;
    }

    public Trial mostActiveTrial() {
        return null;
    }

    public int numUsers() {
        return 0;
    }

    public int numTrials() {
        return trials.getNumTrials();
    }

    public int numQuestionGroups() {
        return 0;
    }

    public int numQuestion4Group(String idGroup) {
        return 0;
    }

    public int numQuestionGroups4Trial(int idTrial) {
        return 0;
    }

    public int numUsers4Trial(int idTrial) {
        return 0;
    }

    public User getUser(String idUser) {
        return null;
    }

    public Iterador<QuestionGroup> getQuestionGroups() {
        return null;
    }
}
