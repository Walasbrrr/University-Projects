import java.io.*;
import java.util.*;



public class Dictionary {
    private final ArrayList<String> words;

    public Dictionary (String filename) {
        words = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filename))){
            while(sc.hasNext()){
                words.add(sc.next().trim().toLowerCase());
            }


        }catch (Exception e){
            System.err.println("Error reading dictionary file: " + filename + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public void addWord(String w){
        if(w != null && !w.isEmpty()) words.add(w);
    }

    public boolean lookup(String word){
        return words.contains(word.toLowerCase());
    }

    public static void main(String[] args){
        Dictionary dic= new Dictionary("src/dictionary.txt");
        System.out.println(dic.lookup("apple"));
        System.out.println(dic.lookup("xyz"));

    }
}