package uoc.ded.practica;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.Answer;
import uoc.ded.practica.model.Question;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ei.tads.Iterador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trial4C19EP2TestExtended {

    private Trial4C19 trial4C19;

    @Before
    public void setUp() throws Exception {
        this.trial4C19 = FactoryTrial4C19Extended.getTrial4C19();
    }

    @After
    public void tearDown() {
        this.trial4C19 = null;
    }


    /**
     * *feature*: (sobre la que fem @test): addUser del TAD TrialC19
     * *given*: Hi ha 10 usuaris en el sistema
     * *scenario*:
     * - S'afegeix un nou usuari en el sistema
     * - S'afegeix un segon usuari en el sistema
     * - Es modifiquen les dades del segon usuari inserir
     */
      
    /*@Test  
    public void testAddUser() {

        // GIVEN:
        Assert.assertEquals(10, this.trial4C19.numUsers());
        //

        this.trial4C19.addUser("idUser1000", "Robert", "Lopez");
        Assert.assertEquals("Robert", this.trial4C19.getUser("idUser1000").getName());
        Assert.assertEquals(11, this.trial4C19.numUsers());

        this.trial4C19.addUser("idUser9999", "XXXXX", "YYYYY");
        Assert.assertEquals("XXXXX", this.trial4C19.getUser("idUser9999").getName());
        Assert.assertEquals(12, this.trial4C19.numUsers());

        this.trial4C19.addUser("idUser9999", "Lluis", "Casals");
        Assert.assertEquals("Lluis", this.trial4C19.getUser("idUser9999").getName());
        Assert.assertEquals("Casals", this.trial4C19.getUser("idUser9999").getSurname());
        Assert.assertEquals(12, this.trial4C19.numUsers());
    }*/
    
    /**
     * *feature*: (sobre la que fem @test): addTrial del TAD Trial4C19
     * *given*: Hi ha 6 Assajos en el sistema
     * *scenario*:
     * - S'afegeix un nou assaig en el sistema
     * - S'afegeix un segon assaig en el sistema
     */
    /*@Test
    public void testAddTrial() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        this.trial4C19.addTrial(22, "Description 22");
        this.trial4C19.addTrial(6, "Description 6");
        Assert.assertEquals(8, this.trial4C19.numTrials());
    }*/

    /**
     * *feature*: (sobre la que fem @test): addTrial del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema
     * *scenario*:
     * - S'afegeix un nou assaig en el sistema
     * - S'afegeix un segon assaig en el sistema que ja existeix
     */    
       
    /*@Test(expected = TrialAlreadyExistsException.class)
    public void testAddTrialAlreadyExists() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        //

        this.trial4C19.addTrial(22, "Description 22222");
        Assert.assertEquals(7, this.trial4C19.numTrials());
        this.trial4C19.addTrial(22, "Description 22222");

    }*/
    
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestionGroup del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema i tres grups de preguntes
     * <p>
     * *scenario*:
     * - S'afegeix un nou grup de preguntes
     */
     
    @Test
    public void testAddQuestionGroup() throws DEDException {
        // Donat el següent estat de l'objecte trial4C19:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        
        //Afegim un set de grups de preguntes nou
        trial4C19.addQuestionGroup("hygiene1", Trial4C19.Priority.LOWER);   
        trial4C19.addQuestionGroup("symptoms4", Trial4C19.Priority.HIGH); 
        trial4C19.addQuestionGroup("habits4", Trial4C19.Priority.MEDIUM); 
        trial4C19.addQuestionGroup("wellness4", Trial4C19.Priority.LOWER); 
        trial4C19.addQuestionGroup("hygiene2", Trial4C19.Priority.LOWER); 
               
        //Afegim un grup amb prioritat incorrecta 
        trial4C19.addQuestionGroup("hygiene3", Trial4C19.Priority.HIGH);    
        
        //Tornem a afegir el mateix grup, aquest cop amb les dades correctes (prioritat = LOWER)
        trial4C19.addQuestionGroup("hygiene3", Trial4C19.Priority.LOWER);
        
        Iterador<QuestionGroup> it = this.trial4C19.getQuestionGroups();
        QuestionGroup qg1 = it.seguent();
        QuestionGroup qg2 = it.seguent();
        QuestionGroup qg3 = it.seguent();
        QuestionGroup qg4 = it.seguent();
        QuestionGroup qg5 = it.seguent();
        QuestionGroup qg6 = it.seguent();
        QuestionGroup qg7 = it.seguent();
        QuestionGroup qg8 = it.seguent();
        QuestionGroup qg9 = it.seguent();
        QuestionGroup qg10 = it.seguent();
        QuestionGroup qg11 = it.seguent();
        QuestionGroup qg12 = it.seguent();
        QuestionGroup qg13 = it.seguent();
        QuestionGroup qg14 = it.seguent();
        QuestionGroup qg15 = it.seguent();


        
        /**
         * EXTENDED TEST x.1
         * 
         * @test comprovarem que, tot i haver afegir dos cops un grup amb el mateix id, el nombre total 
         * d'elements del vector es manté coherent ("n" no s'incrementa quan afegim un grup que ja existeix)
         * 
         * @post el nombre total de grups de preguntes coincideix amb la quantitat d'elements ÚNICS afegits:
         *  
         *       numQuestionGroups = (symptoms x 4) + (habits x 4) + (wellness x 4) + (hygiene x 3) = 15
         */
        Assert.assertEquals(15, this.trial4C19.numQuestionGroups()); 
       
        /** EXTENDED TEST x.2
         * 
         * AVALUAREM QUE ELS GRUPS DE PREGUNTES S'AFEGEIXEN ORDENATS PER PRIORITAT 
         * O PER ORDRE D'ARRIBADA EN CAS DE TENIR LA MATEIXA PRIORITAT (Veure asserts qg9-qg14, on s'han
         * afegit de manera intercalada diferents "categories" d'elements de prioritat LOWEST i aquests
         * queden emmagatzemats per prioritat i ordre d'arribada). 
         * 

         * **/
        
        Assert.assertEquals("symptoms1", qg1.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.HIGH, qg1.getPriority());

        Assert.assertEquals("symptoms2", qg2.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.HIGH, qg2.getPriority());

        Assert.assertEquals("symptoms3", qg3.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.HIGH, qg3.getPriority());

        Assert.assertEquals("symptoms4", qg4.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.HIGH, qg4.getPriority());
        
        Assert.assertEquals("habits1", qg5.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.MEDIUM, qg5.getPriority());

        Assert.assertEquals("habits2", qg6.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.MEDIUM, qg6.getPriority());

        Assert.assertEquals("habits3", qg7.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.MEDIUM, qg7.getPriority());

        Assert.assertEquals("habits4", qg8.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.MEDIUM, qg8.getPriority());
        
        Assert.assertEquals("wellness1", qg9.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg9.getPriority());

        Assert.assertEquals("wellness2", qg10.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg10.getPriority());
        
        Assert.assertEquals("wellness3", qg11.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg11.getPriority());
        
        Assert.assertEquals("hygiene1", qg12.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg12.getPriority());
        
        Assert.assertEquals("wellness4", qg13.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg13.getPriority());
        
        Assert.assertEquals("hygiene2", qg14.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg14.getPriority());
        
        /**
         *  EXTENDED TEST x.3 
         * 
         * @test A [#x] Hem Afegit un grup de preguntes amb prioritat incorrecta i després l'hem tornat
         *  a afegir a [#y], aquest cop amb la prioritat correcta. Per tant, com que el segon cop que 
         *  afegim ja existeix el grup de preguntes, aquest s'actualitza amb les dades noves i no s'afegeix
         *  cap grup nou.  També hem de tenir en compte que en aquest escenari, el mètode OrderedVector.afegir()
         *  hauria d'haver detectat el canvi de prioritat i haver mogut l'element a la posició correcta del 
         *  vector, ja que del contrari el grup quedaria desordenat dins el vector. Per tant, un cop feta 
         *  l'actualització el grup ha d'apareixer a la darrera posició de vector (emmagatezmada a la variable 
         *  QuestionGroup gq15, a [#z]).
         * 
         * @post El vector conté el mateix nombre d'elements, el grup de preguntes existent (id = hygiene3) 
         * s'ha actualitzat amb la prioritat correcta (LOWER), i aquest es troba ordenat dins el vector un 
         * cop actualitzat.
         */
        
        Assert.assertEquals("hygiene3", qg15.getIdGroup());
        Assert.assertEquals(Trial4C19.Priority.LOWER, qg15.getPriority());

    }

    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  tres grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - S'afegeix una nova pregunta
     */
    
    @Test
    public void testAddQuestion() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        
        // Afegim un grup de preguntes nou sense preguntes assignades
        trial4C19.addQuestionGroup("hygiene4", Trial4C19.Priority.LOWER); //Agefim un grup amb prioritat incorrecta 
        
        //Comprovem que s'ha afegit el grup de preguntes correctament i que aquest no disposa de preguntes assignades
        Assert.assertEquals(0, this.trial4C19.numQuestion4Group("hygiene4"));
        
        //Comprovem que numQuestionGroups es manté coherent (no augmenta el nombre d'elements quan groupId existeix al vector
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());


        trial4C19.addQuestion("idQuestion100", "theWording", Trial4C19.Type.TEXT_PLAIN, null, "hygiene3");
        Assert.assertEquals(1, this.trial4C19.numQuestion4Group("hygiene3"));

    }
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  tres grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - S'afegeix un nou grup de preguntes sobre un grup de preguntes inexistent
     */
    
    @Test(expected = QuestionGroupNotFoundException.class)
    public void testAddQuestionQuestionGroupNotFound() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        //
        trial4C19.addQuestion("idQuestion100", "theWording", Trial4C19.Type.TEXT_PLAIN, null, "XXXXXXXXXX");
    }
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  *NOU* grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - es consulten les preguntes d'un grup de preguntes
     */
    
    @Test
    public void testGetQuestions() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        //
        Iterador<Question> it = trial4C19.getQuestions("symptoms");

        Question q1 = it.seguent();
        Assert.assertEquals("idQuestion1a", q1.getIdQuestion());

        Question q2 = it.seguent();
        Assert.assertEquals("idQuestion1b", q2.getIdQuestion());

        Question q3 = it.seguent();
        Assert.assertEquals("idQuestion1c", q3.getIdQuestion());

    }
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  **NOU** grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - es consulten les preguntes d'un grup de preguntes INEXISTENT
     */
    
    @Test(expected = QuestionGroupNotFoundException.class)
    public void testGetQuestionsAndQuestionGroupNotFound() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        //
        Iterador<Question> it = trial4C19.getQuestions("XXXXXX");
    }
    
    /**
     * *feature*: (sobre la que fem @test): assignQuestionGroup2Trial del TAD Trial4C19
     * *given*: Hi ha:
     *  - 6 assajos en el sistema
     *  - tres grups de preguntes
     *  - tres preguntes per grup
     *  - 3 grups de preguntes a l'assaig 1
     *  - 1 grups de preguntes a l'assaig 2
     * <p>
     * *scenario*:
     * - S'assigna un segon grup de preguntes a un assaig clínic (2)
     */
    
    @Test
    public void testAssignQuestionGroup2Trial() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        Assert.assertEquals(3, trial4C19.numQuestionGroups4Trial(1));
        Assert.assertEquals(1, trial4C19.numQuestionGroups4Trial(2));
        //

        trial4C19.assignQuestionGroup2Trial("symptoms", 2);

        Assert.assertEquals(3, trial4C19.numQuestionGroups4Trial(1));
        Assert.assertEquals(2, trial4C19.numQuestionGroups4Trial(2));
    }
    
    /**
     * *feature*: (sobre la que fem @test): assignQuestionGroup2Trial del TAD Trial4C19
     * given*: Hi ha:
     *  - 6 assajos en el sistema
     *  - tres grups de preguntes
     *  - tres preguntes per grup
     *  - 3 grups de preguntes a l'assaig 1
     *  - 1 grups de preguntes a l'assaig 2
     * <p>
     * *scenario*:
     * - S'assigna un  grup de preguntes INEXISTENT a un assaig clínic
     */
    
    @Test(expected = QuestionGroupNotFoundException.class)
    public void testAssignQuestionGroup2TriaAndQuestionGroupNotFoundl() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        Assert.assertEquals(3, trial4C19.numQuestionGroups4Trial(1));
        Assert.assertEquals(1, trial4C19.numQuestionGroups4Trial(2));

        //
        trial4C19.assignQuestionGroup2Trial("XXXXX", 1);
    }
    
    /**
     * *feature*: (sobre la que fem @test): assignQuestionGroup2Trial del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  tres grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - S'assigna un  grup de preguntes a un assaig clínic INEXISTENT
     */
    
    @Test(expected = TrialNotFoundException.class)
    public void testAssignQuestionGroup2TriaAndTrialNotFoundl() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        Assert.assertEquals(3, trial4C19.numQuestionGroups4Trial(1));
        Assert.assertEquals(1, trial4C19.numQuestionGroups4Trial(2));

        //
        trial4C19.assignQuestionGroup2Trial("habits", 50);
    }
    
    /**
     * *feature*: (sobre la que fem @test): assignUser2Trial del TAD Trial4C19
     * given Hi ha:
     *  - 6 assajos en el sistema
     *  - tres grups de preguntes
     *  - tres preguntes per grup
     *  - 3 grups de preguntes a l'assaig 1
     *  - 1 grups de preguntes a l'assaig 2
     *  - 3 usuaris assignats a l'assaig 1
     *  - 1 usuari assignat a l'assaig 2
     *  <p>
     */
    
    @Test
    public void testAssignUser2Trial() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        Assert.assertEquals(3, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
        //
        trial4C19.assignUser2Trial(1, "idUser0005");


        Assert.assertEquals(4, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
    }
    
    /**
     * *feature*: (sobre la que fem @test): assignUser2Trial del TAD Trial4C19
     * given Hi ha:
     *  - 6 assajos en el sistema
     *  - tres grups de preguntes
     *  - tres preguntes per grup
     *  - 3 grups de preguntes a l'assaig 1
     *  - 1 grups de preguntes a l'assaig 2
     *  - 3 usuaris assignats a l'assaig 1
     *  - 1 usuari assignat a l'assaig 2
     *  <p>
     */
    
    @Test(expected = UserIsAlreadyInTrialException.class)
    public void testAssignUser2TrialAndUserAlreadyInTrial() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        Assert.assertEquals(3, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
        //
        trial4C19.assignUser2Trial(2, "idUser0001"); 
    }
    
    /**
     * *feature*: (sobre la que fem @test): getCurrentQuestion del TAD Trial4C19
     * given
     *  Hi ha:
     *  - 6 assajos en el sistema
     *  - tres grups de preguntes
     *  - tres preguntes per grup
     *  - 3 grups de preguntes a l'assaig 1
     *  - 1 grups de preguntes a l'assaig 2
     *  - 3 usuaris assignats a l'assaig 1
     *  - 1 usuari assignat a l'assaig 2
     * <p>
     */   
    
    /* *********************************************************************************
     * 
     * MISSATGE F�RUM DED (Antoni Oller Arcas, 06.11.2020 00:35
     *  
     * Tamb� al testAnswerQuestions() es declara la variable a3 i despr�s no es fa servir mai, 
     * en canvi la variable a2 es repeteix dos cops, suposo que ser� una errada tamb�?
     * s�. �s una petita errada que no afecta al resultat ja que retorna el mateix resultat, 
     * per sort... Per� s'hauria d'arreglar..
     * 
     */

    @Test
    public void testAnswerQuestions() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness"));
        Assert.assertEquals(3, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
        //

        Question q1 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion1a", q1.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:00:00"), "NO");

        Question q2 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion1b", q2.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:15:00"), "YES");

        Question q3 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion1c", q3.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:20:00"), "YES");

        Question q4 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion2a", q4.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:250:00"), "5 times a day");

        Question q5 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion2b", q5.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 18:00:00"), "N95 masks");

        Question q6 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion2c", q6.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 19:00:00"), "3 times a day");

        Question q7 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion3a", q7.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 20:00:00"), "Yes");

        Question q8 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion3b", q8.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 21:00:00"), "Yes");

        Question q9 = trial4C19.getCurrentQuestion("idUser0001");
        Assert.assertEquals("idQuestion3c", q9.getIdQuestion());
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 22:00:00"), "Yes");

        Iterador<Answer> it = trial4C19.getAnswers("idUser0001");

        Answer a1 = it.seguent();
        Assert.assertEquals("NO",a1.getAnswer() );

        Answer a2 = it.seguent();
        Assert.assertEquals("YES",a2.getAnswer() );

        Answer a3 = it.seguent();
        Assert.assertEquals("YES",a2.getAnswer() );

    }
    
    private static Date createDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date ret = null;
        try {
            ret = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }
}