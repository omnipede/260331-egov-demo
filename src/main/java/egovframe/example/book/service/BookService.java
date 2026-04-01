package egovframe.example.book.service;

import egovframe.example.book.dao.BookDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("egovBookService")
public class BookService {

    @Resource(name = "bookDAO")
    private BookDAO bookDAO;

    public List<BookVO> selectBookList() {
        return bookDAO.selectBookList();
    }

    public BookVO selectBookDetail(String bookId) {
        return bookDAO.selectBookDetail(bookId);
    }

    public void insertBook(BookVO vo) {
        bookDAO.insertBook(vo);
    }

    public int updateBook(BookVO vo) {
        return bookDAO.updateBook(vo);
    }

    public int deleteBook(String bookId) {
        return bookDAO.deleteBook(bookId);
    }
}
