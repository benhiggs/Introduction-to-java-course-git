/**
 * Created by Ben on 03/02/2015.
 */
public class ReferenceBook extends NonFiction {

    public ReferenceBook(String name, String refNum, int copiesOwned, int yearPublished) {
        super(name, refNum, copiesOwned, yearPublished);
    }

    public void borrowBook(){System.out.println("You cannot loan out Reference Books. Please select another book");}

    public void returnBook(){System.out.println("You cannot loan out Reference Books. Please select another book");}

}
