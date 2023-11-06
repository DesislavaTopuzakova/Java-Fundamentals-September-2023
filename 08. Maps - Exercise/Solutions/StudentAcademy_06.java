package maps;

import java.util.*;

public class StudentAcademy_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //student -> list of grades
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine()); //брой студенти

        for (int student = 1; student <= countStudents; student++) {
            String studentName = scanner.nextLine(); //име на студент
            double grade = Double.parseDouble(scanner.nextLine()); //оценка

            //1. имам такъв студент
            if (studentGrades.containsKey(studentName)) {
                List<Double> currentGrades = studentGrades.get(studentName);
                currentGrades.add(grade);
            }
            //2. нямам такъв студент
            else {
                studentGrades.put(studentName, new ArrayList<>());
                studentGrades.get(studentName).add(grade);
            }
        }

        //studentGrades: име -> списък с оценки

        Map<String, Double> studentAverageGrade = new LinkedHashMap<>();
        //studentAverageGrade: име -> ср. оценка

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            //entry
            //entry.getKey() -> име
            //entry.getValue() -> списък с оценки
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = getAverageGrade(grades);
                    //grades.stream().mapToDouble(a -> a).average().orElse(0.0);

            //трябва да съхраним студента, само ако ср.оценка >= 4.50
            if (average >= 4.50) {
                studentAverageGrade.put(studentName, average);
            }
        }

        //map: име на студента (key) -> ср. оценка (value)
        studentAverageGrade.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
    }

    //метод, който приема списък с оценки и връща средната оценка
    private static double getAverageGrade(List<Double> grades) {
        //{5, 4, 6, 2}
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
