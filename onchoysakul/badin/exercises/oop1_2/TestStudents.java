package onchoysakul.badin.exercises.oop1_2;
import java.util.ArrayList;
public class TestStudents {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new DmeEnStudent("Manee"));
        students.add(new ComEnStudent("Mana"));
        students.add(new ComEnStudent("Piti"));
        for (Student student : students) {
            student.writeProgram();
        }
    }
}
