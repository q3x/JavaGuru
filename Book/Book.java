public class Book implements Comparable<Book> {
    private String author;
    private int year;
    private String title;
    private int pageCount;

    public Book(String title, String author, int year, int pageCount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setYear(int y) {
        year = y;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setPageCount(int p) {
        pageCount = p;
    }


    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String toString() {
        return title + ", " + author + ", " + year + ", " + pageCount;
    }

    @Override
    public int compareTo(Book o) {
        return author.compareTo(o.getAuthor());
    }

}