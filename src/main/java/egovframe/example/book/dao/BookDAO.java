package egovframe.example.book.dao;

import egovframe.example.book.service.BookVO;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDAO")
public class BookDAO extends EgovAbstractMapper {

    public List<BookVO> selectBookList() {
        return (List<BookVO>) list("egovframe.example.book.dao.BookDAO.selectBookList", null);
    }

    public BookVO selectBookDetail(String bookId) {
        return (BookVO) selectByPk("egovframe.example.book.dao.BookDAO.selectBookDetail", bookId);
    }

    public void insertBook(BookVO vo) {
        insert("egovframe.example.book.dao.BookDAO.insertBook", vo);
    }

    public int updateBook(BookVO vo) {
        return update("egovframe.example.book.dao.BookDAO.updateBook", vo);
    }

    public int deleteBook(String bookId) {
        return delete("egovframe.example.book.dao.BookDAO.deleteBook", bookId);
    }
}
