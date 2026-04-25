import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PermutationsConsole {

    public static void main(String[] args) {
        new PermutationsConsole().run();
    }

    private void run() {
        // Use try-with-resources to auto-close files and scanner
        try (Scanner in = new Scanner(System.in);
             PrintWriter permsOut = new PrintWriter(new File("perms.txt"));
             PrintWriter analyticsOut = new PrintWriter(new File("analytics.txt"))) {

            // 1) Ask for dictionary path and load it
            System.out.print("Enter dictionary file path (e.g., dictionary.txt): ");
            String dictPath = in.nextLine().trim();
            Dictionary dict = new Dictionary(dictPath);

            // Overall analytics
            int totalWords = 0;
            int sumWordLen = 0;
            int totalPerms = 0;
            int totalEnglish = 0;

            // 2) Read and process words one by one (blank line to stop)
            System.out.println("Enter words to process (blank line to finish):");
            while (true) {
                System.out.print("> ");
                String word = in.nextLine().trim();
                if (word.isEmpty()) break;

                totalWords++;
                word = word.toLowerCase();
                sumWordLen += word.length();

                // 3) Use your stack-based calculator
                PermutationsCalculator pc = new PermutationsCalculator(dict);

                // Generate results
                ArrayList<String> all = pc.allPermutations(word);       // all permutations (with dups)
                ArrayList<String> unique = pc.uniquePermutations(word); // unique permutations
                ArrayList<String> english = pc.uniqueWords(word);       // unique English words
                int duplicates = pc.numDuplicates();

                // 4) Write detailed output to perms.txt
                permsOut.println("======================================");
                permsOut.println("Word: " + word);
                permsOut.println("All permutations (" + all.size() + "):");
                permsOut.println(all);
                permsOut.println("Unique permutations (" + unique.size() + "):");
                permsOut.println(unique);
                permsOut.println("Unique English words (" + english.size() + "):");
                permsOut.println(english);
                permsOut.println();

                // Per-word analytics
                double avgDupFraction = all.isEmpty() ? 0.0 : (duplicates * 1.0) / all.size();
                double avgEngFraction = all.isEmpty() ? 0.0 : (english.size() * 1.0) / all.size();

                analyticsOut.println("----- Analytics for: " + word + " -----");
                analyticsOut.println("Total permutations: " + all.size());
                analyticsOut.println("Duplicate permutations: " + duplicates);
                analyticsOut.println("Average duplicate fraction: " + avgDupFraction);
                analyticsOut.println("English words: " + english.size());
                analyticsOut.println("Average English fraction: " + avgEngFraction);
                analyticsOut.println();

                // Update overall totals
                totalPerms += all.size();
                totalEnglish += english.size();
            }

            // 5) Overall analytics
            analyticsOut.println("========== OVERALL ANALYTICS ==========");
            analyticsOut.println("Total words processed: " + totalWords);
            double avgLen = totalWords == 0 ? 0.0 : (sumWordLen * 1.0) / totalWords;
            analyticsOut.println("Average word length: " + avgLen);
            analyticsOut.println("Total permutations processed: " + totalPerms);
            analyticsOut.println("Total English words found: " + totalEnglish);
            double avgEnglishProportion = totalPerms == 0 ? 0.0 : (totalEnglish * 1.0) / totalPerms;
            analyticsOut.println("Average proportion of English words: " + avgEnglishProportion);

            System.out.println("\nDone. Wrote results to perms.txt and analytics.txt");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
