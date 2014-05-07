import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class Dept
{
    private String name;
    private HashMap<String,CourseList> courses;
    private HashSet<String> instructors;
    private ArrayList<String[]> courseList;
    /**
     * Constructor for objects of class Dept
     */
    public Dept(String name)
    {
        this.name = name;
        courses = new HashMap<String,CourseList>();
        instructors = new HashSet<String>();
    }
    public void addCourse(String num,String name,String hours, String inst){
        inst = inst.toLowerCase().equals("staff") ? "staff" : inst;
        instructors.add(inst);
        //add course to courseList
        if(courses.containsKey(inst)){
            courses.get(inst).addCourse(num,name,hours);
        }else {
            courses.put(inst,new CourseList(num,name,hours));
        }
    }
    public void print(){
        //Dept Title
        System.out.println(name+"\n**********************");
        int hours = 0;
        int sHours = 0;
        for(String inst : instructors){
            int hrs = courses.get(inst).getTotalHours();
            if(inst.toLowerCase().equals("staff")){
                sHours = hrs;
            } else {
                //Instructor name and hours
                System.out.format("%1$-" + 30 + "s", "["+inst +"]");
                System.out.println("Total Hours: "+ hrs+".00");
                //courses
                courses.get(inst).print();
                System.out.println();
                //track total hours
                hours+=hrs;
            }
        }
        //Staff info
        if(courses.containsKey("staff")){
            System.out.format("%1$-" + 30 + "s", "[Staff]");
            System.out.println("Total Hours: "+ sHours+".00");
            courses.get("staff").print();
            System.out.println();
        }
        //final data
        System.out.println(">>> Number of Named Instructors: " + (instructors.size()-1));
        System.out.println(">>> Total Hours of Named Instructors: " + hours+".00");
        System.out.println(">>> Total Hours of Staff Instructors: " +sHours+".00\n\n\n");
    }
}
