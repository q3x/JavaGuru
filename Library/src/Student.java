public class Student {
    private int id;
    private String name;
    private int phoneNumber;
    private String bookIdIsReading;

    Data data = new Data();

    public Student(int id, String name, int phoneNumber, String bookIdIsReading) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookIdIsReading = bookIdIsReading;
    }

    public Student() { }


    public void showStudentCart() {
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhoneNumber());

        if (getBookIdIsReading().equals("null"))
            System.out.println("No books reading ;(");
        else {
            data.getBookList();
            int currentBookId = Integer.valueOf(getBookIdIsReading());
            System.out.println("Book reading: " + data.getBookList().get(currentBookId - 1).getTitle());
            System.out.println("Book return date: " + data.getBookList().get(currentBookId - 1).getReturnDate());
        }
    }

    public void extendBookReturnDate(String date) {
        data.updateBookReturnDate(id, date);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBookIdIsReading() {
        return bookIdIsReading;
    }

    public void setBookIdIsReading(String bookIdIsReading) {
        this.bookIdIsReading = bookIdIsReading;
    }

    public String toString() {
        return name + ", " + phoneNumber;
    }
}
