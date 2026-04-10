public class Book {
    String id;
    String title;
    String author;
    int year;
    public Book(String id, String title, String author, int year){
        this.id=id;
        this.title=title;
        this.author=author;
        this.year=year;
    }

    @Override
    public String toString() {
        return id+" "+title+" "+author+" "+year;
    }
}
