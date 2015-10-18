import java.util.Iterator;

/**
 * Created by scotp on 22/01/15.
 * Edited by Ben Higgs for Assignment 2 task 1
 */
public class MyArrayList implements Iterable{
    public static final int DEFAULT_SIZE = 5;
    public static final int EXPANSION = 5;
    private int capacity;
    private int size;
    private Object[] items;

    public MyArrayList() {
        size = 0;
        capacity = DEFAULT_SIZE;
        items = new Object[DEFAULT_SIZE];
    }

    public Iterator iterator() {
        return new Itrerate();
    }

    private class Itrerate implements Iterator  {
        int cur = 0; int prev = -1;

         public boolean hasNext() {
             if(cur >= size){
                 return false;
             }
             else{
                return true;
             }
        }

        public Object next() {
            try{
                indexcheck(cur);
                prev = cur;
                cur++;
                return items[prev];
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println(ex);
                return null;
            }
        }

        public void remove() {
        }
    }

    public void indexcheck(int index){
        if (index >= size || index < 0 ){
            throw new IndexOutOfBoundsException("Index position does not exist");
        }
    }

    public String printexception(int index,String function){
        return("The index "+index+" does not exist, the function "+function+" will not function properly.");
    }

    private void expand() {
        Object[] newItems = new Object[capacity + EXPANSION];
        for (int j = 0; j < size; j++) newItems[j] = items[j];
        items = newItems;
        capacity = capacity + EXPANSION;
    }

    public void add(Object obj) {
        if (size >= capacity) this.expand();
        items[size] = obj;
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) throws IndexOutOfBoundsException{
       try{
           indexcheck(index);
           return items[index];
       }
       catch(IndexOutOfBoundsException ex){
           throw new IndexOutOfBoundsException(printexception(index,"MyArrayList.get"));
       }

    }

    public boolean contains(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) return true;
        }
        return false;
    }

    public void add(int index, Object obj) {
        try{
            indexcheck(index);
            if (size >= capacity) this.expand();
            for (int j = size; j > index; j--) items[j] = items[j - 1];
            items[index] = obj;
            size++;
        }
        catch(IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException(printexception(index,"MyArrayList.add"));
        }

    }

    public int indexOf(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) return j;
        }
        return -1;
    }

    public boolean remove(Object obj) {
        for (int j = 0; j < size; j++) {
            if (obj.equals(this.get(j))) {
                for (int k = j; k < size-1; k++) items[k] = items[k + 1];
                items[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public Object remove(int index) {
        try{
        indexcheck(index);
        Object result = this.get(index);
        for (int k = index; k < size-1; k++) items[k] = items[k + 1];
        items[size-1] = null;
        size--;
        return result;
        }
        catch(IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException(printexception(index,"MyArrayList.remove"));
        }

    }



    public void set(int index, Object obj) {
        try{
            indexcheck(index);
            items[index] = obj;
        }
        catch(IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException(printexception(index,"MyArrayList.set"));
        }

    }
}
