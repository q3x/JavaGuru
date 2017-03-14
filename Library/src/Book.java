public class Book {
    private int id;
    private String author;
    private int year;
    private String title;
    private int pageCount;

    private String givenTo;
    private String givenDate;
    private String returnDate;


    public Book(int id, String title, String author, int year, int pageCount, String givenTo, String givenDate, String returnDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageCount = pageCount;
        this.givenTo = givenTo;
        this.givenDate = givenDate;
        this.returnDate = returnDate;
    }

    public Book() { }



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

    public int getId() {
        return id;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public String getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(String givenDate) {
        this.givenDate = givenDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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
        return title + ", " + author + ", " + year;
    }

    public String printListLine() {
        return id + "," + title + "," + author + "," + year + "," + pageCount + "," + givenTo + "," + givenDate + "," + returnDate;
    }

    public String extendBookReturnDate(String newDate) {
        return id + "," + title + "," + author + "," + year + "," + pageCount + "," +givenTo + "," + givenDate + "," + newDate;
    }

}