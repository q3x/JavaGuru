import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    Data data = new Data();
    List<Student> studentList = data.getStudentList();
    boolean exit;
    int currentStudentId;

    public void showMenu() {
        while (!exit) {
            System.out.println("Please choose:");
            System.out.println("1. Show stats\n2. Login\n3. Exit\n");
            int choice = scanner.nextInt();
            if (choice == 1){
                new Logic().showAllBooksFromBookList();
                new Logic().showAllStudentsFromStudentList();
            }
            else if (choice == 2)
                login();
            else if (choice == 3) {
                System.out.println("Bue!");
                exit = true;
            } else
                System.out.print("Enter valid number");
        }
    }

    private void login() {
        System.out.println("Please Enter your name: ");
        Scanner lineScanner = new Scanner(System.in);
        String choice = lineScanner.nextLine();
        boolean logout = false;
        while (!logout) {
            if (choice.equals("Librarian")) {
                librarianMenu();
                logout = true;
            } else if (choice.equals(checkStudentName(choice))) {
                studentMenu(studentList.get(currentStudentId).getId(),
                        studentList.get(currentStudentId).getName(),
                        studentList.get(currentStudentId).getPhoneNumber(),
                        studentList.get(currentStudentId).getBookIdIsReading());
                logout = true;
            } else {
                System.out.println("Can't login, sorry!\n");
                logout = true;
            }
        }
    }

    private String checkStudentName(String choice) {
        for (int i = 0; i < studentList.size(); i++) {
            String name = String.valueOf(studentList.get(i).getName());
            if (choice.equals(name)) {
                currentStudentId = i;
                return name;
            }
        }
        return null;
    }

    private void studentMenu(int id, String name, int phoneNumber, String bookIdIsReading) {
        Student currentStudent = new Student(id, name, phoneNumber, bookIdIsReading);
        System.out.println("====[ Logged as " + currentStudent.getName() + " ]====");
        boolean session = true;
        while (session) {
            System.out.println("Please choose:");
            System.out.println("1. Show your reading ticket\n2. Extend book return date\n3. Exit\n");
            int choice = scanner.nextInt();
            if (choice == 1)
                currentStudent.showStudentCart();
            else if (choice == 2) {
                Scanner lineScanner = new Scanner(System.in);
                System.out.println("Please Enter new date (dd/mm/yyyy): ");
                String input = lineScanner.nextLine();
                currentStudent.extendBookReturnDate(input);
            } else if (choice == 3) {
                System.out.println("Bue, " + currentStudent.getName() + "!\n");
                session = false;
            } else
                System.out.print("Choice not correct. ");
        }
    }


    private void librarianMenu() {
        Librarian librarian = new Librarian();
        System.out.println("====[ Loged as Librarian ]====");
        boolean session = true;
        while (session) {
            System.out.println("\nPlease choose:");
            System.out.println("1. Show debt students\n2. Show all students\n3. Give book to student" +
                    "\n4. Take book from student\n5. Add book to library.\n6. Remove book from library\n7. Back.");
            int choice = scanner.nextInt();
            if (choice == 1)
                librarian.showDebtStudents();
            else if (choice == 2)
                librarian.showAllStudents();
            else if (choice == 3)
                librarian.giveBook();
            else if (choice == 4)
                librarian.takeBook();
            else if (choice == 5) {
                System.out.println("Enter new book data (Title, Author, Year, Number of pages):");
                Scanner scanner1 = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);
                String title = scanner1.nextLine();
                String author = scanner2.nextLine();
                int year = intScanner.nextInt();
                int pageCount = intScanner.nextInt();

                String newBookData = title + "," + author + "," + String.valueOf(year) + "," + String.valueOf(pageCount);
                librarian.addBook(newBookData);
            }
            else if (choice == 6) {
                System.out.println("Enter book ID to remove:\n");
                int input = scanner.nextInt();
                librarian.removeBook(input);
            }
            else if (choice == 7) {
                System.out.println("Logging out from Librarian!\n");
                session = false;

            } else
                System.out.print("Wrong choice. ");
        }
    }
}
