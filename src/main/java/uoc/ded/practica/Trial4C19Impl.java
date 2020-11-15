package uoc.ded.practica;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.DiccionariOrderedVector_Impl;
import uoc.ded.practica.util.JavaArray;
import uoc.ded.practica.util.JavaArray_Impl;
import uoc.ded.practica.util.OrderedVector;
import uoc.ded.practica.util.OrderedVector_Impl;
import uoc.ei.tads.*;

import java.util.Date;

public class Trial4C19Impl implements Trial4C19 {
		
	private JavaArray trials; //A
	private OrderedVector<QuestionGroup> questionGroups; //B
	private DiccionariOrderedVector<String, User> users; //C
	private Trial mostActiveTrial;//D
	

	public Trial4C19Impl() {
		/** Creem els objectes TAD que defineixen cadascuna de les estructures de dades 
		 * del TAD Trial4C19 
		 */
		this.trials = new JavaArray_Impl();	
		this.questionGroups = new OrderedVector_Impl<>();
		this.users = new DiccionariOrderedVector_Impl<>();
		this.mostActiveTrial = new Trial(0,null);
	}

    public void addUser(String idUser, String name, String surname) {
		User user = new User(name, surname);
    	this.users.afegir(idUser,user);
    }

    public void addTrial(int idTrial, String description) throws Exceptions {
    	
    	/** La comprovació d'errors la fem aquí, abans de treballar sobre el TAD Trial 
    	 * on s'emmagatzemen els assajos [ A més, el "test..." no passa si no es compleix 
    	 * la condició -> (expected = Exceptions.class) ]
    	 */
    	Trial trial = new Trial(idTrial,description);
    	if ( trials.exists(idTrial) ) {
    		throw new Exceptions("Ja existeix un assaig amb identificador: "+idTrial);
    	}
    	this.trials.add(trial); 
    }

    public void addQuestionGroup(String idQuestionGroup, Priority priority) {
    	QuestionGroup questionGroup = new QuestionGroup(idQuestionGroup, priority);
    	this.questionGroups.AfegirOrdenat(questionGroup);
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
        return this.trials.getNumTrials();
    }

    public int numQuestionGroups() {
        return this.questionGroups.nombreElems();
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
        return this.questionGroups.elements();
    }
    
    /* Private methods (getters & setters)*/
}
