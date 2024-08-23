import java.io.File; 
import java.io.IOException;  
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskManager implements TaskOperation {

    static TaskManager taskManager = new TaskManager();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> taskList = new ArrayList<>(); //Ceci est un typage de tableau ArrayList
    static int id = 1;

    @Override
    public void addTask() {
        // System.out.println("Entrer l'ID de la tâche");
        // int id = scanner.nextInt();
        System.out.println("Entrer le titre de la tâche");
        String title = scanner.nextLine();
        Task task = new Task(id++, title);
        taskList.add(task);
        System.out.println(task.getID());
        System.out.println(task.getTitle());
        System.out.println(task.getStatus());
    }

    @Override
    public void displayTaskAll() {
        System.out.println("List des tâches");
        for(Task task: taskList) {
            System.out.println(task.getTitle());
        }
    }

        public void menu() {
        while(true) {
            System.out.println("\nTask Management Système");
            System.out.println("\n Choisir une option");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display All Task");
            System.out.println("4. Display Task by ID");
            System.out.println("5. Exit");
            System.out.println("NB: Le 2 et 4 en cours de developpement ");

            System.out.println("Entrer une valeur");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch(choix) {
                case 1:
                    addTask();
                    WriteToFile();
                    break;
                case 2:
                    displayTaskAll();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Choix invalide, réessayer");
                    break;
            }
        }
        }

        public void WriteToFile () {
            String taskFile = "task.txt";
            try{
                FileWriter myWriter = new FileWriter(taskFile);
                myWriter.write(taskList.toString());
                myWriter.close();
                System.out.println("Tableau ajouté avec succès!");
            } catch(IOException e) {
                System.out.println("Une erreur s'est produite!");
                e.printStackTrace();
            }
        }
        // public void WriteToFile () {
        //     String taskFile = "task.txt";
        //     try(BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
        //         // writer.write(taskList.toString().getID());
        //         writer.write(taskList.toString());
        //         // writer.write(taskList.toString().getStatus());
        //         System.out.println("Tableau ajouté avec succès!");
        //     } catch(IOException e) {
        //         System.out.println("Une erreur s'est produite!");
        //         e.printStackTrace();
        //     }
        // }
    public static void main (String[] args) {

        taskManager.menu();

    //     try {
    //   File myObj = new File("filename.txt");
    //   if (myObj.createNewFile()) {
    //     System.out.println("File created: " + myObj.getName());
    //   } else {
    //     System.out.println("File already exists.");
    //   }
    // } catch (IOException e) {
    //   System.out.println("An error occurred.");
    //   e.printStackTrace();
    // }

    // try {
    //     File myObj = new File("task.txt");
    //     if(myObj.createNewFile()) {
    //         System.out.println("fichier " + myObj.getName() + " est créer");
    //     }else {
    //         System.out.println("Fichier existante!");
    //     }
    // }catch (IOException el) {
    //     System.out.println("Une erreur s'est produite");
    //     el.printStackTrace();
    // }

    // TaskManager.WriteToFile(Task task);
  }
    
}
