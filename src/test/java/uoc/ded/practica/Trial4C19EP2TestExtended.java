package uoc.ded.practica;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.Answer;
import uoc.ded.practica.model.Question;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ded.practica.model.User;
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
     * - S'afegeixen 10 usuaris més de manera desordenada
     * - Es modifiquen les dades del CINQUÉ usuari inserit (idUser9999)
     */
          
    @Test  
    public void testAddUser() {

    	// CONTEXT -> Donat el següent estat inicial de l'objecte trial4C19:
    	
        Assert.assertEquals(10, this.trial4C19.numUsers());
        
        // OPERACIONS TAD [#1] -> Afegim un set de grups d'usuaris (10) nou de manera desordenada 

        trial4C19.addUser("idUser0011", "John", "Simon");
        trial4C19.addUser("idUser0010", "Joseph", "Moon");
        trial4C19.addUser("idUser0014", "Isaias", "Iron");
        trial4C19.addUser("idUser0013", "Marcus", "Weight");
        trial4C19.addUser("idUser9999", "XXXXXX", "YYYYYYY");
        trial4C19.addUser("idUser0012", "Jesus", "Christ");
        trial4C19.addUser("idUser0015", "Ana", "Homes");
        trial4C19.addUser("idUser0018", "Marius", "Father");
        trial4C19.addUser("idUser0016", "August", "Father");
        trial4C19.addUser("idUser9998", "Josephet", "Mariet");
        trial4C19.addUser("idUser0017", "Douglas", "Horseface");
        
        // OPERACIONS TAD [#1] -> Afegim un usuari amb Id existent 
        
        trial4C19.addUser("idUser9999", "Michael", "Jackson");
        
        // INICIALITZACIÓ DELS ASSERTS -> Obtenim tots els elements del vector en variables   
        //                                  locals per tal de poder efectuar els tests (Asserts). 
        
        Iterador<User> it = this.trial4C19.getUsers();
        User u1 = it.seguent();
        User u2 = it.seguent();
        User u3 = it.seguent();
        User u4 = it.seguent();
        User u5 = it.seguent();
        User u6 = it.seguent();
        User u7 = it.seguent();
        User u8 = it.seguent();
        User u9 = it.seguent();
        User u10 = it.seguent();
        User u11 = it.seguent();
        User u12 = it.seguent();
        User u13 = it.seguent();
        User u14 = it.seguent();
        User u15 = it.seguent();
        User u16 = it.seguent();
        User u17 = it.seguent();
        User u18 = it.seguent();
        User u19 = it.seguent();
        User u20 = it.seguent();

        /**
         * EXTENDED TEST [#U.1]
         * 
         * @test Avaluarem que els usuaris s'afegeixen ordenats per id d'usuari. Per a comprovar-ho, 
         * al grup d'operacions sobre el TAD etiquetat amb [#1] s'han afegit de manera intercalada 
         * diferents usuaris. 
         * 
         * @post vector que que conté tots els usuaris ordenats per prioritat per Id d'usuari
         */
        
        Assert.assertEquals("idUser0001", u1.getUserId());
        Assert.assertEquals("idUser0002", u2.getUserId());
        Assert.assertEquals("idUser0003", u3.getUserId());
        Assert.assertEquals("idUser0004", u4.getUserId());
        Assert.assertEquals("idUser0005", u5.getUserId());
        Assert.assertEquals("idUser0006", u6.getUserId());
        Assert.assertEquals("idUser0007", u7.getUserId());
        Assert.assertEquals("idUser0008", u8.getUserId());
        Assert.assertEquals("idUser0009", u9.getUserId());
        Assert.assertEquals("idUser0010", u10.getUserId());
        Assert.assertEquals("idUser0011", u11.getUserId());
        Assert.assertEquals("idUser0012", u12.getUserId());
        Assert.assertEquals("idUser0013", u13.getUserId());
        Assert.assertEquals("idUser0014", u14.getUserId());
        Assert.assertEquals("idUser0015", u15.getUserId());
        Assert.assertEquals("idUser0016", u16.getUserId());
        Assert.assertEquals("idUser0017", u17.getUserId());
        Assert.assertEquals("idUser0018", u18.getUserId());
        Assert.assertEquals("idUser9998", u19.getUserId());
        Assert.assertEquals("idUser9999", u20.getUserId());      
        
        /**
         * EXTENDED TEST [#U.2]
         * 
         * @test Comprovarem que afegir un usuari existent provoca la actualització del mateix 
         * (i per tant no se'n afegeix cap usuari nou al sistema). 
         * 
         * @post vector que que conté tots els usuaris ordenats per prioritat per Id d'usuari, 
         * un dels quals ha vist les seves dades actualitzades
         */    
        
        // Comprovem que el nombre d'usuaris es manté coherent
        
        Assert.assertEquals(20, this.trial4C19.numUsers());
              
        // Comprovem que l'usuari existent s'ha actualitzat correctament 
        
        Assert.assertEquals("Michael", this.trial4C19.getUser("idUser9999").getName());
        Assert.assertEquals("Jackson", this.trial4C19.getUser("idUser9999").getSurname());
    }
        
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestionGroup del TAD Trial4C19
     * *given*: Hi ha [6] assajos en el sistema i [3] grups de preguntes
     * <p>
     * *scenario*:
     * - S'afegeix un set nou de grup de preguntes (11 grups)
     * - S'afegeix un grup de preguntes existent amb dades noves 
     */
     
    @Test
    public void testAddQuestionGroup() throws DEDException {
    	
        // CONTEXT -> Donat el següent estat inicial de l'objecte trial4C19:
    	
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        
        // OPERACIONS TAD [#1] -> Afegim un set de grups de preguntes (10) nou de manera desordenada 
        
        trial4C19.addQuestionGroup("habits2",Trial4C19.Priority.MEDIUM );
        trial4C19.addQuestionGroup("wellness2", Trial4C19.Priority.LOWER);
        trial4C19.addQuestionGroup("symptoms2",Trial4C19.Priority.HIGH );
        trial4C19.addQuestionGroup("habits3",Trial4C19.Priority.MEDIUM );
        trial4C19.addQuestionGroup("wellness3", Trial4C19.Priority.LOWER);
        trial4C19.addQuestionGroup("symptoms3",Trial4C19.Priority.HIGH );
        trial4C19.addQuestionGroup("hygiene1", Trial4C19.Priority.LOWER);   
        trial4C19.addQuestionGroup("symptoms4", Trial4C19.Priority.HIGH); 
        trial4C19.addQuestionGroup("habits4", Trial4C19.Priority.MEDIUM); 
        trial4C19.addQuestionGroup("wellness4", Trial4C19.Priority.LOWER); 
        trial4C19.addQuestionGroup("hygiene2", Trial4C19.Priority.LOWER);
               
        // OPERACIÓ TAD [#2] -> Afegim 1 grup amb prioritat incorrecta (GrupId = "hygiene3", prioritat = "HIGHER")
        
        trial4C19.addQuestionGroup("hygiene3", Trial4C19.Priority.HIGH);    
        
        // OPERACIÓ TAD [#3] -> Tornem a afegir el mateix grup, aquest cop amb les dades correctes ((GrupId = "hygiene3", prioritat = LOWER)
        
        trial4C19.addQuestionGroup("hygiene3", Trial4C19.Priority.LOWER);
        
        // INICIALITZACIÓ DELS ASSERTS -> Obtenim tots els elements del vector en variables   
        //                                  locals per tal de poder efectuar els tests (Asserts). 
        
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
        
        /*
         * EXTENDED TEST [#QG.1]
         * 
         * @test comprovarem que, tot i haver afegir dos cops un grup amb el mateix id, el nombre total 
         * d'elements del vector es manté coherent ("n" no s'incrementa quan afegim un grup que ja existeix)
         * 
         * @post el nombre total de grups de preguntes coincideix amb la quantitat d'elements ÚNICS afegits:
         * numQuestionGroups = (symptoms x 4) + (habits x 4) + (wellness x 4) + (hygiene x 3) = 15
         */
        
        Assert.assertEquals(15, this.trial4C19.numQuestionGroups()); 
       
        /* EXTENDED TEST [#QG.2] 
         * 
         * @test Avaluarem que els grups de preguntes s'afegeixen ordenats per prioritat o per ordre 
         * d'arribada en cas de tenir la mateixa prioritat. Per a comprovar-ho, al grup d'operacions 
         * sobre el TAD etiquetat amb [#1] s'han afegit de manera intercalada diferents "categories" 
         * d'elements de prioritat LOWEST i aquests queden emmagatzemats per prioritat i ordre d'arribada). 
         * 
         * @post vector que que conté tots els grups de preguntes afegits, ordenats per prioritat, o per 
         * ordre d'entrada en cas de grups amb mateixa prioritat.
         */
        
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
        
        /*
         *  EXTENDED TEST [#QG.3] 
         * 
         * @test A la operació [#2] Hem Afegit un grup de preguntes amb prioritat incorrecta i seguidament 
         *  l'hem tornat a afegir a [#3], aquest cop amb la prioritat correcta. Per tant, com que el segon 
         *  cop que afegim ja existeix el grup de preguntes, aquest s'actualitza amb les dades noves i no 
         *  s'afegeix cap grup nou.
         *  
         *  També és important tenir en compte que en aquest escenari, el mètode OrderedVector.afegir()
         *  hauria d'haver detectat el canvi de prioritat i haver mogut l'element a la posició correcta del 
         *  vector, ja que del contrari el grup quedaria desordenat dins el vector. Per tant, un cop feta 
         *  l'actualització el grup ha d'apareixer a la darrera posició de vector .
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
     * *given*: Hi ha 6 assajos en el sistema,  *NOU* grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - es consulten les preguntes d'un grup de preguntes
     */
    
    @Test
    public void testGetQuestions() throws DEDException {
    	
    	// CONTEXT -> Donat el següent estat inicial de l'objecte trial4C19:
    	
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        
        // INICIALITZACIÓ DELS ASSERTS -> Obtenim els elements de la cua en variables   
        
        Question q1_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q2_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q3_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q4_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q5_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q6_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q7_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q8_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q9_ronda1 = trial4C19.getCurrentQuestion("idUser0001");
        Question q1_ronda2 = trial4C19.getCurrentQuestion("idUser0001");
       
        /* EXTENDED TEST [#GetQ.1] 
         * 
         * @test Avaluarem que la llista encadenada de respostes es recorreguda de manera circular. 
         * És a dir, amb aquest test demostrem que les preguntes d'un usuari es poden contestar 
         * indefinidament (quan s'ha respost la darrera pregunta, es torna a començar per la primera 
         * -> cua circular). Destaquem que en aquest test ja no fem les comprovacion que es feien  
         * al test proporcionat amb l'enunciat, és a dir, només comprovem que les preguntes es poden
         * contestar indefinidament.
         * 
         * @post la cua de preguntes d'un usuari manté la mateixa quantitat d'elements després d'obtenir
         *  una pregunta, i si aquesta era la última pregunta de l'usuari, la següent és la primera.
         */      
        
        Assert.assertEquals("idQuestion1a", q1_ronda2.getIdQuestion());     

    }
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha [6] assajos en el sistema,  [3] grups de preguntes i [3] preguntes per grup
     * <p>
     * *scenario*:
     * - S'afegeix una nova pregunta
     */
    
    /*@Test
    public void testAddQuestion() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
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

    }*/
    
    /**
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  tres grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - S'afegeix un nou grup de preguntes sobre un grup de preguntes inexistent
     */
    
    /*@Test(expected = QuestionGroupNotFoundException.class)
    public void testAddQuestionQuestionGroupNotFound() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        //
        trial4C19.addQuestion("idQuestion100", "theWording", Trial4C19.Type.TEXT_PLAIN, null, "XXXXXXXXXX");
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
     * *feature*: (sobre la que fem @test): AddQuestion del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  **NOU** grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - es consulten les preguntes d'un grup de preguntes INEXISTENT
     */
    
    /* @Test(expected = QuestionGroupNotFoundException.class)
    public void testGetQuestionsAndQuestionGroupNotFound() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(9, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        //
        Iterador<Question> it = trial4C19.getQuestions("XXXXXX");
    }*/
    
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
    
    /* @Test
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
    } */
    
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
    
    /* @Test(expected = QuestionGroupNotFoundException.class)
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
    } */
    
    /**
     * *feature*: (sobre la que fem @test): assignQuestionGroup2Trial del TAD Trial4C19
     * *given*: Hi ha 6 assajos en el sistema,  tres grups de preguntes i tres preguntes per grup
     * <p>
     * *scenario*:
     * - S'assigna un  grup de preguntes a un assaig clínic INEXISTENT
     */
    
    /* @Test(expected = TrialNotFoundException.class)
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
    } */
    
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
    
    /* @Test
    public void testAssignUser2Trial() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        Assert.assertEquals(3, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
        //
        trial4C19.assignUser2Trial(1, "idUser0005");


        Assert.assertEquals(4, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
    } */
    
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
    
    /* @Test(expected = UserIsAlreadyInTrialException.class)
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
    } */
    
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
    
    /* 
     * AQUEST TEST NO APORTA RES NOU, NO CAL
     * 
    @Test
    public void testAnswerQuestions() throws DEDException {
        // GIVEN:
        Assert.assertEquals(6, this.trial4C19.numTrials());
        Assert.assertEquals(3, this.trial4C19.numQuestionGroups());
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("symptoms1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("habits1"));
        Assert.assertEquals(3, this.trial4C19.numQuestion4Group("wellness1"));
        Assert.assertEquals(3, trial4C19.numUsers4Trial(1));
        Assert.assertEquals(1, trial4C19.numUsers4Trial(2));
        
        //

        Question q1A = trial4C19.getCurrentQuestion("idUser0001");
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:250:00"), "RESPOSTA 1");

        Question q2A = trial4C19.getCurrentQuestion("idUser0001");
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 18:00:00"), "RESPOSTA 2");

        Question q3A = trial4C19.getCurrentQuestion("idUser0001");
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 19:00:00"), "RESPOSTA 3");
        
        Question q1A = trial4C19.getCurrentQuestion("idUser0001");
        trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:250:00"), "RESPOSTA 1");

        Iterador<Answer> it = trial4C19.getAnswers("idUser0001");
        Answer a1 = it.seguent();
        Answer a2 = it.seguent();
        Answer a3 = it.seguent();
        Answer a4 = it.seguent();
        
        Assert.assertEquals( "RESPOSTA 1",a1.getAnswer() );
        Assert.assertEquals( "RESPOSTA 2",a2.getAnswer() );
        Assert.assertEquals( "RESPOSTA 3",a3.getAnswer() );
        Assert.assertEquals( "RESPOSTA 1",a4.getAnswer() );
        
    }**/
    

}

