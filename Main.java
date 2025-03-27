import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class

class Main {
    static HashMap<String, Integer> votes = new HashMap<String, Integer>();

    static void CastVote(String candidateName) {
        votes[candidateName]++;
        DisplayResults();
    }
    static void DisplayResults()
        {
            foreach (KeyValuePair<string, int> vote in votes)
            {
                System.out.println(vote.Key + "---" + vote.Value);
            }
            System.out.println();
        }

    static void ResetVotes()
        {

            HashMap<String, Integer> newVotes = new HashMap<String, Integer>();
            foreach (KeyValuePair<string, Integer> vote in votes)
            {

                newVotes.Add(vote.Key, 0);
            }
            votes = newVotes;
            DisplayResults();

        }
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String can1 = "Trump";

            String can2 = "Kamala";

            String can3 = "Kenny";


            votes.put(can1, 0);
            votes.put(can2, 0);
            votes.put(can3, 0);

            int choice = 0;
            while (true)
            {
                System.out.println("Who do you want to vote for \n 1: {can1}\n 2: {can2}\n 3: {can3}\n 4: Reset Results\n 5: Display Results\n 6: Quit");
                choice = myObj.nextInt();  // Read user input


                switch (choice)
                {
                    case 1:
                        CastVote(can1);
                        break;
                    case 2:
                        CastVote(can2);
                        break;
                    case 3:
                        CastVote(can3);
                        break;
                    case 4:
                        ResetVotes();
                        break;
                    case 5:
                        DisplayResults();
                        break;
                    case 6:
                        System.out.println("Goodbye");
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }     
        }
}