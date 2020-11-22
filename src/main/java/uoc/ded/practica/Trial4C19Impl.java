package uoc.ded.practica;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.*;

import java.util.Date;

public class Trial4C19Impl implements Trial4C19 {
		
	private Trial[] trials;
	private ContenidorAfitat<QuestionGroup> questionGroups;
	private Diccionari<String, User> users;
	private Trial mostActiveTrial;	

	public Trial4C19Impl() {
		/** Creem els objectes TAD que defineixen cadascuna de les estructures de dades 
		 * del TAD Trial4C19 
		 */
		this.trials = new Trial[Trial4C19.T]; 
		this.questionGroups = new OrderedVector<>(Trial4C19.G); 
		this.users = new DiccionariOrderedVector<>(Trial4C19.U);
		this.mostActiveTrial = new Trial(0,null);
	}

    public void addUser(String idUser, String name, String surname) {
		User user = new User(idUser, name, surname);
		if (!((DiccionariOrderedVector<String,User>) this.users).estaPle()) { //cas d'ús de la implementació de contenidorAcotat
			((DiccionariOrderedVector<String, User>) this.users).afegir(idUser,user);
		}
    }

    public void addTrial(int idTrial, String description) throws TrialAlreadyExistsException {
    	
    	/** La comprovació d'errors la fem aquí, abans de treballar sobre el TAD Trial 
    	 * on s'emmagatzemen els assajos [ A més, el "test..." no passa si no es compleix 
    	 * la condició -> (expected = Exceptions.class) ]
    	 */
    	Trial trial = new Trial(idTrial,description);
    	if ( trials[idTrial] != null ) {
    		throw new TrialAlreadyExistsException(idTrial);
    	}
    	this.trials[idTrial]=trial; 
    }

    public void addQuestionGroup(String idQuestionGroup, Priority priority) {
    	QuestionGroup questionGroup = new QuestionGroup(idQuestionGroup, priority);
    	((OrderedVector<QuestionGroup>) this.questionGroups).afegir(questionGroup); //Hem de fer un cast pq la classe implementa un tipus contenidor
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
    	Question q = null;
    	if (u != null) { 
    	//Si existeix, aleshores hem de veure si té preguntes per respondre ->  AIXO NO CAL PQ NO HO DEMANA EN CONTRACTE !?
    		if (!u.getQuestions().estaBuit()) {
    	    	//Si és que si, aleshores desencuem la pregunta del final i retornem l'objecte (Question)
    			q =  u.getQuestions().desencuar();
    			u.getQuestions().encuar(q); //Cua circular (afegirr comentari bloc de notes paper)
    		}
    	 }
    	return q;
    }

    public void addAnswer(String idUser, Date date, String answer) throws UserNotFoundException, NoQuestionsException {
    	if (!this.users.hiEs(idUser)) {
    		throw new UserNotFoundException(idUser);
    	} else if (this.users.consultar(idUser).getQuestions().estaBuit()) {
    		throw new NoQuestionsException();
    	} else {
    		this.users.consultar(idUser).addAnswer(new Answer(idUser, date, answer));
    	}
    	//Finalment comprovem si idUser és el usuari que més respostes ha fet. En cas afirmatiu,
    	//actualitzarem l'usuari més actiu -> this.users.mostActiveUser = idUser;
    	int userAnswers = this.users.consultar(idUser).getAnswers().nombreElems();  
    	Boolean found = false;
    	int max = 0;
    	Iterador<User> it = this.users.elements();		
    	while ( (it.seguent() != null) & (!found) ) {
			User u = it.seguent();
			if( u.getAnswers().nombreElems() > max ) {
				max = u.getAnswers().nombreElems();
			}
    	}
    	if (userAnswers > max) {
    		// Busquem a quin Trial està assignat l'usuari i establim setMostActiveUser = this.users.consultar(idUser)
    		int i;
			Boolean userFound = false;
    		for (i=0;i<Trial4C19.T;i++) 
    		while (i<Trial4C19.T & !userFound)
    		{
    			userFound = idUser.equals(this.trials[i].getUsersOnThisTrial().consultar(idUser).getUserId());
    			if (!userFound) i++;
    		}
			if (userFound) {
				this.trials[i].setMostActiveUser(this.users.consultar(idUser));			
			}
    	}
    }

    public Iterador<Answer> getAnswers(String idUser) throws UserNotFoundException, NoQuestionsException {
    	if (!this.users.hiEs(idUser)) {
    		throw new UserNotFoundException(idUser);
    	}
    	else if (this.users.consultar(idUser).getQuestions().estaBuit()) {
    		throw new NoQuestionsException();
    	} else {
            return this.users.consultar(idUser).getAnswers().elements();
    	}
    }

    public User mostActiveUser(int idTrial) {
    	return this.trials[idTrial].getMostActiveUser();
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
    
    /** 
     * MÈTODES AUXILIARS DEFINITS PER A COMPLEMENTAR ELS TESTS ADDICIONALS (Test4C19EP2TestExtended.java)
     */
    public Iterador<User> getUsers() {
        return this.users.elements();
    }
}
