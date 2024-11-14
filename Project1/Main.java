import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList game = new CircularLinkedList();
        LinkedList<String> allNamesList = new LinkedList<>();
        Random rand = new Random();
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("How many people do you want to select?");
        int numberOfPlayers = inputScanner.nextInt();
        int totalNames = 0;

        try {
            File file = new File("names.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                allNamesList.add(name);
                totalNames++;
            }
            fileScanner.close();

            if (numberOfPlayers > totalNames) {
                System.out.println("Error: The number of players selected cannot exceed the number of names in the file.");
                return;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure the file is in the correct location.");
            return;
        }

        int addedPlayers = 0;

        while (addedPlayers < numberOfPlayers) {
            int randomIndex = rand.nextInt(allNamesList.size());
            String selectedName = allNamesList.remove(randomIndex);
            game.add(selectedName);
            addedPlayers++;
        }

        System.out.println("Selected players:");
        game.printList(null);

        while (game.getSize() > 1) {
            int size = game.getSize();  // Mevcut oyuncu sayısını al
            int k = rand.nextInt(size) + 1;  // [ 1 =< k <= N ]
            Node current = game.playTurn(k); // k'ncı kişiye bir harf kaybettir
            game.printList(current);
        }

        Node winner = game.findWinner();
    }
}
