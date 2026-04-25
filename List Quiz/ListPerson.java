import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class ListPerson {
    public static void main(String[] args) throws IOException {
        SortedABList<Person> friends = new SortedABList<>();
        try (Scanner in = new Scanner(new File("person.dat"));
             PrintWriter out = new PrintWriter(new FileWriter("friends_alpha.txt"))) {
            build(friends, in);
            printList(friends, out);
        }

        SortedABList<Person> friends2 = new SortedABList<>(Person.SSNComparator);
        try (Scanner in = new Scanner(new File("person.dat"));
             PrintWriter out = new PrintWriter(new FileWriter("friends_ssn.txt"))) {
            build(friends2, in);
            printList(friends2, out);
        }

        SortedABList<Person> friends3 = new SortedABList<>(Person.AgeComparator);
        try (Scanner in = new Scanner(new File("person.dat"));
             PrintWriter out = new PrintWriter(new FileWriter("friends_age.txt"))) {
            build(friends3, in);
            printList(friends3, out);
        }
    }

    public static void build(ListInterface<Person> mypeeps, Scanner peopleFile) {
        String fname;
        String lname;
        int age;
        String cell;
        String ssn;
        String dummy;

        while (peopleFile.hasNext()) {
            fname = peopleFile.nextLine();
            if (!peopleFile.hasNext()) break;
            lname = peopleFile.nextLine();
            if (!peopleFile.hasNextInt()) break;
            age = peopleFile.nextInt();
            dummy = peopleFile.nextLine();
            if (!peopleFile.hasNext()) break;
            cell = peopleFile.nextLine();
            if (!peopleFile.hasNext()) break;
            ssn = peopleFile.nextLine();
            Person onepeep = new Person(fname, lname, age, cell, ssn);
            mypeeps.add(onepeep);
        }
    }

    private static void printList(ListInterface<Person> list, PrintWriter out) {
        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            out.println(it.next());
            out.println();
        }
    }
}
