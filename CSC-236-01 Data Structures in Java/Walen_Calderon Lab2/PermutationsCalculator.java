import java.util.ArrayList;
import java.util.LinkedHashSet;

public class PermutationsCalculator {
    // Stack used to generate permutations
    private final StackInterface<String> stack;

    // Lists to store results
    private final ArrayList<String> all;
    private final ArrayList<String> unique;
    private final ArrayList<String> english;

    // Dictionary for word lookup
    private final Dictionary dict;

    // Constructor: gets the dictionary
    public PermutationsCalculator(Dictionary dic) {
        this.stack = new LinkedStack<>();
        this.all = new ArrayList<>();
        this.unique = new ArrayList<>();
        this.english = new ArrayList<>();
        this.dict = dic;
    }

    // Generate all permutations using the "+" algorithm
    public ArrayList<String> allPermutations(String word) {
        if (word == null) word = "";
        word = word.toLowerCase();
        all.clear();

        // Start with +word
        stack.push("+" + word);

        while (!stack.isEmpty()) {
            String s = stack.top();
            stack.pop();

            int p = s.indexOf('+');

            // If "+" is at the end, it's a complete permutation
            if (p == s.length() - 1) {
                all.add(s.substring(0, p));
            } else {
                // Move each letter from right of "+" to left side
                for (int i = p + 1; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    String left = s.substring(0, p) + ch;
                    String right = s.substring(p + 1, i) + s.substring(i + 1);
                    String next = left + "+" + right;
                    stack.push(next);
                }
            }
        }
        return all;
    }

    // Return only unique permutations (keep order)
    public ArrayList<String> uniquePermutations(String word) {
        if (all.isEmpty()) allPermutations(word);
        unique.clear();
        unique.addAll(new LinkedHashSet<>(all));
        return unique;
    }

    // Return only unique English words from permutations
    public ArrayList<String> uniqueWords(String word) {
        if (all.isEmpty()) allPermutations(word);
        english.clear();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String w : all) {
            if (dict.lookup(w)) set.add(w);
        }
        english.addAll(set);
        return english;
    }

    // Return number of duplicate permutations
    public int numDuplicates() {
        return Math.max(0, all.size() - unique.size());
    }

    // Optional getters
    public ArrayList<String> getAll() { return all; }
    public ArrayList<String> getUnique() { return unique; }
    public ArrayList<String> getEnglish() { return english; }
}
