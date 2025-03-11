import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VotingSystem {
    private Map<String, Integer> candidates;

    public VotingSystem() {
        candidates = new HashMap<>();
        candidates.put("Candidate 1", 0);
        candidates.put("Candidate 2", 0);
        candidates.put("Candidate 3", 0);
    }

    public void displayCandidates() {
        System.out.println("Please select your candidate:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    public void vote(String candidate) {
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
            System.out.println("Thank you for voting for " + candidate + "!");
        } else {
            System.out.println("Invalid candidate. Please try again.");
        }
    }

    public void displayResults() {
        System.out.println("\nVoting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);
        String vote;

        while (true) {
            votingSystem.displayCandidates();
            System.out.print("Enter your vote (or type 'exit' to finish): ");
            vote = scanner.nextLine();

            if (vote.equalsIgnoreCase("exit")) {
                break;
            }

            votingSystem.vote(vote);
        }

        votingSystem.displayResults();
        scanner.close();
    }
}
