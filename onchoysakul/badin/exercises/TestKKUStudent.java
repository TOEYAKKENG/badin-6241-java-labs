package onchoysakul.badin.exercises;
class KKUStudent{
    private String name;
    private double gpa;
    static String uniName = "Khon Kaen University";
    static int numStudents = 0;

    public KKUStudent(){
        this.name = "";
        numStudents++;
    }
    public KKUStudent(String name){
        this.name = name;
        this.gpa = 0.00;
        numStudents++;
    }
    public KKUStudent(String name,double gpa){
        this.name = name;
        this.gpa = gpa;
        numStudents++;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getGPA(){
        return gpa;
    }
    public void setGPA(double gpa){
        this.gpa = gpa;
    }
    
    public static int getNumStudents() {
        return numStudents;
    }
    public static String getUniName() {
        return uniName;
    }

}


public class TestKKUStudent{
    public static void main(String[] args) {
        KKUStudent manee = new KKUStudent();
        manee.setName("Manee");
        manee.setGPA(3.2);
        System.out.println("Name: " + manee.getName() + " GPA is " + manee.getGPA());
        KKUStudent mana = new KKUStudent("Mana");
        mana.setGPA(3.4);
        System.out.println("Num students is " + KKUStudent.getNumStudents());
        System.out.println("Name: " + mana.getName() + " GPA is " + mana.getGPA());
        System.out.println("Mana's university name is " + KKUStudent.getUniName());
    }
}
