public class Ui {
    Logic logic = new Logic();
    Menu menu = new Menu();

    public void go() {
        logic.showAllBooksFromBookList();
        logic.showAllStudentsFromStudentList();
        menu.showMenu();
    }
}
