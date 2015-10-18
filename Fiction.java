/**
 * Created by Ben on 03/02/2015.
 */
public class Fiction extends Book {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Fiction(String name, String refNum, int copiesOwned, String author) {
        super(name, refNum, copiesOwned);
        setAuthor(author);
    }

    public String toString(){
        return (string()+" Author: "+getAuthor());
    }




}
