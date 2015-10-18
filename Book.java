/**
 * Created by Ben on 03/02/2015.
 */
public class Book {
    private String name;
    private String refNum;
    private int copiesOwned;
    private int copiesLoaned;

    public String getName() {
        return name;
    }

    public int getCopiesOwned() {
        return copiesOwned;
    }

    public int getCopiesLoaned() {
        return copiesLoaned;
    }

    public String getRefNum() {
        return refNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public void setCopiesOwned(int copiesOwned) {
        this.copiesOwned = copiesOwned;
    }

    public void setCopiesLoaned(int copiesLoaned) {
        this.copiesLoaned = copiesLoaned;
    }

    public Book(String name, String refNum, int copiesOwned) {
        this.name = name;
        this.refNum = refNum;
        this.copiesOwned = copiesOwned;
        this.copiesLoaned = 0;
    }


    public String string(){
        return (getRefNum()+" Owned: "+getCopiesOwned()+" On loan: "+getCopiesLoaned()+" "+getName());
    }

    public String toString(){ return(string());} //Placed here in case a new subclass is generated and does not specify a specific toString method. It is overwritten in fiction + nonfiction to add extra details to print

    public void borrowBook(){
        if (getCopiesOwned()>getCopiesLoaned()){
            setCopiesLoaned((getCopiesLoaned()+1));
            System.out.println("You have just loaned: "+getName()+" you have "+(getCopiesOwned()-getCopiesLoaned())+" left in the library");
        }
        else{System.out.println("You do not have enough copies of "+getName()+" in the library");}
    }

    public void returnBook() {
        if (getCopiesLoaned() >= 1) {
            setCopiesLoaned(getCopiesLoaned() - 1);
            System.out.println("You just returned a copy of " + getName());
        }
        else {System.out.println("You cannot return " + getName() + ", all the copies have been returned, please check the copies");}
    }

}
