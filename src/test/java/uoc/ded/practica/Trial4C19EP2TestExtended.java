package uoc.ded.practica;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uoc.ded.practica.exceptions.*;
import uoc.ded.practica.model.Answer;
import uoc.ded.practica.model.Question;
import uoc.ded.practica.model.QuestionGroup;
import uoc.ded.practica.model.Trial;
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
     * 
     * CONSIDERACIONS PRÈVIES: 
     * 
     * Per a què s’insereixin ordenadament els usuaris al diccionari, utilitzem un comparador 
     * (classe “Comparable”) d’objectes al contenidor (DiccionariOrderedVector) parametritzat 
     * de manera que li podem passar qualsevol tipus de dades per a fer la comparació. en el 
     * nostre cas, compararem objectes tipus TAD “ClauValor”, que són els que utilitzem per a 
     * indexar els elements del diccionari (usuaris) en funció del seu ID (String).
     * 
     * Aquest comparador però, necessita que la “estructura” del argument “idUser” sigui 
     * uniforme / coherent entre tots els usuaris, ja que si no el resultat de la comparació 
     * és incorrecte. Per exemple, si comparem les cadenes de caràcters “idUser1” i “idUser14”,
     * el comparador avaluarà el primer com a element més gran que el segon de manera incorrecta.
     * Per a solucionar-ho, en comptes de fer que el mètode separi la part entera de la resta 
     * de la cadena (idUser) i realitzar una comparació d’enters, farem les proves afegint la 
     * quantitat de zeros necessària per assolir la uniformitat del format en el moment d’injectar 
     * dades al contenidor (Fitxers “FactoryTrial4C19.java” I “Trial4C19EP2Test.java”). A més, 
     * d’aquesta manera també aconseguim un codi més net i legible / elegant en el mètode 
     * “DiccionariOrderedVector.afegir()”.
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
         * EXTENDED TEST [#1.1]
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
         * EXTENDED TEST [#1.2]
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
        //                                locals per tal de poder efectuar els tests (Asserts). 
        
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
         * EXTENDED TEST [#2.1]
         * 
         * @test comprovarem que, tot i haver afegir dos cops un grup amb el mateix id, el nombre total 
         * d'elements del vector es manté coherent ("n" no s'incrementa quan afegim un grup que ja existeix)
         * 
         * @post el nombre total de grups de preguntes coincideix amb la quantitat d'elements ÚNICS afegits:
         * numQuestionGroups = (symptoms x 4) + (habits x 4) + (wellness x 4) + (hygiene x 3) = 15
         */
        
        Assert.assertEquals(15, this.trial4C19.numQuestionGroups()); 
       
        /** 
         * EXTENDED TEST [#2.2] 
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
        
        /**
         *  EXTENDED TEST [#2.3] 
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
       
        /** EXTENDED TEST [#3.1] 
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
     * *feature*: (sobre la que fem @test): MostActiveUser del TAD Trial4C19
     * *given*: Hi ha [6] assajos en el sistema,  [3] grups de preguntes i [3] preguntes per grup
     * <p>
     * *scenario*:
     *  S'afegeix un set de respostes (3) d'un usuari concret (idUser0005), i una sola resposta d'un altre 
     *  usuari (idUser0001) i es comprova que el primer és l'usuari amb més respostes (MostActiveUser)
     *  
     *  OBSERVACIONS: EL RESULTAT DEL TEST ÉS CORRECTE EN EL CAS D'US PLANTEJAT, PERÒ SI ES REALITZEN
     *  VARIACIONS (E.G. ASSIGNAR L'USUARI A UN TRIAL QUE NO SIGUI EL "1"), EL MÈTODE "AddAnswer()"
     *  LLANÇA UNA EXCEPCIÓ. NO DISPOSO DE MES TEMPS PER A DEPURAR AQUESTA PART DE LA PRÀCTICA.
     *  
     */
    
    @Test
    public void testMostActiveUser() throws DEDException {
    	
    	// CONTEXT -> Donat el següent estat inicial de l'objecte trial4C19:   	

        //TO-DO
        
        // OPERACIONS TAD [#1] -> Afegim una resposta a l'usuari idUser0001
        
        //Question q1 = trial4C19.getCurrentQuestion("idUser0001");
        //trial4C19.addAnswer("idUser0001", createDate("19-10-2020 17:00:00"), "NO");
    	
    	// OPERACIÓ TAD [#2] -> Assignem un usuari a Trial[1] -> idUser0005
    	
    	this.trial4C19.assignUser2Trial(1, "idUser0005"); 
    	
    	// OPERACIONS TAD [#3] -> Desencuem 3 preguntes i afegim 3 respostes a un usuari (idUser0005) que no 
    	// n'havia contestat cap encara.     
    	
    	Question q3 = this.trial4C19.getCurrentQuestion("idUser0005"); //Això no és estrictament necessari per a realitzar el test, però s'efectua la operació per a demostrar la mecanica de respondre preguntes.
    	trial4C19.addAnswer("idUser0005", createDate("19-10-2020 17:250:00"), "RESPOSTA 1");
    	
    	Question q4 = this.trial4C19.getCurrentQuestion("idUser0005");
    	trial4C19.addAnswer("idUser0005", createDate("19-10-2020 17:260:00"), "RESPOSTA 2");
    	
    	Question q5 = this.trial4C19.getCurrentQuestion("idUser0005");
    	trial4C19.addAnswer("idUser0005", createDate("19-10-2020 17:270:00"), "RESPOSTA 3");
    	
    	// OPERACIONS TAD [#3] -> Afegim un darrer usuari que NO ha de provocar la sobreescriptura de mostActiveUser
    	
    	Question q6 = this.trial4C19.getCurrentQuestion("idUser0002");
    	trial4C19.addAnswer("idUser0002", createDate("19-10-2020 17:270:00"), "RESPOSTA 1");
    	    	
        /** EXTENDED TEST [#4.1] 
         * 
         * @test Avaluarem que, després d'afegir un set de respostes a un usuari (major al de 
         * la resta d'usuaris), aquest passa a ser l'usuari més actiu
         * 
         * @post "Trial[].mostActiveUser" conté l'usuari més actiu de l'assaig
         *  
         */ 
    	
    	User u = this.trial4C19.mostActiveUser(1);   	
    	Assert.assertEquals("idUser0005", u.getUserId());    	        
    }
    
    /**
     * *feature*: (sobre la que fem @test): MostActiveTrial del TAD Trial4C19
     * *given*: Hi ha [6] assajos en el sistema,  [3] grups de preguntes i [3] preguntes per grup
     * <p>
     * *scenario*:
     * S'afegeix un set de respostes d'un usuari a un trial diferent als "poblats" al fitxer "Factory",
     * i es comprova que aquest trial passa a contenir l'usuari més actiu.
     */
    
    @Test
    public void testMostActiveTrial() throws DEDException {
        /** EXTENDED TEST [#5.1] 
         * 
         * @test Avaluarem que, després d'afegir un set de respostes a un usuari d'un trial,
         * aquest trial passa a ser el més actiu
         * 
         * @post "T4C19.mostActiveTrial" conté l'usuari més actiu de l'assaig
         *          *  
         */ 
    	
       	trial4C19.assignQuestionGroup2Trial("symptoms1", 20);
       	
    	this.trial4C19.assignUser2Trial(20, "idUser0006"); 
    	
 
    	
    	trial4C19.addAnswer("idUser0001", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	trial4C19.addAnswer("idUser0006", null, "XXXXXXXXXX");
    	
    	Trial t = this.trial4C19.mostActiveTrial();   	
    	Assert.assertEquals(20, t.getIdTrial()); 
        
    }
    
/** ###############################  MÈTODES AUXILIARS  ################################ **/
    
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