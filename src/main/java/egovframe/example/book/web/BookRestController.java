package egovframe.example.book.web;

import egovframe.example.book.service.BookService;
import egovframe.example.book.service.BookVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Resource(name = "bookService")
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookVO>> getBookList() {
        List<BookVO> books = bookService.selectBookList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookVO> getBookDetail(@PathVariable String bookId) {
        BookVO book = bookService.selectBookDetail(bookId);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookVO> createBook(@RequestBody BookVO book) {
        bookService.insertBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping
    public ResponseEntity<BookVO> updateBook(@RequestBody BookVO book) {
        int result = bookService.updateBook(book);
        if (result > 0) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId) {
        int result = bookService.deleteBook(bookId);
        if (result > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
