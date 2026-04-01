package egovframe.example.book.web;

import egovframe.example.book.service.BookService;
import egovframe.example.book.service.BookVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book/api")
public class BookRestController {

    @Resource(name = "egovBookService")
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookVO>> getBookList() {
        List<BookVO> books = bookService.selectBookList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookVO> getBookDetail(@PathVariable String bookId) {
        BookVO book = bookService.selectBookDetail(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookVO> createBook(@RequestBody BookVO book) {
        book.setBookId("BOOK_" + System.currentTimeMillis());
        book.setDeleteYn("N");
        bookService.insertBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookVO> updateBook(@PathVariable String bookId, @RequestBody BookVO book) {
        book.setBookId(bookId);
        int result = bookService.updateBook(book);
        if (result == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.selectBookDetail(bookId));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable String bookId) {
        int result = bookService.deleteBook(bookId);
        if (result == 0) {
            return ResponseEntity.notFound().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "도서 삭제 성공");
        response.put("bookId", bookId);
        return ResponseEntity.ok(response);
    }
}
