import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ben on 24-Mar-15.
 */
public class IRStudies {

    public static String[] studentlist;
    public static String[] list101;
    public static String[] list102;

    public static void importstudents () throws Exception {
        File studlist = new File("src/IRStudents.txt");
        Scanner students = new Scanner (studlist);
        ArrayList<String> studentlist1 = new ArrayList<String>() ;
        while (students.hasNext()){
            String line = students.nextLine();
            studentlist1.add(line);
        }
        students.close();
        studentlist = new String[studentlist1.size()];
        studentlist1.toArray(studentlist);
    }

    public static void import101 () throws Exception {
        File IR101f = new File ("src/IR101.txt");
        Scanner IR101 = new Scanner (IR101f);
        ArrayList<String> list1011 = new ArrayList<String>() ;
        while (IR101.hasNext()){
            String line = IR101.nextLine();
            list1011.add(line);
        }
        IR101.close();
        list101 = new String[list1011.size()];
        list1011.toArray(list101);
    }

    public static void import102 () throws Exception {
        File IR102f = new File ("src/IR102.txt");
        Scanner IR102 = new Scanner (IR102f);
        ArrayList<String> list1022 = new ArrayList<String>() ;
        while (IR102.hasNext()){
            String line = IR102.nextLine();
            list1022.add(line);
        }
        IR102.close();
        list102 = new String[list1022.size()];
        list1022.toArray(list102);
    }

    public static void progress(String id){
        Double one = 0.0;
        Double two = 0.0;
        for (int x=0;x<studentlist.length;x++){
            if (list101[x].contains(id)){
                one = Double.parseDouble(list101[x].substring(6));
            }
            if (list102[x].contains(id)){
                two = Double.parseDouble(list102[x].substring(6));
            }
        }
        double agg = (one+two)/2;
        System.out.println("IR101: "+one+"  IR102:"+two+"   Aggregate: "+String.format( "%.1f", agg ));

        if(one < 40.0){
            if(two < 40.0){
                System.out.println("Class:  Fail    Outcome:    Resit IR101 and IR102");
            }
            else{
            System.out.println("Class:  Fail    Outcome:    Resit IR101");
            }
        }
        else if(two < 40.0){
            System.out.println("Class:  Fail    Outcome:    Resit IR102");
        }
        else if(agg>70.0){
            System.out.println("Class:  1st    Outcome:    Proceed to Stage 2");
        }
        else if(agg>60.0){
            System.out.println("Class:  2.1    Outcome:    Proceed to Stage 2");
        }
        else if(agg>50.0){
            System.out.println("Class:  2.2    Outcome:    Proceed to Stage 2");
        }
        else if(agg>40.0){
            System.out.println("Class:  3rd    Outcome:    Proceed to Stage 2");
        }


    }



    public static void main (String[] args) throws Exception{
        importstudents();
        import101();
        import102();
        System.out.println("----------------------------------------------------");
        int s = studentlist.length;
        for (int x=0;x<s;x++ ){
            System.out.println(studentlist[x]);
            progress(studentlist[x].substring(0, 5));
            System.out.println("----------------------------------------------------");
        }

    }

}
