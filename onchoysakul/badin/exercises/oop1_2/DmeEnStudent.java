package onchoysakul.badin.exercises.oop1_2;

public class DmeEnStudent extends Student {
    public DmeEnStudent(String name) {
        this.name = name;
    }
    @Override
    public void writeProgram() {
        System.out.println(name + " writes program in Python and C#");
    }
}
