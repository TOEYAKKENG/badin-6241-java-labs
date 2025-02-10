package onchoysakul.badin.exercises.oop3;

import java.util.*;

public class TestStudents {
    public static class FavoriteCourseComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.getFavoriteCourse().compareTo(s2.getFavoriteCourse());
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new DmeEnStudent("Manee", "Interaction Design"));
        students.add(new ComEnStudent("Mana", "Advamced Computer Programming"));
        students.add(new ComEnStudent("Piti", "Linear Circuit Analysis"));
        
        System.out.println(students);
        Collections.sort(students, new FavoriteCourseComparator());
        System.out.println(students);
    }
    
}
