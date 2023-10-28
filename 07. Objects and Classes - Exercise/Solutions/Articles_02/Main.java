package ObjectsAndClasses.Articles_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] articleData = scanner.nextLine().split(", ");
        //"Holy Ghost, content, John Sandford".split(", ") => ["Holy Ghost", "content", "John Sandford"]
        String title = articleData[0]; //заглавие на статия
        String content = articleData[1]; //съдържание на статия
        String author = articleData[2]; //автор на статия

        //статия -> title, content, author
        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine()); //брой на команди
        for (int count = 1; count <= n; count++) {
            String command = scanner.nextLine();
            //1. command = "Edit: {new content}".split(": ")        -> ["Edit", "{new content}"]
            //2. command = "ChangeAuthor: {new author}".split(": )  -> ["ChangeAuthor", "{new author}"]
            //3. command = "Rename: {new title}".split(": ")        -> ["Rename", "{new title}"]
            String[] commandParts = command.split(": ");
            String commandName = commandParts[0]; //"Edit", "ChangeAuthor", "Rename"
            String commandParameter = commandParts[1]; //ново съдържание, нов автор, ново заглавие

            switch (commandName) {
                case "Edit":
                    //commandParameter = "{new content}"
                    //сменя текущото съдържание на статия с това от командата -> commandParameter
                    article.edit(commandParameter);
                    break;
                case "ChangeAuthor":
                    //commandParameter = "{new author}" -> текста на новия автор
                    //сменя текущия автор на статия с този от командата -> commandParameter
                    article.changeAuthor(commandParameter);
                    break;
                case "Rename":
                    //commandParameter = "{new title}"
                    //сменя текущото заглавие на статия с това от командата -> commandParameter
                    article.rename(commandParameter);
                    break;
            }
        }

        //крайно състояние на статията
        //отпечатваме: {title} - {content}:  {author}
        //System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
        System.out.println(article.toString());
    }
}
