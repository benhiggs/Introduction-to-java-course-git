/**
 * Created by Ben on 03/02/2015.
 */
public class NonFiction extends Book {
    private int yearPublished;

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }


    public NonFiction(String name, String refNum, int copiesOwned, int yearPublished) {
        super(name, refNum, copiesOwned);
        setYearPublished(yearPublished);
    }

    public String toString(){
        return (string()+" Published: "+getYearPublished());
    }




}
