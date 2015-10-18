/**
 * Created by scotp on 22/01/15.
 */
public class MyArrayListTest {

    static MyArrayList zoo = new MyArrayList();


    public static void printZoo() {
        System.out.print("The zoo now holds " + zoo.size() + " animals: ");
        for (int j = 0; j < zoo.size(); j++) System.out.print(zoo.get(j) + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Testing constructor, add(object) and size() ");
        zoo.add("Ant");
        zoo.add("Bison");
        zoo.add("Camel");
        zoo.add("Dog");
        zoo.add("Elephant");
        zoo.add("Frog");
        zoo.add("Giraffe");
        zoo.add("Horse");
        printZoo();
        System.out.println();

        System.out.println("Testing get(index) and contains(object) ");
        System.out.println("Animal at location 3 is " + zoo.get(3));
        System.out.println("Animal at location 0 is " + zoo.get(0));
        System.out.println("Animal at location 7 is " + zoo.get(7));
        System.out.println("Zoo " + ((zoo.contains("Frog"))? "contains " : "does not contain ") + "Frog");
        System.out.println("Zoo " + ((zoo.contains("Fish"))? "contains " : "does not contain ") + "Fish");
        System.out.println();

        System.out.println("Testing indexOf(object) ");
        System.out.println("Location of Elephant is " + zoo.indexOf("Elephant"));
        System.out.println("Location of Ant is " + zoo.indexOf("Ant"));
        System.out.println("Location of Horse is " + zoo.indexOf("Horse"));
        System.out.println("Location of Crocodile is " + zoo.indexOf("Crocodile"));
        System.out.println();

        System.out.println("Testing add(index,object) ");
        zoo.add(7, "Gorilla");
        zoo.add(1,"Antelope");
        zoo.add(0,"Aardvark");
       zoo.add(11, "Ibex");
        printZoo();
        System.out.println();

        System.out.println("Testing remove(object) ");
        System.out.println("Elephant was " + ((zoo.remove("Elephant"))? "removed " : "not in zoo "));
        System.out.println("Zebra was " + ((zoo.remove("Zebra"))? "removed " : "not in zoo "));
        System.out.println("Horse was " + ((zoo.remove("Horse")) ? "removed " : "not in zoo "));
        System.out.println("Aardvark was " + ((zoo.remove("Aardvark"))? "removed " : "not in zoo "));
        printZoo();
        System.out.println();

        System.out.println("Testing remove(index) ");
        System.out.println(zoo.remove(4) + " removed");
        System.out.println(zoo.remove(0) + " removed");
        System.out.println(zoo.remove(6) + " removed");
        printZoo();
        System.out.println();

    }
}
