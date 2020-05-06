package evaluator.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import evaluator.model.Test;
import evaluator.repository.IntrebariRepository;
import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.util.InputValidation;

public class AppController {

    private IntrebariRepository intrebariRepository;

    public AppController() {
        intrebariRepository = new IntrebariRepository();
    }

    public Intrebare addNewIntrebare(String enunt, String rasp1, String rasp2, String raspCorect, String domeniu) throws DuplicateIntrebareException {
        try {
            InputValidation.validateEnunt(enunt);
            InputValidation.validateVarianta1(rasp1);
            InputValidation.validateVarianta2(rasp2);
            InputValidation.validateVariantaCorecta(raspCorect);
            InputValidation.validateDomeniu(domeniu);
            Intrebare i = new Intrebare(enunt, rasp1, rasp2, raspCorect, domeniu);
            intrebariRepository.addIntrebare(i);
            return i;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean exists(Intrebare intrebare) {
        return intrebariRepository.exists(intrebare);
    }

    public Test createNewTest() throws NotAbleToCreateTestException {

        try {
            if (intrebariRepository.getIntrebari().size() < 5)
                throw new NotAbleToCreateTestException("Nu exista suficiente intrebari pentru crearea unui test!(5)");

            if (intrebariRepository.getNumberOfDistinctDomains() < 5)
                throw new NotAbleToCreateTestException("Nu exista suficiente domenii pentru crearea unui test!(5)");
            List<Intrebare> testIntrebari = new LinkedList<Intrebare>();
            List<String> domenii = new LinkedList<String>();
            Intrebare intrebare;
            Test test = new Test();

            while (testIntrebari.size() != 5) {
                intrebare = intrebariRepository.pickRandomIntrebare();

                if (!testIntrebari.contains(intrebare) && !domenii.contains(intrebare.getDomeniu())) {
                    testIntrebari.add(intrebare);
                    domenii.add(intrebare.getDomeniu());
                    System.out.println(intrebare.getEnunt());
                }
            }
            test.setIntrebari(testIntrebari);
            return test;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void loadIntrebariFromFile(String f) {
        intrebariRepository.setIntrebari(intrebariRepository.loadIntrebariFromFile(f));
    }

    public Statistica getStatistica() throws NotAbleToCreateStatisticsException {
        try {
            if (intrebariRepository.getIntrebari().isEmpty())
                throw new NotAbleToCreateStatisticsException("Repository-ul nu contine nicio intrebare!");

            Statistica statistica = new Statistica();
            for (String domeniu : intrebariRepository.getDistinctDomains()) {
                statistica.add(domeniu, intrebariRepository.getNumberOfIntrebariByDomain(domeniu));
            }

            return statistica;

        } catch (NotAbleToCreateStatisticsException e) {
            System.out.println("O problema a fost gasita in crearea statisticii");
            return null;
        }
    }

    public void getAllQuestions() {
        List<Intrebare> intrebareList = intrebariRepository.getIntrebari();
        for (Intrebare intrebare : intrebareList) {
            System.out.println(intrebare.getEnunt());
        }
    }

    public int getQuestionNr() {
        List<Intrebare> intrebareList = intrebariRepository.getIntrebari();
        return intrebareList.size();
    }

}
