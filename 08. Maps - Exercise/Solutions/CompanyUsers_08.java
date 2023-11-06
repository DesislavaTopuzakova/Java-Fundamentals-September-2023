package maps;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyEmployees = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            //input = "{companyName} -> {employeeId}"
            // .split(" -> ") -> ["{companyName}", "{employeeId}"]
            String companyName = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            //1. имаме налична такава компания
            if (companyEmployees.containsKey(companyName)) {
                //!!! добавяме служителя ако го няма в списъка
                List<String> currentEmployees = companyEmployees.get(companyName);
                if (!currentEmployees.contains(employeeId)) {
                    currentEmployees.add(employeeId);
                }
            }
            //2. нямаме налична такава комания
            else {
                companyEmployees.put(companyName, new ArrayList<>());
                companyEmployees.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }

        //map: key (компания) -> value (списък със служители)
        companyEmployees.entrySet().forEach(entry -> {
            //entry
            //key -> име на компания
            //value -> списък със служители
            System.out.println(entry.getKey());
            //entry.getValue().forEach(employee -> System.out.println("-- " + employee));
            for (String employee : entry.getValue()) {
                System.out.println("-- " + employee);
            }
        });
    }
}
