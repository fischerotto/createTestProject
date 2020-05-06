package evaluator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.exception.NotAbleToCreateTestException;
import evaluator.model.Statistica;
import evaluator.model.Intrebare;

import evaluator.controller.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;
import evaluator.util.InputValidation;

//functionalitati
//F01.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//F02.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//F03.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	private static final String file = "intrebari.txt";
	
	public static void main(String[] args) throws IOException, DuplicateIntrebareException, InputValidationFailedException, NotAbleToCreateTestException, NotAbleToCreateStatisticsException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		AppController appController = new AppController();
		appController.loadIntrebariFromFile("/Users/ottofischer/Downloads/5-ProiectEvaluatorExamen/ProiectEvaluatorExamen/src/main/java/evaluator/Intrebari.txt");


		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Exit");
			System.out.println("5.Afiseaza toate intrebarile");
			System.out.println("");
			
			optiune = console.readLine();
			
			switch(optiune){
				case "1" :
					System.out.println("Enuntul:");
					Scanner scanner = new Scanner(System.in);
					String enunt = scanner.nextLine();
					Scanner scanner2 = new Scanner(System.in);
					System.out.println("Raspuns 1");
					String rasp1 = scanner2.nextLine();
					Scanner scanner3 = new Scanner(System.in);
					System.out.println("Raspuns 2");
					String rasp2 = scanner3.nextLine();
					Scanner scanner4 = new Scanner(System.in);
					System.out.println("Raspunsul corect: ");
					String raspCorect = scanner4.nextLine();
					Scanner scanner5 = new Scanner(System.in);
					System.out.println("Domeniul: ");
					String domeniu = scanner5.nextLine();
					appController.addNewIntrebare(enunt,rasp1,rasp2,raspCorect,domeniu);
				break;
			case "2" :
				appController.createNewTest();
				break;
			case "3" :
				Statistica statistica;
					statistica = appController.getStatistica();
					System.out.println(statistica);
				break;
			case "4" :
				activ = false;
				break;
			case "5" :
					appController.getAllQuestions();
					break;
				default:
				break;
			}

		}
		
	}

}
