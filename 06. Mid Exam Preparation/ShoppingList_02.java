package examPrepMid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //списък с продукти
        List<String> productsList = Arrays.stream(scanner.nextLine() //"Tomatoes!Potatoes!Bread"
                        .split("!"))  //["Tomatoes", "Potatoes", "Bread"]
                .collect(Collectors.toList()); //{"Tomatoes", "Potatoes", "Bread"}

        String command = scanner.nextLine(); //входни данни:  валидна команда или "Go Shopping!"
        while (!command.equals("Go Shopping!")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0]; //"Urgent", "Unnecessary", "Correct", "Rearrange"
            String product = commandParts[1];

            switch (commandName) {
                case "Urgent":
                    //1. command = "Urgent {product}".split(" ") -> ["Urgent", "{product}"]
                    //add the item at the start of the list.  If the item already exists, skip this command
                    if (!productsList.contains(product)) {
                        productsList.add(0, product); //на определено място в списъка
                    }
                    break;
                case "Unnecessary":
                    //2. command = "Unnecessary {product}".split(" ") -> ["Unnecessary", "{product}"]
                    //remove the item with the given name, only if it exists in the list. Otherwise skip this command.
                    if (productsList.contains(product)) {
                        productsList.remove(product);
                    }
                    break;
                case "Correct":
                    //3. command = "Correct {product} {newProduct}".split(" ") -> ["Correct", "{product}", "{newProduct}"]
                    String newProduct = commandParts[2];
                    if (productsList.contains(product)) {
                        int indexProduct = productsList.indexOf(product);
                        productsList.remove(product);
                        productsList.add(indexProduct, newProduct);
                        //productsList.set(indexProduct, newProduct);
                    }
                    break;
                case "Rearrange":
                    //4. command = "Rearrange {product}".split(" ") -> ["Rearrange", "{product}"]
                    //if the grocery exists in the list, remove it from its current position and add it at the end of the list.
                    if (productsList.contains(product)) {
                        productsList.remove(product);
                        productsList.add(product); //накрая на списъка
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        //отпечатам продуктите в списъка (, ) -> {"Tomatoes", "Potatoes", "Lettuce"}
        System.out.println(productsList.toString() //"[Tomatoes, Potatoes, Lettuce]"
                .replace("[", "")   //"Tomatoes, Potatoes, Lettuce]"
                .replace("]", ""));  //"Tomatoes, Potatoes, Lettuce"
        //работи за всички типове списъци

        //лист от текстове -> САМО String.join
        //System.out.println(String.join(", ", productsList)); -> работи само за списък от текстове


    }
}
