package evaluator.controller;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Intrebare;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class AppControllerTest {

    //WHITE TESTING LAB 02
    @Test
    public void addNewIntrebareTC1() throws DuplicateIntrebareException {
        //PRIMA LITERA DIN ENUNT NU E MAJUSCULA EXCEPTION
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "cat face 2+2?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "1";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr();
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }

    @Test
    public void addNewIntrebareTC2() throws DuplicateIntrebareException {
        //ADAUGARE VALIDA

        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "Cat face 4+4?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "2";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr()+1;
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }



    @Test
    public void addNewIntrebareTC3() throws DuplicateIntrebareException {
        //RASPUNSUL TRE SA FIE 1,  2 sau 3
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "Cat face 4+2?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "4";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr();
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }




    @Test
    public void addNewIntrebareTC4() throws DuplicateIntrebareException {
        //Intrebarea exista deja
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "Cat face 2+2?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "1";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr();
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }

    //LAB 03

    @Test
    public void createTestF02_TC01() throws NotAbleToCreateTestException {
        AppController appController = new AppController();
        Assert.assertNull(appController.createNewTest());
    }


    @Test
    public void createTestF02_TC03() throws NotAbleToCreateTestException {
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.createNewTest());
    }








    //LAB 04
    @Test
    public void getStatistica() throws NotAbleToCreateStatisticsException {
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.getStatistica());
    }


    @Test
    public void getStatistica2() throws NotAbleToCreateStatisticsException {
        AppController appController = new AppController();
        Assert.assertNull(appController.getStatistica());
        //Assert.assertnotNull(appController.getStatistica());
    }


    @Test
    public void testBigBang() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException {
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.getStatistica());

        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.createNewTest());

        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "Cat face 4+4?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "2";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr()+1;
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }
    

    @Test
    public void testTopDown2() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException {
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.getStatistica());

        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.createNewTest());
    }

    @Test
    public void testTopDown3() throws NotAbleToCreateStatisticsException, NotAbleToCreateTestException, DuplicateIntrebareException {
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.getStatistica());

        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        Assert.assertNotNull(appController.createNewTest());

        appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");
        String enunt = "Cat face 4+4?";
        String rasp1 = "1)4";
        String rasp2 = "2)8";
        String raspCorect = "2";
        String domeniu = "Mate";
        int nr = appController.getQuestionNr()+1;
        appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
        assertEquals(appController.getQuestionNr(),nr);
    }





}
