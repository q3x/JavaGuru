import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Librarian {
    Data data = new Data();
    List<Book> bookList = data.getBookList();
    List<Student> studentList = data.getStudentList();

    public void addBook(String newBookData) {
        data.getBookList();
        data.getStudentList();
        data.addBookToBookList(newBookData);
    }

    public void removeBook(int id) {
        data.getBookList();
        data.getStudentList();
        data.removeBookFromBookList(id);
    }

    public void giveBook() {
        data.getBookList();
        data.getStudentList();
        data.giveBookToStudent(15, 3, "03/15/1983");
    }

    public void takeBook() {
        data.getBookList();
        data.getStudentList();
        data.getBookFromStudent(15, 3);
    }

    public void showDebtStudents() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        String d1 = dtf.format(today);
        String d2 = "";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = null;
        try {
            todayDate = sdf.parse(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < bookList.size(); i++) {
            d2 = bookList.get(i).getReturnDate();
            if (!d2.equals("null")) {

                Date returnDate = null;
                try {
                    returnDate = sdf.parse(d2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (todayDate.after(returnDate)) {
                    System.out.println("Debt student - " + bookList.get(i).getGivenTo());
                }
            }

        }

    }

    public void showAllStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            if (!studentList.get(i).getBookIdIsReading().equals("null"))
                System.out.println(studentList.get(i).getName() + " is reading " + searchBookId(Integer.valueOf(studentList.get(i).getBookIdIsReading())));
            else
                System.out.println(studentList.get(i).getName() + " have no book");
        }
    }

    private String searchBookId(int id) {
        String bookTitle = "null";
        for (int i = 0; i < bookList.size(); i++) {
            if (id == bookList.get(i).getId()) {
                bookTitle = bookList.get(i).getTitle();
            }
        }
        return bookTitle;
    }
}
