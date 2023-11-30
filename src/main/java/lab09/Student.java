package lab09;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private int idNumber;
    private double GPA;
    public Student(String firstName, String lastName, int idNumber, double GPA){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    @Override
    public int compareTo(Student other) {
        return 0;
    }
}
