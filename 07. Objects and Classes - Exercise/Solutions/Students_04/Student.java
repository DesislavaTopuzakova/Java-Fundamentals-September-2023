package ObjectsAndClasses.Students_04;

public class Student {
    //описание на всеки студент

    //полета -> характеристики
    private String firstName; //първо име
    private String lastName; //фамилия
    private double grade; //оценка

    //конструктор -> метод, чрез който създаваме обекти от класа
    public Student(String firstName, String lastName, double grade) {
        //нов празен обект
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //методи -> действия

    //1. getter за полето grade -> достъп до стойността на полето
    public double getGrade() {
        return this.grade;
    }

    //2. getter за полето firstName -> достъп до стойността на полето
    public String getFirstName() {
        return this.firstName;
    }

    //3. getter за полето lastName -> достъп до стойността на полето lastName
    public String getLastName() {
        return this.lastName;
    }

}
