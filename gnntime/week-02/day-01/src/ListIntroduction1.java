import java.util.ArrayList;

public class ListIntroduction1 {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        // print out the number of elements
        System.out.println(names);

        //Add William to the list
        names.add("William");

        //Print out whether the list is empty or not
        if (names == null) {
            System.out.println("empty");
        }
        else {
            System.out.println("not empty");
        }

        //Add John to the list
        names.add("John");

        //Add Amanda to the list
        names.add("Amanda");

        //Print out the number of elements in the list
        System.out.println(names.size());

        //Print out the 3rd element
        System.out.println(names.get(2));

        //Iterate through the list and print out each name
        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
         }

        //Iterate through the list and print
        int index=1;
        for (String s : names)
            System.out.println((index++) +": "+s);

        //Remove the 2nd element
        names.remove(1);

        //Iterate though the list in a reversed order and print out each name
        for (int i = names.size(); i-- > 0;) {
            System.out.println(names.get(i));
        }

        //Remove all elements
        names.clear();
        System.out.println(names);
    }

}
