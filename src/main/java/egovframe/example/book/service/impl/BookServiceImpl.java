package egovframe.example.book.service.impl;

import egovframe.example.book.dao.BookDAO;
import egovframe.example.book.service.BookService;
import egovframe.example.book.service.BookVO;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
public class BookServiceImpl extends EgovAbstractServiceImpl implements BookService {

    @Resource(name = "bookDAO")
    private BookDAO bookDAO;

    @Override
    public List<BookVO> selectBookList() {
        return bookDAO.selectBookList();
    }

    @Override
    public BookVO selectBookDetail(String bookId) {
        return bookDAO.selectBookDetail(bookId);
    }

    @Override
    public void insertBook(BookVO vo) {
        bookDAO.insertBook(vo);
    }

    @Override
    public int updateBook(BookVO vo) {
        return bookDAO.updateBook(vo);
    }

    @Override
    public int deleteBook(String bookId) {
        return bookDAO.deleteBook(bookId);
    }
}
