package uoc.ded.practica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FactoryTrial4C19Extended {


    public static Trial4C19 getTrial4C19() throws Exception {
        Trial4C19 trial4C19;
        trial4C19 = new Trial4C19Impl();

        ////
        //// USERS
        ////
        trial4C19.addUser("idUser0001", "Joan", "Simo");
        trial4C19.addUser("idUser0002", "Pep", "Lluna");
        trial4C19.addUser("idUser0003", "Isma", "Ferra");
        trial4C19.addUser("idUser0004", "Marc", "Quilez");
        trial4C19.addUser("idUser0005", "Armand", "Morata");
        trial4C19.addUser("idUser0006", "Jesus", "Sallent");
        trial4C19.addUser("idUser0007", "Anna", "Casals");
        trial4C19.addUser("idUser0008", "Mariajo", "Padró");
        trial4C19.addUser("idUser0009", "Agustí", "Padró");
        trial4C19.addUser("idUser0010", "Pepet", "Marieta");


        ////
        //// Trial
        ////
        trial4C19.addTrial(1, "Description 1");
        trial4C19.addTrial(2, "Description 2");
        trial4C19.addTrial(15, "Description 15");
        trial4C19.addTrial(8, "Description 8");
        trial4C19.addTrial(20, "Description 20");
        trial4C19.addTrial(18, "Description 18");


        ////
        //// QuestionGroups
        ////
        trial4C19.addQuestionGroup("habits1",Trial4C19.Priority.MEDIUM );
        trial4C19.addQuestionGroup("wellness1", Trial4C19.Priority.LOWER);
        trial4C19.addQuestionGroup("symptoms1",Trial4C19.Priority.HIGH );

        ////
        //// Questions
        ////
        trial4C19.addQuestion("idQuestion1a", "Can't sleep because of coughing?", Trial4C19.Type.TEXT_PLAIN, null, "symptoms1");
        trial4C19.addQuestion("idQuestion1b", "Do you have pain in the chest or upper abdomen ?", Trial4C19.Type.TEXT_PLAIN, null,"symptoms1");
        trial4C19.addQuestion("idQuestion1c", "do you have a headache?", Trial4C19.Type.TEXT_PLAIN, null, "symptoms1");

        trial4C19.addQuestion("idQuestion2a", "How long you wash your hands?", Trial4C19.Type.TEXT_PLAIN, null, "habits1");
        String[] choices = {"cloth masks", "Surgical masks", "N95 masks"};
        trial4C19.addQuestion("idQuestion2b", "What kind of mask are you using ?", Trial4C19.Type.LIKERT, choices, "habits1");
        trial4C19.addQuestion("idQuestion2c", "Good hydration is crucial for optimal health. How do you hydrate in one day?", Trial4C19.Type.TEXT_PLAIN, null, "habits1");

        trial4C19.addQuestion("idQuestion3a", "do you have pain?",Trial4C19.Type.TEXT_PLAIN, null, "wellness1");
        trial4C19.addQuestion("idQuestion3b", "do you feel itchy?",Trial4C19.Type.TEXT_PLAIN, null, "wellness1");
        trial4C19.addQuestion("idQuestion3c", "do you have a skin rash?",Trial4C19.Type.TEXT_PLAIN, null, "wellness1");

        ////
        //// Assign QuestionGroups
        ////
        trial4C19.assignQuestionGroup2Trial("habits1", 1);
        trial4C19.assignQuestionGroup2Trial("wellness1", 1);
        trial4C19.assignQuestionGroup2Trial("symptoms1", 1);

        trial4C19.assignQuestionGroup2Trial("habits1", 2);

        ////
        //// Assign Users
        ////
        trial4C19.assignUser2Trial(1, "idUser0001");
        trial4C19.assignUser2Trial(1, "idUser0002");
        trial4C19.assignUser2Trial(1, "idUser0003");
        trial4C19.assignUser2Trial(2, "idUser0004");

        return trial4C19;
    }



}