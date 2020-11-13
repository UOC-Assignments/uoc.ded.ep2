package uoc.ded.practica;

import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.*;
import uoc.ded.practica.util.DiccionariOrderedVector;
import uoc.ded.practica.util.OrderedVector;
import uoc.ei.tads.*;

import java.util.Date;

public class Trial4C19Impl implements Trial4C19 {
	
	private Trial trials; //Potser ha de ser protected i anar dins el constructor???
	
	public Trial4C19Impl() {
		/* Creem els objectes TAD que defineixen cadascuna de les estructures de dades 
		 * del TAD Trial4C19 */
		trials = new Trial_Impl();
		//users = 
		//questions = 
		//....
	}

    public void addUser(String idUser, String name, String surname) {

    }

    public void addTrial(int idTrial, String description) throws Exceptions {
    	//La comprovació d'errors la fem aquí, abans de treballar sobre el TAD Trial on s'emmagatzemen els assajos (Trial)
    	
    	trials.trialIndexedInsert(idTrial,description); //Susbstitueix: this.trialIndexedInsert(e);
    	System.out.println("trial added"); //******DEBUG
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
