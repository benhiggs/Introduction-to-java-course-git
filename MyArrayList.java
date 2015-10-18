/**
 * Created by Ben on 03/02/2015.
 */
public class MyArrayList{
    protected static Object[] ArrayList;
    protected static  int size=0;

    public MyArrayList() {
       ArrayList = new Object[5];
    }

    public static void add(Object o){
        if (ArrayList.length==size){
            incrementLength();
            ArrayList[size]=o;
            size++;
        }
        else{
            for (int i=0;i<ArrayList.length;i++) {
                if (ArrayList[i] == null) {
                    ArrayList[i] = o;
                    size++;
                    break;
                }
            }
        }

    }

    public static void incrementLength(){
        Object[] newarray=new Object[ArrayList.length+1];
        for (int i=0;i<ArrayList.length;i++){newarray[i]=ArrayList[i];}
        ArrayList=newarray.clone();
    }

    public static int size(){
        return size;
    }

    public static Object get(int index){
        return ArrayList[index];
    }

    public static boolean contains (Object o){
        boolean pos=false;
        for (int i=0;i<ArrayList.length;i++){
            if (ArrayList[i]==o){
                pos=true;
            }
        }
        return pos;
    }

    public static void set(int index, Object o){
        ArrayList[index] = o;
        size++;
    }

    public static int indexOf(Object o){
        int pos=-1;
        for (int i=0;i<ArrayList.length;i++){
            if (ArrayList[i]==o){
                pos = i;
            }
        }
        return pos;
    }

    public static void add (int index, Object o){
        Object[] old=ArrayList.clone();
        ArrayList = new Object[size+1];
        for (int i=0;i<index;i++){
            ArrayList[i]=old[i];
        }
        ArrayList[index]=o;
        for (int i=index;i<old.length;i++){
            ArrayList[i+1]=old[i];
        }
        size++;
    }

    public static boolean remove(Object o){
        boolean del = false;
        int pos=-1;
        pos= indexOf(o);
        if (pos!=-1){
            Object[] old=ArrayList.clone();
            ArrayList = new Object[size-1];
            for (int i=0;i<pos;i++){
                ArrayList[i]=old[i];
            }
            for (int i=pos+1;i<old.length;i++){
                ArrayList[i-1]=old[i];
            }
            size--;
            del=true;
        }
        return del;
        }

    public static Object remove(int index){
        Object oldthing=ArrayList[index];
        Object[] old=ArrayList.clone();
        ArrayList = new Object[size-1];
        for (int i=0;i<index;i++){
            ArrayList[i]=old[i];
        }
        for (int i=index+1;i<old.length;i++){
            ArrayList[i-1]=old[i];
        }
        size--;
        return oldthing;
    }


}
