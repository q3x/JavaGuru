/* Создать класс Book описывающий книгу (свойства: title, pageCount, author, etc.).
        Написать программу, которая:
        1) загружает коллекцию книг из указанного файла
        2) сортирует коллекцию книг по указанному свойству
        (для каждого свойства написать свою реализацию java.util.Comparator)
        3) выводит отсортированную коллекцию на консоль или в файл */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    List<Book> bookList;

    public static void main(String[] args) {
        Main m = new Main();
        m.makeList();
        m.showList();
        m.showSortedList();
    }

    private void showList() {
        System.out.println("В порядке добавления: ");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }

    private void showSortedList() {
        System.out.println("\nПо автору: ");
        AuthorCompare authorCompare = new AuthorCompare();
        Collections.sort(bookList, authorCompare);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }

        System.out.println("\nПо названию: ");
        TitleCompare titleCompare = new TitleCompare();
        Collections.sort(bookList, titleCompare);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }

        System.out.println("\nПо году издания: ");
        YearCompare yearCompare = new YearCompare();
        Collections.sort(bookList, yearCompare);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }

        System.out.println("\nПо количеству страниц: ");
        PageCompare pageCompare = new PageCompare();
        Collections.sort(bookList, pageCompare);
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }


    private void makeList() {
        bookList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("book_list.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(",");
                bookList.add(new Book(lineParts[0], lineParts[1], Integer.valueOf(lineParts[2]), Integer.valueOf(lineParts[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class AuthorCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return one.getAuthor().compareTo(two.getAuthor());
        }
    }

    class TitleCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return one.getTitle().compareTo(two.getTitle());
        }
    }

    class YearCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return (two.getYear() - one.getYear());
        }
    }

    class PageCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return (two.getPageCount() - one.getPageCount());
        }
    }
}
