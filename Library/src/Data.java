import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Book> bookList;
    private List<Student> studentList;

    public List<Book> getBookList() {
        loadDataFromBookListDB();
        return bookList;
    }

    public List<Student> getStudentList() {
        loadDataFromStudentListDB();
        return studentList;
    }

    public void loadDataFromBookListDB() {
        bookList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("book_list.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(",");
                bookList.add(new Book(Integer.valueOf(lineParts[0]), lineParts[1], lineParts[2],
                        Integer.valueOf(lineParts[3]), Integer.valueOf(lineParts[4]),
                        lineParts[5], lineParts[6], lineParts[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromStudentListDB() {
        studentList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("student_list.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(",");
                studentList.add(new Student(Integer.valueOf(lineParts[0]), lineParts[1],
                        Integer.valueOf(lineParts[2]), lineParts[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBookReturnDate(int id, String newDate) {
        try {
            PrintWriter writer = new PrintWriter("book_list.txt", "UTF-8");
            for (int i = 0; i < bookList.size(); i++) {
                int currentId = Integer.valueOf(bookList.get(i).getId());
                if (currentId == id) {
                    writer.println(bookList.get(i).extendBookReturnDate(newDate));
                } else
                    writer.println(bookList.get(i).printListLine());
            }
            System.out.println("Successful extendet to " + newDate);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void addBookToBookList(String newBookData) {

        try {
            PrintWriter writer = new PrintWriter("book_list.txt", "UTF-8");
            int id = 0;
            for (int i = 0; i < bookList.size(); i++) {
                writer.println(bookList.get(i).printListLine());
                id = bookList.get(i).getId();
            }
            writer.println(id + 1 + "," + newBookData + ",null,null,null");
            writer.close();
            System.out.println("Book successful added to list!");
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void removeBookFromBookList(int id) {
        try {
            PrintWriter writer = new PrintWriter("book_list.txt", "UTF-8");
            for (int i = 0; i < bookList.size(); i++) {
                int currentId = Integer.valueOf(bookList.get(i).getId());
                if (currentId == id) {

                } else
                    writer.println(bookList.get(i).printListLine());
            }
            System.out.println("Book removed from list");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void giveBookToStudent(int bookId, int studentId, String returnDate) {
        giveBookToStudentInBookList(bookId, studentId, returnDate);
        giveStudentBook(studentId, bookId);
        System.out.println("Book given to student");
    }

    public void giveStudentBook(int studentId, int bookId) {
        try {
            PrintWriter writer = new PrintWriter("student_list.txt", "UTF-8");
            for (int i = 0; i < studentList.size(); i++) {
                int currentId = Integer.valueOf(studentList.get(i).getId());
                if (currentId == studentId) {

                    writer.println(studentId + "," + studentList.get(i).getName() + "," + studentList.get(i).getPhoneNumber()
                    + "," + bookId);
                } else
                    writer.println(currentId + "," + studentList.get(i).getName() + "," + studentList.get(i).getPhoneNumber()
                            + "," + studentList.get(i).getBookIdIsReading());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void giveBookToStudentInBookList(int bookId, int studentId, String returnDate) {
        try {
            PrintWriter writer = new PrintWriter("book_list.txt", "UTF-8");
            for (int i = 0; i < bookList.size(); i++) {
                int currentId = Integer.valueOf(bookList.get(i).getId());
                if (currentId == bookId) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate today = LocalDate.now();
                    writer.println(bookId + "," + bookList.get(i).getTitle() + "," + bookList.get(i).getAuthor() + ","
                            + bookList.get(i).getYear() + "," + bookList.get(i).getPageCount() + ","
                            + studentList.get(studentId - 1).getName() + "," + dtf.format(today) + "," + returnDate);
                } else
                    writer.println(bookList.get(i).printListLine());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void getBookFromStudent(int bookId, int studentId) {
        takeStudentBook(studentId);
        takeBookFromStudent(bookId);
    }

    public void takeBookFromStudent(int bookId) {
        try {
            PrintWriter writer = new PrintWriter("book_list.txt", "UTF-8");
            for (int i = 0; i < bookList.size(); i++) {
                int currentId = Integer.valueOf(bookList.get(i).getId());
                if (currentId == bookId) {
                    writer.println(bookId + "," + bookList.get(i).getTitle() + "," + bookList.get(i).getAuthor() + ","
                            + bookList.get(i).getYear() + "," + bookList.get(i).getPageCount() + ",null,null,null");
                } else
                    writer.println(bookList.get(i).printListLine());
            }
            System.out.println("Book removed from list");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void takeStudentBook(int studentId) {
        try {
            PrintWriter writer = new PrintWriter("student_list.txt", "UTF-8");
            for (int i = 0; i < studentList.size(); i++) {
                int currentId = Integer.valueOf(studentList.get(i).getId());
                if (currentId == studentId) {

                    writer.println(studentId + "," + studentList.get(i).getName() + "," + studentList.get(i).getPhoneNumber()
                            + ",null");
                } else
                    writer.println(currentId + "," + studentList.get(i).getName() + "," + studentList.get(i).getPhoneNumber()
                            + "," + studentList.get(i).getBookIdIsReading());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error creating file...");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
