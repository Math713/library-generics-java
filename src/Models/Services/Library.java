package Models.Services;

import Models.Entities.Book;
import Models.Entities.GenericRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private GenericRepository<Book> repository = new GenericRepository<>();

    public void addBook(Book book) {
        repository.add(book);
        System.out.println("Book added successfully!");
    }

    public List<Book> listBooks() {
        return repository.getAll();
    }

    public List<Book> searchByTitle(String title) {
        return repository
                .getAll()
                .stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}