package uoc.ded.practica;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.*;

import java.util.Date;

public class Trial4C19Impl implements Trial4C19 {
		
	private Trial[] trials; //A
	private ContenidorAfitat<QuestionGroup> questionGroups; //B
	private Diccionari<String, User> users; //C
	private Trial mostActiveTrial;//D	

	public Trial4C19Impl() {
		/** Creem els objectes TAD que defineixen cadascuna de les estructures de dades 
		 * del TAD Trial4C19 
		 */
		this.trials = new Trial[Trial4C19.T]; 
		this.questionGroups = new OrderedVector<>(Trial4C19.G); //BUG #001
		this.users = new DiccionariOrderedVector<>(Trial4C19.U);
		this.mostActiveTrial = new Trial(0,null);
	}

    public void addUser(String idUser, String name, String surname) {
		User user = new User(idUser, name, surname);
		if (!((DiccionariOrderedVector<String,User>) this.users).estaPle()) { //cas d'ús de la implementació de contenidorAcotat
			((DiccionariOrderedVector<String, User>) this.users).afegir(idUser,user);
		}
    }

    public void addTrial(int idTrial, String description) throws Exceptions {
    	
    	/** La comprovació d'errors la fem aquí, abans de treballar sobre el TAD Trial 
    	 * on s'emmagatzemen els assajos [ A més, el "test..." no passa si no es compleix 
    	 * la condició -> (expected = Exceptions.class) ]
    	 */
    	Trial trial = new Trial(idTrial,description);
    	if ( trials[idTrial] != null ) {
    		throw new Exceptions(idTrial);
    	}
    	this.trials[idTrial]=trial; 
    }

    public void addQuestionGroup(String idQuestionGroup, Priority priority) {
    	QuestionGroup questionGroup = new QuestionGroup(idQuestionGroup, priority);
    	((OrderedVector<QuestionGroup>) this.questionGroups).AfegirOrdenat(questionGroup); //Hem de fer un cast pq la classe implementa un tipus contenidor
    }

    public void addQuestion(String idQuestion, String wording, Type type, String[] choices, String idGroup) throws QuestionGroupNotFoundException {    	  	
    	QuestionGroup qg = ((OrderedVector<QuestionGroup>) questionGroups).existeix(idGroup); 
    	if ( qg == null ) {
    		throw new QuestionGroupNotFoundException(idGroup);
    	} else { 
        	Question q = new Question(idQuestion,wording,type,choices);
        	qg.addQuestion(q);
    	}	
    }

    public Iterador<Question> getQuestions(String idGroup) throws QuestionGroupNotFoundException {
    	QuestionGroup qg = ((OrderedVector<QuestionGroup>) questionGroups).existeix(idGroup); 
    	if ( qg == null ) {
    		throw new QuestionGroupNotFoundException(idGroup);
    	} else { return qg.getQuestions().elements(); }	
    }

    public void assignQuestionGroup2Trial(String idGroup, int idTrial) throws QuestionGroupNotFoundException, TrialNotFoundException {
    	QuestionGroup qg = ((OrderedVector<QuestionGroup>) questionGroups).existeix(idGroup); 
    	if ( qg == null ) {
    		throw new QuestionGroupNotFoundException(idGroup);
    	} else if ( trials[idTrial] == null ) {
    		throw new TrialNotFoundException(idTrial);
    	} else { 
    		trials[idTrial].assignQuestionGroup(qg); 
    	}    	
    }

    public void assignUser2Trial(int idTrial, String idUser) throws UserIsAlreadyInTrialException {
    	int i;
    	Boolean exists = false;
    	User userInTrial;
    	//En primer lloc hem de buscar a tots els trials per a saber si l'usuari ja esta assignat a algun d'ells
    	for (i=0;i<Trial4C19.T;i++) {
    		if (trials[i]!=null) {
    			userInTrial = this.trials[i].getUsersOnThisTrial().consultar(idUser);
    			if (userInTrial != null) { 
    				exists = true; 
    			}
    		}
    	}
    	//Si l'usuari ja està assignat a un altre assaig, llançem excepció
    	if (exists) {
    		throw new UserIsAlreadyInTrialException(idUser,idTrial);
    	//Si l'usuari no existeix a cap trial, aleshores l'inserim al trial "idTrial"
    	} else {
    		User u = users.consultar(idUser); 
    		this.trials[idTrial].assignUser(u);
    	}
    }

    public Question getCurrentQuestion(String idUser) throws UserNotFoundException {
    	//Primer hem de comprovar si l'usuari existeix
    	User u = this.users.consultar(idUser);
    	Question ret = null;
    	if (u != null) { 
    	//Si existeix, aleshores hem de veure si té preguntes per respondre
    		if (!u.getQuestions().estaBuit()) {
    	    	//Si és que si, aleshores desencuem la pregunta del final i retornem l'objecte (Question)
    			ret =  u.getQuestions().desencuar();
    		}
    	 }
    	return ret;
    }

    public void addAnswer(String idUser, Date date, String answer) throws UserNotFoundException, NoQuestionsException {
    	//TODO
    }

    public Iterador<Answer> getAnswers(String idUser) throws UserNotFoundException, NoQuestionsException {
    	//TODO
        return null;
    }

    public User mostActiveUser(int idTrial) {
    	//TODO
        return null;
    }

    public Trial mostActiveTrial() {
    	//TODO
        return null;
    }

    public int numUsers() {
        return this.users.nombreElems();
    }

    public int numTrials() {
		int i;
		int count = 0;
		for (i=0;i<Trial4C19.T;i++) {
			if (trials[i] != null) {
				count++;
			}
		}
		return count;
    }

    public int numQuestionGroups() {
        return this.questionGroups.nombreElems();
    }

    public int numQuestion4Group(String idGroup) {   	
    	QuestionGroup qg = ((OrderedVector<QuestionGroup>) questionGroups).existeix(idGroup); 
    	return qg.getQuestions().nombreElems();
    }

    public int numQuestionGroups4Trial(int idTrial) {
    	
        return this.trials[idTrial].getQuestionGroupsOnThisTrial().nombreElems();
    }

    public int numUsers4Trial(int idTrial) {
        return trials[idTrial].getUsersOnThisTrial().nombreElems();
    }

    public User getUser(String idUser) {
    	if (this.users.hiEs(idUser)) {
    		return this.users.consultar(idUser);
    	} else { return null; }
    }

    public Iterador<QuestionGroup> getQuestionGroups() {
        return this.questionGroups.elements();
    }
    
}
