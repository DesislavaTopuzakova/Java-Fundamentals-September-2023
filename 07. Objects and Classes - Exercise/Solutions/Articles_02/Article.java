package ObjectsAndClasses.Articles_02;

public class Article {
    //ОПИСАНИЕ НА СТАТИЯ
    //полета -> характеристики (заглавие, съдържание, автор)
    private String title;
    private String content;
    private String author;

    //конструктор -> метод, чрез който съзадаваме обекти от класа
    //автоматично генериране:
    //1. ALT + INSERT
    //2. десен бутон в името на класа -> Generate...
    public Article(String title, String content, String author) {
        //нов празен обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //методи -> действия със статия
    //1. edit -> заменя съдържанието с ново
    public void edit (String newContent) {
        this.content = newContent;
    }

    //2. change author -> променя автора
    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    //3. rename -> променя заглавието
    public void rename(String newTitle) {
        this.title = newTitle;
    }

    //getters -> методи, чрез които взимаме стойността на полето
    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor () {
        return this.author;
    }

    //вградени методи: toString
    //метод toString -> метод, който показва как изглежда обекта под формата на текст
    //default: "{package}.{class}@{address}"
    //искам: "{title} - {content}:  {author}"

    @Override //пренаписвате вграден метод
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
