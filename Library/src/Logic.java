import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Logic {
    Data data = new Data();
    List<Book> bookList = data.getBookList();
    List<Student> studentList = data.getStudentList();


    public void showAllBooksFromBookList() {
        System.out.println("Список книг в библиотеке:\n====");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + 1 + ". " + bookList.get(i));
        }
        System.out.println("");
    }


    public void showAllStudentsFromStudentList() {
        System.out.println("Список читателей:\n==== ");
        String bookReturnDate = "";
        String bookIsReading = "";

        for (int i = 0; i < studentList.size(); i++) {
            String bookId = studentList.get(i).getBookIdIsReading();
            if (!bookId.equals("null")) {
                bookReturnDate = bookList.get(checkBookId(bookId)).getReturnDate();
                bookIsReading = bookList.get(checkBookId(bookId)).getTitle();
                System.out.println(i + 1 + ". " + studentList.get(i) + ", " + bookIsReading + ", " + dateFormatter(bookReturnDate));
            } else {
                System.out.println(i + 1 + ". " + studentList.get(i) + ", нет книги");
            }
        }
        System.out.println("");
    }

    private int checkBookId(String bookId) {
        int bookOrderInArrayList = 0;
        for(int i = 0; i < bookList.size(); i++) {
            if (Integer.valueOf(bookId) == bookList.get(i).getId())
                bookOrderInArrayList = i;
        }
        return bookOrderInArrayList;
    }


    public String dateFormatter(String date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = df.parse(date);
            SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            return df1.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}