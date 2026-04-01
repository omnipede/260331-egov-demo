package egovframe.example.book.service;

import java.util.List;

public interface BookService {

    List<BookVO> selectBookList();

    BookVO selectBookDetail(String bookId);

    void insertBook(BookVO vo);

    int updateBook(BookVO vo);

    int deleteBook(String bookId);
}
