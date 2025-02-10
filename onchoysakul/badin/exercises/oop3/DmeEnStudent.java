package onchoysakul.badin.exercises.oop3;

public class DmeEnStudent extends Student {
    public DmeEnStudent(String name, String favoriteCourse) {
        this.name = name;
        this.favoriteCourse = favoriteCourse;
    }

    public String toString(){
        return name + " => favorite course = " + favoriteCourse;
    }

    
}
