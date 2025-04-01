import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // HashMap to store candidate names and their votes
    static Map<String, Integer> votes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize candidates
        String can1 = "Trump";
        String can2 = "Kamala";
        String can3 = "Kenny";

        // Add candidates to the HashMap with votes set at 0
        votes.put(can1, 0);
        votes.put(can2, 0);
        votes.put(can3, 0);

        int choice;

        // Main loop for voting
        while (true) {
            System.out.println("Who do you want to vote for:");
            System.out.println("1: " + can1);
            System.out.println("2: " + can2);
            System.out.println("3: " + can3);
            System.out.println("4: Reset Results");
            System.out.println("5: Display Results");
            System.out.println("6: Quit");

            //prompt user for input and converts to int
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            // Check user input and call corresponding method
            switch (choice) {
                case 1:
                    castVote(can1);
                    break;
                case 2:
                    castVote(can2);
                    break;
                case 3:
                    castVote(can3);
                    break;
                case 4:
                    resetVotes();
                    break;
                case 5:
                    displayResults();
                    break;
                case 6:
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    // Methods to cast vote
    static void castVote(String candidateName) {
        votes.put(candidateName, votes.get(candidateName) + 1); // Increment vote count for the candidate
        displayResults();
    }

    // Method to display results
    static void displayResults() {
        for (Map.Entry<String, Integer> vote : votes.entrySet()) {
            System.out.println(vote.getKey() + " --- " + vote.getValue()); // Display candidate name and votes
        }
        System.out.println();
    }
    // Method to reset votes
    static void resetVotes() {
        for (String key : votes.keySet()) {
            votes.put(key, 0); // Reset each candidate's vote count to 0
        }
        displayResults();
    }
}
