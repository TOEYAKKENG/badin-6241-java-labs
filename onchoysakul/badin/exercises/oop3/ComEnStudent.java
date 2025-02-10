package onchoysakul.badin.exercises.oop3;

public class ComEnStudent extends Student {
    public ComEnStudent(String name, String favoriteCourse) {
        this.name = name;
        this.favoriteCourse = favoriteCourse;
    }
    
    public String toString(){
        return name + " => favorite course = " + favoriteCourse;
    }

}
