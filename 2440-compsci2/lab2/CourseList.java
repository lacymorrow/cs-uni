import java.util.ArrayList;
public class CourseList{
    private String[] arr;
    private ArrayList<String[]> courses;
    public CourseList(String num, String name, String hour)
    {
        String[] arr = {name,num,hour};
        courses = new ArrayList<String[]>();
        courses.add(arr);
    }
    public void addCourse(String num, String name, String hour){
        String[] arr = {name,num,hour};
        courses.add(arr);
    }
    public void print(){
        //print course info
        for(int i = 0;i<courses.size();i++){ 
            System.out.println("    "+courses.get(i)[1]+"     "+courses.get(i)[0]+"     "+courses.get(i)[2]+".00");
        }
    }
    public int getTotalHours(){
        int hours = 0;
        for(int i=0;i<courses.size();i++){
            hours += Integer.parseInt(courses.get(i)[2]);
        }
        return hours;
    }
}
