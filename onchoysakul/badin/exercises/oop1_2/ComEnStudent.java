package onchoysakul.badin.exercises.oop1_2;

public class ComEnStudent extends Student {
    public ComEnStudent(String name) {
        this.name = name;
    }
    @Override
    public void writeProgram() {
        System.out.println(name + " writes program in Python and Java");
    }
}
