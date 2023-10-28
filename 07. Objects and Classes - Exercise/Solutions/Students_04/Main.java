package ObjectsAndClasses.Students_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>(); //празен списък

        for (int count = 1; count <= countStudents; count++) {
            //scanner.nextLine() -> "Lakia Eason 3.90"
            String[] studentInfo = scanner.nextLine().split(" ");
            // "Lakia Eason 3.90".split(" ") => ["Lakia", "Eason", "3.90"]
            String firstName = studentInfo[0]; //първо име
            String lastName = studentInfo[1]; //фамилия
            double grade = Double.parseDouble(studentInfo[2]); //оценка

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        //списък със студенти

        //1. сортиране по оценка (descending order)
        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade) //ascending order
                                                                        .reversed()); //descending order

        //2. принтирам списъка
        for (Student student : studentList) {
            //"{first name} {second name}: {grade}"
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }

    }
}
